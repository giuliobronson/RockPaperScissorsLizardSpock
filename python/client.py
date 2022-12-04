from socket import *

class Client:
    def __init__(self, HOST, PORT):
        self.HOST   = HOST
        self.PORT   = PORT
        self.socket = socket(AF_INET, SOCK_STREAM)
        self.socket.connect((self.HOST, self.PORT))

    def message(self, msg):
        tmp = str(msg) + "\r\n"
        self.socket.send(tmp.encode())  
        return self.socket.recv(1024).decode()