package prj5;

import student.TestCase;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 *
 */
public class InfluencerTest extends TestCase {
    
    private Influencer inf01;
    private Influencer inf02;
    private Influencer inf03;
    private Influencer diff01;
    private Influencer diff02;
    private Influencer diff03;
    private Influencer diff04;
    private Influencer diff05;
    private Influencer diff06;
    private Influencer diff07;
    private Influencer diff08;
    private Influencer diff09;

    /**
     * The setUp method for the tests for the Influencer class
     */
    public void setUp() {
        inf01 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 1, 2, 3, 4, 5);
        inf02 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 1, 2, 3, 4, 5);
        inf03 = new Influencer("month01", "inf03", "channel01", "country01",
            "topic01", 1, 2, 3, 4, 5);
        diff01 = new Influencer("month01", "inf01", "channel02", "country01",
            "topic01", 1, 2, 3, 4, 5);
        diff02 = new Influencer("month01", "inf01", "channel01", "country02",
            "topic01", 1, 2, 3, 4, 5);
        diff03 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic02", 1, 2, 3, 4, 5);
        diff04 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 2, 2, 3, 4, 5);
        diff05 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 1, 3, 3, 4, 5);
        diff06 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 1, 2, 4, 4, 5);
        diff07 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 1, 2, 3, 5, 5);
        diff08 = new Influencer("month01", "inf01", "channel01", "country01",
            "topic01", 1, 2, 3, 4, 6);
        diff09 = new Influencer("month0", "inf01", "channel01", "country01",
            "topic01", 1, 2, 3, 1, 6);
    }

    /**
     * Testing the getMonth for the Influencer Class
     */
    public void testGetMonth() {
        assertEquals("month01", inf01.getMonth());
    }

    /**
     * Testing the getUserName for the Influencer Class
     */
    public void testGetUserName() {
        assertEquals("inf01", inf01.getUserName());
    }

    /**
     * Testing the getChannelName for the Influencer Class
     */
    public void testGetChannelName() {
        assertEquals("channel01", inf01.getChannelName());
    }

    /**
     * Testing the getCountryName for the Influencer Class
     */
    public void testGetCountryName() {
        assertEquals("country01", inf01.getCountryName());
    }

    /**
     *Testing the getMainTopic for the Influencer Class
     */
    public void testGetMainTopic() {
        assertEquals("topic01", inf01.getMainTopic());
    }

    /**
     * Testing the getLikes for the Influencer Class
     */
    public void testGetLikes() {

        assertEquals(1, inf01.getLikes(), 0.00001);
    }

    /**
     * Testing the getPosts for the Influencer Class
     */
    public void testGetPosts() {
        assertEquals(2, inf01.getPosts(), 0.00001);
    }

    /**
     * Testing the getFollowers for the Influencer Class
     */
    public void testGetFollowers() {
        assertEquals(3, inf01.getFollowers(), 0.00001);
    }

    /**
     * Testing the getComments for the Influencer Class
     */
    public void testGetComments() {
        assertEquals(4, inf01.getComments(), 0.00001);
    }

    /**
     * Testing the getViews for the Influencer class
     */
    public void testGetViews() {
        assertEquals(5, inf01.getViews(), 0.00001);
    }

    /**
     * Testing the toString for the Influencer Class
     */
    public void testToString() {
        assertEquals("[User Name: inf01 Channel Name: channel01 "
            + "Country: country01 Main Topic: "
            + "topic01 Likes: 1.0 Posts: 2.0 Followers: "
            + "3.0 Comments: 4.0 Views: 5.0]", inf01.toString());
    }

    /**
     * Testing the Equals for the Influencer Class
     */
    public void testEquals() {
        String string01 = null;
        String string02 = "";
        assertFalse(inf01.equals(string01));
        assertFalse(inf01.equals(string02));
        assertTrue(inf01.equals(inf02));
        assertFalse(inf01.equals(inf03));
        assertFalse(inf01.equals(diff01));
        assertFalse(inf01.equals(diff02));
        assertFalse(inf01.equals(diff03));
        assertFalse(inf01.equals(diff04));
        assertFalse(inf01.equals(diff05));
        assertFalse(inf01.equals(diff06));
        assertFalse(inf01.equals(diff07));
        assertFalse(inf01.equals(diff08));
        assertFalse(inf01.equals(diff09));
    }

    /**
     * Testing the getEngagaementRate for the Influencer Class
     */
    public void testGetEngagementRate() {

        assertEquals(inf01.getEngagementRate(), 166.66666666666669, .01);

    }

    /**
     * Testing the getReachEngagaementRate for the Influencer Class
     */
    public void testGetReachEngagementRate() {

        assertEquals(inf01.getReachEngagementRate(), 100.0, .01);
    }

    /**
     * Testing the compareToEngagaementRate for the Influencer Class
     */
    public void testCompareToEngagementRate() {

        assertEquals(inf01.compareToEngagementRate(diff01), 0);
        assertEquals(inf03.compareToEngagementRate(diff07), -1);
        assertEquals(1, inf03.compareToEngagementRate(diff09));
    }

    /**
     * Testing the compareToReachEngagaementRate for the Influencer Class
     */
    public void testCompareToEngagementRateByReach() {

        assertEquals(inf01.compareToEngagementRateByReach(diff01), 0);
        assertEquals(inf01.compareToEngagementRateByReach(diff07), -1);
        assertEquals(inf01.compareToEngagementRateByReach(diff09), 1);
    }

    /**
     * Testing the compareToChannelName for the Influencer Class
     */
    public void testCompareToChannelName() {

        assertEquals(inf01.compareToChannelName(diff01), -1);
        assertEquals(inf01.compareToChannelName(diff02), 0);
        assertEquals(diff01.compareToChannelName(diff09), 1);
    }
}