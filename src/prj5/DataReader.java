package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 *
 */
public class DataReader 
{
    private SortingTheInfo sorter;
    private SLList<Influencer> temp;
    
    public DataReader(String fileName) throws java.text.ParseException,
    java.io.FileNotFoundException
    {
        temp = readFile(fileName);
        sorter = new SortingTheInfo(temp);
        GUI newGui = new GUI(sorter);
    }
    
    /**
     * This method reads and parses in the provided file.
     */
    public SLList<Influencer> readFile(String fileName) throws FileNotFoundException
    {
        SLList<Influencer> newList = new SLList<Influencer>();
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();
        while (file.hasNextLine())
        {
            String read = file.nextLine();
            Scanner currentLine = new Scanner(read).useDelimiter(",\\s*");
            String[] array = new String[10];
            int indexOfLine = 0;
            while ((currentLine.hasNext()) && (indexOfLine < 10))
            {
                array[indexOfLine] = currentLine.next();
                indexOfLine++;
            }
            currentLine.close();
            if (indexOfLine == 10) 
            {
                String month = array[0];
                String userName = array[1];
                String channelName = array[2];
                String countryName = array[3];
                String mainTopic = array[4];
                int likes = Integer.valueOf(array[5]);
                int posts = Integer.valueOf(array[6]);
                int followers = Integer.valueOf(array[7]);
                int comments = Integer.valueOf(array[8]);
                int views = Integer.valueOf(array[9]);
                
                if (checkValidity(month, userName, channelName, mainTopic))
                {
                    Influencer inf = new Influencer(month, userName, channelName, countryName, mainTopic, likes, posts, followers, comments, views);
                    newList.add(inf);
                }
            }
        }
        file.close();
        return newList;
    }
    
    
    
    /**
     * This method checks if the read data is valid
     */
    private boolean checkValidity(String month, String name, String channel, String topic)
    {
        int counter = 0;
        if (month != null && month.length() > 0)
        {
            counter++;
        }
        
        if (name != null && name.length() > 0)
        {
            counter++;
        }
        if (channel != null && channel.length() > 0)
        {
            counter++;
        }
        if (topic != null && topic.length() > 0)
        {
            counter++;
        }
        return (counter == 4);
    }
}
