package prj5;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 *
 */
public class SortingTheInfoTest extends student.TestCase {
    private SortingTheInfo s1;
    private SLList<Influencer> s1List;
    private SLList<Influencer> s1Traditional;
    private SLList<Influencer> s1Reach;
    private SLList<Influencer> s1Channel;
    private Influencer r1;
    private Influencer r2;
    private Influencer r3;
    
    /**
     * This is the setUp method where
     * objects get instantiated.
     */
    public void setUp()
    {
        r1 = new Influencer("January", "bctionDan", "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        r2 = new Influencer("January", "actionDan", "bizardHigh", "US",
            "education", 43882, 431, 95800, 4129, 442422);
        r3 = new Influencer("January", "cctionDan", "cizardHigh", "US",
            "education", 33882, 431, 95800, 4129, 442422);
        s1List = new SLList<Influencer>();
        s1List.add(r2);
        s1List.add(r3);
        s1List.add(r1);
        s1Traditional = new SLList<Influencer>();
        s1Traditional.add(r3);
        s1Traditional.add(r2);
        s1Traditional.add(r1);
        s1 = new SortingTheInfo(s1List);
        s1Channel = new SLList<Influencer>();
        s1Channel.add(r1);
        s1Channel.add(r2);
        s1Channel.add(r3);
        s1Reach = new SLList<Influencer>();
        s1Reach.add(r3);
        s1Reach.add(r2);
        s1Reach.add(r1);
        System.out.println(r3.getEngagementRate());
        System.out.println(r2.getEngagementRate());
        System.out.println(r1.getEngagementRate());
    }
    
    /**
     * This testing case checks if the 
     * sortByChannel() method functions
     * properly.
     */
    public void testSortByChannel()
    {
        assertEquals("{[User Name: actionDan Channel Name: bizardHigh "
            + "Country: US Main Topic: education Likes: 43882.0 "
            + "Posts: 431.0 Followers: 95800.0 Comments: 4129.0 "
            + "Views: 442422.0], [User Name: cctionDan "
            + "Channel Name: cizardHigh Country: US Main "
            + "Topic: education Likes: 33882.0 Posts: 431.0 "
            + "Followers: 95800.0 Comments: 4129.0 Views: 442422.0], "
            + "[User Name: bctionDan Channel Name: aizardHigh "
            + "Country: US Main Topic: education Likes: 53882.0 "
            + "Posts: 431.0 Followers: 95800.0 Comments: 4129.0 "
            + "Views: 442422.0]}", s1List.toString());
        assertEquals(s1.sortByChannel(s1.getList()), s1Channel);
        s1.getList().clear();
        assertEquals(s1.sortByChannel(s1.getList()), new SLList<Influencer>());
        
    }
    
    /**
     * This testing case checks if the 
     * getFirstQuarter() method
     * functions properly.
     */
    public void testGetFirstQuarter()
    {
        r1 = new Influencer("January", "bctionDan", "bizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        r2 = new Influencer("January", "actionDan", "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        r3 = new Influencer("January", "cctionDan", "cizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        Influencer r4 = new Influencer("February", "bctionDan", "bizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        Influencer r5 = new Influencer("February", "actionDan", "aizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        Influencer r6 = new Influencer("February", "cctionDan", "cizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        Influencer r7 = new Influencer("March", "bctionDan", "bizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        Influencer r8 = new Influencer("March", "actionDan", "aizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        Influencer r9 = new Influencer("March", "cctionDan", "cizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        Influencer r10 = new Influencer("Marc", "cctionDan", "cizardHigh",
            "US", "education", 53882, 431, 95800, 4129, 442422);
        s1.getList().clear();
        s1.getList().add(r1);
        s1.getList().add(r2);
        s1.getList().add(r3);
        s1.getList().add(r4);
        s1.getList().add(r5);
        s1.getList().add(r6);
        s1.getList().add(r7);
        s1.getList().add(r8);
        s1.getList().add(r9);
        s1.getList().add(r10);
        int a = 53882 * 3;
        int b = 431 * 3;
        int c = 95800;
        int d = 4129 * 3;
        int e = 442422 * 3;
        Influencer inf01 = new Influencer("February",
            "bctionDan", "bizardHigh",
            "US", "education", a, b, c, d, e);
        Influencer inf02 = new Influencer("February",
            "actionDan", "aizardHigh",
            "US", "education", a, b, c, d, e);
        Influencer inf03 = new Influencer("February",
            "cctionDan", "cizardHigh",
            "US", "education", a, b, c, d, e);
        SLList<Influencer> s1First = new SLList<Influencer>();
        
        s1First.add(inf01);
        s1First.add(inf02);
        s1First.add(inf03);
        assertEquals(s1.getFirstQuarter(s1.getList()), s1First);        
    }
    
    /**
     * This testing case checks if the 
     * sortByTraditionalEngagement() 
     * method functions properly.
     */
    public void testSortByTraditionalEngagement()
    {
        assertEquals(s1.sortByTraditionalEngagement(s1.getList())
            , s1Traditional);
        s1.getList().clear();
        assertEquals(s1.sortByTraditionalEngagement(s1.getList()), 
            new SLList<Influencer>());
    }
    
    /**
     * This testong case checks if the 
     * sortByReachEngagement() method
     * functions properly.
     */
    public void testSortByReachEngagement()
    {
        assertEquals(s1.sortByReachEngagement(s1.getList()),
            s1Reach);
        s1.getList().clear();
        assertEquals(s1.sortByReachEngagement(s1.getList()), 
            new SLList<Influencer>());
    }
    
    /**
     * This testing case checks if the 
     * getFebruary() method functions
     * properly.
     */
    public void testGetFebruary()
    {
        SLList<Influencer> feb = new SLList<Influencer>();
        
        Influencer j = new Influencer("January", "bctionDan",
            "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        feb.add(j);
        Influencer f = new Influencer("February", "bctionDan",
            "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        feb.add(f);
        feb.add( new Influencer("March", "bctionDan",
            "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422));
        s1 = new SortingTheInfo(feb);
        SLList<Influencer> correct = new SLList<Influencer>();
        correct.add(f);
        assertEquals(s1.getFebruary(feb), correct);
    }
    
    /**
     * This testing case checks if the 
     * getMArch() method functions
     * properly.
     */
    public void testGetMarch()
    {
        SLList<Influencer> mar = new SLList<Influencer>();
        
        Influencer j = new Influencer("January", "bctionDan",
            "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        mar.add(j);
        mar.add( new Influencer("February", "bctionDan", "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422));
        Influencer m = new Influencer("March", "bctionDan", "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        mar.add(m);
        s1 = new SortingTheInfo(mar);
        SLList<Influencer> correct = new SLList<Influencer>();
        correct.add(m);
        assertEquals(s1.getMarch(mar), correct);
    }
    
    /**
     * This testing case checks if the 
     * getJanuary() method functions properly.
     */
    public void testGetJanuary()
    {
        SLList<Influencer> jan = new SLList<Influencer>();
        
        Influencer j = new Influencer("January", "bctionDan", 
            "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422);
        jan.add(j);
        jan.add( new Influencer("February", "bctionDan", "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422));
        jan.add( new Influencer("March", "bctionDan", "aizardHigh", "US",
            "education", 53882, 431, 95800, 4129, 442422));
        s1 = new SortingTheInfo(jan);
        SLList<Influencer> correct = new SLList<Influencer>();
        correct.add(j);
        assertEquals(s1.getJanuary(jan), correct);
    }
}
