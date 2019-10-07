package mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;


public class SpinController extends MouseAdapter{
	private GameEngine engine = new GameEngineImpl();
	private GameEngineCallbackGUI gecGUI;
	private SimplePlayer player;
	public void mousePressed(MouseEvent event) {
		
		
			engine.spinPlayer(player, 100, 1000, 100, 50, 500, 50);
			System.out.println(player.getPlayerName());
	      
	}

}
