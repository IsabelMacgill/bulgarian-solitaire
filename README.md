# bulgarian-solitaire
A Java program that executes a game of bulgarian solitaire with the modification that the user can choose how many cards they want to play with. The user's input is tested to make sure that it is a triangular number, and the cards are grouped into a random number of piles to start. 
* Constructor: The constructor uses a Scanner to take in the user's number of cards, and does input validation to make sure it is a triangular number. The cards are then distributed into a random number of piles.*
* Play Method: The key method of this program is the play method, which executes the game flow by taking one card from each pile to create a new pile. This continues until the number of cards in each pile is 1, 2, 3, etc. adding up to the original number of cards. 
