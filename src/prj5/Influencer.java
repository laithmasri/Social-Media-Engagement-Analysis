package prj5;

import java.text.DecimalFormat;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 *
 */
public class Influencer {
    
    private String month;
    private String influencerUserName;
    private String channelName;
    private String countryName;
    private String mainTopic;
    private double totalLikes;
    private double totalPosts;
    private double totalFollowers;
    private double totalComments;
    private double totalViews;

    /**
     * Default Constructor
     * 
     * @param month
     *            Represents the Month
     * @param userName
     *            Represents the username
     * @param channel
     *            Represents the channel name
     * @param country
     *            Represents the country name
     * @param topic
     *            Represents the topic
     * @param likes
     *            Represents the number of likes
     * @param posts
     *            Represents the number of posts
     * @param followers
     *            Represents the number of followers
     * @param comments
     *            Represents the number of comments
     * @param views
     *            Represents the number of views
     */
    public Influencer(
        String month,
        String userName,
        String channel,
        String country,
        String topic,
        double likes,
        double posts,
        double followers,
        double comments,
        double views) {
        this.month = month;
        influencerUserName = userName;
        channelName = channel;
        countryName = country;
        mainTopic = topic;
        totalLikes = likes;
        totalPosts = posts;
        totalFollowers = followers;
        totalComments = comments;
        totalViews = views;
    }


    /**
     * Method to get the Month of the Influencer
     * 
     * @return The month
     */
    public String getMonth() {
        return month;
    }


    /**
     * Method to get the Username of the Influencer
     * 
     * @return The username
     */
    public String getUserName() {
        return influencerUserName;
    }


    /**
     * Method to get the channel name of the Influencer
     * 
     * @return channel name
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Method to get the country name of the Influencer
     * 
     * @return country name
     */
    public String getCountryName() {
        return countryName;
    }


    /**
     * Method to get the Main Topic of the Influencer
     * 
     * @return main topic
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * Method to get the Likes of the Influencer
     * 
     * @return num of likes
     */
    public double getLikes() {
        return totalLikes;
    }


    /**
     * Method to get the posts of the Influencer
     * 
     * @return num of posts
     */
    public double getPosts() {
        return totalPosts;
    }


    /**
     * Method to get the followers of the Influencer
     * 
     * @return num of followers
     */
    public double getFollowers() {
        return totalFollowers;
    }


    /**
     * Method to get the Comments of the Influencer
     * 
     * @return num of comments
     */
    public double getComments() {
        return totalComments;
    }


    /**
     * Method to get the Views of the Influencer
     * 
     * @return num of views
     */
    public double getViews() {
        return totalViews;
    }


    /**
     * Method to return all the characteristics of the influencer
     * 
     * @return string containing the info
     *         about the influencer object
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("User Name: ").append(getUserName()).append(" ");
        builder.append("Channel Name: ").append(getChannelName()).append(" ");
        builder.append("Country: ").append(getCountryName()).append(" ");
        builder.append("Main Topic: ").append(getMainTopic()).append(" ");
        builder.append("Likes: ").append(getLikes()).append(" ");
        builder.append("Posts: ").append(getPosts()).append(" ");
        builder.append("Followers: ").append(getFollowers()).append(" ");
        builder.append("Comments: ").append(getComments()).append(" ");
        builder.append("Views: ").append(getViews());
        builder.append("]");
        return builder.toString();
    }


    /**
     * Equals method to check if it the same influencer
     * 
     * @param obj
     *            Represents the object
     * @return boolean checking
     *         if two objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Influencer otherObject = (Influencer)obj;
        return ((this.getUserName().equals(otherObject.getUserName())) && (this
            .getChannelName().equals(otherObject.getChannelName())) && (this
                .getCountryName().equals(otherObject.getCountryName())) && (this
                    .getMainTopic().equals(otherObject.getMainTopic())) && (this
                        .getLikes() == otherObject.getLikes()) && (this
                            .getPosts() == otherObject.getPosts()) && (this
                                .getFollowers() == otherObject.getFollowers())
            && (this.getComments() == otherObject.getComments()) && (this
                .getViews() == otherObject.getViews()));
    }


    /**
     * Method to get the Trad rate of the Influencer
     * 
     * @return engagement rate
     */
    public double getEngagementRate() {
        DecimalFormat decimal = new DecimalFormat("0.00");
        double ans = ((double)(this.getComments() + this.getLikes()) / this
            .getFollowers()) * 100;
        decimal.format(ans);
        return ans;
    }


    /**
     * Method to get the Reach rate of the Influencer
     * 
     * @return engagement reach
     */
    public double getReachEngagementRate() {
        return ((double)(this.getComments() + this.getLikes())
            / this.totalViews) * 100;
    }


    /**
     * CompareTo method to help with compare
     * the different Influencers' Channel
     * name
     * 
     * @param other
     *            Represents the object
     * @return int comparison
     */
    public int compareToChannelName(Influencer other) {
        if (this.getChannelName().compareToIgnoreCase(other
            .getChannelName()) > 0) {
            return 1;
        }
        if (this.getChannelName().compareTo(other.getChannelName()) < 0) {
            return -1;
        }
        return 0;
    }


    /**
     * CompareTo method to help with compare 
     * the different Influencers' Trad rate
     * 
     * @param other
     *            Represents the object
     * @return int comparison
     */
    public int compareToEngagementRate(Influencer other) {
        if (this.getEngagementRate() > other.getEngagementRate()) {
            return 1;
        }
        if (this.getEngagementRate() < other.getEngagementRate()) {
            return -1;
        }
        return 0;
    }


    /**
     * CompareTo method to help with compare 
     * the different Influences' Reach
     * Rate
     * 
     * @param other
     *            Represents the object
     * @return int comparison
     */
    public int compareToEngagementRateByReach(Influencer other) {
        if (this.getReachEngagementRate() > other.getReachEngagementRate()) {
            return 1;
        }
        if (this.getReachEngagementRate() < other.getReachEngagementRate()) {
            return -1;
        }
        return 0;
    }
}