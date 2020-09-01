package mvc.app;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import mvc.view.AppFrame;


public class MVCTest {

	public static void main(String[] args) {
		  SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{				
				AppFrame app = new AppFrame();
				app.setVisible(true);
				app.setBounds(200, 200, 1050, 570);
				app.setMinimumSize(new Dimension(800,500));
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}
