package com.stackroute.oops.league.model;

import java.io.Serializable;

/**
 * This class contains four fields playerId,teamTitle,season and experience.
 * This is a subclass of Serializable and Comparable interface
 */
public class PlayerTeam implements Serializable, Comparable {
     private String playerId;
     private String teamTitle;
     private String season;
     private double experience;
    //Parameterized Constructor to initialize all properties
    public PlayerTeam(String playerId, String teamTitle,String season,double experience) {
        this.playerId=playerId;
        this.teamTitle=teamTitle;
        this.season=season;
        this.experience=experience;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getTeamTitle() {
        return this.teamTitle;
    }
  public String getSeason(){
    return season;
 }
 public double getExperience() {
    return experience;
 }
    /**
     * This overridden method should return player details in below format
     * Player{playerId=xxxxx, teamTitle=xxxxxx}
     */
    @Override
    public String toString() {
        return "playerId="+ playerId+","+"teamTitle="+ teamTitle;
    }

    //Overridden compare method based on playerId
    @Override
    public int compareTo(Object object) {
        return 0;
    }
}
