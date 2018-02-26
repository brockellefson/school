#!/usr/bin/env python
#Brock Ellefson Lizzie Andrews
import sys
import socket
import requests
#from BaseHTTPServer import BaseHTTPRequestHandler, HTTPServer
import re

#----------------------------------------------------
own_board = [[0 for x in range(10)]for y in range(10)]
opponent_board = [[0 for x in range(10)]for y in range(10)]
ship_health = {'C': 5,'B': 4,'R': 3,'S': 3,'D': 2}
#----------------------------------------------------

def process_file(board, infile):
    for i in range(10):
        for j in range(11): #\n
            if(j > 9):
                infile.read(1) #skip \n
            else:
                board[i][j] = infile.read(1)
                opponent_board[i][j] = "_"

def print_board(board):
    the_board = ''
    for i in range(10):
        for j in range(11): #because of \n
            if (j > 9):
                the_board += "\n" #return
            else:
                the_board += board[i][j] #print char
    return the_board

def decode(data):
    #GET requests
    if "GET /own_board.html" in data:
        return (print_board(own_board))
    elif "GET /opponent_board.html" in data:
        return (print_board(opponent_board))
    #POST requests
    elif "POST / HTTP/1.1" in data:
        match = re.search("x=\d&y=\d", data)
        coordinates = match.group(0) if match else None
        if coordinates == None:
            return('404')
        return hit_or_miss(coordinates)
    #bad format
    else:
        return ('400')

def hit_or_miss(coordinates):
    x = int(coordinates[2])
    y = int(coordinates[6])

    if x > 9 or x < 0 or y > 9 or y < 0:
        return '404'

    if own_board[x][y] != '_' and own_board[x][y] != 'x':
        ship_health[own_board[x][y]] -= 1
        if ship_health[own_board[x][y]] == 0:
            hit = ('hit=1$sink=%s'%(own_board[x][y]))
            #opponent_board[x][y] = own_board[x][y]
            own_board[x][y] = 'x'
            return hit
        #opponent_board[x][y] = own_board[x][y]
        own_board[x][y] = 'x'
        return 'hit=1'

    if own_board[x][y] == 'x':
        return '410'
    own_board[x][y] = 'x'
    #opponent_board[x][y] = 'x'
    return 'hit=0'

def hit(data):
    #x=2&y=0hit=1
    print(data)
    match = re.search("x=\d&y=\dhit=\d", data)
    dedata = match.group(0) if match else None
    hit = dedata[11]
    x = int(dedata[2])
    y = int(dedata[6])
    if hit == '0':
        opponent_board[x][y] = 'x'
    else:
        opponent_board[x][y] = 'H'

def main():
    port = int(sys.argv[1])
    efile = open(sys.argv[2])
    process_file(own_board, efile)

    while 1:
        s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
<<<<<<< HEAD:CS466/BattleShip/server.py
        s.bind(("192.168.1.2", port))
=======
        s.bind(("192.168.1.11", port))
>>>>>>> bda3088982709b1ecb0b1723e45c2775a70537cb:CS466/Assignment 1/BattleShip/server.py
        #print ("Socket binded to port")
        s.listen(1)
        #print ("Socket is listening")
        conn, addr = s.accept()
        print(addr[0])
        data = conn.recv(1024)
        response = 'Thank you'
        if addr[0] == '192.168.1.2':
            hit(data)
        else:
            response = decode(data)

        conntype = 'Connection: close'
        conttype = 'Content-Type: application/x-uuu-form-urlencoded'
        contlen = 'Content-Length:  %s' %(len(response))

        print ("\nReceived from client:\n" + data + "\n")

        if response == "404":
            message = ("HTTP/1.1 404\n%s\n%s\n%s" %(conntype, conttype, contlen))
        elif response == "410":
            message = ("HTTP/1.1 410\n%s\n%s\n%s" %(conntype, conttype, contlen))
        elif response == "400":
            message = ("HTTP/1.1 400\n%s\n%s\n%s" %(conntype, conttype, contlen))
        else:
            message = ("HTTP/1.1 200\n%s\n%s\n%s\n%s\n" %(conntype, conttype, contlen, response ))

        print ("\nSent to client:\n" + message + "\n")
        conn.send(bytes(message))
        s.close()
main()
