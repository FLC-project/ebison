/*
 * @(#)MetalCheckBoxIcon.java	1.13 00/02/02
 *
 * Copyright 1998-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

package javax.swing.plaf.metal;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.plaf.*;

/**
 * CheckboxIcon implementation for OrganicCheckBoxUI
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases.  The current serialization support is appropriate
 * for short term storage or RMI between applications running the same
 * version of Swing.  A future release of Swing will provide support for
 * long term persistence.
 *
 * @version 1.13 02/02/00
 * @author Steve Wilson
 */
public class MetalCheckBoxIcon implements Icon, UIResource, Serializable {

    protected int getControlSize() { return 13; }

    public void paintIcon(Component c, Graphics g, int x, int y) {

        JCheckBox cb = (JCheckBox)c;
	ButtonModel model = cb.getModel();
	int controlSize = getControlSize();

       	boolean drawCheck = model.isSelected();

	if (model.isEnabled()) {
	    if(cb.isBorderPaintedFlat()) {
		g.setColor(MetalLookAndFeel.getControlDarkShadow());
		g.drawRect(x+1, y, controlSize-1, controlSize-1);
	    }
   	    if (model.isPressed() && model.isArmed()) {
		if(cb.isBorderPaintedFlat()) {
		    g.setColor(MetalLookAndFeel.getControlShadow());
		    g.fillRect(x+2, y+1, controlSize-2, controlSize-2);
		} else {
		    g.setColor(MetalLookAndFeel.getControlShadow());
		    g.fillRect(x, y, controlSize-1, controlSize-1);
		    MetalUtils.drawPressed3DBorder(g, x, y, controlSize, controlSize);
		}
	    } else if(!cb.isBorderPaintedFlat()) {
	        MetalUtils.drawFlush3DBorder(g, x, y, controlSize, controlSize);
	    }
	    g.setColor( MetalLookAndFeel.getControlInfo() );
       	} else {
	    g.setColor( MetalLookAndFeel.getControlShadow() );
	    g.drawRect( x, y, controlSize-1, controlSize-1);
	}

	
	if(drawCheck) {
	    if (cb.isBorderPaintedFlat()) {
		x++;
	    }
	    drawCheck(c,g,x,y);
	}
    }

    protected void drawCheck(Component c, Graphics g, int x, int y) {
	int controlSize = getControlSize();
	g.fillRect( x+3, y+5, 2, controlSize-8 );
	g.drawLine( x+(controlSize-4), y+3, x+5, y+(controlSize-6) );
	g.drawLine( x+(controlSize-4), y+4, x+5, y+(controlSize-5) );
    }

    public int getIconWidth() {
        return getControlSize();
    }
       
    public int getIconHeight() {
        return getControlSize();
    }
 }
