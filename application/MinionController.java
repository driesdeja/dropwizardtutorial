package com.driesdejager.tutorial.dropwizard.application;

import ch.qos.logback.core.util.FileUtil;
import com.driesdejager.tutorial.dropwizard.api.Minion;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by driesd on 11/03/16.
 */
public class MinionController {

    ArrayList<String> names, ids, locations;

    public MinionController() throws IOException{

        ids = new ArrayList<>();
        names = new ArrayList<>();
        locations = new ArrayList<>();

        File f = new File("minions.txt");


        BufferedReader br = new BufferedReader(new FileReader(f));
        StringBuffer fileContents = new StringBuffer();
        String line = br.readLine();
        while (line != null) {
            fileContents.append(line);
            line = br.readLine();
        }

        br.close();

        String file = fileContents.toString();

        System.out.println(file);
        boolean running = true;
//

        String temp = file.substring(1);
        while(running){
            ids.add(temp.substring(0, temp.indexOf("`")-1));
            locations.add(temp.substring(temp.indexOf("`")+1, temp.indexOf("@")));
            names.add(temp.substring(temp.indexOf("@")+1, temp.indexOf("|")-1));

            System.out.println(temp.length());
            temp = temp.substring(temp.indexOf("|"));

            if(temp.length() < 2) running = false;

        }

        for(String id: ids){
            System.out.println(id);
        }

    }

    public boolean isMinionRegistered(Minion minion){
        boolean registered = false;

        for (String id: ids){
            if(id.equals(minion.getId())) registered = true;
        }

        if(registered) return true;
        else return false;
    }
    public boolean isMinionRegistered(String minionId){
        return false;
    }

    /**
     * registerMinion
     * Used to register the minion, it creates a unique id for the minion and stores the id sent with the id received...
     * @param minion
     * @return
     */


    public Minion registerMinion(Minion minion) throws IOException{
        //register the Minion
        // Where should the minion be "registered"?
        //return the id the application generated for the minion

        // write to file ("minions.txt")
        FileWriter fw = new FileWriter("minions.txt");
        fw.write("~" + minion.getId() + "`" + minion.getLocation() + "@" + minion.getName());
        fw.flush();
        fw.close();
        return minion;
    }
}
