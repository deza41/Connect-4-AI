import java.util.Scanner;
public class Insert
{
    Scanner input = new Scanner(System.in);
    public Insert()
    {
        
    }

    public void InsertIntoBoard(int Board[][],int currentPosition, int currentPlayer)//insert for player(used to test and play against the ai)
    {
        boolean Inserted = false;//boolean to tell if its inserted or not
        if(Board[0][currentPosition] != 0)//if the top of the board is full in that column will ask user to enter another one
        {
           do {
               System.out.println("Full, Select another colum 0-6");
               currentPosition = input.nextInt();

           }while(Board[0][currentPosition] != 0);
        }

        for(int x = 5; x>= 0; x--)
        {
            if(Board[x][currentPosition] == 0 && Inserted == false)//loops though and finds the top of the column that is empty to insert into
            {
                Board[x][currentPosition] = currentPlayer;
                Inserted = true;
            }
        }

    }

    public void InsertIntoBoardMinMax(int Board[][],int currentPosition, int currentPlayer)//insert for minimax
    {
        boolean Inserted = false;
        if(Board[0][currentPosition] != 0)//if column is full it will not insert
        {

        }
        else
        {
            for(int x = 5; x>= 0; x--)//loops though and finds the top of the column that is empty to insert into
            {
                if(Board[x][currentPosition] == 0 && Inserted == false)
                {
                    Board[x][currentPosition] = currentPlayer;
                    Inserted = true;
                }
            }
        }
    }

    public boolean[] validMoves(int Board[][])//returns a boolean array of all the valid pieces (column that isnt full)
    {
        boolean[] valid = new boolean[7]; //creates the valid move array
        for(int x = 0; x<= 6; x++)//loops though the columns and checks if there is a free slot
        {
            if(Board[0][x] == 0)
            {
                valid[x] = true;
            }
            else 
            {
                valid[x] = false;
            }
        }
        return valid;
    }


public void remove(int Board[][],int currentPosition)//removes from the top of the column
{
    for(int x = 0; x<= 5; x++)//goes to the top of the column and removes a piece
    {
        if(Board[x][currentPosition] != 0)
        {
            Board[x][currentPosition] = 0;
            break;
        }

    }

}
}
