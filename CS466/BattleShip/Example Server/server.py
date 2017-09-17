import sys
import requests
import socket

#get input params and convert board
port = int(sys.argv[1])
board_url = sys.argv[2]
board_file = open(board_url)
board = board_file.read()
ip = '127.0.0.1'

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind((ip, port))
sock.listen(1)

connection, address = sock.accept()
ans = connection.recv(1024).decode("ascii")

# CCCCC	Carrier
# BBBB	Battleship
# RRR	cRuiser
# SSS	Submarine
# D	Destroyer(2)



#testing
print('Connection:\n\n' + str(connection))
print('\nAddress:\n\n' + str(address))
print('Ans:\n\n' + str(ans))
