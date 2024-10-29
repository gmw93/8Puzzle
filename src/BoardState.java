//Grant Williams gmw140030
import java.lang.Math;


public class BoardState {
    //This class takes in the goal state that is expected at the end and stores it.
    // It also takes in the problem state temporarily and then compares it to the 
    // goal state to find the Manhattan Distance
    private static int [][] goal = {{0,1,2},{3,4,5},{6,7,8}};
    public int MDistance(int[][] prob)
    {
        int mD = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(prob[i][j] == 0)
                {
                    mD = mD + Math.abs(i - 0) + Math.abs(j - 0);
                }
                if(prob[i][j] == 1)
                {
                    mD = mD + Math.abs(i - 0) + Math.abs(j - 1);
                }
                if(prob[i][j] == 2)
                {
                    mD = mD + Math.abs(i - 0) + Math.abs(j - 2);
                }
                if(prob[i][j] == 3)
                {
                    mD = mD + Math.abs(i - 1) + Math.abs(j - 0);
                }
                if(prob[i][j] == 4)
                {
                    mD = mD + Math.abs(i - 1) + Math.abs(j - 1);
                }
                if(prob[i][j] == 5)
                {
                    mD = mD + Math.abs(i - 1) + Math.abs(j - 2);
                }
                if(prob[i][j] == 6)
                {
                    mD = mD + Math.abs(i - 2) + Math.abs(j - 0);
                }
                if(prob[i][j] == 7)
                {
                    mD = mD + Math.abs(i - 2) + Math.abs(j - 1);
                }
                if(prob[i][j] == 8)
                {
                    mD = mD + Math.abs(i - 2) + Math.abs(j - 2);
                }
            }
        }
        return mD;
    }
}
