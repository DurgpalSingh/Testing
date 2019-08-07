package com.dp.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String... arr) {
		System.out.println(arr);
		int socketNo = Integer.valueOf(arr[0]).intValue();
		DatagramSocket dSocket = null;
		try {
			dSocket = new DatagramSocket(socketNo);
			byte[] buffer = new byte[1000];
			while (true) {
				DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length);
				dSocket.receive(dPacket);
				DatagramPacket reply = new DatagramPacket(dPacket.getData(), dPacket.getLength(), dPacket.getAddress(),
						dPacket.getPort());
				dSocket.send(reply);
			}
		} catch (Exception ex) {
			System.out.println("Error Occured");
		} finally {
			if (dSocket != null) {
				dSocket.close();
			}
		}
	}
}
