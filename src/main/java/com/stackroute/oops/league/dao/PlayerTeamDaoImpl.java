package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements the PlayerTeamDao interface This class has two fields
 * playerTeamSet,playerDao and a String constant for storing file name.
 */
public class PlayerTeamDaoImpl implements PlayerTeamDao {
    private static final String TEAM_FILE_NAME = "src/main/resources/finalteam.csv";

    /**
     * Constructor to initialize an empty TreeSet and PlayerDao object
     */
    public PlayerTeamDaoImpl() {
        TreeSet<PlayerDao> PlayerDao = new TreeSet<>();
    }

    /*
    Returns the list of players belonging to a particular teamTitle by reading
    from the file finalteam.csv
     */
    @Override
    public Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle) {
        if(teamTitle != TEAM_FILE_NAME )
        return ;
    }

    //Add he given PlayerTeam Object to finalteam.csv file
    @Override
    public boolean addPlayerToTeam(Player player) throws PlayerNotFoundException {
        PlayerDao.add(TEAM_FILE_NAME);
        return false;
    }

    //Return the set of all PlayerTeam by reading the file content from finalteam.csv file
    @Override
    public Set<PlayerTeam> getAllPlayerTeams() {
        if(player != TEAM_FILE_NAME)
        return getAllPlayerTeams();
    }
}
