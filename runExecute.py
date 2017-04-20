# Created by myron on 4/12/2017.
# This is Python file that is executed from Java code
from org.python.modules import math
import csv

class RunExecute:
    mapping = [0] * 134
    data = []
    label = []
    temp = [0] * 11
    probability = 0

    # 10 ids as parameters and self as parameter
    # assigns the id values to the local self temp array values
    def __init__(self, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10):
        self.temp[0] = 0
        self.temp[1] = id1
        self.temp[2] = id2
        self.temp[3] = id3
        self.temp[4] = id4
        self.temp[5] = id5
        self.temp[6] = id6
        self.temp[7] = id7
        self.temp[8] = id8
        self.temp[9] = id9
        self.temp[10] = id10

    # This is the primary method that computes the likely outcome of the match
    def calc(self):
        with open("champions.tsv") as tsv:
            for line in csv.reader(tsv, dialect="excel-tab"):
                temp1 = map(int, line[0:2])
                self.mapping[temp1[0]] = temp1[1]
        tsv.close()

        if len(self.temp) > 2:
            team1 = [0] * 134
            team1_copy = [0] * 134

            win = map(int, self.temp[1:6])
            for i in range(0, len(win)):
                win_index = self.mapping.index(win[i])
                team1[win_index] = 1
                team1_copy[win_index] = 1

            team2 = [0] * 134
            team2_copy = [0] * 134
            lose = map(int, self.temp[6:11])
            for i in range(0, len(lose)):
                lose_index = self.mapping.index(lose[i])
                team2[lose_index] = 1
                team2_copy[lose_index] = 1

            team1.extend(team2_copy)
            self.data.append(team1)

        calc = open("calc.txt", "r")
        current_sum = 0
        index = 0
        for line in calc:
            temp3 = line.split()
            current_sum = current_sum + self.data[0][index] * float(temp3[0])
            index = index + 1
            current_sum = current_sum + self.data[0][index] * float(temp3[1])
            index = index + 1
            current_sum = current_sum + self.data[0][index] * float(temp3[2])
            index = index + 1
            current_sum = current_sum + self.data[0][index] * float(temp3[3])
            index = index + 1
        # print calc
        # print len(self.data[0])
        current_sum = -current_sum
        self.probability = 1 / (1 + math.exp(current_sum))
