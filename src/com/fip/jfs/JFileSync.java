// JFileSync.java

package com.fip.jfs;

import java.awt.EventQueue;
import java.io.PrintStream;

import com.fip.jfs.conf.JFSConfig;
import com.fip.jfs.conf.JFSSettings;
import com.fip.jfs.conf.JFSTextTranslation;

import com.fip.jfs.gui.JFSMainView;

/**
 * JFileSync is an application for synchronizing pairs of directories. 
 * This class is the main class of the application. It processes a Java Swing-based graphical user
 * interface.
 *
 * @author Fabien Ipseiz
 * @version 9 févr. 2013
 */
public class JFileSync {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Get settings for the first time in order to load stored
		// settings before doing any actions:
		//JFSSettings s = JFSSettings.getInstance();

		// Get translation and configuration object:
		//JFSTextTranslation t = JFSTextTranslation.getInstance();
		//JFSConfig config = JFSConfig.getInstance();
		//PrintStream p = JFSLog.getOut().getStream();

		// Clean config before starting (if main method is used as service):
		//config.clean();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Determine whether the last configuration when stored when
					// the program has exited should be loaded at GUI startup:
					JFSMainView frame = new JFSMainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
