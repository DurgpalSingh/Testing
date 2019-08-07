package com.dp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String...arr) {
		String server = "localhost";
		int port = 1122;
		try {
			Socket s = new Socket(server, port);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String str = new String(dis.readUTF());
			System.out.println(str);
			dis.close();
			is.close();
			s.close();			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
