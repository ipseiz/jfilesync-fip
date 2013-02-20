// JFSConfig.java

package com.fip.jfs.conf;

import java.io.File;

/**
 * Manages all configuration options of JFileSync user profile.
 *
 * @author Fabien Ipseiz
 * @version 20 févr. 2013
 */

public enum JFSUserConfig {
	INSTANCE;
	
	/** Stores the default configuration file. */
	protected static File defaultFile = new File(JFSConst.HOME_DIR
			+ File.separator + JFSConst.DEFAULT_PROFILE_FILE);
	
	/** Stores the title of the configuration. */
	protected String title;
	
	/**
	 * Sets some default values for the configuration object.
	 */
	private JFSUserConfig() {
		clean();
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
	
	/**
	 * Returns the reference of the only JFSUserConfig object. 
	 * 
	 * @return The only JFSUserConfig instance.
	 */
	public static final JFSUserConfig getInstance() {
		return JFSUserConfig.INSTANCE;
	}
}
