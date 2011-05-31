/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_network_interface;

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author jonghayun
 */
public class server extends JFrame {

	private ServerSocket servSock;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket sock;
	
	private JTextArea jta = new JTextArea();
	private JTextField jtf = new JTextField();
	private JPanel panel = new JPanel();

	public server() {
		try {
			InetAddress ownIP = InetAddress.getLocalHost();
			JOptionPane.showMessageDialog(null, "Your IP is " + ownIP.getHostAddress());
			servSock = new ServerSocket(1205);
			dis = new DataInputStream(sock.getInputStream());
			dos = new DataOutputStream(sock.getOutputStream());

			boolean connected = dis.readBoolean();
			if (connected == true) {
				JOptionPane.showMessageDialog(null, "Client Succeced to connect your server.");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		panel.setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);

		jtf.addActionListener(new TextFieldListener());

		setTitle("Chatting");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public int communicate_client(int before, int after) {
		int input = 0;

		try {
			dos.writeInt(before * 100 + after);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		JOptionPane.showMessageDialog(null, "Wait opponent player");

		try {
			input = dis.readInt();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return input;
	}
	
	private class TextFieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				String message = jtf.getText().trim();
				dos.writeUTF(message);
				dos.flush();
				jta.append("I: " + message + "\n");

				message = dis.readUTF();
				jta.append("Enemy: " + message + "\n");
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}