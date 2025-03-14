package com.company.java019;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network001_InetAddress {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("1. ip HostName : "+local.getHostName());
			System.out.println("1. ip HostAddress : "+local.getHostAddress());
			//192.168.40.62
			
			local = InetAddress.getByName("www.naver.com");
			System.out.println("3. naver "+local);
		} catch (UnknownHostException e) {  e.printStackTrace(); }
		
	}
}
