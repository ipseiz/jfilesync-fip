// JFSSettings.java

package com.fip.jfs.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fip.jfs.conf.JFSConst;
import com.fip.jfs.conf.JFSSettings;

/**
 * Manages all JFileSync settings needed by the GUI application. 
 * The class implements the singleton design pattern.
 *
 * @author Fabien Ipseiz
 * @version 17 févr. 2013
 */

public class JFSSettings {
	
	/** Stores the only instance of the class. */
	private static JFSSettings instance = null;
	
	/** The settings file containing all attribute values. */
	protected static File file = new File(JFSConst.HOME_DIR + File.separator
			+ JFSConst.SETTINGS_FILE);
	
	/** The JFileSync main window's X coordinate. */
	private int windowX;

	/** The JFileSync main window's Y coordinate. */
	private int windowY;

	/** The JFileSync main window's width. */
	private int windowWidth;

	/** The JFileSync main window's height. */
	private int windowHeight;
	
	/** SLF4J bound to logback-classic. */
	private static final Logger logger = LoggerFactory.getLogger(JFSSettings.class);
	
	Properties settings = new Properties();
	
	/**
	 * Sets some default values for the settings object and loads the settings
	 * file from the standard location.
	 */
	private JFSSettings() {
		clean();
		load();
	}
	
	/**
	 * Returns the reference of the only JFSSettings object. 
	 * 
	 * @return The only JFSSettings instance.
	 */
	public final static JFSSettings getInstance() {
		if (instance == null)
			instance = new JFSSettings();

		return instance;
	}
	
	/**
	 * Restores the default values.
	 */
	public final void clean() {
		// Restore default values:
		windowX = JFSConst.getInstance().WINDOW_X;
		windowY = JFSConst.getInstance().WINDOW_Y;
		windowWidth = JFSConst.getInstance().WINDOW_WIDTH;
		windowHeight = JFSConst.getInstance().WINDOW_HEIGHT;
	}
	
	/**
	 * loads a settings file.
	 */
	public final void load() {
		//TODO see whether following test is pertinent
		/*if (!file.exists())
			return;*/
		
		try {
			FileInputStream in = new FileInputStream(file);
			settings.load(in);
			
			// restore window MainView settings elements
			windowX=getInt(settings,"windowX",windowX);
			windowY=getInt(settings,"windowY",windowY);
			windowWidth=getInt(settings,"windowWidth",windowWidth);
			windowHeight=getInt(settings,"windowHeight",windowHeight);
			
			in.close();
		} catch (IOException e){
			logger.error("Unable to load the settings file.");
		}
	}
	
	/**
	 * Stores a settings file.
	 */
	public final void store() {
		// create window MainView settings elements 
		settings.setProperty("windowX", String.valueOf(this.getWindowX()));
		settings.setProperty("windowY", String.valueOf( this.getWindowY()));
		settings.setProperty("windowWidth", String.valueOf(this.getWindowWidth()));
		settings.setProperty("windowHeight", String.valueOf(this.getWindowHeight()));
		try {
			FileOutputStream out = new FileOutputStream(file);
			settings.store(out, "--- configuration of the JFS main window ---");
			out.close();
		} catch (IOException e) {
			logger.error("Unable to write the settings file.");
		}
	}
	
	/**
	 * Return the integer value of a stored String.
	 * 
	 * @param props
	 *            the name of the .properties file (settings file.)
	 * @param name
	 *            the key. 
	 * @param value
	 *            the default value.
	 * 
	 * @return the integer value 
	 */
	public static int getInt(Properties props, String name, int value) { 
		String v = props.getProperty(name); 
		if(v == null) {
			return value;
		}
		return Integer.parseInt(v);
	}

	/**
	 * Sets the bounds to store for the JFS main window.
	 * 
	 * @param x
	 *            X coordinate.
	 * @param y
	 *            Y coordinate.
	 * @param width
	 *            Width.
	 * @param height
	 *            Height.
	 */
	public final void setWindowBounds(int x, int y, int width, int height) {
		windowX = x;
		windowY = y;
		windowWidth = width;
		windowHeight = height;
	}

	/**
	 * Return the windowX for the JFS main window.
	 * 
	 * @return the windowX
	 */
	public final int getWindowX() {
		return windowX;
	}

	/**
	 * Return the windowY for the JFS main window.
	 * 
	 * @return the windowY 
	 */
	public final int getWindowY() {
		return windowY;
	}

	/**
	 * Return the width for the JFS main window.
	 * 
	 * @return the width 
	 */
	public final int getWindowWidth() {
		return windowWidth;
	}

	/**
	 * Return the windowHeight for the JFS main window.
	 * 
	 * @return the windowHeight 
	 */
	public final int getWindowHeight() {
		return windowHeight;
	}
	
}
