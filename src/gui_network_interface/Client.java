/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_network_interface;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jonghayun
 */
public class Client {
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	
	public Client(){
		String serverIP=JOptionPane.showInputDialog(null,"Enter the IP address of server: ");
		
		try{
			Socket socket=new Socket(serverIP,1205);
			if(socket.isConnected()){
				JOptionPane.showMessageDialog(null,"Success to Connect!");
			}
			else if(socket.isClosed()){
				JOptionPane.showMessageDialog(null, "Connetion Failed!");
				System.exit(1);
			}
			fromServer=new DataInputStream(socket.getInputStream());
			toServer=new DataOutputStream(socket.getOutputStream());
			toServer.writeBoolean(true);//연결 됐음을 신호로 보냄
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,ex.toString());
		}
	}
	
	public int communicate_server(int before,int after){
		int input=0;
		
		try{//seding coordinates
			toServer.writeInt(before*100+after);
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,ex.toString());
		}
		
		JOptionPane.showMessageDialog(null,"Wait opponent player");
		
		try{//receiving coordinates
			input=fromServer.readInt();
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,ex.toString());
		}
		
		return input;
	}
}
