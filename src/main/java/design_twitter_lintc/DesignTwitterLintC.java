package design_twitter_lintc;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class DesignTwitterLintC {
//    Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
//
//    postTweet(userId, tweetId): Compose a new tweet.
//            getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
//    follow(followerId, followeeId): Follower follows a followee.
//    unfollow(followerId, followeeId): Follower unfollows a followee.
//    Example:
//
//    Twitter twitter = new Twitter();
//
//    // User 1 posts a new tweet (id = 5).
//    twitter.postTweet(1, 5);
//
//    // User 1's news feed should return a list with 1 tweet id -> [5].
//    twitter.getNewsFeed(1);
//
//    // User 1 follows user 2.
//    twitter.follow(1, 2);
//
//    // User 2 posts a new tweet (id = 6).
//    twitter.postTweet(2, 6);
//
//    // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
//    // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//    twitter.getNewsFeed(1);
//
//    // User 1 unfollows user 2.
//    twitter.unfollow(1, 2);
//
//    // User 1's news feed should return a list with 1 tweet id -> [5],
//    // since user 1 is no longer following user 2.
//    twitter.getNewsFeed(1);

    // Insert your Solution class here
/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */

public static class Tweet {
    public int id;
    public int user_id;
    public String text;
    public static Tweet create(int user_id, String tweet_text) {
        // This will create a new tweet object,
        // and auto fill id
        return null;
    }
}

    public class MiniTwitter {
        Map<Integer, Set<Integer>> follows;
        Map<Integer, List<Tweet>> timelines;
        public MiniTwitter() {
            // do intialization if necessary
            timelines = new HashMap();
            follows = new HashMap();

        }

        /*
         * @param user_id: An integer
         * @param tweet_text: a string
         * @return: a tweet
         */
        public Tweet postTweet(int user_id, String tweet_text) {
            // write your code here
            Tweet t = Tweet.create(user_id, tweet_text);
            //tweets.put(t.id, t);
            if (!timelines.containsKey(user_id))
                timelines.put(user_id, new LinkedList());
            timelines.get(user_id).add(0, t);

            follow(user_id, user_id);

            return t;
        }

        /*
         * @param user_id: An integer
         * @return: a list of 10 new feeds recently and sort by timeline
         */
        public List<Tweet> getNewsFeed(int user_id) {
            // write your code here
            PriorityQueue<Tweet> pq = new PriorityQueue<>(10, (a,b) -> (b.id-a.id));
            // if (timelines.get(user_id) != null)
            // for (Tweet t : timelines.get(user_id)) {
            //     pq.add(t);
            // }
            if (follows.containsKey(user_id))
                for (int uid : follows.get(user_id)) {
                    if (timelines.get(uid) != null)
                        for (Tweet t : timelines.get(uid)) {
                            pq.add(t);
                        }
                }
            List<Tweet> res = new ArrayList<Tweet>();
            while (res.size() < 10 && !pq.isEmpty()) {
                res.add(pq.poll());
            }
            return res;
        }

        /*
         * @param user_id: An integer
         * @return: a list of 10 new posts recently and sort by timeline
         */
        public List<Tweet> getTimeline(int user_id) {
            // write your code here
            if (timelines.get(user_id) == null) return new ArrayList<Tweet>();
            return timelines.get(user_id).subList(0, Math.min(10, timelines.get(user_id).size()));
        }

        /*
         * @param from_user_id: An integer
         * @param to_user_id: An integer
         * @return: nothing
         */
        public void follow(int from_user_id, int to_user_id) {
            // write your code here
            if (!follows.containsKey(from_user_id))
                follows.put(from_user_id, new HashSet());
            follows.get(from_user_id).add(to_user_id);
        }

        /*
         * @param from_user_id: An integer
         * @param to_user_id: An integer
         * @return: nothing
         */
        public void unfollow(int from_user_id, int to_user_id) {
            // write your code here
            if (follows.containsKey(from_user_id))
                follows.get(from_user_id).remove(to_user_id);
        }
    }
    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
    public static class UnitTest {
        @Test
        public void testDesignTwitter() {
            //Solution s = new DesignTwitter().new Solution();
        }
    }
}

