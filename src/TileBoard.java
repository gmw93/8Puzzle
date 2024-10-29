//Grant Williams gmw140030
public class TileBoard {
    /*
    This class manipulates the data within the Problem Tile Board
        and manipulates the tiles of the problem board.
        The zero action commands:up, down, right, and left
        The Zero check actions: chUp, chDown, chRight, and chLeft
        The Get functions: getTiles, gZC or getZeroColumn, and gZR or getZeroRow
        And this is where the original printBoard function is located
    */
    int[][] pB;
    int zR;
    int zC;
    public TileBoard(int[][] p)
    {
        pB = new int[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
            {
                pB[i][j] = p[i][j];
                if(pB[i][j] == 0)
                {
                    zR = i;
                    zC = j;
                }
            }
    }
    public boolean chUp()
    {
        if(zR - 1 >= 0)
            return true;
        return false;
    }
    public boolean chDown()
    {
        if(zR + 1 <= 2)
            return true;
        return false;
    }
    public boolean chLeft()
    {
        if(zC - 1 >= 0)
            return true;
        return false;
    }
    public boolean chRight()
    {
        if(zC+1 <= 2)
            return true;
        return false;
    }
    public int[][] up()
    {
        //int [][] pB = pB;
        pB[zR][zC] = pB[zR - 1][zC];
        pB[zR-1][zC] = 0;
        zR = zR - 1;
        return pB;
    }
    public int[][] down()
    {
        //int [][] pb = pB;
        pB[zR][zC] = pB[zR + 1][zC];
        pB[zR + 1][zC] = 0;
        zR = zR + 1;
        return pB;
    }
    public int[][] left()
    {
        //int [][] pb = pB;
        pB[zR][zC] = pB[zR][zC - 1];
        pB[zR][zC - 1] = 0;
        zC = zC - 1;
        return pB;
    }
    public int[][] right()
    {
        //int [][] pb = pB;
        pB[zR][zC] = pB[zR][zC + 1];
        pB[zR][zC + 1] = 0;
        zC = zC + 1;
        return pB;
    }
    public int[][] getTiles()
    {    return pB;  }
    public void printBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                System.out.print(pB[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }
    public int gZR(){return zR;}
    public int gZC(){return zC;}
}
