import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public class Remove_links
{
	public static void main(String args[]) throws IOException
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
            		File file = new File(INPUT_PATH+"\\"+name);
                    PDDocument document = Loader.loadPDF(file);
                    document.setAllSecurityToBeRemoved(true);
            		//Page
            		
            		for (PDPage pageX : document.getPages())
                    {
	            		List<PDAnnotation> annotations = pageX.getAnnotations();
	            		List<PDAnnotation> annotations2 = pageX.getAnnotations();
	            		for (PDAnnotation annotation : annotations)
	            		{
	            			PDAnnotation annot = annotation;
	            			if (annot instanceof PDAnnotationLink)
	            			{
	            				PDAnnotationLink link = (PDAnnotationLink) annot;
	            				PDAction action = link.getAction();
	            				if(action instanceof PDActionURI)
	            				{
	//            					PDActionURI uri = (PDActionURI) action;
	//            					if("https:uma.es".equals(uri.getURI()));
	//            					{
	//            						annotations.remove(link);
	//            						break;
	//            					}
	            					annotations2.remove(link);
	            				}
	            			}
	            		}
	            		pageX.setAnnotations(annotations2);
                    }
            		//Saving the document
            		document.save(OUTPUT_PATH+"\\"+name);
            		
            		//Closing the document
            		document.close();
            	}
            }
	    }
	}
	
}
