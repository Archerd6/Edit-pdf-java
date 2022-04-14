package Edit_pdf_java;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class RemoveMetadata
{

	public static void main(String[] args)
	{
		Ejecutar();
	}

	static void Ejecutar()
	{
		String INPUT_PATH = System.getProperty("user.dir") + "\\pdf_In";
	    String OUTPUT_PATH = System.getProperty("user.dir") + "\\pdf_Out";
		
	    //Loading existing documents
	    File dir = new File(INPUT_PATH);
	    File[] directoryListing = dir.listFiles();
	    if (directoryListing != null)
	    {
            for (File child : directoryListing)
            {
            	String name = child.getName();
            	if (name.endsWith(".pdf"))
            	{
            		File pdf = new File(INPUT_PATH+"\\"+name);
                    PDDocument document;
					try
					{
						document = Loader.loadPDF(pdf);
						document.setAllSecurityToBeRemoved(true);
	            		PDDocumentInformation information = document.getDocumentInformation();
	            		if(information != null)
	            		{
	            			document.setDocumentInformation(new PDDocumentInformation());
	            			//Saving the document
	            			document.save(OUTPUT_PATH+"\\"+name);
	            		}
	            		document.getDocumentCatalog().setMetadata(null); // Tilman Hausherr 
	            		document.save(OUTPUT_PATH+"\\"+name);
	            		//Closing the document
	            		document.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
            	}
            }
	    }
	    
	}
	
	
}
