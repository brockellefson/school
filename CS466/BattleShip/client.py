#!/usr/bin/env python
#Brock Ellefson Lizzie Andrews

import socket
import sys
import requests

#----------------------------------------------------

ip = sys.argv[1]
port = int(sys.argv[2])
x = sys.argv[3]
y = sys.argv[4]
#----------------------------------------------------

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

s.connect((ip, port))

print ("Connected")
#url = 'http://{0}:{1}'.format(ip,port)
#message = requests.post(url, data = {'x':x, 'y':y})

#temp
message = ("x= " + x + " y= " + y)
s.send(message)
data = s.recv(1024).decode("ascii")
update(data)
print (data)
s.close()













# url = 'http://{0}:{1}'.format(ip,port)
# message = requests.post(url, data = {'x':x, 'y':y})
# print('The server is firing at')
# print(message.url)
