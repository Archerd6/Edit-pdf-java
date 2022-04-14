package Edit_pdf_java;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class RemovingPages
{
	public static void main(String args[]) throws IOException
	{
		int pagina = Integer.parseInt(args[0]);
		Ejecutar(pagina);
	}

	static void Ejecutar(int pagina) throws IOException
	{
		String INPUT_PATH = System.getProperty("user.dir") + "\\pdf_In";
	    String OUTPUT_PATH = System.getProperty("user.dir") + "\\pdf_Out";
		
	    //Loading existing documents
	    File dir = new File(INPUT_PATH);
	    dir.mkdirs();
	    File dirOut = new File(OUTPUT_PATH);
	    dirOut.mkdirs();
	    
	    File[] directoryListing = dir.listFiles();
	    if (directoryListing != null)
	    {
            for (File child : directoryListing)
            {
            	String name = child.getName();
            	if (name.endsWith(".pdf"))
            	{
            		File file = new File(INPUT_PATH+"\\"+name);
                    PDDocument document = Loader.loadPDF(file);
                    
            		//Listing the number of existing pages
            		int noOfPages = document.getNumberOfPages();
            		System.out.println("Número de paginas: "+noOfPages);
            		
            		//Removing the pages
            		document.removePage(pagina-1); // BORRA LA PAGUINA args[0]
            		System.out.println("Pagina borrada, ahora quedan: "+document.getNumberOfPages());
            		
            		//Saving the document
            		document.save(OUTPUT_PATH+"\\"+name);
            		
            		//Closing the document
            		document.close();
            	}
            }
	    }
		
	}
}
