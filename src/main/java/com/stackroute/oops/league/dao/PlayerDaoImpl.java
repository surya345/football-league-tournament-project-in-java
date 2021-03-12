package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerAlreadyAllottedException;
import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
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
       playerList=new ArrayList<>();
    }

    /**
     * Return true if  player object is stored in "player.csv" as comma separated fields successfully
     * when password length is greater than six and yearExpr is greater than zero
     */
    @Override
    public boolean addPlayer(Player player) throws PlayerAlreadyExistsException {
        Player player1=null;
        boolean isAlreadyExists=true;
        try {
         player1= findPlayer(player.getPlayerId());
            
        }
        catch (PlayerNotFoundException e) {
            
            e.printStackTrace();
        }
          if(player1!=null){
              throw new PlayerAlreadyExistsException("Player Already Exists");
          }
          if(player.getPassword().length() >6 && player.getYearExpr() >0){
              try{
            FileWriter writer=new FileWriter(PLAYER_FILE_NAME);
            writer.append(player.getPlayerId()+", " +player.getPassword()+", "+player.getPlayerName()+", "+player.getYearExpr()+", "+player.getTeamTitle());
            writer.flush();
            writer.close();

            isAlreadyExists=true;}
           catch(IOException e){
            e.printStackTrace();
           }
           
            return isAlreadyExists;
           
               
           }
            
        return false;
    }

  

    // Return the list of player objects by reading data from the file "player.csv"
    @Override
    public List<Player> getAllPlayers()  {
    // Player player2;
    // //  if(player2!=null){
    // //      throw new PlayerAlreadyAllottedException("Player Already Alloted");
    // //  }
    try { 
        String playerData[];
        Player player;
        String temp;
        FileReader reader =new FileReader(PLAYER_FILE_NAME);
        BufferedReader bufferedReader =new BufferedReader(reader);
        while(((temp =bufferedReader.readLine())!=null)){
        playerData=temp.split(",");
        player=new Player(playerData[0], playerData[1],playerData[2], Integer.parseInt(playerData[3]));
        player.setTeamTitle(playerData[4]);
        playerList.add(player);
        
        }
    } catch (Exception e) {
        e.printStackTrace();
        
    }

    return playerList;
       
    }

    /**
     * Return Player object given playerId to search
     */
    @Override
    public Player findPlayer(String playerId) throws PlayerNotFoundException {
        if(playerId ==""|| playerId==null||playerId==" "){
            throw new PlayerNotFoundException("Player Not found");
        }
        boolean isFound=false;
        Player player=null;
        try {
            String playerData[];
           
            
            String temp;
            FileReader  reader = new FileReader(PLAYER_FILE_NAME);
            BufferedReader bufferedReader =new BufferedReader(reader);
            while(((temp = bufferedReader.readLine())!=null)){
            // throw new PlayerNotFoundException("Player not found");
            playerData=temp.split(",");
           
            if(playerId .equals(playerData[0]) ){
            player=new Player(playerData[0], playerData[1],playerData[2], Integer.parseInt(playerData[3]));

            player.setTeamTitle(playerData[4]);
            isFound=true;
            return player;
            }
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
      if(!isFound)
       throw new PlayerNotFoundException("Player Not Found");
       
       if(isFound)
       return player;
    }
    
}
