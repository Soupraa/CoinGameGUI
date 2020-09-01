package mvc.view;

import java.util.Collection;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.controller.AddPlayerController;
import mvc.controller.RemovePlayerController;


public class MenuBar extends JMenuBar{
	
	private JMenuBar menuBar = new JMenuBar();
	
	
	public MenuBar(GameEngine engine, AppFrame frame) 
	{
		JMenu menu = new JMenu("Menu");
		menu.updateUI();
		menuBar.add(menu);
		add(menuBar);
		
		//Addplayer menu
		JMenuItem menuItem = new JMenuItem("Add Player");
		menuItem.updateUI();
		AddPlayerController addPlayerActionListener = new AddPlayerController(engine, frame);
		menuItem.addActionListener(addPlayerActionListener);
		menu.add(menuItem);
		
		//Remove player menu
		JMenuItem menuItem2 = new JMenuItem("Remove Player");
		RemovePlayerController removePlayer = new RemovePlayerController(engine, frame);
		menuItem2.addActionListener(removePlayer);
		menu.add(menuItem2);
	}	
}
