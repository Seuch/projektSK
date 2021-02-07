/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projektsk;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seuch
 */
public class ClientHandler extends Thread{
    private final Socket socket;
    
    public ClientHandler(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run(){
        BufferedReader in;
        DataOutputStream out;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            return;
        }
        
        String msg;
        try {
            out.writeBytes("CONNECT"+"\n");
        } catch (IOException ex) {
            return;
        }
        while (true) {
            try {
                msg = in.readLine();
                System.out.println(msg);
                if(Thread.activeCount() == 5) 
                {
                    System.out.println("START");
                    break;
                }
                        
                }
             catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}