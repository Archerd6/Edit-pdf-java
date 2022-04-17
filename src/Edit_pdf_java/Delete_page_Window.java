package Edit_pdf_java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class Delete_page_Window extends JFrame /*La clase principal es una ventana (JFrame)*/
{
	/** Ancho de la ventana*/
	private int widht = 640;
	/** Alto de la ventana*/
	private int height = 480;
	
	/** Panel en el que se generan todos los gráficos*/
	private ImagenSnake imagenSnake;

	Integer ToErase;
	public Delete_page_Window()
	{
		inicializa();
	}
	
	private void inicializa()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Edit_pdf_java.class.getResource("/imgs/Erase.png")));
		setTitle("Delete");       /*Nombre de la ventana*/
		this.setSize(230, 183); /*Tamaño de la ventana*/
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2 -widht/2, dim.height/2 -height/2);  /*Para que aparezca centrado*/
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);    /* Para apagar el programa cuando cierre la ventana*/
		
		imagenSnake = new ImagenSnake();
		this.getContentPane().add(imagenSnake); 
		getContentPane().setLayout(null);
		
		// Number of pages
		Integer nPages = 1;
		try
		{
			nPages = RemovingPages.NumberOfPages();
		}
		catch (IOException e2)
		{
			e2.printStackTrace();
		}
		
		// from 1 to 88, in 1.0 steps start value 1 
		SpinnerNumberModel model1 = new SpinnerNumberModel(1.0, 1.0, Double.parseDouble(nPages.toString()), 1.0);
		JSpinner spinner = new JSpinner(model1);
		
		JButton btnBorrar = new JButton("Delete");
		btnBorrar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnBorrar.setBackground(new Color(245, 245, 220));
				try
				{

					RemovingPages.Ejecutar((int)Double.parseDouble(spinner.getValue().toString()));
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setFocusable(false);
		btnBorrar.setBounds(59, 94, 89, 23);
		getContentPane().add(btnBorrar);/*Añadir el JPanel (imagenSnake) a la ventana JFarme (snake)*/	
		
		

				spinner.setBounds(74, 28, 62, 42);
				getContentPane().add(spinner);
				
				JComponent editor = spinner.getEditor();
				JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
				spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
	}

	public static void main(String[] args)
	{
		Delete_page_Window D = new Delete_page_Window(); /*Crea la ventana*/
		D.setVisible(true);    /*Hacer visible la ventana*/   /* Para modo pantalla completa ->  D.setExtendedState(Frame.MAXIMIZED_BOTH)*/
	}
	
	/**Clase que tiene los gráficos de la serpiente, la comida, el borde y si está activada la variable desarrollador, también los de la información adicional*/
	public class ImagenSnake extends JPanel
	{
		
	}
}