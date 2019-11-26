
public class EvaluateScore
{
    private int bestMove;
    private int numberOfNodes;

    public EvaluateScore()
    {
        numberOfNodes = 0;
    }

    public int Evaluate(int Board[][], int currentPlayer)
    {
        int score = 0;
        int empty = 0;
        int Connected = 0;
        for(int i = 0; i<4; i++)
        {
            for(int x = 0; x<=5; x++)
            {
                Connected = 0;
                empty = 0;
                if(Board[x][i] == currentPlayer)
                    Connected++;
                if(Board[x][i+1] == currentPlayer)
                    Connected++;
                if(Board[x][i+2] == currentPlayer) 
                    Connected++;
                if(Board[x][i+3] == currentPlayer)
                    Connected++;
                if(Board[x][i] == 0)
                    empty++;
                if(Board[x][i+1] == 0)
                    empty++;
                if(Board[x][i+2] == 0) 
                    empty++;
                if(Board[x][i+3] == 0)
                    empty++;    
                score = score + EvaluationCalc(Board,Connected, empty);
            }
        }

        Connected = 0;
        //check vertical
        for(int x = 0; x<= 6; x++)
        {
            for(int i = 0; i<3; i++)
            { 
                Connected = 0;
                empty = 0;
                if(Board[i][x] == currentPlayer)
                    Connected++;
                if(Board[i+1][x] == currentPlayer)
                    Connected++;
                if(Board[i+2][x] == currentPlayer) 
                    Connected++;
                if(Board[i+3][x] == currentPlayer)
                    Connected++;
                if(Board[i][x] == 0)
                    empty++;
                if(Board[i+1][x] == 0)
                    empty++;
                if(Board[i+2][x] == 0) 
                    empty++;
                if(Board[i+3][x] == 0)
                    empty++;    
                score = score + EvaluationCalc(Board,Connected, empty);
            }   
        }

        Connected = 0;
        empty = 0;
        //check postitive diagonal
        if(Board[2][0] == currentPlayer )
            Connected++;
        if(Board[3][1] == currentPlayer )
            Connected++;
        if(Board[4][2] == currentPlayer) 
            Connected++;
        if(Board[5][3] == currentPlayer)
            Connected++;
        if(Board[2][0] == 0 )
            empty++;
        if(Board[3][1] == 0 )
            empty++;
        if(Board[4][2] == 0) 
            empty++;
        if(Board[5][3] == 0)
            empty++;    
        score = score + EvaluationCalc(Board,Connected, empty);

        Connected = 0;
        empty = 0;
        if(Board[0][3] == currentPlayer)
            Connected++;
        if(Board[1][4] == currentPlayer)
            Connected++;
        if(Board[2][5] == currentPlayer)
            Connected++;
        if(Board[3][6] == currentPlayer)
            Connected++; 
        if(Board[0][3] == 0)
            empty++;
        if(Board[1][4] == 0)
            empty++;
        if(Board[2][5] == 0)
            empty++;
        if(Board[3][6] == 0)
            empty++;        
        score = score + EvaluationCalc(Board,Connected, empty);

        Connected = 0;
        empty = 0;
        int row = 1;
        int col = 0;
        for(int i = 0; i<2; i++)
        {
            Connected = 0;
            empty = 0;
            if(Board[row][col] == currentPlayer) 
                Connected++; 
            if(Board[row+1][col+1] == currentPlayer) 
                Connected++; 
            if(Board[row+2][col+2] == currentPlayer) 
                Connected++; 
            if(Board[row+3][col+3] == currentPlayer)
                Connected++;
            if(Board[row][col] == 0) 
                empty++; 
            if(Board[row+1][col+1] == 0) 
                empty++; 
            if(Board[row+2][col+2] == 0) 
                empty++; 
            if(Board[row+3][col+3] == 0)
                empty++;    
            score = score + EvaluationCalc(Board,Connected, empty);

            Connected = 0;
            empty = 0;

            if(Board[row-1][col+2] == currentPlayer)
                Connected++;
            if(Board[row][col+3] == currentPlayer )
                Connected++;
            if(Board[row+1][col+4] == currentPlayer)
                Connected++;
            if(Board[row+2][col+5] == currentPlayer)
                Connected++;
            if(Board[row-1][col+2] == 0)
                empty++;
            if(Board[row][col+3] == 0 )
                empty++;
            if(Board[row+1][col+4] == 0)
                empty++;
            if(Board[row+2][col+5] == 0)
                empty++;    
            score = score + EvaluationCalc(Board,Connected, empty);
            col ++;
            row ++;
        }

        Connected = 0;
        row = 0;
        col = 0;
        for(int i = 0; i<3; i++)
        {
            Connected = 0;
            empty = 0;
            if(Board[row][col] == currentPlayer )
                Connected++;
            if(Board[row+1][col+1] == currentPlayer) 
                Connected++;
            if(Board[row+2][col+2] == currentPlayer) 
                Connected++;
            if(Board[row+3][col+3] == currentPlayer)
                Connected++;
            if(Board[row][col] == 0 )
                empty++;
            if(Board[row+1][col+1] == 0) 
                empty++;
            if(Board[row+2][col+2] == 0) 
                empty++;
            if(Board[row+3][col+3] == 0)
                empty++;    
            score = score + EvaluationCalc(Board,Connected, empty);

            Connected = 0;
            empty = 0;
            if(Board[row][col+1] == currentPlayer)
                Connected++;
            if(Board[row+1][col+2] == currentPlayer) 
                Connected++;
            if(Board[row+2][col+3] == currentPlayer) 
                Connected++;
            if(Board[row+3][col+4] == currentPlayer)
                Connected++;
             if(Board[row][col+1] == 0)
                empty++;
            if(Board[row+1][col+2] == 0) 
                empty++;
            if(Board[row+2][col+3] == 0) 
                empty++;
            if(Board[row+3][col+4] == 0)
                empty++;   
            score = score + EvaluationCalc(Board,Connected, empty);
            col ++;
            row ++;
        }

        //check negitive diagonal
        Connected = 0;
        empty = 0;
        if(Board[0][3] == currentPlayer) 
            Connected++;
        if(Board[1][2] == currentPlayer )
            Connected++;
        if(Board[2][1] == currentPlayer) 
            Connected++;
        if(Board[3][0] == currentPlayer)
            Connected++;
        if(Board[0][3] == 0) 
            empty++;
        if(Board[1][2] == 0 )
            empty++;
        if(Board[2][1] == 0) 
            empty++;
        if(Board[3][0] == 0)
            empty++;    
        score = score + EvaluationCalc(Board,Connected, empty);
        Connected = 0;
        empty = 0;

        if(Board[2][6] == currentPlayer) 
            Connected++;
        if(Board[3][5] == currentPlayer)
            Connected++;
        if(Board[4][4] == currentPlayer)
            Connected++;
        if(Board[5][3] == currentPlayer)
            Connected++;
        if(Board[2][6] == 0) 
            empty++;
        if(Board[3][5] == 0)
            empty++;
        if(Board[4][4] == 0)
            empty++;
        if(Board[5][3] == 0)
            empty++;    
        score = score + EvaluationCalc(Board,Connected, empty);
        Connected = 0;
        empty = 0;

        row = 0;
        col = 4;
        for(int i = 0; i<2; i++)
        {
            Connected = 0;
            empty = 0;
            if(Board[row][col] == currentPlayer) 
                Connected++;
            if(Board[row+1][col-1] == currentPlayer) 
                Connected++;
            if(Board[row+2][col-2] == currentPlayer)
                Connected++;
            if(Board[row+3][col-3] == currentPlayer)
                Connected++;
            if(Board[row][col] == 0) 
                empty++;
            if(Board[row+1][col-1] == 0) 
                empty++;
            if(Board[row+2][col-2] == 0)
                empty++;
            if(Board[row+3][col-3] == 0)
                empty++;    
            score = score + EvaluationCalc(Board,Connected, empty);
            Connected = 0; 
            empty = 0;
            if(Board[row+1][col+2] == currentPlayer)
                Connected++;
            if(Board[row+2][col+1] == currentPlayer)
                Connected++;
            if(Board[row+3][col] == currentPlayer) 
                Connected++;
            if(Board[row+4][col-1] == currentPlayer)
                Connected++;
            if(Board[row+1][col+2] == 0)
                empty++;
            if(Board[row+2][col+1] == 0)
                empty++;
            if(Board[row+3][col] == 0) 
                empty++;
            if(Board[row+4][col-1] == 0)
                empty++;    
            score = score + EvaluationCalc(Board,Connected, empty);
            row ++;
            col --;
        }
        row = 0;
        col = 5;
        for(int i = 0; i<3; i++)
        { 
            Connected = 0;
            empty = 0;
            if(Board[row][col] == currentPlayer) 
                Connected++;
            if(Board[row+1][col-1] == currentPlayer)
                Connected++;
            if(Board[row+2][col-2] == currentPlayer) 
                Connected++;
            if(Board[row+3][col-3] == currentPlayer)
                Connected++;
            if(Board[row][col] == 0) 
                empty++;
            if(Board[row+1][col-1] == 0)
                empty++;
            if(Board[row+2][col-2] == 0) 
                empty++;
            if(Board[row+3][col-3] == 0)
                empty++;    
            score = score + EvaluationCalc(Board,Connected, empty);
            Connected = 0;
            empty = 0;
            if(Board[row][col+1] == currentPlayer )
                Connected++;
            if(Board[row+1][col] == currentPlayer )
                Connected++;
            if(Board[row+2][col-1] == currentPlayer )
                Connected++;
            if(Board[row+3][col-2] == currentPlayer)
                Connected++;
            if(Board[row][col+1] == 0 )
                empty++;
            if(Board[row+1][col] == 0 )
                empty++;
            if(Board[row+2][col-1] == 0 )
                empty++;
            if(Board[row+3][col-2] == 0)
                empty++; 
            score = score + EvaluationCalc(Board,Connected, empty);
            row ++;
            col --;
        }

        return score;
    }

    public int EvaluationCalc(int Board[][],int connected, int empty)//calculates the score of the current board
    {
        int score = 0;//then score that will be returned

        if (connected == 4)//if its going to be a win (4 pieces in a row)
        {
            score = score + 100;
        }
        else if(connected == 3 && empty == 1)//if there is 3 pieces and a free slot
        {
            score = score + 5;
        }
        else if(connected == 2 && empty == 2)//if there is two pieces and 2 free slots
        {
            score = score + 2;
        }

        if (connected == 0 && empty == 1)// if there is only a free slot and the opponent has filled 3
        {
            score = score - 4;
        }


        return score;//returns the score back to the user
    }

    public int getBestMove()
    {
        return bestMove;
    }//returns the best move
    public void setBestMove(int move)
    {
        bestMove = move;
    }//sets the new best move

    public int perft()
    {
        return numberOfNodes;
    }//retunrs number of nodes at a depth
    public void addNode()
    {
        numberOfNodes ++;
    }//increments the number of nodes made at a depth
    public void clearNodes()
    {
        numberOfNodes =0;
    }//resets the number of nodes at a depth

}
