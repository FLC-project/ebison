/*
 * @(#)DynFixed.java	1.9 00/02/02
 *
 * Copyright 1998-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */


package org.omg.CORBA;

/**
 *  Represents a <code>DynAny</code> object that is associated
 *  with an IDL fixed type.
 */

public interface DynFixed extends org.omg.CORBA.Object, org.omg.CORBA.DynAny
{
    /**
     * Returns the value of the fixed type represented in this
     * <code>DynFixed</code> object.
     *
     * @return the value as a byte array
	 * @see #set_value
     */
    public byte[] get_value();

    /**
     * Sets the given fixed type instance as the value for this 
     * <code>DynFixed</code> object.
     *
     * @param val the value of the fixed type as a byte array
	 * @throws org.omg.CORBA.DynAnyPackage.InvalidValue if the given
	 *         argument is bad
	 * @see #get_value
     */
    public void set_value(byte[] val)
        throws org.omg.CORBA.DynAnyPackage.InvalidValue;
}
