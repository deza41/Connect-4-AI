import java.util.Scanner;
    public class Interface
    {
        public static void main(String args[])
        {
            Scanner console = new Scanner(System.in);//scanner used for unuput
            String input;//input will be used to reference anything coming into the program
            String[] splitInput;//splits up the string to use for commands
            String[] splitPosition;

            EvaluateScore EvaluateScore = new EvaluateScore();//creates an evaluation object
            int Board[][];//the main board that will be used
            int nextMove = 0;//the next move of the maximising player
            int depth;//the depth of the number of turn in the future your program will run


            Board = new int[6][7];//creates the board 7X6
            CheckWin CheckWin = new CheckWin();//checkwin object
            Insert Insert = new Insert();//Insert object
            Minimax Minimax = new Minimax();// Minmax object
            depth = 5;//sets the depth that the tree will go to

            //make empty and initialise
            for(int x = 0; x < 6; x++)
            {
                for(int y = 0; y < 7; y++)
                {
                    Board[x][y] = 0;
                }
            }



            //game logic
            while(true)
            {

                input = console.nextLine();//gets the input
                splitInput = input.split(" ");//splits up the input

                switch(splitInput[0])//switch statement for different operations
                {
                    case "name":
                        System.out.println("enginename-c3187785");//tells the co-ordinator the name of the engine
                        break;
                    case "isready":
                        System.out.println("readyok");//handshake for the co-ordinator
                        break;
                    case "position":
                        if(splitInput.length == 3)//grabs the position of the column
                        {
                            int last = Integer.parseInt(String.valueOf(splitInput[2].charAt(splitInput[2].length() - 1)));//gets the last number of the number sequence
                            Insert.InsertIntoBoardMinMax(Board,last,2);//add oppenent move to your board
                            //PrintBoard(Board);
                        }
                        break;
                    case "go":
                        //minimax
                        int score = Minimax.Run(Board,depth,true,nextMove,2, EvaluateScore);//runs the minimax alg
                        nextMove = EvaluateScore.getBestMove();//gets the best move for max player
                        Insert.InsertIntoBoardMinMax(Board,nextMove,1);//inserts into the board
                        System.out.println("bestmove "+ nextMove + " " + score);//tells the co-ordinator the best move for max player
                        //PrintBoard(Board);
                        break;
                    case "perft":
                        EvaluateScore.clearNodes();//resets the node cout
                        int perftDepth = Integer.valueOf(splitInput[1]);//gets the depth to check to
                        Minimax.Run(Board,perftDepth,true,nextMove,1, EvaluateScore);//runs the evaluation to generate the nodes
                        System.out.println("perft "+ perftDepth + " " + EvaluateScore.perft());//tells the co-ordinator the number of nodes at the chosen depth
                        EvaluateScore.clearNodes();//clears the naodes again
                        //PrintBoard(Board);
                        break;
                    case "quit":
                        System.out.println("quitting");//tells the co-ord that the engine is ending
                        System.exit(0);//exits the program
                        break;
                }
            }
        }





        public static void PrintBoard(int Board[][])//used to print the board
        {
            //print the board
            int y = 0;
            for(int x = 0; x < 6; x++)
            {
                if(Board[x][y] == 0)
                {
                    System.out.print("|"+" |");
                }
                else{
                    System.out.print("|"+Board[x][y]+"|");
                }

                for(y = 1; y < 6; y++)
                {
                    if(Board[x][y] == 0)
                    {
                        System.out.print(" |");
                    }
                    else{
                        System.out.print(Board[x][y]+"|");
                    }
                }
                if(Board[x][y] == 0)
                {
                    System.out.println(" |");
                }
                else{
                    System.out.println(Board[x][y]+"|");
                }
                y = 0;
            }
        }
    }
