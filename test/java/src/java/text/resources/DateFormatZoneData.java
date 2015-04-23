/*
 * @(#)DateFormatZoneData.java	1.14 00/01/19
 *
 * Copyright 1996-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 * The original version of this source code and documentation
 * is copyrighted and owned by Taligent, Inc., a wholly-owned
 * subsidiary of IBM. These materials are provided under terms
 * of a License Agreement between Taligent and Sun. This technology
 * is protected by multiple US and International patents.
 *
 * This notice and attribution to Taligent may not be removed.
 * Taligent is a registered trademark of Taligent, Inc.
 *
 */

package java.text.resources;

import java.util.ResourceBundle;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Supplement package private date-time formatting zone data for DateFormat.
 * DateFormatData used in DateFormat will be initialized by loading the data
 * from LocaleElements and DateFormatZoneData resources. The zone data are
 * represented with the following form:
 * {ID, new String[] {ID, long zone string, short zone string, long daylight 
 * string, short daylight string, representative city of zone}}, where ID is
 * NOT localized, but is used to look up the localized timezone data
 * internally. Localizers can localize any zone strings except
 * for the ID of the timezone.
 * Also, localizer should not touch "localPatternChars" entry.
 *
 * The <CODE>DateFormatZoneData</CODE> bundles of all locales must extend
 * this base class. This class implements similar to 
 * <CODE>ListResourceBundle</CODE>, except that it preserves the order of 
 * the keys that it obtained from <CODE>getContents</CODE> and return through
 * <CODE>getKeys</CODE>. As in <CODE>ListResourceBundle</CODE>,
 * <CODE>getKeys</CODE> appends keys from the parent bundle's
 * <CODE>getKeys</CODE> to this bundle's keys unless they duplicate
 * one of this bundle's keys.
 *
 * @see          ListResourceBundle
 * @see          Format
 * @see          DateFormatData
 * @see          LocaleElements
 * @see          SimpleDateFormat
 * @see          TimeZone
 * @version      1.14 01/19/00
 * @author       Chen-Lieh Huang
 */
//  ROOT DateFormatZoneData
//
public class DateFormatZoneData extends ResourceBundle
{

    /**
     * Override ResourceBundle. Same semantics.
     */
    public Object handleGetObject(String key) {
	if (lookup == null || keys == null) {
	    loadLookup();
	}
	return lookup.get(key);
    }

    /**
     * Implmentation of ResourceBundle.getKeys. Unlike the implementation in
     * <CODE>ListResourceBundle</CODE>, this implementation preserves 
     * the order of keys obtained from <CODE>getContents</CODE>.
     */
    public Enumeration getKeys() {
	if (lookup == null || keys == null) {
	    loadLookup();
	}
	Enumeration result = null;
	if (parent != null) {
	    final Enumeration myKeys = keys.elements();
	    final Enumeration parentKeys = parent.getKeys();
	    
            result = new Enumeration() {
                public boolean hasMoreElements() {
                    if (temp == null) {
                        nextElement();
		    }
                    return (temp != null);
                }

                public Object nextElement() {
                    Object returnVal = temp;
                    if (myKeys.hasMoreElements()) {
                        temp = myKeys.nextElement();
                    } else {
                        temp = null;
                        while ((temp == null) && (parentKeys.hasMoreElements())) {
                            temp = parentKeys.nextElement();
                            if (lookup.containsKey(temp))
                                temp = null;
                        }
                    }
                    return returnVal;
                }
                Object temp = null;
            };
        } else {
            result = keys.elements();
        }
        return result;
    }

    /**
     * Create hashtable and key vector while loading resources.
     */
    private synchronized void loadLookup() {
	Object[][] contents = getContents();
	Hashtable temp = new Hashtable(contents.length);
	Vector tempVec = new Vector(contents.length);
        for (int i = 0; i < contents.length; ++i) {
            temp.put(contents[i][0],contents[i][1]);
	    tempVec.add(contents[i][0]);
        }
        lookup = temp;
	keys = tempVec;
    }

    Hashtable lookup = null;
    Vector keys = null;

    /**
     * Overrides ListResourceBundle
     */
    public Object[][] getContents() {
        return new Object[][] {
	    {"PST", new String[] {"PST", "Pacific Standard Time", "PST",
	        "Pacific Daylight Time", "PDT", "San Francisco"}},
	    {"MST", new String[] {"MST", "Mountain Standard Time", "MST",
		"Mountain Daylight Time", "MDT", "Denver"}},
	    {"CST", new String[] {"CST", "Central Standard Time", "CST",
		"Central Daylight Time", "CDT", "Chicago"}},
	    {"EST", new String[] {"EST", "Eastern Standard Time", "EST",
		"Eastern Daylight Time", "EDT", "New York"}},
	    // Copied from DateFormatZoneData_en
	    {"America/Los_Angeles", new String[] {"America/Los_Angeles", "Pacific Standard Time", "PST",
		"Pacific Daylight Time", "PDT" /*San Francisco*/}},
	    {"America/Denver", new String[] {"America/Denver", "Mountain Standard Time", "MST",
		"Mountain Daylight Time", "MDT" /*Denver*/}},
	    {"America/Phoenix", new String[] {"America/Phoenix", "Mountain Standard Time", "MST",
		"Mountain Standard Time", "MST" /*Phoenix*/}},
	    {"America/Chicago", new String[] {"America/Chicago", "Central Standard Time", "CST",
		"Central Daylight Time", "CDT" /*Chicago*/}},
	    {"America/New_York", new String[] {"America/New_York", "Eastern Standard Time", "EST",
		"Eastern Daylight Time", "EDT" /*New York*/}},
	    {"America/Indianapolis", new String[] {"America/Indianapolis", "Eastern Standard Time", "EST",
		"Eastern Standard Time", "EST" /*Indianapolis*/}},
	    {"Pacific/Honolulu", new String[] {"Pacific/Honolulu", "Hawaii Standard Time", "HST",
		"Hawaii Standard Time", "HST" /*Honolulu*/}},
	    {"America/Anchorage", new String[] {"America/Anchorage", "Alaska Standard Time", "AKST",
		"Alaska Daylight Time", "AKDT" /*Anchorage*/}},
	    {"America/Halifax", new String[] {"America/Halifax", "Atlantic Standard Time", "AST",
		"Atlantic Daylight Time", "ADT" /*Halifax*/}},
	    {"Europe/Paris", new String[] {"Europe/Paris", "Central European Standard Time", "CET",
		"Central European Daylight Time", "CEST" /*Paris*/}},
	    {"GMT", new String[] {"GMT", "Greenwich Mean Time", "GMT",
		"Greenwich Mean Time", "GMT" /*Reykjavik*/}},
	    {"Asia/Jerusalem", new String[] {"Asia/Jerusalem", "Israel Standard Time", "IST",
		"Israel Daylight Time", "IDT" /*Tel Aviv*/}},
	    {"Asia/Tokyo", new String[] {"Asia/Tokyo", "Japan Standard Time", "JST",
		"Japan Standard Time", "JST" /*Tokyo*/}},
	    {"Europe/Bucharest", new String[] {"Europe/Bucharest", "Eastern European Standard Time",
		"EET", "Eastern European Daylight Time", "EEST" /*Bucharest*/}},
	    {"Asia/Shanghai", new String[] {"Asia/Shanghai", "China Standard Time", "CST",
		"China Standard Time", "CDT" /*Peking*/}},
            {"localPatternChars", "GyMdkHmsSEDFwWahKz"},
        };
    }
}
