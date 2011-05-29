package com.cyrusian.academic.sra;

import java.awt.*;
import javax.swing.*;

public class JImagePanel extends JPanel {
	Image image;

	public JImagePanel(Image image) {
		this.image = image;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(this.image, 650, 0, this);
	}
}