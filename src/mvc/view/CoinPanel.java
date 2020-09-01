package mvc.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.Coin;
import model.interfaces.Player;

public class CoinPanel extends JPanel{
	private AppFrame frame;
	private JPanel panel = new JPanel();
	private ImageIcon headsCoin = new ImageIcon("images/heads.png");
	private ImageIcon tailsCoin = new ImageIcon("images/tails.png");
	JLabel heads = new JLabel(headsCoin);
	JLabel tails = new JLabel(tailsCoin);
	String headsimage = "images/heads.png";
	String tailsimage = "images/tails.png";
	private static final String TAILS = "TAILS";
	private static final String HEADS = "HEADS";
	public CoinPanel(AppFrame frame) {
		this.frame = frame;		
//		Graphics g = heads.getGraphics();
//	    g.drawImage(headsCoin, 0, 0, 20, 20, null);		
		panel.add(heads);
		panel.add(tails);
		add(panel);
	}
	/*
	 * ALGORITHM
	 * 	BEGIN
	 * 		REFRESH COIN PANEL
	 * 		TRY
	 * 			IF PLAYER'S NAME IS EQUAL TO THE PLAYER IN THE TOOL BAR
	 * 				THEN IF THE COIN IS ONE AND IS EQUAL TO HEADS CONSTANT
	 * 					REDRAW HEADS IMAGE TO TAILS IMAGE
	 * 				IF THE COIN IS ONE AND IS EQUAL TO TAILS CONSTANT
	 * 					REDRAW TAILS IMAGE TO HEADS IMAGE
	 * 		CATCH ANY EXEPCTIONS
	 * 	END
	 */
	public void coinOneflip(Coin coin, Player player) {
		revalidate();
		repaint();
		if (player.getPlayerName() == frame.getToolBar().getSelectedPlayer()) {
			try {
				if (coin.getNumber() == 1 && coin.getFace().name() == HEADS) {
					heads.setIcon(new ImageIcon(ImageIO.read(new File(headsimage))));

				}
				if (coin.getNumber() == 1 && coin.getFace().name() == TAILS) {
					heads.setIcon(new ImageIcon(ImageIO.read(new File(tailsimage))));
				}
			} catch (IOException e) {

			}
		}
	}
	public void coinTwoflip(Coin coin, Player player) {
		revalidate();
		repaint();
		if (player.getPlayerName() == frame.getToolBar().getSelectedPlayer()) {
			try {
				if (coin.getNumber() == 2 && coin.getFace().name() == HEADS) {
					tails.setIcon(new ImageIcon(ImageIO.read(new File(headsimage))));

				}
				if (coin.getNumber() == 2 && coin.getFace().name() == TAILS) {
					tails.setIcon(new ImageIcon(ImageIO.read(new File(tailsimage))));
				}
			} catch (IOException e) {

			}
		}
	}
	
	public void SpinCoinOneFlip(Coin coin) {
		try {
			if (coin.getNumber() == 1 && coin.getFace().name() == HEADS) {
				heads.setIcon(new ImageIcon(ImageIO.read(new File(headsimage))));

			}
			if (coin.getNumber() == 1 && coin.getFace().name() == TAILS) {
				heads.setIcon(new ImageIcon(ImageIO.read(new File(tailsimage))));
			}
		} catch (IOException e) {

		}
	}
	public void SpinCoinTwoFlip(Coin coin) {
		try {
			if (coin.getNumber() == 2 && coin.getFace().name() == HEADS) {
				tails.setIcon(new ImageIcon(ImageIO.read(new File(headsimage))));

			}
			if (coin.getNumber() == 2 && coin.getFace().name() == TAILS) {
				tails.setIcon(new ImageIcon(ImageIO.read(new File(tailsimage))));
			}
		} catch (IOException e) {

		}
	}
	public String isSpinning() {
		return "Spinning";
	}
}
