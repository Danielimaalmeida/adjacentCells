package algorithm;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

public class Main {




    public static void main(String[] args) throws ParseException, IOException {

        //Instantiates the reader interface
        ArrayReader reader = new JsonArrayReader();

        try {

            int[][] matrix = reader.readFile("1000x1000.json");

            //Instantiation of the adjacent cells identifier
            AdjacentCellsIdentifier recursion = new RecursionIdentifier(matrix.length, matrix.length);

            //Gets the nodes of adjacent cells from the given 2-Dimensional Array
            List<Node> nodes = recursion.findAllNodes(matrix);

            //Prints the nodes
            ((RecursionIdentifier) recursion).findAllNodestoString(nodes).forEach(System.out::println);
        }

        catch (FileNotFoundException exception) {

            System.out.println("File not found " + exception.getMessage());

        }

    }
}

