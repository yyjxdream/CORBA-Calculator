package server;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA_2_3.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import _final.Calc;
import _final.CalcHelper;

public class ServerClass {

	public static void main(String[] args) throws Exception {
		
		org.omg.CORBA.ORB orb=ORB.init(args,null);
		POA rootpoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate();
		
		servant servantImpl=new servant();
		
		Calc cal=CalcHelper.narrow(rootpoa.servant_to_reference(servantImpl));
		
		org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
		NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef); 
		//NameComponent path[]= ncRef.to_name("Cal");
		ncRef.rebind(ncRef.to_name("Cal"), cal);
		System.out.println("Server is waiting for clients connecting....");
		orb.run();
	}

}
