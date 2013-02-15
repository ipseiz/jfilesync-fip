// JFSSettings.java

package com.fip.jfs.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.fip.jfs.conf.JFSConst;
import com.fip.jfs.conf.JFSSettings;

/**
 * Manages all JFileSync settings needed by the GUI application. 
 * The class implements the singleton design pattern.
 *
 * @author Fabien Ipseiz
 * @version 15 févr. 2013
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
	
	Properties settings = new Properties();
	
	/**
	 * Sets some default values for the settings object and loads the settings
	 * file from the standard location.
	 */
	private JFSSettings() {
		clean();
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
	 * Stores a settings file.
	 */
	public final void store() {
		// create window MainView settings elements 
		settings.setProperty("windowX", "" +  this.getWindowX());
		settings.setProperty("windowY", "" +  this.getWindowY());
		settings.setProperty("windowWidth", "" +  this.getWindowWidth());
		//TODO see with Julien what is the best coding 
		settings.setProperty("windowHeight", String.valueOf(this.getWindowHeight()));
		try {
			FileOutputStream out = new FileOutputStream(file);
			settings.store(out, "--- configuration of the window MainView ---");
			out.close();
		} catch (IOException e) {
			//TODO management of the logs by using log4j
			System.out.println("Unable to write the settings file.");
		}
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
