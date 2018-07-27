package design_twitter;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class DesignTwitter {
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
    class Twitter {
        class Tweet {
            int id;
            long timestamp;
            public Tweet(int id, long timestamp) {
                this.id = id;
                this.timestamp = timestamp;
            }
        }
        Map<Integer, List<Tweet>> timelines;
        Map<Integer, Set<Integer>> follows;

        /** Initialize your data structure here. */
        public Twitter() {
            timelines = new HashMap<>();
            follows = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            long timestamp = System.nanoTime();
            Tweet t = new Tweet(tweetId, timestamp);
            if (!timelines.containsKey(userId)) {
                timelines.put(userId, new ArrayList<Tweet>());
            }
            timelines.get(userId).add(0, t);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(10, (a,b) -> (int)(b.timestamp-a.timestamp));
            if (!follows.containsKey(userId)) {
                follows.put(userId, new HashSet<Integer>());
            }
            follows.get(userId).add(userId);
            for (int u: follows.get(userId)) {
                if (timelines.containsKey(u))
                    for (Tweet t: timelines.get(u)) {
                        pq.offer(t);
                    }
            }

            List<Integer> res = new ArrayList<>();
            while (!pq.isEmpty() && res.size() < 10) {
                res.add(pq.poll().id);
            }

            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (!follows.containsKey(followerId)) {
                follows.put(followerId, new HashSet<Integer>());
            }
            follows.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (follows.containsKey(followerId)) {
                follows.get(followerId).remove(followeeId);
            }
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
            Twitter twitter = new DesignTwitter().new Twitter();
            twitter.postTweet(1, 4);
            twitter.postTweet(2, 5);
            twitter.unfollow(1, 2);
            twitter.follow(1, 2);
            List<Integer> r = twitter.getNewsFeed(1);
        }
    }
}

