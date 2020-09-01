package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.Player;
import mvc.controller.BetPlaceController;

public class StatusBar extends JPanel implements PropertyChangeListener {
	private JLabel statusLabel1 = new JLabel("\t Current Player: ", JLabel.LEFT);
	public StatusBar(ToolBar toolBar, CoinPanel coinPanel) {
		toolBar.addPropertyChangeListener(ToolBar.PLAYERNAME, this);

		statusLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		statusLabel1.setPreferredSize(new Dimension(100, 30));
		setLayout(new GridLayout(1, 2));
		add(statusLabel1);


	}

	private void setStatus1(String playerSelected) {
		statusLabel1.removeAll();
		statusLabel1.setText(playerSelected);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// for status1
		if (evt.getPropertyName().equals(ToolBar.PLAYERNAME) && evt.getNewValue() != null) {
			setStatus1("Current Player: \t" + evt.getNewValue().toString());
		}
	}
}
