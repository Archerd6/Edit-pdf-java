package Edit_pdf_java;

import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class GetImages
{
	public static void main(String args[]) throws IOException
	{
		Ejecutar();
	}

	static void Ejecutar() throws IOException
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
                    int f = 0; //Folder indice
                    for(PDPage page : document.getPages())
            		{
                    	f++;
                	    String OUTPUT_PATH_PAGE_X = OUTPUT_PATH + "\\"+f;
                    	File dir1 = new File(OUTPUT_PATH_PAGE_X);
                    	dir1.mkdirs();
        				PDResources pdResources = page.getResources();
        				int i = 0;
        				for(COSName c : pdResources.getXObjectNames())
        				{
        					PDXObject o = pdResources.getXObject(c);
        					if(o instanceof PDImageXObject)
        					{
        						File filee = new File(OUTPUT_PATH_PAGE_X+"\\imagen"+i+++".png");
        						ImageIO.write(((PDImageXObject)o).getImage(), "png", filee);
        					}
        				}
            		}
                    
            		//Closing the document
            		document.close();
            	}
            }
	    }
	}
	
}