#!/usr/bin/python
import MySQLdb
import Analysis
import Visualization
# TODO:
#write SQL Queries
#use queries on database
#store data from queries
#run analysis on data for each question
#visualize results

def jason_bateman(): #jason bateman query
    cursor = db.cursor()
    cursor.execute("SELECT m.budget FROM movie m right JOIN film f ON m.film_tconst=f.tconst left JOIN FILM_has_ACTOR g ON f.tconst=g.FILM_tconst WHERE g.ACTOR_PERSON_nconst LIKE 'nm0000867';") #Query 1 (Budget of all Jason Bateman Movies) #nm0000867
    queryrows = cursor.fetchall() #store our table
    budget = []
    for row in queryrows:
        if None not in row: #if the film jason bateman was in had a budget
            row = (row[0])
            budget.append(int(row)) #add to list of budgets
    average = analyze.mean(budget) #calc mean
    standard_dev = analyze.standard_dev(budget) #calc sd
    print(standard_dev)
    print(average)

def actor_director(): #actor director duo
    cursor = db.cursor()
    cursor.execute("SELECT AVG(f.idbm_score), AVG(f.number_votes), a.name, d.name, COUNT(*) AS c FROM film_has_actor fa JOIN film f ON fa.FILM_tconst = f.tconst  JOIN film_has_director fd ON fd.FILM_tconst = fa.FILM_tconst JOIN person a ON fa.ACTOR_PERSON_nconst = a.nconst JOIN person d ON fd.DIRECTOR_PERSON_nconst = d.nconst WHERE f.idbm_score >6 AND f.number_votes>50000 GROUP BY a.name, d.name HAVING c > 4;")
    act_dic = cursor.fetchall()  # store our table
    act_solo_scores = [] #actor solo work scores
    act_dic_scores = [] #actor dic work scores
    for row in act_dic: #for all tuples of actor/dir
        act_dic_scores.append(float(row[0])) #add avg act dic pair score
        cursor.execute("SELECT AVG(f.idbm_score), AVG(f.number_votes), a.name FROM film_has_actor fa JOIN film f ON fa.FILM_tconst = f.tconst  JOIN person a ON fa.ACTOR_PERSON_nconst = a.nconst WHERE f.idbm_score >6 AND f.number_votes>50000 AND a.name LIKE '" + row[3] + "'")
        act_solo_query = cursor.fetchall() #get avg movie rating for each actor
        for actrow in act_solo_query:
            act_solo_scores.append(float(actrow[0])) #add avg act solo score
        print(row)
        print(act_dic_scores)
    visual.t_test(act_dic_scores, act_solo_scores)

def zombie(): #zombie query
    cursor = db.cursor()
    cursor.execute("select f.idbm_score, m.year from film f join movie m on m.FILM_tconst = f.tconst where f.plot_keywords LIKE '%zombie%';")
    zombies = cursor.fetchall()
    score = []
    year = []
    for movie in zombies:
        score.append(float(movie[0]))
        year.append(int(movie[1]))

    analyze.logistic_regression(year, score, 'Zombie Movie Regression Model', 'Year Released', 'IMDB Score')

def genre_search():
    cursor = db.cursor()
    cursor.execute("select substr(p.nconst,3) as dirID, m.budget, SUBSTRING_INDEX(SUBSTRING_INDEX(f.genre, ',', 1), ',', -1) as g1 FROM film as f join film_has_director fd on fd.FILM_tconst = f.tconst join person p on p.nconst = fd.DIRECTOR_PERSON_nconst join movie m on m.FILM_tconst = f.tconst where m.budget > 0;")
    genre = cursor.fetchall()
    analyze.gnb(genre)


def age_search():
    cursor = db.cursor()
    cursor.execute("select avg(t.idbm_score), (t.year-p.birth_year) as filming_age from ( select f.idbm_score as idbm_score, m.year as year, f.tconst as tconst FROM film as f join movie m on m.FILM_tconst = f.tconst where m.year > 1970 ) as t join film_has_actor fa on fa.FILM_tconst = t.tconst join person p on p.nconst = fa.ACTOR_PERSON_nconst where p.birth_year > 0 and t.idbm_score > 0 and (t.year-p.birth_year)>0 and (t.year-p.birth_year)<100 group by filming_age")
    age_t = cursor.fetchall()
    print age_t
    score = []
    age = []
    for ages in age_t:
        score.append(float(ages[0]))
        age.append(int(ages[1]))

    analyze.quad_regression(age, score, 'Movie Score/Actor Age Correlation', 'Actor Age at Release', 'IMDB Score')



if __name__ == '__main__':
    #create our analyzer
    analyze = Analysis.Analyzer()

    #create the visualizer
    visual = Visualization.Visual()

    #connect to database
    db = MySQLdb.connect(host="192.168.1.24", #ip
                         port=3306, #port
                         user="root",  #our username
                         passwd="pass1", #our password
                         db="mydb") #our database
    print('Connected')
    #jason_bateman()
    #actor_director()
    #zombie()
    genre_search()
    #age_search()

    db.close()