#!/usr/bin/env python
#Brock Ellefson Lizzie Andrews
import sys
import socket
import requests

#----------------------------------------------------
port = int(sys.argv[1])
efile = open(sys.argv[2])


board = []

def process_file(infile):
     for line in infile:
         line = line.rstrip()
         for char in line:
             board.append(char)

process_file(efile)
#--------------------------------------------------
#Ships
C = 5
B = 4
R = 3
S = 2
D1 = 1
D2 = 1


def update(inData):
    inData = inData.split(" ")
    x = int(inData[1])
    y = int(inData[3]) * 10
    cord = x + y

    if x < 0 or x > 9 or y < 0 or y > 90:
        return("HTTP Not Found")

    if board[cord] == "x":
        return("HTTP Gone")
    elif board[cord] != "-":
        #hit
        hit = "hit=1"
        board[cord] = "x"
        return(hit)
    else:
        #miss
        board[cord] = "x"
        return("hit=0")





s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind(("127.0.0.1", port))
print ("socket binded to port")

s.listen(1)
print ("socket is listening")

while 1:
    conn, addr = s.accept()
    data = conn.recv(1024).decode("ascii")

    #print('\nConnection:\n' + str(conn))
    #print('\nAddress:\n' + str(addr))
    #print('\nData:\n' + str(data))
    conn.send(update(data))
    conn.close()
