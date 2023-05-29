package Edit_pdf_java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.rendering.PDFRenderer;


public class PDFtoImg
{
	public static void main(String[] args)
	{	
		Ejecutar();
	}

	static void Ejecutar()
	{
		String INPUT_PATH = System.getProperty("user.dir") + "\\pdf_In";
	    String OUTPUT_PATH = System.getProperty("user.dir") + "\\pdf_Out";
		
	    try {
	    	
            File dir = new File(INPUT_PATH);
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
            	
                for (File child : directoryListing) {
                    String name = child.getName();
                    
                    if (name.endsWith(".pdf")) {
                    	
                        File pdf = new File(INPUT_PATH + "\\" + name);
                        PDDocument document = Loader.loadPDF(pdf);

                        Splitter splitter = new Splitter();
                        List<PDDocument> pages = splitter.split(document);

                        // Saving each page as an individual document and converting to PNG
                        int i = 1;
                        for (PDDocument page : pages) {
                            page.save(OUTPUT_PATH + "\\" + i + ".pdf");

                            PDFRenderer renderer = new PDFRenderer(page);
                            BufferedImage image = renderer.renderImageWithDPI(0, 300); // Render the first page

                            ImageIO.write(image, "PNG", new File(OUTPUT_PATH + "\\" + i + ".png"));

                            page.close();
                            i++;
                        }

                        document.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


}
