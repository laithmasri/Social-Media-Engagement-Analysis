package prj5;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 *
 */
public class SortingTheInfo {

    private SLList<Influencer> list;

    /**
     * Constructor for SortingTheInfo class
     * 
     * @param other
     *            the SLList<Influencer> object our list field is getting set to
     */
    public SortingTheInfo(SLList<Influencer> other) {
        this.list = other;
    }

    /**
     * getter for list field of SortingTheInfo class
     * 
     * @return the list field of the SortingTheInfo object calling the method
     */
    public SLList<Influencer> getList() {
        return this.list;
    }

    /**
     * Sorts the passed in SLList<Influencer> by first quarter
     * 
     * @param entry
     *            the SLList<Influencer> that we are sorting by first quarter
     * @return a SLList<Influencer> that is sorted by first quarter
     */
    public SLList<Influencer> getFirstQuarter(SLList<Influencer> entry) {

        SLList<Influencer> rtrn = new SLList<Influencer>();
        SLList.Node<Influencer> t = entry.getHead();
        while (t != null) {
            SLList.Node<Influencer> i = rtrn.getHead();
            Boolean ticker = false;
            if (!(t.getData().getMonth().equalsIgnoreCase("January") || t
                .getData().getMonth().equalsIgnoreCase("February") || t
                    .getData().getMonth().equalsIgnoreCase("March"))) {
                ticker = true;
            }
            while (i != null && !ticker) {
                if (i.getData().getChannelName().compareTo(t.getData()
                    .getChannelName()) == 0) {
                    i.setData(new Influencer(t.getData().getMonth(), t.getData()
                        .getUserName(), t.getData().getChannelName(), t
                            .getData().getCountryName(), t.getData()
                                .getMainTopic(), i.getData().getLikes() + t
                                    .getData().getLikes(), i.getData()
                                        .getPosts() + t.getData().getPosts(), t
                                            .getData().getFollowers(), i
                                                .getData().getComments() + t
                                                    .getData().getComments(), i
                                                        .getData().getViews()
                                                        + t.getData()
                                                            .getViews()));
                    ticker = true;
                }
                i = i.next();
            }
            if (!ticker) {
                rtrn.add(t.getData());
            }
            t = t.next();
        }
        return rtrn;

    }

    /**
     * Sorts the passed in SLList<Influencer> by channel name
     * 
     * @param other
     *            the SLList<Influencer> that we are sorting by channel
     * @return a SLList<Influencer> that is sorted 
     */
    public SLList<Influencer> sortByChannel(SLList<Influencer> other) {

        if (other.getSize() > 1) {
            SLList.Node<Influencer> unsortedPart = other.getHead().next();
            SLList.Node<Influencer> sortedPart = other.getHead();
            sortedPart.setNext(null);
            while (unsortedPart != null) {
                SLList.Node<Influencer> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertNodeforChannel(other, nodeToInsert);
            }
        }
        return other;

    }

    /**
     * Sorts the passed in SLList<Influencer> by reach engagement
     * 
     * @param other
     *            the SLList<Influencer> that we are sorting by reach engagement
     * @return a SLList<Influencer> that is sorted by reach engagement
     */
    public SLList<Influencer> sortByReachEngagement(SLList<Influencer> other) {
        if (other.getSize() > 1) {
            SLList.Node<Influencer> unsortedPart = other.getHead().next();
            SLList.Node<Influencer> sortedPart = other.getHead();
            sortedPart.setNext(null);
            while (unsortedPart != null) {
                SLList.Node<Influencer> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertNode(other, nodeToInsert, false);
            }
        }
        return other;
    }

    /**
     * Sorts the passed in SLList<Influencer> by traditional engagement
     * 
     * @param other
     *            the SLList<Influencer> that we are sorting by traditional
     *            engagement
     * @return a SLList<Influencer> that is sorted by traditional engagement
     */
    public SLList<Influencer> sortByTraditionalEngagement(
        SLList<Influencer> other) {
        if (other.getSize() > 1) {
            SLList.Node<Influencer> unsortedPart = other.getHead().next();
            SLList.Node<Influencer> sortedPart = other.getHead();
            sortedPart.setNext(null);
            while (unsortedPart != null) {
                SLList.Node<Influencer> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertNode(other, nodeToInsert, true);
            }

        }
        return other;
    }

    /**
     * 
     * @param other represents a list
     * @param nodeToInsert represents a list
     */
    private void insertNodeforChannel(
        SLList<Influencer> other,
        SLList.Node<Influencer> nodeToInsert) {
        Influencer insert = (Influencer)nodeToInsert.getData();
        SLList.Node<Influencer> currentNode = other.getHead();
        SLList.Node<Influencer> previousNode = null;

        while ((currentNode != null) && insert.compareToChannelName(
            (Influencer)currentNode.getData()) == 1) {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(other.getHead());
            other.setHead(nodeToInsert);
        }
    }

    /**
     * 
     * @param other represents a list
     * @param nodeToInsert represents a list
     * @param type represents a boolean
     */
    private void insertNode(
        SLList<Influencer> other,
        SLList.Node<Influencer> nodeToInsert,
        Boolean type) {
        Influencer insert = (Influencer)nodeToInsert.getData();
        SLList.Node<Influencer> currentNode = other.getHead();
        SLList.Node<Influencer> previousNode = null;
        Boolean isTradiotional = type;
        if (isTradiotional) {
            while ((currentNode != null) && insert.compareToEngagementRate(
                (Influencer)currentNode.getData()) == 1) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
        }
        else {
            while ((currentNode != null) && insert
                .compareToEngagementRateByReach((Influencer)currentNode
                    .getData()) == 1) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(other.getHead());
            other.setHead(nodeToInsert);
        }
    }
    
    /**
     * Sorts the passed in SLList<Influencer> to only get Influencers whose
     * months field is exclusively January
     * 
     * @param entry
     *            the SLList<Influencer> that we are sorting for only January
     * @return a SLList<Influencer> that is sorted by only Influencers whose
     *         months field is exclusively January
     */
    public SLList<Influencer> getJanuary(SLList<Influencer> entry)
    {
        SLList<Influencer> rtrn = new SLList<Influencer>();
        SLList.Node<Influencer> t = entry.getHead();
        while (t != null) {
            if (t.getData().getMonth().compareToIgnoreCase("January") == 0)
            {
                rtrn.add(t.getData());
            }
            t =  t.next();
        }
        return rtrn;
    }
    
    /**
     * Sorts the passed in SLList<Influencer> to only get Influencers whose
     * months field is exclusively February
     * 
     * @param entry
     *            the SLList<Influencer> that we are sorting for only February
     * @return a SLList<Influencer> that is sorted by only Influencers whose
     *         months field is exclusively February
     */
    public SLList<Influencer> getFebruary(SLList<Influencer> entry)
    {
        SLList<Influencer> rtrn = new SLList<Influencer>();
        SLList.Node<Influencer> t = entry.getHead();
        while (t != null) {
            if (t.getData().getMonth().compareToIgnoreCase("February") == 0)
            {
                rtrn.add(t.getData());
            }
            t =  t.next();
        }
        return rtrn;
    }
    
    /**
     * Sorts the passed in SLList<Influencer> to only get Influencers whose
     * months field is exclusively March
     * 
     * @param entry
     *            the SLList<Influencer> that we are sorting for only March
     * @return a SLList<Influencer> that is sorted by only Influencers whose
     *         months field is exclusively March
     */
    public SLList<Influencer> getMarch(SLList<Influencer> entry)
    {
        SLList<Influencer> rtrn = new SLList<Influencer>();
        SLList.Node<Influencer> t = entry.getHead();
        while (t != null) {
            if (t.getData().getMonth().compareToIgnoreCase("March") == 0)
            {
                rtrn.add(t.getData());
            }
            t =  t.next();
        }
        return rtrn;
    }
}
