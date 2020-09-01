package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.Border;

import model.interfaces.Player;

public class SummaryPanel extends JPanel {
//	private JTable table;
//	private  DefaultTableModel model = new DefaultTableModel();
	Border blackline = BorderFactory.createLineBorder(Color.black);

	public SummaryPanel() {
		setBorder(blackline);
		setPreferredSize(new Dimension(155, 300));
//		
//		table = new JTable(model);
//		table.setMaximumSize(new Dimension(330,1200));
//		add(new JScrollPane(table)); 
//		model.addColumn("player ID");
//		model.addColumn("playerName");
//		model.addColumn("Points"); 
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
//		    TableColumn col = table.getColumnModel().getColumn(0);
//		    int width = 110;
//		    col.setPreferredWidth(width);
//		    setMaximumSize(new Dimension(400,1000));		
	}

	public void SummaryPanelUpdate(Collection<Player> players) {
		removeAll();
		updateUI();
		JLabel label1, label2, label3, label4, label5;
		if (players != null && players.size() > 0) {
			for (Player i : players) {
				label1 = new JLabel("Player Id: " + i.getPlayerId());
				label2 = new JLabel("Player Name: " + i.getPlayerName());
				label3 = new JLabel("Player Points: " + i.getPoints());
				label4 = new JLabel("Player Bet: " + i.getBet());
				label5 = new JLabel("Player BetType: " + i.getBetType());
				add(label1);
				add(label2);
				add(label3);
				add(label4);
				add(label5);
//				if(i.getPoints() <= 0) {
//					engine.removePlayer(i);
//				}
			}

		}
	}	

}
	
