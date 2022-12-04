import numpy as np

class Game:
    def __init__(self):
        self.__payoff = np.array([[0, -1, 1, 1, -1], 
                                [1, 0, -1, -1, 1],
                                [-1, 1, 0, 1, -1],
                                [-1, 1, -1, 0, 1],
                                [1, -1, 1, -1, 0]])
        self.__history = {
            "1"   : 0,
            "2"   : 0,
            "Tie" : 0,
        }
    
    def getHistory(self):
        return self.__history
    
    def check(self, client_move, server_move):
        result = self.__payoff[client_move][server_move]
        if   result > 0: 
            self.__history['1']   += 1
            print('Player 1 Wins')
        elif result < 0: 
            self.__history['2']   += 1
            print('Player 2 Wins')
        else: 
            self.__history['Tie'] += 1
            print('Draw')
