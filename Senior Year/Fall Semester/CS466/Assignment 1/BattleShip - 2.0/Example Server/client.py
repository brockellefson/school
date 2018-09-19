import sys
import requests

ip = 0

#init
ip = sys.argv[1]
port = sys.argv[2]
x = sys.argv[3]
y = sys.argv[4]

url = 'http://{0}:{1}'.format(ip,port)
r = requests.post(url, data = {'x':x, 'y':y})
print('The server is firing at')
print(r.url)
