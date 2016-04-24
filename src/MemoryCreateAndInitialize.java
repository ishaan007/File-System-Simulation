import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class MemoryCreateAndInitialize {
	public static final int con=2097152;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		File file=new File("memory.txt");
		boolean newFile=file.createNewFile();
		
		double i=0;
		FileWriter fw=new FileWriter(file);
		while(i<con)
		{
			fw.write('#');
			i++;
		}
		fw.flush();
		fw.close();
		}
		catch(IOException e)
		{
			
		}
	}

}