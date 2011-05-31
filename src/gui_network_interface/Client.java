/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_network_interface;

import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jonghayun
 */
public class Client extends JFrame {

	private DataOutputStream toServer;
	private DataInputStream fromServer;
	private JTextField jtf;
	private JTextArea jta;
	JPanel panel;

	public Client() {
		String serverIP = JOptionPane.showInputDialog(null, "Enter the IP address of server: ");

		try {
			Socket socket = new Socket(serverIP, 1205);
			if (socket.isConnected()) {
				JOptionPane.showMessageDialog(null, "Success to Connect!");
			} else if (socket.isClosed()) {
				JOptionPane.showMessageDialog(null, "Connetion Failed!");
				System.exit(1);
			}
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
			toServer.writeBoolean(true);

			panel = new JPanel();
			jtf = new JTextField();
			jta = new JTextArea();

			panel.setLayout(new BorderLayout());
			add(panel, BorderLayout.SOUTH);
			add(new JScrollPane(jta), BorderLayout.CENTER);

			jtf.addActionListener(new TextFieldListener());

			setTitle("Chatting");
			setSize(500, 300);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public int communicate_server(int before, int after) {
		int input = 0;

		try {//seding coordinates
			toServer.writeInt(before * 100 + after);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		JOptionPane.showMessageDialog(null, "Wait opponent player");

		try {//receiving coordinates
			input = fromServer.readInt();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return input;
	}

	private class TextFieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				String message = jtf.getText().trim();
				toServer.writeUTF(message);
				toServer.flush();
				jta.append("I: " + message + "\n");

				message = fromServer.readUTF();
				jta.append("Enemy: " + message + "\n");
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
