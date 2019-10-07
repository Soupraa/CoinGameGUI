package mvc.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class AppFrame extends JFrame{
	GameEngine engine;
	public AppFrame() {
		engine = new GameEngineImpl();
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(new MenuBar(engine), BorderLayout.NORTH);
		top.add(new ToolBar(), BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		
		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout());
		middle.add(new CoinPanel(), BorderLayout.CENTER);
		middle.add(new SummaryPanel(), BorderLayout.EAST);
		middle.add(new StatusBar(), BorderLayout.SOUTH);	
		add(middle, BorderLayout.CENTER);	
	}

}
