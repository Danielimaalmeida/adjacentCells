package algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecursionIdentifierTest {


    /**
     * GIVEN a 2DArray
     * WHEN we call the method findAllNodes
     * THEN the method should return a list with all nodes of adjacent points in the given 2DArray
     */
    @Test
    void findAllNodestoString() {

        List<String> expectedResult = new ArrayList<>();
        String line1 = "Node 0: [0, 3][1, 3][1, 2][1, 4]";
        String line2 = "Node 1: [0, 6][0, 7][1, 7][1, 6][2, 6][3, 6][3, 7][4, 7][4, 6]";
        String line3 = "Node 2: [3, 3][4, 3]";
        expectedResult.add(line1);
        expectedResult.add(line2);
        expectedResult.add(line3);

        //GIVEN a 2DArray
        int[][] matrix = new int[][]{{0,0,0,1,0,0,1,1},
                {0,0,1,1,1,0,1,1},
                {0,0,0,0,0,0,1,0},
                {0,0,0,1,0,0,1,1},
                {0,0,0,1,0,0,1,1}};


        //WHEN we call the method findAllNodes
        AdjacentCellsIdentifier recursion = new RecursionIdentifier(matrix.length, matrix[0].length);
        List<Node> nodes = recursion.findAllNodes(matrix);
        List<String> nodesToString = ((RecursionIdentifier) recursion).findAllNodestoString(nodes);

        //THEN the method should return a list with all nodes of adjacent points in the given 2DArray
        assertEquals(expectedResult, nodesToString);
    }


    /**
     * GIVEN a 2DArray
     * WHEN we call the method findAllNodes
     * THEN the method should return a list with all nodes of adjacent points in the given 2DArray
     */
    @Test
    void findAllNodes() {

        List<Node> expectedResult = new ArrayList<>();
        Node node1 = new Node();
        node1.addPointToNode(new Point(0, 3));
        node1.addPointToNode(new Point(1, 3));
        node1.addPointToNode(new Point(1, 2));
        expectedResult.add(node1);

        //GIVEN a 2DArray that has only one node of adjacent points
        int[][] matrix = new int[][]{{0,0,0,1},{0,0,1,1}};



        //WHEN we call the method findAllNodes
        AdjacentCellsIdentifier recursion = new RecursionIdentifier(matrix.length, matrix[0].length);
        List<Node> nodes = recursion.findAllNodes(matrix);


        //THEN the method should return a list with only one node
        assertEquals(expectedResult.get(0).getPoints().get(0), nodes.get(0).getPoints().get(0));
        assertEquals(expectedResult.get(0).getPoints().get(1), nodes.get(0).getPoints().get(1));
        assertEquals(expectedResult.get(0).getPoints().get(2), nodes.get(0).getPoints().get(2));
        assertTrue(nodes.size() == 1);
    }
}