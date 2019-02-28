package algorithm;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ArrayReader {

    /**
     * This method receives a file path with a Json file and parses it to a 2-Dimensional Array
     *
     * @param filepath file to parse
     * @return 2-Dimensional Integer Array
     * @throws ParseException
     * @throws IOException
     */int[][] readFile(String filepath) throws ParseException, IOException;
}
