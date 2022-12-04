import random
import numpy as np

class BayesianPlayer:
    def __init__(self):
        self.step = 0
        self.history = {
            "opponent": [],
            "action"  : [],
        }

    def play(self, last_move):
        self.step += 1
        self.history['opponent'].append(last_move)
        if self.step < 4: 
            guess = random.choice(np.arange(5))
            self.history['action'].append(guess)
            return guess
        else: 
            guess = self.__naive_bayes()
            self.history['action'].append(guess)
            return (guess + 1) % 5

    def __naive_bayes(self):
        unique, counts = np.unique(self.history['opponent'], return_counts=True)
        coll = dict(zip(unique, counts))
        return int(max(coll, key=coll.get))