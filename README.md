# Connect-4-AI
This was a project to make a simple MinMax AI to play a game of connect for against you or against another AI.

# Coordinator Commands

• name – request for the engines name. The reply should be the name of the engine. The
name should be whatever name you want to give it, followed by your student number, that
is, enginename-cXXXXXXX.

• isready – A command used to synchronise the engine with the coordinator. The reply
should be readyok.

• position startpos <moves> – The current order of moves played from the start position.
For example, position startpos 0123456. Only the numbers 0−6 will ever be used. This
command will always be followed by the isready command. The only operation allowed to
be performed by the engine between receiving this command is to update the internal board
with the moves, no searching is allowed.
  
• go ftime x stime y – Tells the engine to start calculating. The x string will be the time
remaining for the first player in milliseconds. The y string will be how long the second player
has left. The reply should be bestmove z v where z is the column number, 0 − 6, that the
engine wants to place its next marker in. If it is invalid it will be an automatic forfeit. v is
the value of the evaluation function after that move. All searching is done here.

• perft x – Tells the engine to count how many nodes are in the entire search tree when
expanded to depth x from the current position. The reply should be perft x y where x is
the same value passed in, and y is the number of nodes in the search tree when it is expanded
to depth x. This should be a separate algorithm to your minimax algorithm, mostly used for
debugging and performance testing (hence the name) purposes and be ready to take in any
depth.

• quit – Tells the engine to quit. Reply should be quitting.

# Running Coordinator

To run the file from the command line you need to use java -jar connect_4_coordinator.jar
along with the arguments to pass to the program. The arguments are:

• (required) e0 <path> where <path> is the directory containing the file called Interface
which includes the main method of your engine.
  
• (optional) e1 <path> where <path> is the directory containing a file called Interface which
includes the main method of another engine. If this is not used the first engine will be used
again, so it is easy to set up a self game for the engine.
  
• (optional) time x where x is the amount of time in milliseconds each engine is allowed to
use. If this is not used, x will be 120000 (2 minutes).

• (optional) perft x where x is the depth the engine should calculate the perft function to.
