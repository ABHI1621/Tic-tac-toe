import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
class tcpserver{
	public static void main(String args[]) throws Exception{
	String clientsentence;
	String capsen;
	ServerSocket welcomesocket= new ServerSocket(6790);
	while(true){
		Socket connectionSocket=welcomesocket.accept();
		BufferedReader infromclient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outtoclient=new DataOutputStream(connectionSocket.getOutputStream());
		clientsentence = infromclient.readLine();
		Scanner in= new Scanner(System.in);
		System.out.println("Message Received From Client: "+clientsentence);
		System.out.println("ENTER Y/N");
		char ans=in.next().charAt(0);
		if (ans=='n')
		System.exit(0);
		capsen=clientsentence.toUpperCase()+'\n';
		outtoclient.writeBytes(capsen);
		}
	}
}
