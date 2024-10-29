//Grant Williams gmw140030
import java.util.ArrayList;

public class GameTree {
    public class GameNode {
        int [][] source; //problem state
        GameNode parent;// previous state
        int f_value;//f-value = depth + Manhattan Distance
        double depth;//depth
        //first node for the GameTree is initialized by this method
        private GameNode(int [][] n)
        {
            source = n;
            depth = 0;
            f_value = 0 + new BoardState().MDistance(n);
            parent = null;
        }
        //all nodes after the first node are initialized by this method
        private GameNode(TileBoard n, double d)
        {
            source = n.getTiles();
            depth = d + 1;
            f_value = (int)depth + new BoardState().MDistance(n.getTiles());
            parent = null;
        }
        // returns the f_value
        private int getF_Value() {return f_value;}
        private int[][] getSource()
        {   return source;   }
        // the second print board function
        //  prints the problem state as it is stored in the node
        public void printBoard()
        {
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                    System.out.print(source[i][j] + "\t");
                System.out.println();
            }
            System.out.println();
        }
    }
    GameNode root;//first node in tree
    GameNode goal; //goal node in tree
    
    public GameTree(int [][] n)
    {
        root = new GameNode(n);
    }
    //creates the possible nodes (up to 4) for each problem state and stores them
    // in an ArrayList which is then returned to RBFS
    public ArrayList<GameNode> createChildren(GameNode node)
    {
        ArrayList<GameNode> arr = new ArrayList();
        TileBoard adUp = new TileBoard(node.source);
        TileBoard adDown = new TileBoard(node.source);
        TileBoard adLeft = new TileBoard(node.source);
        TileBoard adRight = new TileBoard(node.source);
        boolean u = adUp.chUp();
        boolean d = adDown.chDown();
        boolean l = adLeft.chLeft();
        boolean r = adRight.chRight();
        //adUp.printBoard();
        if(u)
        {   
            adUp.up();
            //System.out.println("adup");
            //adUp.printBoard();
            GameNode UP = new GameNode(adUp,node.depth);
            UP.parent = node;
            arr.add(UP);
        }
        if(d)
        {
            adDown.down();
            //System.out.println("addown");
            //adDown.printBoard();
            GameNode DOWN = new GameNode(adDown,node.depth);
            DOWN.parent = node;
            arr.add(DOWN);
        }
        if(l)
        {
            adLeft.left();
            //System.out.println("adLeft");
            //adLeft.printBoard();
            GameNode LEFT = new GameNode(adLeft,node.depth);
            LEFT.parent = node;
            arr.add(LEFT);
        }
        if(r)
        {
            adRight.right();
            //System.out.println("adRight");
            //adRight.printBoard();
            GameNode RIGHT = new GameNode(adRight,node.depth);
            arr.add(RIGHT);
        }
        return arr;
    }
    // Tuple class stores teh node and f_value allowing for \
    //  node to equal null for the Recursive Best First Search
    public class Tuple{
        GameNode node;
        //int[][] s;
        double f_value;
        public Tuple(GameNode n, double f)
        {
            node = n;
            //s = n.source;
            f_value = f;
        }
    }
    public GameNode RecursiveBestFirstSearch()
    {
        return RBFS(root,Double.POSITIVE_INFINITY).node;
    }
    public Tuple RBFS(GameNode node, double f_limit)
    {
        BoardState ch = new BoardState(); 
        if(ch.MDistance(node.source) == 0)
            return new Tuple(node,node.f_value);//goal state reached
        ArrayList<GameNode> successors = createChildren(node);
        if(successors.isEmpty())
            return new Tuple(null, Double.POSITIVE_INFINITY);//fail state
        for(GameNode s: successors)
            s.f_value = Math.max(node.f_value, s.getF_Value());
        
        while(true)
        {
            successors.sort((x,y)->x.f_value-y.f_value);
            GameNode lowest = successors.get(0);
            int alt = successors.get(1).f_value;
            if(lowest.f_value > f_limit) {
                return new Tuple(null,lowest.f_value);//fail state
            }
            Tuple result = RBFS(lowest,Math.min(f_limit,alt));//recursively calls the next probable state to reach goal
            lowest.f_value = (int) result.f_value;
            
            if(result.node != null)
                return result;//goal state returned from above goal state reached line
        }
    }
    // prints the resulting path from start to goal
    public void printResults(GameNode n)
    {
        if(n.parent != null)
            printResults(n.parent);
        n.printBoard();
    }
    public void printNewChildren()
    {
        ArrayList<GameNode> arr = createChildren(root);
        for(int i = 0; i < arr.size(); i++)
        {
            System.out.println(i);
            arr.get(i).printBoard();
        }
        
    }
}
