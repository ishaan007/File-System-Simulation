import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
public class MemoryInitialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File file=new File("memory.txt");
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.writeChars("Location:C:\\workspaceJava\\FileSystem\n");
			fw.writeChars("Size: 2.00 MB 2,097,152 bytes\n");
			fw.writeChars("Created: ‎Today, ‎April ‎11, ‎2016\n");
			fw.writeChars("Security: Modify, Read and Execute,Read,Write\n");
			fw.writeChars("Owner:ishaan-pc-ishaan\n");
			fw.writeChars("Computer:ISHAAN-PC-(this computer)\n");
			fw.seek(8193);
			fw.writeChars("Number of Files 0");
			
			
			fw.close();
		}
		catch(IOException e)
		{
			
		}
		

	}

}
