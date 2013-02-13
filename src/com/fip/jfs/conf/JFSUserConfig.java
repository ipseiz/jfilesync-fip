// JFSConfig.java

package com.fip.jfs.conf;

/**
 * Manages all configuration options of JFileSync user profile.
 *
 * @author Fabien Ipseiz
 * @version 8 févr. 2013
 */

public enum JFSUserConfig {
	INSTANCE;
	
	
	/**
	 * Returns the reference of the only JFSUserConfig object. 
	 * 
	 * @return The only JFSUserConfig instance.
	 */
	public static final JFSUserConfig getInstance() {
		return JFSUserConfig.INSTANCE;
	}
}
