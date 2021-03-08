package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is implementing the PlayerDao interface
 * This class has one field playerList and a String constant for storing file name
 */
public class PlayerDaoImpl implements PlayerDao {
    private static final String PLAYER_FILE_NAME = "src/main/resources/player.csv";
    private List<Player> playerList;

    /**
     * Constructor to initialize an empty ArrayList for playerList
     */
    public PlayerDaoImpl( ) {
      ArrayList<Player> playerList=new ArrayList<>();
    }

    /**
     * Return true if  player object is stored in "player.csv" as comma separated fields successfully
     * when password length is greater than six and yearExpr is greater than zero
     */
    @Override
    public boolean addPlayer(Player player) throws PlayerAlreadyExistsException {
        
        if(player.equals(PLAYER_FILE_NAME)){
            return true;
        }
        if(player.getPassword().length() >=6 ){
          return true;
        }
        if(player.getYearExpr() >= 4 ){
            return true;
        }
        return false;
    }

  

    // Return the list of player objects by reading data from the file "player.csv"
    @Override
    public List<Player> getAllPlayers() {
       if( player != PLAYER_FILE_NAME ){
        return playerList;}
       
    }

    /**
     * Return Player object given playerId to search
     */
    @Override
    public Player findPlayer(String playerId) throws PlayerNotFoundException {
       if(playerId != PLAYER_FILE_NAME){
        return null;
       }
       return null;

    }
}
