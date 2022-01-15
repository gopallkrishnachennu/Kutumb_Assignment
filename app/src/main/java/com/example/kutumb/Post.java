package com.example.kutumb;

import java.util.List;

public class Post
{
    int rank;
    String username,repositoryName,url,description,language,languageColor,totalStars,forks,starsSince,since;
    List<post1> builtBy;

    public Post(int rank, String username, String repositoryName, String url, String description, String language, String languageColor, String totalStars, String forks, String starsSince, String since, List<post1> builtBy) {
        this.rank = rank;
        this.username = username;
        this.repositoryName = repositoryName;
        this.url = url;
        this.description = description;
        this.language = language;
        this.languageColor = languageColor;
        this.totalStars = totalStars;
        this.forks = forks;
        this.starsSince = starsSince;
        this.since = since;
        this.builtBy = builtBy;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public String getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(String totalStars) {
        this.totalStars = totalStars;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getStarsSince() {
        return starsSince;
    }

    public void setStarsSince(String starsSince) {
        this.starsSince = starsSince;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public List<post1> getBuiltBy() {
        return builtBy;
    }

    public void setBuiltBy(List<post1> builtBy) {
        this.builtBy = builtBy;
    }
}
