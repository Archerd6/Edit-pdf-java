package Edit_pdf_java;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Edit_pdf_java
{
	private JFrame frame;
	private JButton btnInsertMetadata;
	private JButton btnMergePdfs;
	private JButton BRemove_links;
	private JButton btnRemoveMetadata;
	private JButton btnRemovePage;
	private JButton btnSplit;
	private JTextField txtTextosiFuera;

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
		txtTextosiFuera.setVisible(false);
		
		String INPUT_PATH = System.getProperty("user.dir") + "\\pdf_In";
	    String OUTPUT_PATH = System.getProperty("user.dir") + "\\pdf_Out";
	    
	  //Loading existing documents
	    File dir = new File(INPUT_PATH);
	    dir.mkdirs();
	    File dirOut = new File(OUTPUT_PATH);
	    dirOut.mkdirs();
		
	    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Edit_pdf_java.class.getResource("/imgs/PDFicon.png")));
	    
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 444, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGetImages = new JButton("Get Images");
		btnGetImages.setBackground(new Color(224, 255, 255));
		btnGetImages.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					GetImages.Ejecutar();
				}
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGetImages.setBounds(10, 33, 103, 23);
		frame.getContentPane().add(btnGetImages);
		btnGetImages.setFocusable(false);
		
		btnInsertMetadata = new JButton("Insert Metadata");
		btnInsertMetadata.setBackground(new Color(245, 245, 220));
		btnInsertMetadata.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				InsertMetadata.Ejecutar();
			}
		});
		btnInsertMetadata.setFocusable(false);
		btnInsertMetadata.setBounds(10, 118, 127, 23);
		frame.getContentPane().add(btnInsertMetadata);
		
		btnMergePdfs = new JButton("MergePDFs");
		btnMergePdfs.setBackground(new Color(255, 239, 213));
		btnMergePdfs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MergePdfs.Ejecutar();
			}
		});
		btnMergePdfs.setFocusable(false);
		btnMergePdfs.setBounds(270, 33, 127, 23);
		frame.getContentPane().add(btnMergePdfs);
		
		BRemove_links = new JButton("Remove links");
		BRemove_links.setBackground(new Color(240, 255, 255));
		BRemove_links.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Remove_links.Ejecutar();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		BRemove_links.setFocusable(false);
		BRemove_links.setBounds(270, 118, 127, 23);
		frame.getContentPane().add(BRemove_links);
		
		btnRemoveMetadata = new JButton("Remove Metadata");
		btnRemoveMetadata.setBackground(new Color(248, 248, 255));
		btnRemoveMetadata.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				RemoveMetadata.Ejecutar();
			}
		});
		btnRemoveMetadata.setFocusable(false);
		btnRemoveMetadata.setBounds(10, 227, 137, 23);
		frame.getContentPane().add(btnRemoveMetadata);
		
		btnRemovePage = new JButton("Remove Page");
		btnRemovePage.setBackground(new Color(255, 240, 245));
		btnRemovePage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtTextosiFuera.isVisible())
				{
					try
					{
						RemovingPages.Ejecutar(Integer.parseInt(txtTextosiFuera.getText()));
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
				}
				else
				{
					txtTextosiFuera.setVisible(true);
				}
			}
		});
		btnRemovePage.setFocusable(false);
		btnRemovePage.setBounds(270, 227, 127, 23);
		frame.getContentPane().add(btnRemovePage);
		
		btnSplit = new JButton("Split PDF");
		btnSplit.setBackground(new Color(230, 230, 250));
		btnSplit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SplitPdf.Ejecutar(); // All done
			}
		});
		btnSplit.setFocusable(false);
		btnSplit.setBounds(145, 305, 127, 23);
		frame.getContentPane().add(btnSplit);
		
		txtTextosiFuera = new JTextField();
		txtTextosiFuera.setHorizontalAlignment(SwingConstants.CENTER);
		txtTextosiFuera.setText("(Number)");
		txtTextosiFuera.setBounds(0, 0, 428, 20);
		frame.getContentPane().add(txtTextosiFuera);
		txtTextosiFuera.setColumns(10);
	}
}
