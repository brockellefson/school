#!/usr/bin/env python
#Brock Ellefson Lizzie Andrews


import sys
import socket

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(('localhost', 5000))
print ("Connected")
s.close()
