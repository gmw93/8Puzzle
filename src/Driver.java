//Grant Williams
// gmw140030
// cs 4365.002
// 10/13/18
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    //controls the whole project, calling on the primary methods that may or may not
    // call on other methods
    public static void main(String args[]) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int[][] probBoard = tiler();
        GameTree puzzleSolver = new GameTree(probBoard);
        puzzleSolver.printResults(puzzleSolver.RecursiveBestFirstSearch());
    }
    //takes in the input file called "input.txt"
    //then extracts line by line the information in the file
    //and breaks up each line by the tabs seperating the numbers
    public static int[][] tiler() throws FileNotFoundException
    {
        File in = new File("input.txt");
        int [][] a = new int [3] [3];
        Scanner sc = new Scanner(in);
        for(int j = 0; j < 3; j++)
        {
            String s = sc.nextLine();
            int i = 0;
            for(String retriev: s.split("\t"))
            {
                a[j][i] = Integer.parseInt(retriev);
                //System.out.print(a[j][i]);
                i++;
            }
            //System.out.println();
        }
        return a;
    }
}
