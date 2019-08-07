package com.dp.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String...arr) {
		DatagramSocket dSocket = null;
		try {
			dSocket = new DatagramSocket();
			byte[] data = arr[0].getBytes();
			InetAddress host = InetAddress.getByName(arr[1]);
			int port = Integer.valueOf(arr[2]).intValue();
			DatagramPacket request = new DatagramPacket(data, data.length, host, port);
			dSocket.send(request);
			byte[] buffer = new byte[1000];	
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			dSocket.receive(reply);
			System.out.println("Client " + reply.getData());
		} catch(Exception ex) {
			System.out.println("Client Exception");
		} finally {
			if(dSocket != null) {
				dSocket.close();
			}
		}
	}
}
