package com.kodilla.testing.forum;

public class ForumComment {
    private final ForumPost forumPost;
    private final String commnetBody;
    private final String author;

    public ForumComment(ForumPost forumPost, String commnetBody, String author) {
        this.forumPost = forumPost;
        this.commnetBody = commnetBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commnetBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumComment that = (ForumComment) o;

        if (!forumPost.equals(that.forumPost)) return false;
        if (!commnetBody.equals(that.commnetBody)) return false;
        return author.equals(that.author);
    }

    @Override
    public int hashCode() {
        int result = forumPost.hashCode();
        result = 31 * result + commnetBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}

