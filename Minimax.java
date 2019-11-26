import java.util.Scanner;
public class Minimax
{
    CheckWin CheckWin = new CheckWin();
    Insert Insert = new Insert();
    int score = 0;
    int value;
    int player;
    int opponent;
    int [][] MiniBoard= new int[6][7];
    boolean[] validMoves;
    public  Minimax()
    {

    }

    public int Run(int Board[][], int depth, boolean MaxPlayer, int nextMove,int currentPlayer , EvaluateScore EvaluateScore)
    {
        boolean win = false;
        copyArray(MiniBoard, Board);
        //PrintBoard();

        if(currentPlayer == 1)
        {
            player = 1;
            opponent = 2;
        }
        else
        {
            player = 2;
            opponent = 1;
        }

        if(IsTerminal() == true)
        {
            if(CheckWin.HasWon(MiniBoard, player))//checks if player has won
            {
                return 100000; 
            }
            else if(CheckWin.HasWon(MiniBoard, opponent))//chekcs if opponent wins
            {
                return -100000;
            }
            else//returns 0 if its a draw
            {
                return 0;
            }
        }
        if(depth == 0)//when you have traversed as far as you can go
        {
            return EvaluateScore.Evaluate(MiniBoard,currentPlayer);//evaluate the score of the current board
        }

        if(MaxPlayer)//maximizingPlayer
        {
            value = -99999999;//largest negirive (that is not neg infinity)
            for(int x = 0; x< 7; x++)//loops though all 7 columns placing prieces in different configs
            {
                validMoves = Insert.validMoves(MiniBoard);//checks if there is any room to place a piece
                if(validMoves[x] == true) //if there is room
                {   
                    int CopyBoard[][]= new int[6][7];//make a new board
                    copyArray(CopyBoard, MiniBoard);//copy the original board at the prev depth
                    Insert.InsertIntoBoard(CopyBoard, x, player);//insert into the new board for the new depth
                    EvaluateScore.addNode();//adds to the node count
                    int newScore = Run(CopyBoard,depth-1,false,nextMove,currentPlayer, EvaluateScore);//runs recursive
                    if(newScore > value)//trying to find the biggest to maximise the player
                    {
                        value = newScore;//sets the new
                        EvaluateScore.setBestMove(x);//sets the best move to newst move
                    }
                    Insert.remove(MiniBoard, x);//removes from the current depth board

                }
            }
            return value;//returns the value of the Minimax
        }
        else//minimizingPlayer
        {
            value = 99999999;
            for(int x = 0; x< 7; x++)//loops though all 7 columns placing prieces in different configs
            {
                validMoves = Insert.validMoves(MiniBoard);//checks if there is any room to place a piece
                if(validMoves[x] == true) //if there is room
                {   
                    int CopyBoard[][] = new int[6][7];//make a new board
                    copyArray(CopyBoard, MiniBoard);//copy the original board at the prev depth
                    Insert.InsertIntoBoard(CopyBoard, x, opponent);//insert into the new board for the new depth
                    EvaluateScore.addNode();//adds to the node cout
                    int newScore = Run(CopyBoard,depth-1,true,nextMove,currentPlayer, EvaluateScore);//runs recursive
                    if(newScore < value)//trying to find the smallest to minimise the opponent
                    {
                        value = newScore;//sets the new
                        EvaluateScore.setBestMove(x);//sets the best move to newst move
                    }
                    Insert.remove(MiniBoard, x);//removes from the current depth board
                }
            }
            return value;//returns the value of the Minimax
        }
    }
    //checks if something is terminal(end of game)
    public boolean IsTerminal(){
        return CheckWin.HasWon(MiniBoard, 1) |CheckWin.HasWon(MiniBoard, 2) |  CheckWin.IsDraw(MiniBoard);
    }
    
    public void copyArray(int first[][],int second[][])//have to make an array copy because java done = as reference
    {
        for(int x = 0; x<first.length; x++)
        {
            for(int y = 0; y<first[x].length; y++)
            {
                first[x][y] = second[x][y];  
            }
        }
    }
    

}