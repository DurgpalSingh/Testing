package com.dp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String...args) {
		int PORT = 1122;
		try {
			ServerSocket ss = new ServerSocket(PORT);
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("Server responed");
			dos.close();
			os.close();
			s.close();			
		} catch (IOException e) {
			System.out.println("Error occured");
			e.printStackTrace();
		}
	}
}
