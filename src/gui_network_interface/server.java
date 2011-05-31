/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_network_interface;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.lang.*;

/**
 *
 * @author jonghayun
 */
public class server {

	private ServerSocket servSock;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket sock;

	public server() {
		try {
			InetAddress ownIP = InetAddress.getLocalHost();
			JOptionPane.showMessageDialog(null, "Your IP is " + ownIP.getHostAddress());
			servSock = new ServerSocket(1205);
			dis=new DataInputStream(sock.getInputStream());
			dos=new DataOutputStream(sock.getOutputStream());
			
			boolean connected=dis.readBoolean();
			if(connected==true)	JOptionPane.showMessageDialog(null, "Client Succeced to connect your server.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public int communicate_client(int before,int after){
		int input=0;
		
		try{
			dos.writeInt(before*100+after);
		}catch(IOException ex){		
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		
		JOptionPane.showMessageDialog(null,"Wait opponent player");
		
		try{
			input=dis.readInt();
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		
		return input;
	}
}