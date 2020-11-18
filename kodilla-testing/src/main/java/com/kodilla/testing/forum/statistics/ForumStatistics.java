package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersNumber;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        usersNumber = statistics.usersNames().size();
        if(usersNumber != 0) {
            averagePostsPerUser = (double) statistics.postsCount() / usersNumber;
            averageCommentsPerUser = (double) statistics.commentsCount() / usersNumber;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }
        if (statistics.postsCount() != 0) {
            averageCommentsPerPost = (double) statistics.commentsCount() / statistics.postsCount();
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public String showStatistics(){
        return "Users number: " + usersNumber + "\n Average posts per user: "
                + averagePostsPerUser + "\n Average comments per user: " + averageCommentsPerUser
                + "\n Average comments per post: " + averageCommentsPerPost;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
