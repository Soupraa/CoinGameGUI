package mvc.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.interfaces.GameEngine;
import mvc.controller.MenuController;

public class MenuBar extends JMenuBar{
	private JMenuBar menuBar = new JMenuBar();
	GameEngine engine;
	public MenuBar(GameEngine engine) 
	{
		this.engine = engine;
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		add(menuBar);
		
		JMenuItem menuItem = new JMenuItem("Add Player");
		MenuController addPlayerActionListener = new MenuController(engine);
		menuItem.addActionListener(addPlayerActionListener);
		menu.add(menuItem);
		
		//JMenuItem menuItem2 = new JMenuItem("Remove Player");
		//menuItem2.addMouseListener(new MenuController());
	}
}
