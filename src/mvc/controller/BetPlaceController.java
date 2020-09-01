package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.AppFrame;
import mvc.view.ToolBar;

public class BetPlaceController implements ActionListener{
	private GameEngine engine;
	private AppFrame frame;
	private JTextField betAmount = new JTextField();
	private JComboBox<BetType> comboBox = new JComboBox<>(BetType.values());


	public BetPlaceController(GameEngine engine, AppFrame frame) {
		this.frame = frame;
		this.engine = engine;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] message = {"Enter bet Amount", betAmount, "Select Bet Type:", comboBox};
		int option = JOptionPane.showConfirmDialog(null, message, "Place Bet", JOptionPane.OK_CANCEL_OPTION);
		if (!BetisNull()) {
			if(option == JOptionPane.OK_OPTION) {
			placeBet();	
				
			}
		}
	}
	public boolean BetisNull() {
		return betAmount.getText().isEmpty() || betAmount.getText() == null;
	}
	public void placeBet() {			
		String strBet = betAmount.getText();
		if(frame.getToolBar().getSelectedPlayer() != null) {
		engine.placeBet(frame.getToolBar().getSelectedIndex(), Integer.valueOf(strBet).intValue(),(BetType) comboBox.getSelectedItem());
		frame.getSummaryPanel().SummaryPanelUpdate(engine.getAllPlayers());
		betAmount.setText(null);
		}
		betAmount.setText(null);
	}
}
