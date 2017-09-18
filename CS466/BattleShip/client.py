#!/usr/bin/env python
#Brock Ellefson Lizzie Andrews

import socket
import sys
#import httplib
import re
#----------------------------------------------------
#arguments we pass in
ip = sys.argv[1]
port = int(sys.argv[2])
x = sys.argv[3]
y = sys.argv[4]
#----------------------------------------------------

def decode(data):
        match = re.search("hit=\d", data)
        hit = match.group(0) if match else None
        return (hit + "&")

def main():
    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM) #creates socket
    s.connect((ip, port)) #connects us to server
    print ("Connected")

    #headers
    coordinates = ("x=" + x + "&y=" + y)
    conntype = 'Connection: close'
    conttype = 'Content-Type: application/x-uuu-form-urlencoded'
    user = 'User-Agent: client.py'
    contlen = 'Content-Length:  %s' %(len(coordinates))


    s.send(bytes("POST / HTTP/1.1\n%s\n%s\n%s\n%s\n%s" %(conntype, conttype, user, contlen, coordinates) )) #post to server
    data = s.recv(1024) #decode data we get back from server
    print (data)
    hit = decode(data)

    s.close() #close connection
    coordinates += hit
    contlen = 'Content-Length:  %s' %(len(coordinates))
    s.connect(('127.0.0.1', 5000))
    s.send(bytes("POST / HTTP/1.1\n%s\n%s\n%s\n%s\n%s" %(conntype, conttype, user, contlen, coordinates) )) #post to server
    s.close()
main()
