package com.sun.corba.se.ActivationIDL.RepositoryPackage;

/**
* com/sun/corba/se/ActivationIDL/RepositoryPackage/ServerDefHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from ../../../../../../src/share/classes/com/sun/corba/se/ActivationIDL/activation.idl
* Monday, September 30, 2002 1:50:46 AM PDT
*/


// server program definition.  We should make this a ValueType.
public final class ServerDefHolder implements org.omg.CORBA.portable.Streamable
{
  public com.sun.corba.se.ActivationIDL.RepositoryPackage.ServerDef value = null;

  public ServerDefHolder ()
  {
  }

  public ServerDefHolder (com.sun.corba.se.ActivationIDL.RepositoryPackage.ServerDef initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.sun.corba.se.ActivationIDL.RepositoryPackage.ServerDefHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.sun.corba.se.ActivationIDL.RepositoryPackage.ServerDefHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.sun.corba.se.ActivationIDL.RepositoryPackage.ServerDefHelper.type ();
  }

}