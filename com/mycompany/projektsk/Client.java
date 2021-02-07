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
public class Client {
    public static void main(String[] args) throws Exception{
        final int INDEX = 459313;
        int x = 1;
        int numberOfDomino = 0;
        
        String ip_address = "localhost";
        int port = 6969;
        
        boolean connection = false;
        String msgFromServer;
        
            try(Socket client = new Socket(ip_address, port))
            {
                connection = true;
                PrintWriter outToServer = new PrintWriter(client.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                while(connection){
                    msgFromServer = inFromServer.readLine();

                    //System.out.println(msgFromServer);
                    //System.out.println(importantMsgFromServer);

                        if(msgFromServer.equals("CONNECT") || msgFromServer.equals("CONNECT\n")) {
                            System.out.println(msgFromServer);
                            outToServer.print("LOGIN " + INDEX + "\n");
                            outToServer.flush();
                        }
                        else if(msgFromServer.equals("YOUR CHOICE") || msgFromServer.equals("YOUR CHOICE\n") || msgFromServer.equals("ERROR"))
                        {
                            System.out.println(msgFromServer);
                            if(numberOfDomino < 48){
                                numberOfDomino++;
                                outToServer.print("CHOOSE " + numberOfDomino + "\n");
                                outToServer.flush();
                            }
                            else 
                            {
                                numberOfDomino = 1;
                                outToServer.print("CHOOSE " + numberOfDomino + "\n");
                                outToServer.flush();
                            }
                        }
                        else if(msgFromServer.equals("YOUR MOVE") || msgFromServer.equals("YOUR MOVE\n"))
                        {
                            System.out.println(msgFromServer);
                            outToServer.print("MOVE " + x + " 0 0\n");
                            outToServer.flush();
                            x += 2;
                        }
                        else if(msgFromServer.startsWith("GAME")){
                            System.out.println(msgFromServer);
                            connection = false;
                        } 
                        else{ System.out.println(msgFromServer);}
            }
            client.close();
    }
            
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
    }
}