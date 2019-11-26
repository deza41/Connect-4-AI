
public class CheckWin
{
    public CheckWin()
    {

    }

    public boolean HasWon(int Board[][],int currentPlayer)//checks if a player has one
    {
        boolean winner = false;
        int col = 0;
        int row = 0;
        //check horizontal wins
        for(int i = 0; i<4; i++)
        {
            for(int x = 0; x<=5; x++)
            {
                if(winner == false 
                && Board[x][i] == currentPlayer 
                && Board[x][i+1] == currentPlayer 
                && Board[x][i+2] == currentPlayer 
                && Board[x][i+3] == currentPlayer)
                {
                    winner = true;
                }
            }
        }

        //check vertical
        for(int x = 0; x<= 6; x++)
        {
            for(int i = 0; i<3; i++)
            {
                if(winner == false 
                && Board[i][x] == currentPlayer 
                && Board[i+1][x] == currentPlayer 
                && Board[i+2][x] == currentPlayer 
                && Board[i+3][x] == currentPlayer)
                {
                    winner = true;
                }
            }
        }

        //check postitive diagonal
        if(winner == false 
        && Board[2][0] == currentPlayer 
        && Board[3][1] == currentPlayer 
        && Board[4][2] == currentPlayer 
        && Board[5][3] == currentPlayer)
        {
            winner = true;
        }
        else if(winner == false 
        && Board[0][3] == currentPlayer 
        && Board[1][4] == currentPlayer 
        && Board[2][5] == currentPlayer 
        && Board[3][6] == currentPlayer)
        {
            winner = true;
        }

        row = 1;
        col = 0;
        for(int i = 0; i<2; i++)
        {
            if(winner == false 
            && Board[row][col] == currentPlayer 
            && Board[row+1][col+1] == currentPlayer 
            && Board[row+2][col+2] == currentPlayer 
            && Board[row+3][col+3] == currentPlayer)
            {
                winner = true;
            }
            if(winner == false 
            && Board[row-1][col+2] == currentPlayer 
            && Board[row][col+3] == currentPlayer 
            && Board[row+1][col+4] == currentPlayer 
            && Board[row+2][col+5] == currentPlayer)
            {
                winner = true;
            }
            col ++;
            row ++;
        }
        row = 0;
        col = 0;
        for(int i = 0; i<3; i++)
        {
            if(winner == false 
            && Board[row][col] == currentPlayer 
            && Board[row+1][col+1] == currentPlayer 
            && Board[row+2][col+2] == currentPlayer 
            && Board[row+3][col+3] == currentPlayer)
            {
                winner = true;
            }
            if(winner == false 
            && Board[row][col+1] == currentPlayer 
            && Board[row+1][col+2] == currentPlayer 
            && Board[row+2][col+3] == currentPlayer 
            && Board[row+3][col+4] == currentPlayer)
            {
                winner = true;
            }
            col ++;
            row ++;
        }

        //check negitive diagonal
        if(winner == false 
        && Board[0][3] == currentPlayer 
        && Board[1][2] == currentPlayer 
        && Board[2][1] == currentPlayer 
        && Board[3][0] == currentPlayer)
        {
            winner = true;
        }
        else if(winner == false 
        && Board[2][6] == currentPlayer 
        && Board[3][5] == currentPlayer 
        && Board[4][4] == currentPlayer 
        && Board[5][3] == currentPlayer)
        {
            winner = true;
        }

        row = 0;
        col = 4;
        for(int i = 0; i<2; i++)
        {
            if(winner == false 
            && Board[row][col] == currentPlayer 
            && Board[row+1][col-1] == currentPlayer 
            && Board[row+2][col-2] == currentPlayer 
            && Board[row+3][col-3] == currentPlayer)
            {
                winner = true;
            }
            if(winner == false 
            && Board[row+1][col+2] == currentPlayer 
            && Board[row+2][col+1] == currentPlayer 
            && Board[row+3][col] == currentPlayer 
            && Board[row+4][col-1] == currentPlayer)
            {
                winner = true;
            }
            row ++;
            col --;
        }
        row = 0;
        col = 5;
        for(int i = 0; i<3; i++)
        {
            if(winner == false 
            && Board[row][col] == currentPlayer 
            && Board[row+1][col-1] == currentPlayer 
            && Board[row+2][col-2] == currentPlayer 
            && Board[row+3][col-3] == currentPlayer)
            {
                winner = true;
            }
            if(winner == false 
            && Board[row][col+1] == currentPlayer 
            && Board[row+1][col] == currentPlayer 
            && Board[row+2][col-1] == currentPlayer 
            && Board[row+3][col-2] == currentPlayer)
            {
                winner = true;
            }
            row ++;
            col --;
        }
        return winner;
    }

    public boolean IsDraw(int Board[][]) {
        //check for draws
        if (Board[0][0] != 0 && Board[0][1] != 0 && Board[0][2] != 0 && Board[0][3] != 0 && Board[0][4] != 0 && Board[0][5] != 0 && Board[0][6] != 0) {
            return true;
        }
        else
        {
            return false;
        }

    }
}
