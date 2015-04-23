/*
 * @(#)AccessControlException.java	1.9 00/02/02
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
 
package java.security;

/**
 * <p> This exception is thrown by the AccessController to indicate
 * that a requested access (to a critical system resource such as the
 * file system or the network) is denied.
 *
 * <p> The reason to deny access can vary.  For example, the requested
 * permission might be of an incorrect type,  contain an invalid
 * value, or request access that is not allowed according to the
 * security policy.  Such information should be given whenever
 * possible at the time the exception is thrown.
 *
 * @version 	1.9, 02/02/00
 * @author Li Gong
 * @author Roland Schemers
 */

public class AccessControlException extends SecurityException {

    // the permission that caused the exeception to be thrown.
    private Permission perm; 

    /**
     * Constructs an <code>AccessControlException</code> with the
     * specified, detailed message. 
     *
     * @param   s   the detail message.
     */
    public AccessControlException(String s) {
        super(s);
    }

    /**
     * Constructs an <code>AccessControlException</code> with the
     * specified, detailed message, and the requested permission that caused
     * the exception. 
     *
     * @param   s   the detail message.
     * @param   p   the permission that caused the exception.
     */
    public AccessControlException(String s, Permission p) {
        super(s);
	perm = p;
    }

    /**
     * Gets the Permission object associated with this exeception, or
     * null if there was no corresponding Permission object.
     *
     * @return the Permission object.
     */
    public Permission getPermission() {
	return perm;
    }
}
