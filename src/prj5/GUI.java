package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;


/**
 * This class represents the window 
 * than contains the statistics
 * analysis.
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 2nd of December
 *
 */
public class GUI 
{
    private final Double barHeight = 2.0;
    private SLList<Influencer> current;
    private SLList<Influencer> theList;
    private SLList<Influencer> firstQ;
    private SLList<Influencer> janList;
    private SLList<Influencer> febList;
    private SLList<Influencer> marList;
    private SortingTheInfo sorter;
    private SLList<Influencer> colorUse;
    private Window window;
    
    private Button sortChannelName; //north
    private Button sortEngRate; //north
    private Button quit; //north
    
    private Button tradEngRate; //west
    private Button reachEngRate; //west
    
    private Button jan; //south
    private Button feb; //south
    private Button mar; //south
    private Button quarter; //south
    
    //Button trackers
    private boolean sortChannelClicked = true;
    private boolean engRateClicked = false;
    private boolean tradRateClicked = true;
    private boolean reachClicked = false;
    private boolean janClicked = false;
    private boolean febClicked = false;
    private boolean marClicked = false;
    private boolean quartClicked = false;
    
    //Bar graphs
    private Shape bar;
    
    /**
     * This is the constructor for the class.
     * It basically instantiates objects to 
     * certain values.
     * 
     * @param sorting Represents a Sorter object
     *                that handles the sorting 
     *                mechanisms for each list.
     */
    public GUI(SortingTheInfo sorting)
    {
        //Initializing the window.
        window = new Window("Social Media Company");
        window.setSize(1200, 700);
        
        sorter = sorting;
        theList = sorter.getList();
        current = sorter.getFirstQuarter(theList);
        current = sorter.sortByTraditionalEngagement(current);
        
        //Splitting up months into diff lists.
        firstQ = sorter.getFirstQuarter(theList);
        janList = sorter.getJanuary(theList);
        febList = sorter.getFebruary(theList);
        marList = sorter.getMarch(theList);
        
        //Initializing the color of the bars.
        colorUse = sorter.getFirstQuarter(theList);

        
        //--------------------------------------------------------
        sortChannelName = new Button("Sort by Channel Name");
        sortChannelName.onClick(this, "clickedSortChannelName");
        window.addButton(sortChannelName, WindowSide.NORTH);
        
        sortEngRate = new Button("Sort by Engagement Rate");
        sortEngRate.onClick(this, "clickedSortEngRate");
        window.addButton(sortEngRate, WindowSide.NORTH);
        
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);
        //--------------------------------------------------------
        tradEngRate = new Button("Traditional Engagement Rate");
        tradEngRate.onClick(this, "clickedTradEngRate");
        window.addButton(tradEngRate, WindowSide.WEST);
        
        reachEngRate = new Button("Reach Engagement Rate");
        reachEngRate.onClick(this, "clickedReachEngRate");
        window.addButton(reachEngRate, WindowSide.WEST);
        //--------------------------------------------------------
        jan = new Button("Januray");
        jan.onClick(this, "clickedJanuary");
        window.addButton(jan, WindowSide.SOUTH);
        
        feb = new Button("February");
        feb.onClick(this, "clickedFebruary");
        window.addButton(feb, WindowSide.SOUTH);
        
        mar = new Button("March");
        mar.onClick(this, "clickedMarch");
        window.addButton(mar, WindowSide.SOUTH);
        
        quarter = new Button("First Quarter (Jan - March)");
        quarter.onClick(this, "clickedFirstQuarter");
        window.addButton(quarter, WindowSide.SOUTH);
        //--------------------------------------------------------

        //Default display
        display();
    }
    
    
    /**
     * This method sorts whatever data present
     * on the window by the channel name, which
     * is also known to be alphabetically ascending.
     * 
     * @param sortChannelButton Represents the sortChannel button.
     */
    public void clickedSortChannelName(Button sortChannelButton)
    {
        window.removeAllShapes();
        //revert booleans to original values.
        sortChannelClicked = true;
        engRateClicked = false;
        current = sorter.sortByChannel(current);
        
        if (tradRateClicked)
        {
            buildTrad(current);
        }
        else if (reachClicked)
        {
            buildReach(current);
        }
        buildInfo();
    }
    
    /**
     * This method narrows the information that
     * is present on the window to only contain
     * data from the month January.
     * 
     * @param janButton Represents the January button.
     */
    public void clickedJanuary(Button janButton)
    {
        //revert booleans to original values.
        janClicked = true;
        febClicked = false;
        marClicked = false;
        quartClicked = false;
        current = janList;
        if (sortChannelClicked)
        {
            current = sorter.sortByChannel(current);
            if (tradRateClicked)
            {
                buildTrad(current);
            }
            else if (reachClicked)
            {
                buildReach(current);
            }
        }
        else if (engRateClicked)
        {
            if (tradRateClicked)
            {
                current = sorter.sortByTraditionalEngagement(current);
                buildTrad(current);
            }
            else if (reachClicked)
            {
                current = sorter.sortByReachEngagement(current);
                buildReach(current);
            }  
        }
        buildInfo();
    }
    
    /**
     * This method narrows the information that
     * is present on the window to only contain
     * data from the month February.
     * 
     * @param febButton Represents the February button.
     */
    public void clickedFebruary(Button febButton)
    {
        //revert booleans to original values.
        janClicked = false;
        febClicked = true;
        marClicked = false;
        quartClicked = false;
        current = febList;
        if (sortChannelClicked)
        {
            current = sorter.sortByChannel(current);
            if (tradRateClicked)
            {
                buildTrad(current);
            }
            else if (reachClicked)
            {
                buildReach(current);
            }
        }
        else if (engRateClicked)
        {
            if (tradRateClicked)
            {
                current = sorter.sortByTraditionalEngagement(current);
                buildTrad(current);
            }
            else if (reachClicked)
            {
                current = sorter.sortByReachEngagement(current);
                buildReach(current);
            }
        }
        buildInfo();
    }
    
    /**
     * This method narrows the information that
     * is present on the window to only contain
     * data from the month March.
     * 
     * @param marButton Represents the March button.
     */
    public void clickedMarch(Button marButton)
    {
        //revert booleans to original values.
        janClicked = false;
        febClicked = false;
        marClicked = true;
        quartClicked = false;
        current = marList;
        if (sortChannelClicked)
        {
            current = sorter.sortByChannel(current);
            if (tradRateClicked)
            {
                buildTrad(current);
            }
            else if (reachClicked)
            {
                buildReach(current);
            }
        }
        else if (engRateClicked)
        {
            if (tradRateClicked)
            {
                current = sorter.sortByTraditionalEngagement(current);
                buildTrad(current);
            }
            else if (reachClicked)
            {
                current = sorter.sortByReachEngagement(current);
                buildReach(current);
            }  
        }
        buildInfo();
    }
    
    /**
     * This method narrows the information that
     * is present on the window to contain
     * data from the first three months of the year.
     * 
     * @param quartButton Represents the first quarter button.
     */
    public void clickedFirstQuarter(Button quartButton)
    {
        //revert booleans to original values.
        janClicked = false;
        febClicked = false;
        marClicked = false;
        quartClicked = true;
        current = firstQ;
        if (sortChannelClicked)
        {
            current = sorter.sortByChannel(current);
            if (tradRateClicked)
            {
                buildTrad(current);
            }
            else if (reachClicked)
            {
                buildReach(current);
            }
        }
        else if (engRateClicked)
        {
            if (tradRateClicked)
            {
                current = sorter.sortByTraditionalEngagement(current);
                buildTrad(current);
            }
            else if (reachClicked)
            {
                current = sorter.sortByReachEngagement(current);
                buildReach(current);
            }  
        }
        buildInfo();
    }
    
    /**
     * This method calculates the reach engagement rate and 
     * presents it on the window.
     * 
     * @param reachButton Represents the reach rate button.
     */
    public void clickedReachEngRate(Button reachButton)
    {
        if (engRateClicked)
        {
            current = sorter.sortByReachEngagement(current);
        }
        tradRateClicked = false;
        reachClicked = true;
        buildReach(current);
        buildInfo();
    }
    
    /**
     * This method calculates the traditiona; engagement rate and 
     * presents it on the window.
     * 
     * @param tradButton Represents the traditional rate button.
     */
    public void clickedTradEngRate(Button tradButton)
    {
        if (engRateClicked)
        {
            current = sorter.sortByTraditionalEngagement(current);
            //sortChannelClicked = false;
        }
        
        tradRateClicked = true;
        reachClicked = false;
        buildTrad(current);
        buildInfo();
        
    }
    
    
    /**
     * This method shows the user which 
     * category they're looking at, and
     * which sorting mechanism is used
     * to display the data.
     */
    private void buildInfo()
    {
        int height = window.getHeight() / 20;
        //Period
        TextShape period = new TextShape(50, height, "");
        if (janClicked)
        {
            period.setText("Time Period: January");
        }
        else if (febClicked)
        {
            period.setText("Time Period: February");
        }
        else if (marClicked)
        {
            period.setText("Time Period: March");
        }
        else if (quartClicked)
        {
            period.setText("Time Period: First Quarter (Jan - March)");
        }
        
        //Formula
        TextShape formula = new TextShape(50, height + 15, "");
        if (tradRateClicked)
        {
            formula.setText("Formula: Traditional Engagement Rate");
        }
        else if (reachClicked)
        {
            formula.setText("Formula: Reach Engagement Rate");
        }
        
        //Sorting view
        TextShape view = new TextShape(50, height + 30, "");
        if (sortChannelClicked)
        {
            view.setText("Sorting View: Channel Name");
        }
        else if (engRateClicked)
        {
            view.setText("Sorting View: Engagement Rate");
        }
        
        window.addShape(period);
        window.addShape(formula);
        window.addShape(view);
    }
    
    /**
     * This method is used to build the numbers
     * calculated to display the traditional engagement rate
     * under the corresponding channel name.
     * 
     * @param sortedList Represents the sorted list
     *                   that the data is being taken
     *                   from.
     */
    private void buildTrad(SLList<Influencer> sortedList)
    {
        window.removeAllShapes();
        int width = window.getWidth() / 8;
        int height01 = (window.getHeight() / 3) * 2;
        int height02 = ((window.getHeight() / 3) * 2) + 50;
        
        for (int x = 0; x < sortedList.getSize(); x++)
        {
            String channelName = sortedList.get(x).getChannelName();
            Double rate = current.get(x).getEngagementRate();
            if (rate.isInfinite())
            {
                String NA = "N/A";
                TextShape trad = new TextShape(width + (200 * x), height02, NA);
                window.addShape(trad);
            }
            else
            {
                String decimal = String.format("%.1f", rate);
                TextShape trad = new TextShape(width + (200 * x), height02, decimal);
                window.addShape(trad);
                buildBar(x);
            }
            TextShape name = new TextShape(width + (200 * x), height01, channelName);
            window.addShape(name);
            buildBar(x);
        }
    }
    
    /**
     * This method is used to build the numbers
     * calculated to display the reach engagement rate
     * under the corresponding channel name.
     * 
     * @param sortedList Represents the sorted list
     *                   that the data is being taken
     *                   from.
     */
    private void buildReach(SLList<Influencer> sortedList)
    {
        window.removeAllShapes();
        int width = window.getWidth() / 8;
        int heightName = (window.getHeight() / 3) * 2;
        int heightRate = ((window.getHeight() / 3) * 2) + 50;
        
        for (int x = 0; x < sortedList.getSize(); x++)
        {
            String channelName = sortedList.get(x).getChannelName();
            Double rate = current.get(x).getReachEngagementRate();
            if (rate.isInfinite())
            {
                String NA = "N/A";
                TextShape reach = new TextShape(width + (200 * x), heightRate, NA);
                window.addShape(reach);
            }
            else
            {
                String decimal = String.format("%.1f", rate);
                TextShape reach = new TextShape(width + (200 * x), heightRate, decimal);
                window.addShape(reach);
                buildBar(x, 1);
                
            }
            TextShape name = new TextShape(width + (200 * x), heightName, channelName);
            window.addShape(name);
            buildBar(x, 1);
        }
    }
    
    
    /**
     * This method is called in the
     * constructor, which allows data
     * to be displayed by certain 
     * values once the window opens
     * up on the screen.
     */
    private void display()
    {
        clickedFirstQuarter(quarter);
        current = sorter.sortByChannel(current);
        buildTrad(current);
        buildInfo();
    }
    
    /**
     * This method is used to build the bar graphs
     * that represent the value of the traditional
     * engagement rates.
     * 
     * @param x Represents the index of the color
     *          that the influencer holds.
     */
    private void buildBar(int x) {
        int width = window.getWidth();
        int width1 = width / 8;
        int y = ((window.getHeight() / 3) * 2) - 50;
        this.bar = null;

        for (int i = 0; i <= x; i++) {

            Double rate = current.get(i).getEngagementRate() * barHeight;
            if (!rate.isInfinite()) {
                int wide = (width1 + ((i * 2) * 100));
                this.bar = new Shape(wide, y - rate.intValue(), 40, rate
                    .intValue(), assignColor(x));
            }
        }
        window.addShape(bar);
    }
    
    /**
     * This method is used to build the bar graphs
     * that represent the value of the reach
     * engagement rates.
     * 
     * @param x Represents the index of the color
     *          that the influencer holds.
     * @param z is used to as an extra parameter
     *          to differentiate between the two
     *          methods which have the same name.
     */
    private void buildBar(int x, int z) 
    {
        int width = window.getWidth();
        int width1 = width / 8;

        int y = ((window.getHeight() / 3) * 2) - 50;
        this.bar = null;
        for (int i = 0; i <= x; i++) {
            Double rate = current.get(i).getReachEngagementRate() * barHeight;
            if (!rate.isInfinite()) {

                int wide = (width1 + ((i * 2) * 100));
                this.bar = new Shape(wide, y - rate.intValue(), 40, rate
                    .intValue(), assignColor(x));
            }
        }
        window.addShape(bar);
    }

    /**
     * This method is used to assign colors
     * for each inluencer's bar graph.
     * 
     * @param num Represents the position of
     *            the influencer in the list.
     * @return a Color object representing the 
     *         color of the bar graph.
     */
    private Color assignColor(int num) {
        if (current.get(num).getChannelName().equals(colorUse.get(0)
            .getChannelName())) {
            return Color.red;
        }
        else if (current.get(num).getChannelName().equals(colorUse.get(1)
            .getChannelName())) {
            return Color.blue;
        }
        else if (current.get(num).getChannelName().equals(colorUse.get(2)
            .getChannelName())) {
            return Color.green;
        }
        else if (current.get(num).getChannelName().equals(colorUse.get(3)
            .getChannelName())) {
            return Color.magenta;
        }
        return Color.black;
    }
    
    /**
     * This method sorts the presented data
     * by either their traditional or reach
     * engagement rate.
     * 
     * @param engRate Represents a button for
     *                for the engagement rate option.
     */
    public void clickedSortEngRate(Button engRate)
    {
        sortChannelClicked = false;
        engRateClicked = true;
        if (tradRateClicked)
        {
            current = sorter.sortByTraditionalEngagement(current);
            buildTrad(current);
        }
        else if (reachClicked)
        {
            current = sorter.sortByReachEngagement(current);
            buildReach(current);
        }
        else
        {
            buildTrad(current);
        }
        buildInfo();
    }
    
    /**
     * This method allows the user to click
     * the quit button and close the window.
     * 
     * @param quitted Represents the quit button.
     */
    public void clickedQuit(Button quitted)
    {
        System.exit(0);
    }
}