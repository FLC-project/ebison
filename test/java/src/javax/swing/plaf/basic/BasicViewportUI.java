/*
 * @(#)BasicViewportUI.java	1.5 00/02/02
 *
 * Copyright 1998-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

package javax.swing.plaf.basic;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;


/**
 * BasicViewport implementation
 *
 * @version 1.1 05/01/98
 * @author Rich Schiavi
 */
public class BasicViewportUI extends ViewportUI {

    // Shared UI object
    private static ViewportUI viewportUI;

    public static ComponentUI createUI(JComponent c) {
	if(viewportUI == null) {
            viewportUI = new BasicViewportUI();
	}
        return viewportUI;
    }

    public void installUI(JComponent c) {
        super.installUI(c);
        installDefaults(c);
    }

    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);

    }

    protected void installDefaults(JComponent c) {
        LookAndFeel.installColorsAndFont(c,
					 "Viewport.background",
					 "Viewport.foreground",
					 "Viewport.font");
    }

    protected void uninstallDefaults(JComponent c) {
    }
}
