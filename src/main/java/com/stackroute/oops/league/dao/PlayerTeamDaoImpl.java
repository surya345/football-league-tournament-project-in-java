package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public PlayerTeamDaoImpl(String playerDao) {
         
        TreeSet<PlayerDao> ts = new TreeSet<>();
        
    }

    /*
    Returns the list of players belonging to a particular teamTitle by reading
    from the file finalteam.csv
     */
    @Override
    public Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle) {
        
        try {
            PlayerTeam playerTeam;
            FileReader reader =new FileReader(TEAM_FILE_NAME);
            BufferedReader bufferedreader =new BufferedReader(reader);
            String playerData[];
            String temp;
            while(((temp = bufferedreader.readLine())!=null)){
            playerData =temp.split(",");
            playerTeam =new PlayerTeam(playerData[0], playerData[1], playerData[2], Integer.parseInt(playerData[3]));
            // playerTeam.setTeamTitle(playerData[4]);
            if(){

            }
            }
        } catch (Exception e) {
          
            e.printStackTrace();
        }
        return null;
    }

    //Add the given PlayerTeam Object to finalteam.csv file
    @Override
    public boolean addPlayerToTeam(Player player) throws PlayerNotFoundException {
          
           
            try {
                PlayerTeam playerTeam;
                FileReader reader = new FileReader(TEAM_FILE_NAME);
                BufferedReader bufferedreader =new BufferedReader(reader);
                String playerData[];
                String temp;
                while(((temp = bufferedreader.readLine())!=null)){
                    playerData=temp.split(",");
                    playerTeam =new PlayerTeam(playerData[0], playerData[1], playerData[2], Integer.parseInt(playerData[3]));
                    PlayerDao.add(playerTeam);
                }
               
            } catch (Exception e) {
               
                e.printStackTrace();
            }
           
        
        return false;
    }

    //Return the set of all PlayerTeam by reading the file content from finalteam.csv file
    @Override
    public Set<PlayerTeam> getAllPlayerTeams() {
        
        try {
            FileReader reader = new FileReader(TEAM_FILE_NAME);
            BufferedReader bufferedReader =new BufferedReader(reader);
            String temp;
            String playerdata[];
            try {
                while((temp=bufferedReader.readLine())!=null){
                playerdata = temp.split(",");
                }
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        } catch (Exception e1) {
           
            e1.printStackTrace();
        }
    
        return getAllPlayerTeams();
    }
}
