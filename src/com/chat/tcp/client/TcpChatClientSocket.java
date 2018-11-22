package com.chat.tcp.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpChatClientSocket {

	public static void main(String[] args) throws Exception{
		int port =9091;
		String serverIp = "192.168.1.14";		
		Scanner sc = new Scanner(System.in);
		String msg;
		String reply;
		while(true) {
			Socket clientChatSocket = new Socket(serverIp, port);
			msg = sc.nextLine();
			PrintWriter out = new PrintWriter(new OutputStreamWriter(clientChatSocket.getOutputStream()));
			out.println(msg);
			out.flush();			
			BufferedReader br = new BufferedReader(new InputStreamReader(clientChatSocket.getInputStream()));
			reply = br.readLine();
			System.out.println(reply);
		}

	}

}
