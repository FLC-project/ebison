/*
 * @(#)AttributeValue.java	1.4 00/02/02
 *
 * Copyright 1999, 2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

package java.awt;

import sun.awt.DebugHelper;

abstract class AttributeValue {
    private final int value;
    private final String[] names;

    private static final DebugHelper dbg =
        DebugHelper.create(AttributeValue.class);

    protected AttributeValue(int value, String[] names) {
        if (dbg.on) {
	    dbg.assert(value >= 0 && names != null && value < names.length);
	}
        this.value = value;
	this.names = names;
    }
    // This hashCode is used by the sun.awt implementation as an array
    // index.
    public int hashCode() {
        return value;
    }
    public String toString() {
        return names[value];
    }
}
