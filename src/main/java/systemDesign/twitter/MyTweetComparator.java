package systemDesign.twitter;

import java.util.Comparator;

public class MyTweetComparator implements Comparator<Tweet> {
    @Override
    public int compare(Tweet a, Tweet b) {
        return b.time - a.time;
    }
}
