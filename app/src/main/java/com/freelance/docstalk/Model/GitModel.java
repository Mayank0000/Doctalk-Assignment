package com.freelance.docstalk.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Shubham Shukla on 24-03-2018.
 */

public class GitModel {
    @SerializedName("incomplete_results")
    private String incompleteresults;
    @SerializedName("total_count")
    private String totalcount;
    @SerializedName("items")
    private ArrayList<InnerItems> items;

    public GitModel(String incompleteresults, String totalcount, ArrayList<InnerItems> items) {
        this.incompleteresults = incompleteresults;
        this.totalcount = totalcount;
        this.items = items;
    }

    public String getIncompleteresults() {
        return incompleteresults;
    }

    public void setIncompleteresults(String incompleteresults) {
        this.incompleteresults = incompleteresults;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public ArrayList<InnerItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<InnerItems> items) {
        this.items = items;
    }

    public class InnerItems{
        @SerializedName("login")
        @Expose
        private String login;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("avatar_url")
        @Expose
        private String avatar_url;
        @SerializedName("html_url")
        @Expose
        private String html_url;
        @SerializedName("followers_url")
        @Expose
        private String followers_url;
        @SerializedName("following_url")
        @Expose
        private String following_url;
        @SerializedName("gists_url")
        @Expose
        private String gists_url;
        @SerializedName("starred_url")
        @Expose
        private String starred_url;
        @SerializedName("subscriptions_url")
        @Expose
        private String subscriptions_url;
        @SerializedName("organisations_url")
        @Expose
        private String organisations_url;
        @SerializedName("repos_url")
        @Expose
        private String repos_url;
        @SerializedName("events_url")
        @Expose
        private String events_url;
        @SerializedName("received_events_url")
        @Expose
        private String received_events_url;
        @SerializedName("type_url")
        @Expose
        private String type_url;
        @SerializedName("site_domain")
        @Expose
        private String site_domain;
        @SerializedName("score")
        @Expose
        private String score;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getGists_url() {
            return gists_url;
        }

        public void setGists_url(String gists_url) {
            this.gists_url = gists_url;
        }

        public String getStarred_url() {
            return starred_url;
        }

        public void setStarred_url(String starred_url) {
            this.starred_url = starred_url;
        }

        public String getSubscriptions_url() {
            return subscriptions_url;
        }

        public void setSubscriptions_url(String subscriptions_url) {
            this.subscriptions_url = subscriptions_url;
        }

        public String getOrganisations_url() {
            return organisations_url;
        }

        public void setOrganisations_url(String organisations_url) {
            this.organisations_url = organisations_url;
        }

        public String getRepos_url() {
            return repos_url;
        }

        public void setRepos_url(String repos_url) {
            this.repos_url = repos_url;
        }

        public String getEvents_url() {
            return events_url;
        }

        public void setEvents_url(String events_url) {
            this.events_url = events_url;
        }

        public String getReceived_events_url() {
            return received_events_url;
        }

        public void setReceived_events_url(String received_events_url) {
            this.received_events_url = received_events_url;
        }

        public String getType_url() {
            return type_url;
        }

        public void setType_url(String type_url) {
            this.type_url = type_url;
        }

        public String getSite_domain() {
            return site_domain;
        }

        public void setSite_domain(String site_domain) {
            this.site_domain = site_domain;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "InnerItems{" +
                    "login='" + login + '\'' +
                    ", id='" + id + '\'' +
                    ", avatar_url='" + avatar_url + '\'' +
                    ", html_url='" + html_url + '\'' +
                    ", followers_url='" + followers_url + '\'' +
                    ", following_url='" + following_url + '\'' +
                    ", gists_url='" + gists_url + '\'' +
                    ", starred_url='" + starred_url + '\'' +
                    ", subscriptions_url='" + subscriptions_url + '\'' +
                    ", organisations_url='" + organisations_url + '\'' +
                    ", repos_url='" + repos_url + '\'' +
                    ", events_url='" + events_url + '\'' +
                    ", received_events_url='" + received_events_url + '\'' +
                    ", type_url='" + type_url + '\'' +
                    ", site_domain='" + site_domain + '\'' +
                    ", score='" + score + '\'' +
                    '}';
        }
    }
}
