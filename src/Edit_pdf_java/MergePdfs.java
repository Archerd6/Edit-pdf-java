package Edit_pdf_java;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class MergePdfs
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
	    Comparator<File> c1 = new FileNameComparator();
	    Arrays.sort(directoryListing, c1);
	    
	    if (directoryListing != null)
	    {
	    	PDFMergerUtility pdfMerger = new PDFMergerUtility();
			pdfMerger.setDestinationFileName(OUTPUT_PATH+"\\Out.pdf");
            for (File child : directoryListing)
            {
            	String name = child.getName();
            	if (name.endsWith(".pdf"))
            	{
					try
					{
						pdfMerger.addSource(INPUT_PATH+"\\"+name);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
            	}
            }
            try
			{
				pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	    }
	}


}
