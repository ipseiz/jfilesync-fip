// JFSConfig.java

package com.fip.jfs.conf;


/**
 * Manages all configuration options of JFileSync user profile.
 * The class implements the singleton design pattern.
 *
 * @author Fabien Ipseiz
 * @version 10 févr. 2013
 */

public class JFSConfig {

	/** Stores the only instance of the class. */
	private static JFSConfig instance = null;

	/** Stores the title of the configuration. */
	protected String title;
	
	/**
	 * Sets some default values for the configuration object.
	 */
	private JFSConfig() {
		clean();
	}
	
	/**
	 * Returns the reference of the only object of the class.
	 * 
	 * @return The only instance.
	 */
	public static JFSConfig getInstance() {
		if (instance == null)
			instance = new JFSConfig();

		return instance;
	}
	
	/**
	 * Restores the default values, but keeps all registered observers.
	 */
	public final void clean() {
		// Basic settings:
		title = JFSTextTranslation.getInstance().get("profile.defaultTitle");
		
	}
	
	/**
	 * Returns the name of the configuration.
	 * 
	 * @return Title.
	 */
	public final String getTitle() {
		return title;
	}
	
}
