#!/usr/bin/env python
import argparse
import re
import random
from itertools import islice
from collections import Counter, defaultdict

# Replace the string value of the following variable with your names.
ME = 'Brock Ellefson';
COLLABORATORS = ['Satan']

def process_file(infile):
    titles = set()

    # Loop through each line of the file
    print ('Processing file')
    for line in infile:
        line = line.rstrip()

        #seperates line after last <SEP>
        data = line.split("<SEP>")
        data = data[3]

        #deletes superfluous text
        seperater = ['[', '(', '"', 'feat.']
        for sep in seperater:
            data = data.split(sep, 1)[0]

        #deletes special chars
        data = re.sub('[.?&;!]', '', data)

        #lower case and adds song title 'titles' list
        lower_case_clean_title = data.lower()
        titles.add(lower_case_clean_title)
    print('File has been processed\n')

##################################################################################
    # loop over the cleaned titles and compute the bigram counts
    print ('Constructing Bi-Gram')

    #this is the dictonary where all the bigrams are stored
    d = defaultdict(int)
    bigram_count = 'ERROR: bigram empty'


    for title in titles:
        bigram_count = re.findall("\w+",title)

        #counts all bigrams in a single line
        bigram = Counter(zip(bigram_count, islice(bigram_count,1 ,None)))
        for key, value in bigram.items():
            #key is the bigram, value is the frequency
            d[key] += 1



    print ('Bi-Gram Contructed\n')
##################################################################################



    # using bigram_count, find most common word following 'word'
    def most_common_word(word):
        high = 0
        common_word = '\nThere was no most common word :('
        for key, value in d.items():
            if key[0] == word:
                #ties
                if high == value:
                    rand = random.randint(0,1)
                    if rand == 1:
                        high = value
                        common_word = key[1]
                #finds a new high
                elif high < value:
                    high = value
                    common_word = key[1]
        return common_word


    #bigrams song title generator for EC
    def create_song_title(word, n):
        create_title = []
        create_title.append(word)
        next_word = word
        for w in range(n):
            next_word = most_common_word(next_word)
            create_title.append(' ')
            create_title.append(next_word)
        song_title = ''.join(create_title)
        return song_title



    # return most common word
    def test_bigram():
        exit = 0
        input_string = 'null'
        while exit !=1:
            input_string = input('\nPlease enter a word to see its most common follow up word\n(type "exit" to exit or generate_title to generate a song title): ')
            if input_string == 'exit':
                exit = 1
            elif input_string == 'generate_title':
                input_string = input('Please enter a root word: ')
                n = int(input('Please enter n: '))
                print ('\nthe song title generated is: ', create_song_title(input_string, n-1))
            else:
                print('\nthe most common word after', input_string, 'is: ', most_common_word(input_string))

    test_bigram()

    return most_common_word


##################################################################################

# DON'T WORRY ABOUT CODE BELOW HERE, IT JUST MAKES YOUR LIVE EASIER
def get_file_name():
    parser = argparse.ArgumentParser()
    parser.add_argument('subsampled_unique_tracks.txt', action='store_true')
    return parser.parse_args().file_name


def main():
    print ('CSCI 305 Lab 1 submitted by %s' % ME)
    print ('  with help from %s\n\n' % ', '.join(COLLABORATORS))
    #file_name = get_file_name()
    with open('subsampled_unique_tracks.txt', encoding="utf8") as infile:
        process_file(infile)


if __name__ == '__main__':
    main()
