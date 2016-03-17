package client;

import java.util.Scanner;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA_2_3.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import _final.Calc;
import _final.CalcHelper;

public class ClientClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb=ORB.init(args,null);
		org.omg.CORBA.Object ojbRef=orb.resolve_initial_references("NameService");
		NamingContextExt ncRef=NamingContextExtHelper.narrow(ojbRef);
		Calc cal=CalcHelper.narrow(ncRef.resolve_str("Cal"));
		
		String line="";
		String op[];
		String opcode="";
		int op1,op2;
		System.out.println("Basic Calculator,Please insert the correct format,eg,+ 2 2,'exit' to leave...");
		Scanner s=new Scanner(System.in);
		while(true)
		{
			System.out.print("Client:");
			line =s.nextLine();
			if(line.equals("exit"))
			{
				System.out.println("Server:"+"I'm out!");
				break;
			}
			
			op=line.split(" ");
			opcode=op[0];
			op1=Integer.valueOf(op[1]);
			op2=Integer.valueOf(op[2]);
			int result=cal.calculate(opcode, op1, op2);
			System.out.println("result:"+result);
		}
		
	}

}
