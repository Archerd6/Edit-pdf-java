package Edit_pdf_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class Edit_pdf_java
{
	private JTextArea textPath;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Edit_pdf_java window = new Edit_pdf_java();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Edit_pdf_java()
	{
		// First done by the program
		initialize();
		
		//textPath.setText(System.getProperty("user.dir")); // Pruebas
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textPath = new JTextArea();
		textPath.setBackground(SystemColor.menu);
		textPath.setEditable(false);
		textPath.setText("Localization of path");
		textPath.setBounds(10, 73, 414, 22);
		frame.getContentPane().add(textPath);
	}
}
