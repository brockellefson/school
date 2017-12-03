import numpy as np
from sklearn.naive_bayes import GaussianNB
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression as lr

class Analyzer:

    def mean(self, data):
        return np.mean(data) #divide by total movies

    def standard_dev(self, data):
        return np.std(data, axis = 0)

    def profit(gross, budget):
        data = gross - budget
        return data

    def logistic_regression(self, inx, iny, title, xlabel, ylabel ):
        x = np.array(inx)
        y = np.array(iny)

        x = x.reshape(len(x), 1)
        y = y.reshape(len(y), 1)

        lreg = lr()
        lreg.fit(x, y)
        pred = lreg.predict(x)

        plt.scatter(x, y)
        plt.plot(x, pred)
        plt.title(title)
        plt.xlabel(xlabel)
        plt.ylabel(ylabel)

        plt.show()


    def quad_regression(self, inx, iny, title, xlabel, ylabel):
        x = np.array(inx)
        y = np.array(iny)
        z = np.polyfit(x, y, 3)

        p = np.poly1d(z)
        p3 = np.poly1d(np.polyfit(x, y, 3))

        xp = np.linspace(0, 100, 100)
        _ = plt.plot(x, y, '.', xp, p(xp), '-', xp, p3(xp), '--')

        plt.scatter(inx, iny)
        plt.title(title)
        plt.xlabel(xlabel)
        plt.ylabel(ylabel)

        plt.show()

    def gnb(self, data):
        genre = []          #make genre list
        datapts = []
        genreIter = 0
        genreDict = {}
        for movie in data:

            if genreDict.get(movie[2]) is None:     #if genre is new make new entry in dict
                genreDict[movie[2]] = genreIter
                genreIter += 1

            genre.append(genreDict.get(movie[2]))
            datapts.append([float(movie[0]), float(movie[1])])

        genre = np.array(genre)
        datapts = np.array(datapts)

        gnb = GaussianNB()
        GaussianNB(priors=None)
        y_pred = gnb.fit(datapts, genre).predict(datapts)

        print(y_pred)
        print('# datapoints predicted = ' + str(datapts.shape[0]))
        print('# datapoints correctly = ' + str((genre != y_pred).sum()))