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

    def __init__(self, ID1, ID2, ID3, ID4, ID5, ID6, ID7, ID8, ID9, ID10):
        self.temp[0] = 0
        self.temp[1] = ID1
        self.temp[2] = ID2
        self.temp[3] = ID3
        self.temp[4] = ID4
        self.temp[5] = ID5
        self.temp[6] = ID6
        self.temp[7] = ID7
        self.temp[8] = ID8
        self.temp[9] = ID9
        self.temp[10] = ID10

    def calc(self):
        with open("champions.tsv") as tsv:
            for line in csv.reader(tsv, dialect="excel-tab"):
                temp1 = map(int, line[0:2])
                self.mapping[temp1[0]] = temp1[1]
        tsv.close()

        # it's out of scope

        # temp = [0,54,80,25,202,267,223,1,23,28,64,267,223,1]

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
        sum = 0
        index = 0
        for line in calc:
            temp3 = line.split()
            sum = sum + self.data[0][index] * float(temp3[0])
            index = index +1
            sum = sum + self.data[0][index] * float(temp3[1])
            index = index + 1
            sum = sum + self.data[0][index] * float(temp3[2])
            index = index + 1
            sum = sum + self.data[0][index] * float(temp3[3])
            index = index + 1
        print calc
        print len(self.data[0])
        sum = -sum
        self.probability = 1 / (1 + math.exp(sum))

    def execute(self):
        for i in range(len(self.temp)):
            print self.temp[i]
        print self.mapping
        print self.data
        # print self.sum
        print self.probability
        # return int(self.probability.__int__(self.probability))
