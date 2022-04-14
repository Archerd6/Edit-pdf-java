package Edit_pdf_java;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitPdf
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
	            		
						Splitter splitter = new Splitter();
						List<PDDocument> Pages = splitter.split(document);
						Iterator<PDDocument> iterator = Pages.listIterator();
						
						//Saving each page as an individual document
						int i = 1;
						while(iterator.hasNext())
						{
							PDDocument pd = iterator.next();
							pd.save(OUTPUT_PATH+"\\"+ i++ +".pdf");
						}
						System.out.println("Multiple pdf's created");
						
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
