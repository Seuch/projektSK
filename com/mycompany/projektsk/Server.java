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
public class Server {
    public static void main(String[] args) throws IOException{
        final int port = 6868;
        ServerSocket serwer = new ServerSocket(port);
        Socket socket = null;
            
        while(true){
            try{
                socket = serwer.accept();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            new ClientHandler(socket).start();
        }
        
    }
}
