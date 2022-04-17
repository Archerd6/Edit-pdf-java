package Edit_pdf_java;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;






@SuppressWarnings("serial")
public class Insert_metadata_Window extends JFrame /*La clase principal es una ventana (JFrame)*/
{
	/** Ancho de la ventana*/
	private int widht = 640;
	/** Alto de la ventana*/
	private int height = 480;
	
	/** Panel en el que se generan todos los gráficos*/
	private ImagenSnake imagenSnake;

	Integer ToErase;
	private JTextField textTitle;
	private JTextField textSubject;
	private JTextField textKeywords;
	private JTextField textProducer;
	private JTextField textAuthor;
	private JTextField textCreator;
	private JLabel lblCreator;
	private JLabel lblProducer;
	private JButton btnInsert;
	public Insert_metadata_Window()
	{
		setResizable(false);
		setTitle("Isert metadata");
		inicializa();
	}
	
	private void inicializa()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Edit_pdf_java.class.getResource("/imgs/Insert.png")));/*Nombre de la ventana*/
		this.setSize(376, 413); /*Tamaño de la ventana*/
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2 -widht/2, dim.height/2 -height/2);  /*Para que aparezca centrado*/
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);    /* Para apagar el programa cuando cierre la ventana*/
		
		imagenSnake = new ImagenSnake();
		this.getContentPane().add(imagenSnake); 
		getContentPane().setLayout(null);
		
		textTitle = new JTextField();
		textTitle.setText("T");
		textTitle.setBounds(166, 35, 132, 20);
		getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textSubject = new JTextField();
		textSubject.setText("S");
		textSubject.setColumns(10);
		textSubject.setBounds(166, 82, 132, 20);
		getContentPane().add(textSubject);
		
		textKeywords = new JTextField();
		textKeywords.setText("K");
		textKeywords.setColumns(10);
		textKeywords.setBounds(166, 135, 132, 20);
		getContentPane().add(textKeywords);
		
		textProducer = new JTextField();
		textProducer.setText("P");
		textProducer.setColumns(10);
		textProducer.setBounds(166, 274, 132, 20);
		getContentPane().add(textProducer);
		
		textAuthor = new JTextField();
		textAuthor.setText("A");
		textAuthor.setColumns(10);
		textAuthor.setBounds(166, 185, 132, 20);
		getContentPane().add(textAuthor);
		
		textCreator = new JTextField();
		textCreator.setText("C");
		textCreator.setColumns(10);
		textCreator.setBounds(166, 231, 132, 20);
		getContentPane().add(textCreator);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(35, 38, 46, 14);
		getContentPane().add(lblTitle);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(35, 85, 46, 14);
		getContentPane().add(lblSubject);
		
		JLabel lblKeywords = new JLabel("Keywords");
		lblKeywords.setBounds(35, 138, 76, 14);
		getContentPane().add(lblKeywords);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(35, 188, 46, 14);
		getContentPane().add(lblAuthor);
		
		lblCreator = new JLabel("Creator");
		lblCreator.setBounds(35, 234, 46, 14);
		getContentPane().add(lblCreator);
		
		lblProducer = new JLabel("Producer");
		lblProducer.setBounds(35, 277, 57, 14);
		getContentPane().add(lblProducer);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnInsert.setBackground(new Color(245, 245, 220));
				InsertMetadata.Ejecutar(textTitle.getText(),textSubject.getText(),textKeywords.getText(),textAuthor.getText(),textCreator.getText(),textProducer.getText());
			}
		});
		btnInsert.setFocusable(false);
		btnInsert.setBounds(129, 340, 89, 23);
		getContentPane().add(btnInsert);
		
		
	}

	public static void main(String[] args)
	{
		Insert_metadata_Window D = new Insert_metadata_Window(); /*Crea la ventana*/
		D.setVisible(true);    /*Hacer visible la ventana*/   /* Para modo pantalla completa ->  D.setExtendedState(Frame.MAXIMIZED_BOTH)*/
	}
	
	/**Clase que tiene los gráficos de la serpiente, la comida, el borde y si está activada la variable desarrollador, también los de la información adicional*/
	public class ImagenSnake extends JPanel
	{
		
	}
}