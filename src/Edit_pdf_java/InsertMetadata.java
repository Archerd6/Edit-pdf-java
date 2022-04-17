package Edit_pdf_java;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class InsertMetadata
{

	public static void main(String[] args)
	{
		Ejecutar(null, null, null, null, null, null);
	}

	static void Ejecutar(String string, String string2, String string3, String string4, String string5, String string6)
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
						PDDocumentInformation information2 = document.getDocumentInformation();
						if(information2 != null)
	            		{
	            			document.setDocumentInformation(new PDDocumentInformation());
	            			//Saving the document
	            			document.save(OUTPUT_PATH+"\\"+name);
	            		}
	            		document.getDocumentCatalog().setMetadata(null); // Tilman Hausherr
	            		
	            		PDDocumentInformation information = new PDDocumentInformation();
	            		
	            		information.setTitle(string);
	            		information.setSubject(string2);
	            		information.setKeywords(string3);
	            		information.setAuthor(string4);
	            		information.setCreator(string5);
	            		information.setProducer(string6);
	            		information.setCreationDate(Calendar.getInstance());
	            		information.setModificationDate(Calendar.getInstance());
	            		
            			document.setDocumentInformation(information);
            			
            			//Saving the document
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
