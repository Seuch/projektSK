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
public class Serwer {
    public static void main(String[] args) throws IOException{
        ServerSocket serwer = new ServerSocket(6969);
        Socket s = serwer.accept();
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("CONNECT\n");
        pr.flush();
        
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(inFromClient.readLine());
        
    }
}
