package algorithm;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonArrayReader implements ArrayReader {

    private int arraySize;

    /**
     * This method receives a file path with a Json file and parses it to a 2-Dimensional Array
     *
     * @param filepath file to parse
     * @return 2-Dimensional Integer Array
     * @throws ParseException
     * @throws IOException
     */
    @Override
    public int[][] readFile(String filepath) throws ParseException, IOException {

        List<int[]> arrayList = parseJsonToString(filepath);

        //Sets the arraySize
        int arraySize = arrayList.get(0).length;
        setArraySize(arraySize);

        int[][] matrix = new int[arraySize][arraySize];

        for(int i = 0; i < arraySize; i++) {
            matrix[i] = arrayList.get(i);
        }

        return matrix;
    }


    private void setArraySize(int arraySize) {
      this.arraySize = arraySize;
    }


    /**
     * This method converts each line of the json file to a 1-Dimensional Array
     *
     * @param filepath FilePath of the json file
     *
     * @return List of int arrays
     *
     * @throws ParseException
     * @throws IOException
     */
    private static List<int[]> parseJsonToString(String filepath) throws ParseException, IOException {

        List<int[]> arrayList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONArray array = (JSONArray) jsonParser.parse(new FileReader(filepath));


        for(int i = 0; i < array.size(); i++) {
            String arrayToString = array.get(i).toString();
            arrayToString = trimArray(arrayToString);
            arrayList.add( convertStringArrayToIntArray(arrayToString));

        }

        return arrayList;
    }


    /**
     * This method converts a string array to a int array
     *
     * @param toConvert String to convert
     *
     * @return Int array
     */
    private static int[] convertStringArrayToIntArray(String toConvert) {

        int[] array = new int[toConvert.length()];
        char[] charArray =  toConvert.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            array[i] = Character.getNumericValue(charArray[i]);
        }

        return array;
    }

    /**
     * This method removes all "," froms a String
     * @param str
     * @return
     */
    private static String trimArray(String str) {
        str = str.substring(1, str.length() - 1);
        str = str.replace(",", "");
        return str;
    }
}
