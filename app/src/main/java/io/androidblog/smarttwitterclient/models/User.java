package io.androidblog.smarttwitterclient.models;

public class User {

    private long uid;
    private String screenName;
    private String userId;
    private String profileImageUrl;
    private String profileBannerUrl;
    private String followers;
    private String following;
    private String description;

    public User(long uid, String screenName, String userId, String profileImageUrl, String profileBannerUrl, String followers, String following, String description) {
        this.uid = uid;
        this.screenName = screenName;
        this.userId = userId;
        this.profileImageUrl = profileImageUrl;
        this.profileBannerUrl = profileBannerUrl;
        this.followers = followers;
        this.following = following;
        this.description = description;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserIde(String userId) {
        this.userId = userId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
