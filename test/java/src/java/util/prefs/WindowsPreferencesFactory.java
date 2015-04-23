/*
 * @(#)WindowsPreferencesFactory.java	1.5 01/12/03
 *
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.util.prefs;

/**
 * Implementation of  <tt>PreferencesFactory</tt> to return 
 * WindowsPreferences objects.
 *
 * @author  Konstantin Kladko
 * @version 1.5, 12/03/01
 * @see Preferences
 * @see WindowsPreferences
 * @since 1.4
 */
class WindowsPreferencesFactory implements PreferencesFactory  {
    
    /**
     * Returns WindowsPreferences.userRoot
     */
    public Preferences userRoot() {
        return WindowsPreferences.userRoot;
    }
    
    /**
     * Returns WindowsPreferences.systemRoot
     */
    public Preferences systemRoot() {
        return WindowsPreferences.systemRoot;
    }
}
