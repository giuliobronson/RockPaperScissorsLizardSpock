from nbplayer import BayesianPlayer
from game import Game
from client import Client

if __name__ == "__main__":
    player = BayesianPlayer()
    client = Client('192.168.0.8', 5000)
    game   = Game()
    server_move = 0
    for i in range(15):  
        client_move = player.play(server_move)
        server_move = int(client.message(client_move))
        game.check(client_move, server_move)
    print(game.getHistory())
