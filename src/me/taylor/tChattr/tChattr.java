package me.taylor.tChattr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class tChattr {

	public static void main(String[] args) {
		new GUI().setup();
		
		tChattr chattr = new tChattr();
		chattr.setUpNetworking();
		chattr.thread();
	}
	
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;
	
	public void thread() {
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
	}
	 
	 private void setUpNetworking() {
		 try {
			 socket = new Socket("127.0.0.1", 5000);
			 InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			 reader = new BufferedReader(streamReader);
			 writer = new PrintWriter(socket.getOutputStream());
			 new GUI().incoming.append("Networking established! :) \n");
		 } catch(IOException ex) {
			 ex.printStackTrace();
		 }
	 }
	
	

}
