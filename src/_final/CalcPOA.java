package _final;


/**
* _final/CalcPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calc.idl
* Wednesday, March 16, 2016 10:42:44 AM PDT
*/

public abstract class CalcPOA extends org.omg.PortableServer.Servant
 implements _final.CalcOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("calculate", new java.lang.Integer (0));
    _methods.put ("exit", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // _final/Calc/calculate
       {
         String opcode = in.read_string ();
         int op1 = in.read_long ();
         int op2 = in.read_long ();
         int $result = (int)0;
         $result = this.calculate (opcode, op1, op2);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // _final/Calc/exit
       {
         int $result = (int)0;
         $result = this.exit ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:final/Calc:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calc _this() 
  {
    return CalcHelper.narrow(
    super._this_object());
  }

  public Calc _this(org.omg.CORBA.ORB orb) 
  {
    return CalcHelper.narrow(
    super._this_object(orb));
  }


} // class CalcPOA
