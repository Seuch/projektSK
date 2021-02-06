/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projektsk;

import java.net.*;
import java.io.*;

/**
 *
 * @author seuch
 */
public class Klient {
    public static void main(String[] args) throws IOException{
        String msgFromServer;
        final int INDEX = 459313;
        
        Socket client = new Socket("localhost", 6969);

        DataOutputStream outToServer = new

        DataOutputStream(client.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //outToServer.writeBytes(msg + '\n');

        msgFromServer = inFromServer.readLine();

        System.out.println(msgFromServer);
        
        if(msgFromServer.equals("CONNECT") || msgFromServer.equals("CONNECT\n")) {
            outToServer.writeBytes("LOGIN " + INDEX + "\n");
        } else {
        }
        
        

        client.close();
    }
}
