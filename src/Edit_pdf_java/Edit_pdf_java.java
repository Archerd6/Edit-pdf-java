package Edit_pdf_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.io.File;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit_pdf_java
{
	private JTextArea textPath;
	private JFrame frame;
	private JButton btnInsertMetadata;
	private JButton btnMergePdfs;
	private JButton Remove_links;
	private JButton btnRemoveMetadata;
	private JButton btnRemovePage;
	private JButton btnSplit;

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
		
		textPath.setVisible(false);
		//textPath.setText(System.getProperty("user.dir")); // Pruebas
		
		String INPUT_PATH = System.getProperty("user.dir") + "\\pdf_In";
	    String OUTPUT_PATH = System.getProperty("user.dir") + "\\pdf_Out";
	    
	  //Loading existing documents
	    File dir = new File(INPUT_PATH);
	    dir.mkdirs();
	    File dirOut = new File(OUTPUT_PATH);
	    dirOut.mkdirs();
		
	    
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textPath = new JTextArea();
		textPath.setBackground(SystemColor.menu);
		textPath.setEditable(false);
		textPath.setText("Localization of path");
		textPath.setBounds(10, 11, 414, 22);
		frame.getContentPane().add(textPath);
		
		JButton btnGetImages = new JButton("Get Images");
		btnGetImages.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnGetImages.setBounds(50, 70, 103, 23);
		frame.getContentPane().add(btnGetImages);
		btnGetImages.setFocusable(false);
		
		btnInsertMetadata = new JButton("Insert Metadata");
		btnInsertMetadata.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnInsertMetadata.setFocusable(false);
		btnInsertMetadata.setBounds(50, 132, 127, 23);
		frame.getContentPane().add(btnInsertMetadata);
		
		btnMergePdfs = new JButton("MergePDFs");
		btnMergePdfs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnMergePdfs.setFocusable(false);
		btnMergePdfs.setBounds(258, 70, 127, 23);
		frame.getContentPane().add(btnMergePdfs);
		
		Remove_links = new JButton("Remove links");
		Remove_links.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		Remove_links.setFocusable(false);
		Remove_links.setBounds(258, 132, 127, 23);
		frame.getContentPane().add(Remove_links);
		
		btnRemoveMetadata = new JButton("Remove Metadata");
		btnRemoveMetadata.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnRemoveMetadata.setFocusable(false);
		btnRemoveMetadata.setBounds(50, 196, 137, 23);
		frame.getContentPane().add(btnRemoveMetadata);
		
		btnRemovePage = new JButton("Remove Page");
		btnRemovePage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnRemovePage.setFocusable(false);
		btnRemovePage.setBounds(258, 196, 127, 23);
		frame.getContentPane().add(btnRemovePage);
		
		btnSplit = new JButton("Split PDF");
		btnSplit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SplitPdf.Executar();
				System.out.println("Hecho");
			}
		});
		btnSplit.setFocusable(false);
		btnSplit.setBounds(163, 268, 127, 23);
		frame.getContentPane().add(btnSplit);
	}
}
