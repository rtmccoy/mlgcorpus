import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class lowercaser
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File fl = new File("mlg.t2s.train.justeng.filtered.parsed");
		Scanner sc = new Scanner(fl);
		PrintWriter pw = new PrintWriter("mlg.t2s.train.justeng.filtered.parsed.lowercased");
		String thisLine = "";
		char thisChar = ' ';		
		boolean hasPrinted = false;
		int thisIndex = 0;
		char nextChar = ' ';
		String formattedLine = "";

		while(sc.hasNext())
		{
			
			thisLine = sc.nextLine();
			formattedLine = "";

			//System.out.println("Hi there!");

			for(int i = 0; i < thisLine.length(); i++)
			{
				hasPrinted = false;
				thisChar = thisLine.charAt(i);
				if(!Character.isLetter(thisChar))
					formattedLine += thisChar;
				else if(Character.isLowerCase(thisChar))
					formattedLine += thisChar;
				else
				{
					thisIndex = i;

					while(!hasPrinted)
					{
						nextChar = thisLine.charAt(thisIndex + 1);
						if(nextChar == ' ')
						{
							formattedLine += thisChar;
							hasPrinted = true;
						}
						else if(nextChar == ')')
						{
							formattedLine += Character.toLowerCase(thisChar);
							hasPrinted = true;
						}
						thisIndex++;
					}
				}
			}

			formattedLine = formattedLine.replaceAll("-lrb-", "-LRB-");
			formattedLine = formattedLine.replaceAll("-rrb-", "-RRB-");
			formattedLine = formattedLine.replaceAll("-lcb-", "-LCB-");
			formattedLine = formattedLine.replaceAll("-rcb-", "-RCB-");
			formattedLine = formattedLine.replaceAll("-lsb-", "-LSB-");
			formattedLine = formattedLine.replaceAll("-rsb-", "-RSB-");
			
			//formattedLine = formattedLine.replaceAll("e", "Q");


			pw.println(formattedLine);

	
		}
		
		pw.close();
	}

	
}	 
