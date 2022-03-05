import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator<File>
{

	@Override
	public int compare(File o1, File o2)
	{
		String a1 = o1.getName();
		a1 = a1.substring(0,a1.lastIndexOf('.'));
		
		String a2 = o2.getName();
		a2 = a2.substring(0,a2.lastIndexOf('.'));
		
		int n1 = Integer.parseInt(a1);
		int n2 = Integer.parseInt(a2);
		
		int n3 = Integer.compare(n1, n2);
		
		return n3;
	}

}
