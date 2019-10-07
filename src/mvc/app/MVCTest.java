package mvc.app;

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
				app.setBounds(100, 100, 640, 480);
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}
