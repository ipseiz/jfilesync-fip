// JFSConfigFileFilter.java
package com.fip.jfs.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;
//import com.fip.jfs.conf.JFSText;

/**
 * This class is used in order to filter the list of files shown in the
 * JFileChooser object.
 *
 * @author Fabien Ipseiz
 * @version 5 févr. 2013
 */

public class JFSConfigFileFilter extends FileFilter {
	
	/** All allowed extensions: */
	private static final String[] ALLOWED_EXTENSIONS = { "xml", "conf", "jfs" };

	/**
	 * Determines whether the given file is accepted by the filter.
	 * 
	 * @param file
	 *            A file in the list of the file chooser.
	 * @return True if and only if the file is accepted.
	 */
	public boolean accept(File file) {
		if (file != null) {
			// Show file if it is a directory:
			if (file.isDirectory())
				return true;

			// Determine extension of the file:
			String filename = file.getName();
			String extension = "";
			int index = filename.lastIndexOf('.');

			if ((index > 0) && (index < (filename.length() - 1)))
				extension = filename.substring(index + 1).toLowerCase();

			for (String s : ALLOWED_EXTENSIONS)
				if (extension.equals(s))
					return true;
		}

		return false;
	}

	/**
	 * The description of this filter.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		return "JFS profiles files";
		//	return JFSText.getInstance().get("profile.configFiles");
	}

	/**
	 * Returns the allowed extensions.
	 * 
	 * @return The allowed extensions.
	 */
	public String[] getFilterExtensions() {
		String[] extensions = new String[ALLOWED_EXTENSIONS.length];
		for (int i = 0; i < extensions.length; i++) {
			extensions[i] = "*." + ALLOWED_EXTENSIONS[i];
		}

		return extensions;
	}
}
