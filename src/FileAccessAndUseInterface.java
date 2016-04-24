import java.io.File;
import java.util.Scanner;


public class FileAccessAndUseInterface extends FileAccessAndUse {
	static Scanner s=new Scanner(System.in);
	public static boolean checkIfInputValid(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			String tmp=s.substring(i, i+1);
			char t=tmp.charAt(0);
			if((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
			{
				
			}
			else
			{
				System.out.println("Sorry "+t+" is not a valid character");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws MemoryOverFlowException {
		// TODO Auto-generated method stub
		File file=new File("memory.txt");
		System.out.println("User@FileSystem");
		System.out.println("User Instructions");
		System.out.println("type CREATE to create a file");
		System.out.println("type READ to read a file");
		System.out.println("type WRITE to write to a file");
		System.out.println("type COPY to copy to a file");
		System.out.println("type RENAME to rename a file");
		System.out.println("type DELETE to delete a file");
		System.out.println("type META to fetch meta data of a file");
		System.out.println("type EXIT to shut down the file system");
		String userInput=s.next();
		while(!userInput.equals("EXIT"))
		{
			if(userInput.equals("CREATE"))
			{
				// create file
				System.out.println("enter the file name");
				String fileName=s.next();
				if(checkIfInputValid(fileName))
				{
					createFile(file, fileName);
				}
				
				
			}
			if(userInput.equals("READ"))
			{
				// read file
				System.out.println("enter the file name");
				String fileName=s.next();
				if(checkIfInputValid(fileName))
				{
					readData(file, fileName);
				}
				
				
			}
			if(userInput.equals("WRITE"))
			{
				// write to a file
				System.out.println("enter the file name");
				String fileName=s.next();
				if(checkIfInputValid(fileName))
				{

					System.out.println("enter the data to be entered");
					String data=s.next();
					if(checkIfInputValid(data))
					{
						writeData(file, data, fileName);
					}
				}	
			}
			if(userInput.equals("COPY"))
			{
				// copy to a file
				System.out.println("enter the source file name");
				String from=s.next();
				if(checkIfInputValid(from))
				{

					System.out.println("enter the destination file name");
					String to=s.next();
					if(checkIfInputValid(to))
					{
						copyFile(file, from, to);
					}
				}	
			}
			if(userInput.equals("RENAME"))
			{
				// rename a file
				System.out.println("enter the file name");
				String fileName=s.next();
				if(checkIfInputValid(fileName))
				{

					System.out.println("enter the new name ");
					String newName=s.next();
					if(checkIfInputValid(newName))
					{
						reNameFile(file, fileName, newName);
					}
				}	
			}
			if(userInput.equals("DELETE"))
			{
				// delete file
				System.out.println("enter the file name");
				String fileName=s.next();
				if(checkIfInputValid(fileName))
				{
					deleteFile(file, fileName);
				}
				
				
			}
			if(userInput.equals("EDIT"))
			{
				// EDIT a file
				System.out.println("enter the file name");
				String fileName=s.next();
				if(checkIfInputValid(fileName))
				{

					System.out.println("enter the data to be entered");
					String data=s.next();
					if(checkIfInputValid(data))
					{
						editData(file, data, fileName);
					}
				}	
			}
			if(userInput.equals("META"))
			{
				// fetch meta
				fetchMeta(file);	
			}
			System.out.println("User@FileSystem");
			System.out.println("User Instructions");
			System.out.println("type CREATE to create a file");
			System.out.println("type READ to read a file");
			System.out.println("type WRITE to write to a file");
			System.out.println("type COPY to copy to a file");
			System.out.println("type RENAME to rename a file");
			System.out.println("type DELETE to delete a file");
			System.out.println("type META to fetch meta data of a file");
			System.out.println("type EXIT to shut down the file system");
			
			userInput=s.next();
		}
		System.out.println("System is turning off your data is secure");
		

	}

}
