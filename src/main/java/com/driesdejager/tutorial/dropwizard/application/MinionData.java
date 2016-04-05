package com.driesdejager.tutorial.dropwizard.application;

import com.driesdejager.tutorial.dropwizard.api.Heartbeat;
import com.driesdejager.tutorial.dropwizard.api.Minion;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by georgej on 23/03/16.
 */
public class  MinionData {

    private ArrayList<Minion> minions;
    private ArrayList<Heartbeat> heartbeats;

    public ArrayList<Minion> getMinions() {
        return minions;
    }
    public ArrayList<Heartbeat> getHeartbeats() { return heartbeats; }

    public boolean isMinionRegistered(Minion minion){
        for(Minion min: minions){
            if(min.getId().equals(minion.getId())) return true;
        }
        return false;
    }

    public boolean isMinionRegistered(String id){
        for(Minion min: minions){
            if(min.getId().equals(id)) return true;
        }
        return false;
    }


    public boolean saveHB(Heartbeat hb) throws IOException{
        // TODO: save heartbeat
        FileWriter fw = new FileWriter("minions.txt");
        fw.write("~" + hb.getId() + "`" + hb.getTime());
        fw.flush();
        fw.close();
        return true;
    }

    public boolean registerMinion(Minion minion) throws IOException{
        // TODO: save minion

        FileWriter fw = new FileWriter("minions.txt");
        fw.write("~" + minion.getId() + "`" + minion.getLocation() + "@" + minion.getName());
        fw.flush();
        fw.close();


        return true;
    }

    public MinionData() throws IOException{
        getAllHeartbeats();
        getAllMinions();
    }

    private void getAllMinions() throws IOException{
        File f = new File("minions.txt");

        BufferedReader br = new BufferedReader(new FileReader(f));
        String fileContents = "";
        String line = br.readLine();
        while (line != null) {
            fileContents += line;
            line = br.readLine();
        }

        br.close();

        String tempFile = fileContents.substring(1);
        boolean running = false;
        while(running){
            Minion tempMinion = new Minion();
            tempMinion.setId(tempFile.substring(0, tempFile.indexOf("`")-1));
            tempMinion.setLocation(tempFile.substring(tempFile.indexOf("`")+1, tempFile.indexOf("@")));
            tempMinion.setName(tempFile.substring(tempFile.indexOf("@")+1, tempFile.indexOf("|")-1));

            tempFile = tempFile.substring(tempFile.indexOf("|"));
            if(tempFile.length() < 2) running = false;

            minions.add(tempMinion);
        }
    }

    private void getAllHeartbeats() throws IOException{
        File f = new File("heartbeats.txt");

        BufferedReader br = new BufferedReader(new FileReader(f));
        String fileContents = "";
        String line = br.readLine();
        while (line != null) {
            fileContents += line;
            line = br.readLine();
        }

        br.close();

        String tempFile = fileContents.substring(1);
        boolean running = false;
        while(running){
            Minion tempMinion = new Minion();
            tempMinion.setId(tempFile.substring(0, tempFile.indexOf("`")-1));
            tempMinion.setLocation(tempFile.substring(tempFile.indexOf("`")+1, tempFile.indexOf("@")));
            tempMinion.setName(tempFile.substring(tempFile.indexOf("@")+1, tempFile.indexOf("|")-1));

            tempFile = tempFile.substring(tempFile.indexOf("|"));
            if(tempFile.length() < 2) running = false;

            minions.add(tempMinion);
        }
    }
}




/*

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
 */