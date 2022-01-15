package com.example.kutumb;

public class post1 {
    String username,url,avatar;
    private boolean expanded;
    public post1(String username, String url, String avatar) {
        this.username = username;
        this.url = url;
        this.avatar = avatar;
        this.expanded=false;
    }
    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
