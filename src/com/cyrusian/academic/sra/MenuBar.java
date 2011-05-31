/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyrusian.academic.sra;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jonghayun
 */
public class MenuBar {
	private JMenuBar menuBar;

	public MenuBar(){
		menuBar=new JMenuBar();
		
		JMenu difMenu=new JMenu("Difficulty");
		menuBar.add(difMenu);
		
		JMenuItem dif_easy=new JMenuItem("Easy");
		JMenuItem dif_mid=new JMenuItem("Middle");
		JMenuItem dif_hard=new JMenuItem("Hard");
		difMenu.add(dif_easy);
		difMenu.add(dif_mid);
		difMenu.add(dif_hard);
		
	}
}
