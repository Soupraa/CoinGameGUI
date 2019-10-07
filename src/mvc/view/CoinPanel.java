package mvc.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
public class CoinPanel extends JPanel {
	private GameEngine gameEngine;
		public CoinPanel() {
			BufferedImage headsCoin;
			BufferedImage tailsCoin;
			try {
				headsCoin = ImageIO.read(new File("images/heads.png"));
				JLabel heads = new JLabel(new ImageIcon(headsCoin));
				add(heads);
				
				tailsCoin = ImageIO.read(new File("images/tails.png"));
				JLabel tails = new JLabel(new ImageIcon(tailsCoin));
				add(tails);
			} catch (IOException e) {
				}		
		}
}
