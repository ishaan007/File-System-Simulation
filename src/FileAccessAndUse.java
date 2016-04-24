import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
public class FileAccessAndUse {
	
	public static void bootSector(File file)
	{
		try
		{
		RandomAccessFile fw = new RandomAccessFile (file, "rws");
		fw.seek(0);
		int i=0;
		while(i<8192)
		{
			char justRead=fw.readChar();
			if(justRead=='#')
			{
				break;
			}
			System.out.print(justRead);
			i++;
		}
		}
		catch(IOException e)
		{
		}
		}
	public static void createFile(File file,String fileName) throws MemoryOverFlowException
	{
		try
		{
		RandomAccessFile fw = new RandomAccessFile (file, "rws");
		fw.seek(8225);
		char rd=fw.readChar();
		fw.seek(8225);
		int numFiles=(int)(rd)-48;
		//System.out.println(numFiles);
		
		if(numFiles==4)
		{
			System.out.println("Number of files Exceeded memory limit ");
			throw new MemoryOverFlowException();
		}
		fw.writeChar(rd+1);
		fw.seek(8225+numFiles*100+2);
		fw.writeChars(fileName);
		fw.seek(8225+numFiles*100+2);
		//System.out.println(fw.readChar());
		//System.out.println(fw.readChar());
		
		
		}
		catch(IOException e)
		{
			
		}
		
	}
	public static void writeData(File file,String data,String fileName)
	{//8625
		// start from 262144
		//each sec
		System.out.println("enterd write");
		try
		{
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.seek(8225);
			char rd=fw.readChar();
			int numFiles=(int)(rd)-48;
			//System.out.println(numFiles);
			int FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				fw.readChar();
				String tmp="";
				char t=fw.readChar();
				tmp=t+"";
				
				while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
				{
					//System.out.println(t);
					t=fw.readChar();
					tmp=tmp+t;
				}
				//System.out.println("exited while");
				//System.out.println(tmp);
				//System.out.println(fileName);
				if(tmp.substring(0, tmp.length()-1).equals(fileName))
				{
					FileNum=i;
					break;
				}
				
				
			}
			if(FileNum==-1)
			{
				System.out.println("No Such File Exists on the drive");
				return;
			}
			//fw.seek(262144+i*100000);
			fw.seek(262144+FileNum*100000);
			//RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.writeChars(data);
			
			
		}
		catch(IOException e)
		{
			
		}
	}
	public static void readData(File file,String fileName)
	{//8625
		// start from 262144
		//each sec
		System.out.println("entered read");
		try
		{
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.seek(8225);
			char rd=fw.readChar();
			int numFiles=(int)(rd)-48;
			int FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				String tmp="";
				fw.readChar();
				char t=fw.readChar();
				tmp=t+"";
				
				while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
				{
					
					t=fw.readChar();
					//System.out.println(t);
					tmp=tmp+t;
				}
				if(tmp.substring(0, tmp.length()-1).equals(fileName))
				{
					FileNum=i;
					break;
				}
				
				
			}
			if(FileNum==-1)
			{
				System.out.println("No Such File Exists on the drive");
				return ;
			}
			fw.seek(262144+FileNum*100000);
			char t=fw.readChar();
			//System.out.println(t);
			String tm=""+t;
			while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z')||t=='\n')
			{
				t=fw.readChar();
				tm=tm+t;
				//System.out.println(t);

			}
			//System.out.println("entered read");
			System.out.println(tm);	
			
		}
		catch(IOException e)
		{
			
		}
	}
	public static void editData(File file,String newData,String fileName)
	{//8625
		// start from 262144
		//each sec
		try
		{
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.seek(8225);
			char rd=fw.readChar();
			int numFiles=(int)(rd)-48;
			int FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				String tmp="";
				fw.readChar();
				char t=fw.readChar();
				tmp=t+"";
				
				while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
				{
					
					t=fw.readChar();
					//System.out.println(t);
					tmp=tmp+t;
				}
				if(tmp.substring(0, tmp.length()-1).equals(fileName))
				{
					FileNum=i;
					break;
				}
				
				
			}
			if(FileNum==-1)
			{
				System.out.println("No Such File Exists on the drive");
				return;
			}
			
			fw.seek(262144+FileNum*100000);
			//RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.writeChars(newData);
			for(int i=0;i<100;i++)
			{
				fw.writeChars("#");
			}
			
			
		}
		catch(IOException e)
		{
			
		}
	}
	public static void copyFile(File file,String from,String to)
	{
		System.out.println("entered copy");
		try
		{
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.seek(8225);
			char rd=fw.readChar();
			int numFiles=(int)(rd)-48;
			int FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				String tmp="";
				fw.readChar();
				char t=fw.readChar();
				tmp=t+"";
				
				while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
				{
					
					t=fw.readChar();
					//System.out.println(t);
					tmp=tmp+t;
				}
				if(tmp.substring(0, tmp.length()-1).equals(from))
				{
					FileNum=i;
					break;
				}
				
				
			}
			if(FileNum==-1)
			{
				System.out.println("No Such Source File Exists on the drive");
				return ;
			}
			fw.seek(262144+FileNum*100000);
			char t=fw.readChar();
			//System.out.println(t);
			String tm=""+t;
			while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z')||t=='\n')
			{
				t=fw.readChar();
				tm=tm+t;
				//System.out.println(t);

			}	
			
			//
			//
			fw.seek(8225);
			 rd=fw.readChar();
			 numFiles=(int)(rd)-48;
			//System.out.println(numFiles);
			 FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				fw.readChar();
				String tmp="";
				char t1=fw.readChar();
				tmp=t1+"";
				
				while((t1 >= 'a' && t1 <= 'z') || (t1 >= 'A' && t1 <= 'Z'))
				{
					//System.out.println(t1);
					t1=fw.readChar();
					tmp=tmp+t1;
				}
				//System.out.println("exited while");
				//System.out.println(tmp);
				//System.out.println(fileName);
				if(tmp.substring(0, tmp.length()-1).equals(to))
				{
					FileNum=i;
					break;
				}
				
				
			}
			if(FileNum==-1)
			{
				System.out.println("No Such Destination File Exists on the drive");
				return;
			}
			//fw.seek(262144+i*100000);
			fw.seek(262144+FileNum*100000);
			//RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.writeChars(tm);
			
		}
		catch(IOException e)
		{
			
		}

	}
	public static void reNameFile(File file,String current,String newName)
	{
		//System.out.println("enter reName");
		try
		{
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.seek(8225);
			char rd=fw.readChar();
			int numFiles=(int)(rd)-48;
			int FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				String tmp="";
				fw.readChar();
				char t=fw.readChar();
				tmp=t+"";

				
				while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
				{
					
					t=fw.readChar();
					//System.out.println(t);
					tmp=tmp+t;
					
				}
				if(tmp.substring(0, tmp.length()-1).equals(current))
				{
					FileNum=i;
					fw.seek(8225+FileNum*100+2);
					fw.writeChars(newName);
					for(int j=0;j<100;j++)
					{
						fw.writeChars("#");
					}
					break;
				}
			}
			if(FileNum==-1)
			{
				System.out.println("No Such File Exists on the drive.No Rename Possible");
				return ;
			}
			
		}
		catch(IOException e)
		{
			
		}
	}
	public static void deleteFile(File file,String fileName)
	{
		
		//System.out.println("entered delete");
		try
		{
			RandomAccessFile fw = new RandomAccessFile (file, "rws");
			fw.seek(8225);
			char rd=fw.readChar();
			int numFiles=(int)(rd)-48;
			if(numFiles==0)
			{
				System.out.println("Can not delete the file no file on the block");
				return;
			}
			int FileNum=-1;
			for(int i=0;i<numFiles;i++)
			{
				

				fw.seek(8225+i*100);
				String tmp="";
				fw.readChar();
				char t=fw.readChar();
				tmp=t+"";
				
				while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z'))
				{
					
					t=fw.readChar();
					//System.out.println(t);
					tmp=tmp+t;
				}
				if(tmp.substring(0, tmp.length()-1).equals(fileName))
				{
					FileNum=i;
					break;
				}
				
				
			}
			if(FileNum==-1)
			{
				System.out.println("No Such File Exists on the drive");
				return ;
			}
			// delete file name
			int counter1=1;
			fw.seek(8225+FileNum*100);
			String tm="";
			fw.readChar();
			char t3=fw.readChar();
			tm=t3+"";
			
			while((t3 >= 'a' && t3 <= 'z') || (t3 >= 'A' && t3 <= 'Z'))
			{
				
				t3=fw.readChar();
				//System.out.println(t3);
				tm=tm+t3;
				counter1++;
			}
			fw.seek(8225+FileNum*100);
			String tempStr="";
			int m=0;
			while(m<counter1)
			{
				tempStr=tempStr+"#";
				m++;
			}
			
					
			fw.writeChars(tempStr);
			
			
			
			
			fw.seek(262144+FileNum*100000);
			char t=fw.readChar();
			//System.out.println(t);
			String tm1=""+t;
			int counter=0;
			while((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z')||t=='\n')
			{
				t=fw.readChar();
				tm1=tm1+t;
				//System.out.println(t);
				counter++;

			}
			//delete file data
			fw.seek(262144+FileNum*100000);
			int k=0;
			String strin="";
			while(k<counter)
			{
				strin=strin+"#";
				k++;
			}
			fw.writeChars(strin);
			//change file number
			fw.seek(8225);
			char rd1=fw.readChar();
			fw.seek(8225);
			//System.out.println(numFiles);
			fw.writeChar(rd1-1);
			
				
			
		}
		catch(IOException e)
		{
			
		}
	}
	public static void fetchMeta(File file)
	{
		System.out.println("Boot Sector size 8kb");
		System.out.println("Meta Data size 100 bytes per file");
		System.out.println("Cluster size 100000 bytes per file");
		System.out.println("Maximum number of clusters 4");
		bootSector(file);
	}
	
	public static void main(String[] args) throws MemoryOverFlowException {
		// TODO Auto-generated method stub
		File file=new File("memory.txt");
		fetchMeta(file);
		createFile(file, "svsv");
		writeData(file,"algorithmsisfunitisawesome", "svsv");
		readData(file,"svsv");
		createFile(file, "abcd");
		writeData(file,"acnvjfbvhfd", "abcd");
		readData(file,"abcd");
		editData(file, "sorrybutilovealgorithmsunderstood","svsv");
		readData(file,"svsv");
		copyFile(file, "svsv", "abcd");
		readData(file,"abcd");
		reNameFile(file, "abcd", "dcba");
		readData(file,"dcba");
		deleteFile(file, "dcba");
		readData(file,"dcba");
		//copyFile(file, from, to);
		
	}
}
