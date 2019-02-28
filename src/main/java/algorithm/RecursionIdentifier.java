package algorithm;
import java.util.ArrayList;
import java.util.List;

public class RecursionIdentifier implements AdjacentCellsIdentifier {

    private static final  int[] horizontalCheck = new int[]{-1, 0, 0, 1};
    private static final int[] verticalCheck = new int[]{0, -1, 1, 0};
    private boolean[][] visitedCells;

    private final int lines;
    private final int columns;

    public RecursionIdentifier(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        visitedCells = new boolean[lines][columns];
    }

    /**
     * This method checks if a certain cell may be out of bounds, if it is equal to 1 and if it was already visitedCells
     *
     * @param matrix  2DArray to search for nodes of adjacent points
     * @param line    x coordinate of the point fo verify
     * @param column  y coordinate of the point fo verify
     * @return TRUE if valid FALSE if not
     */
    private boolean isValid(int[][] matrix, int line, int column) {
        return (line >= 0) && (line < lines) &&
                (column >= 0) && (column < columns) &&
                (!visitedCells[line][column] && (matrix[line][column] == 1));
    }

    /**
     * This method finds all adjacent cells of a given point within a matrix by recursion. For each adjacent cell a new
     * Point with x,y coordinates is created and added to a given cell
     *
     * @param matrix 2DArray to find adjacent cells
     * @param line  x coordinate of the point to add
     * @param column y coordinate of the point to add
     * @param node Node to add adjacent points to
     */
    private void findAdjacentCells(int[][] matrix, int line, int column, Node node) {

        //Marks the current cell as visitedCells
        visitedCells[line][column] = true;

        for (int i = 0; i < horizontalCheck.length; ++i)

            if (isValid(matrix, line + horizontalCheck[i], column + verticalCheck[i])) {
                Point point = new Point(line, column);
                node.addPointToNode(point);
                findAdjacentCells(matrix, line + horizontalCheck[i], column + verticalCheck[i], node);
            }

        Point point = new Point(line, column);
        node.addPointToNode(point);
    }

    /**
     * This method gets all adjacent cells of a given matrix
     *
     * @param matrix 2DArray to find all adjacent Cells
     *
     * @return Returns a list of nodes
     */
    @Override
    public List<Node> findAllNodes(int[][] matrix) {

        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < lines; ++i)
            for (int j = 0; j < columns; ++j)
                if (matrix[i][j]==1 && !visitedCells[i][j])  {

                    Node node = new Node();
                    findAdjacentCells(matrix, i, j, node);

                    if(node.getPoints().size() > 1) {
                        nodeList.add(node);
                    }
                }

        return nodeList;
    }


    /**
     * This method concatenates the points for every node
     *
     * @param nodes Nodes to concatenate
     *
     * @return List of String
     */
    public List<String> findAllNodestoString(List<Node> nodes) {

        int count;
        List<String> allNodes = new ArrayList<>();
        int listSize = nodes.size() <= 10000 ? nodes.size() : 10000;

        for(int i = 0; i < listSize; i++) {
            count = i;
            String nodeId = "Node " + count + ": ";

            StringBuilder node = new StringBuilder();
            node.append(nodeId);

                for (Point point : nodes.get(i).getPoints()) {
                    node.append(point.toString());

            }
            allNodes.add(node.toString());
        }

        return allNodes;
    }
}
