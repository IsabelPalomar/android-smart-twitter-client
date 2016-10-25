package io.androidblog.smarttwitterclient.models;

import java.io.Serializable;

public class Tweet implements Serializable{

    private long uid;
    private String body;
    private String username;
    private String screenName;
    private String createdAt;
    private String profileImgUrl;

    public Tweet(long uid, String body, String username, String screenName, String createdAt, String profileImgUrl) {
        this.uid = uid;
        this.body = body;
        this.username = username;
        this.screenName = screenName;
        this.createdAt = createdAt;
        this.profileImgUrl = profileImgUrl;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

}
