package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Palagu
 * @version 18th of November
 *
 */
public class Input {
    /**
     * 
     * @param args
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws ProjectDataException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            try {
                new DataReader(args[0]);
            }
            catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                new DataReader("SampleInput1_2022.csv");
            }
            catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
