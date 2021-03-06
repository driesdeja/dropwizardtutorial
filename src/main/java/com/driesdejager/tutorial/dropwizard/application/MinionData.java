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
            System.out.println(min.getLocation() + " " + min.getName());
            if(min.getId().equals(id)) return true;
        }
        return false;
    }


    public boolean saveHB(Heartbeat hb) throws IOException{
        // TODO: save heartbeat
        FileWriter fw = new FileWriter("heartbeats.txt", true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        PrintWriter out = new PrintWriter(bw);
//        out.println("~" + hb.getId() + "`" + hb.getTime());
        fw.append("~" + hb.getId() + "`" + hb.getTime() + "\n");
        fw.flush();
        fw.close();
        return true;
    }

    public boolean registerMinion(Minion minion) throws IOException{
        // TODO: save minion
        System.out.println(minions.size());

        FileWriter fw = new FileWriter("minions.txt", true);
        fw.append("~" + minion.getId() + "`" + minion.getLocation() + "@" + minion.getName() + "|" + "\n");
        fw.flush();
        fw.close();


        return true;
    }

    public MinionData() throws IOException{
        getAllHeartbeats();
        logAllMinions();
    }

    private void logAllMinions() throws IOException{
        minions = new ArrayList<Minion>();

        File f = new File("minions.txt");

        BufferedReader br = new BufferedReader(new FileReader(f));
        String fileContents = "";
        String line = br.readLine();
        while (line != null) {
            fileContents += line;
            line = br.readLine();
        }

//        System.out.println(fileContents);

        br.close();

        String tempFile = fileContents.substring(1);
        boolean running = true;
        while(running){
            Minion tempMinion = new Minion();
            tempMinion.setId(tempFile.substring(0, tempFile.indexOf("`")));
            tempMinion.setLocation(tempFile.substring(tempFile.indexOf("`")+1, tempFile.indexOf("@")));
            tempMinion.setName(tempFile.substring(tempFile.indexOf("@")+1, tempFile.indexOf("|")));
//            System.out.println(tempFile.substring(0, tempFile.indexOf("`")));

            if(tempFile.substring(tempFile.indexOf("|")).length() > 4){
                if(tempFile.substring(tempFile.indexOf("|")+2).length() > 5) tempFile = tempFile.substring(tempFile.indexOf("|")+2);
                else running = false;
            }
            else running = false;

            minions.add(tempMinion);
        }
    }

    private void getAllHeartbeats() throws IOException{
        heartbeats = new ArrayList<Heartbeat>();

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
            Heartbeat tempHeartbeat = new Heartbeat();
            tempHeartbeat.setId(tempFile.substring(0, tempFile.indexOf("`")-1));
            tempHeartbeat.setTime(tempFile.substring(tempFile.indexOf("`")+1, tempFile.indexOf("|")-1));

            tempFile = tempFile.substring(tempFile.indexOf("|"));
            if(tempFile.length() < 2) running = false;

            heartbeats.add(tempHeartbeat);
        }
    }

    public Heartbeat getMinionHeartbeat(String id){
        for(Heartbeat hb: heartbeats){
            if(hb.getId().equals(id)) return hb;
        }
        return null;
    }

    public Heartbeat getMostRecentHeartbeat(String id){
        for (int i = heartbeats.size()-1; i >= 0; i--){
            if(heartbeats.get(i).getId().equals(id)) return heartbeats.get(i);
        }
        return null;
    }

    public ArrayList<Minion> getAllMinions(){
        return minions;
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