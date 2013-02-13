// JFSConst.java

package com.fip.jfs.conf;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;


/**
 * Enumeration JFSConst stores all constant variables including the possible
 * synchronization modes and the possible views onto the files. Moreover it is
 * possible to retrieve constants from a configuration properties file. 
 * Enumeration is used instead of the singleton design pattern.
 * 
 * @author Fabien Ipseiz
 * @version 6 févr. 2013
 */
public enum JFSConst {

	INSTANCE;
	
	/** Stores the class name of the used properties file. */
	private final static String CONFIG_CLASS = "com.fip.jfs.resources.conf.JFSGuiConfig";
	
	/** Stores the class name of the default used (French) bundle. */
	public static final String TRANSLATION_CLASS = "com.fip.jfs.resources.conf.JFSTranslation";
	
	/** The associated bundle to access the properties file. */
	private ResourceBundle bundle;
	
	/**
	 * Constructor:
	 * Sets some default values for the object.
	 * (General JFS properties values are stored in JFSConfig.properties file).
	 */
	private JFSConst() {
		bundle = ResourceBundle.getBundle(JFSConst.CONFIG_CLASS);
	}
	
	/** The file name of the settings file. */
	public final static String SETTINGS_FILE = "Settings.properties";
	
	/** The default location for JFS configuration files. */
	public final static String HOME_DIR = System.getProperty("user.home", ".")
			+ File.separator + ".jfs";
	
	/**
	 * The default state of the JFileSync main window (maximized, iconified,
	 * etc.).
	 */
	public final int WINDOW_STATE = JFrame.NORMAL;

	/** The default JFileSync main window position along the x axis. */
	public final int WINDOW_X = 100;

	/** The default JFileSync main window position along the y axis. */
	public final int WINDOW_Y = 100;

	/** The default JFileSync main window's width. */
	public final int WINDOW_WIDTH = 800;

	/** The default JFileSync main window's height. */
	public final int WINDOW_HEIGHT = 600;
	
	
	/**
	 * Returns the reference of the only JFSConst object. 
	 * 
	 * @return The only JFSConst instance.
	 */
	public static final JFSConst getInstance() {
		return JFSConst.INSTANCE;
	}
	
	/**
	 * Returns the string value for a certain key.
	 * 
	 * @param key
	 *            The key.
	 * @return The assigned string.
	 */
	public final String getString(String key) {
		return bundle.getString(key);
	}
	
	/**
	 * Tries to create a valid URL corresponding to a given key identifying a
	 * icon file.   
	 * 
	 * @param key
	 *            The key.
	 * @return A valid URL.
	 */
	public final URL getIconUrl(String key) {
		return getUrl(JFSConst.getInstance().getString("jfs.icon.base") + "/"
				+ bundle.getString(key));
	}

	/**
	 * Tries to create a valid URL corresponding to a given file name.
	 * 
	 * @param fileName
	 *            The file name.
	 * @return A valid URL.
	 */
	public final URL getUrl(String fileName) {
		URL fileUrl = null;

		try {
			fileUrl = ClassLoader.getSystemResource(fileName);
		} catch (Exception e) {
			//JFSLog.getErr().getStream().println(
			//		"Couldn't create URL: " + fileName);
		}

		return fileUrl;
	}
}
