#!/usr/bin/env python
#Brock Ellefson Lizzie Andrews
import sys
import socket

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

s.bind(("127.0.0.1", 5000))

print ("socket binded to port")

s.listen(5)
print ("socket is listening")

while 1:
   c, addr = s.accept()

   print ("Got connection from", addr)

   c.close()
