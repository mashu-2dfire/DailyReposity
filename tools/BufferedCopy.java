import java.io.*;
class  BufferedCopy
{
	public static void main(String[] args)throws IOException 
	{
		BufferedWriter bw=null;
		BufferedReader br=null;
		bw=new BufferedWriter(new FileWriter("bufferedcopy.txt"));
		br=new BufferedReader(new FileReader("bufferedCopy.txt"));
		String str=null;
		while ((str=br.readLine())!=null)
		{
			bw.write(str);
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
