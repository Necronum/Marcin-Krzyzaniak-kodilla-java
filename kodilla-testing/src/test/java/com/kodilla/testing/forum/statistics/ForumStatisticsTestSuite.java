package com.kodilla.testing.forum.statistics;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    private List<String> generateListOfNUsers(int usersNumber) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersNumber; n++) {
            String user = "user" + n;
            resultList.add(user);
        }
        return resultList;
    }
    private static int testCounter = 0;

    @Mock
    private Statistics StatisticsMock;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterEach
    public void afterEveryTest(){
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(StatisticsMock);
        System.out.println(forumStatistics.showStatistics());
    }

    @Nested
    @DisplayName("Testing with 100 users and 1000 posts")
    class TestWith100And1000{

        @BeforeEach
        public void beforeEveryTest(){
            when(StatisticsMock.usersNames()).thenReturn(generateListOfNUsers(100));
            when(StatisticsMock.postsCount()).thenReturn(1000);
            when(StatisticsMock.commentsCount()).thenReturn(1000);
            testCounter++;
            System.out.println("Preparing to execute test #" + testCounter);
        }

        @Test
        @DisplayName("Testing methods for user (user number and average comments per user)")
        void testListOf100Users(){
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();

            //When
            forumStatistics.calculateAdvStatistics(StatisticsMock);

            //Then
            assertEquals(100, forumStatistics.getUsersNumber());
            assertEquals(10, forumStatistics.getAverageCommentsPerUser());
        }

        @Test
        @DisplayName("Testing methods for posts (average posts per user and average comments per post)")
        void test1000Posts(){
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();

            //When
            forumStatistics.calculateAdvStatistics(StatisticsMock);

            //Then
            assertEquals(10, forumStatistics.getAveragePostsPerUser());
            assertEquals(1, forumStatistics.getAverageCommentsPerPost());
        }
    }

    @Nested
    @DisplayName("Testing with 0 users, posts and comments")
    class TestWith0{

        @BeforeEach
        public void beforeEveryTest(){
            when(StatisticsMock.usersNames()).thenReturn(new ArrayList<>());
            when(StatisticsMock.postsCount()).thenReturn(0);
            lenient().when(StatisticsMock.commentsCount()).thenReturn(0);
            testCounter++;
            System.out.println("Preparing to execute test #" + testCounter);
        }

        @Test
        @DisplayName("Testing methods for user (user number and average comments per user)")
        void testListOf0Users(){
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();

            //When
            forumStatistics.calculateAdvStatistics(StatisticsMock);

            //Then
            assertEquals(0, forumStatistics.getUsersNumber());
            assertEquals(0, forumStatistics.getAverageCommentsPerUser());
        }

        @Test
        @DisplayName("Testing methods for posts (average posts per user and average comments per post)")
        void test0Posts(){
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();

            //When
            forumStatistics.calculateAdvStatistics(StatisticsMock);

            //Then
            assertEquals(0, forumStatistics.getAveragePostsPerUser());
            assertEquals(0, forumStatistics.getAverageCommentsPerPost());
        }
    }

    @Nested
    @DisplayName("Testing with more comments than posts")
    class TestWithMoreComments{

        @BeforeEach
        public void beforeEveryTest(){
            when(StatisticsMock.usersNames()).thenReturn(generateListOfNUsers(1));
            when(StatisticsMock.postsCount()).thenReturn(10);
            when(StatisticsMock.commentsCount()).thenReturn(100);
            testCounter++;
            System.out.println("Preparing to execute test #" + testCounter);
        }

        @Test
        @DisplayName("Testing methods for average comments per post")
        void testMoreComments(){
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();

            //When
            forumStatistics.calculateAdvStatistics(StatisticsMock);

            //Then
            assertEquals(10, forumStatistics.getAverageCommentsPerPost());
        }
    }

    @Nested
    @DisplayName("Testing with more comments than posts")
    class TestWithMorePosts{

        @BeforeEach
        public void beforeEveryTest(){
            when(StatisticsMock.usersNames()).thenReturn(generateListOfNUsers(1));
            when(StatisticsMock.postsCount()).thenReturn(100);
            when(StatisticsMock.commentsCount()).thenReturn(10);
            testCounter++;
            System.out.println("Preparing to execute test #" + testCounter);
        }

        @Test
        @DisplayName("Testing methods for average comments per post")
        void testMorePosts(){
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();

            //When
            forumStatistics.calculateAdvStatistics(StatisticsMock);

            //Then
            assertEquals(0.1, forumStatistics.getAverageCommentsPerPost());
        }
    }
}
