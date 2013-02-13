// JFSGuiSupport.java

package com.fip.jfs.gui;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.fip.jfs.conf.JFSConst;
import com.fip.jfs.conf.JFSTextTranslation;

/**
 * Description
 *
 * @author Fabien Ipseiz
 * @version 8 févr. 2013
 */
public class JFSGuiSupport {
	
	/**
	 * Creates a button containing text and a tool tip.
	 * 
	 * @param nameKey
	 *            Name of the button.
	 * @param alias
	 *            Alias name: the associate command (String) for this button.
	 * @param listener
	 *            The action listener.
	 * @return The generated element.
	 */
	public static JButton getButton(String nameKey, String alias,
			ActionListener listener) {
		JButton button = new JButton(JFSTextTranslation.getInstance().get(nameKey));
		button.setActionCommand(alias);
		button.addActionListener(listener);
		return button;
	}
	
	/**
	 * Creates a button containing an icon and a tool tip.
	 * 
	 * @param iconKey
	 *            A valid icon key which will be displayed on the button.
	 * @param alias
	 *            Alias name: the associate command (String) for this button.  
	 * @param listener
	 *            The action listener.
	 * @param toolTipKey
	 *            The tool tip text.
	 * @return The generated element.
	 */
	public static JButton getButton(String iconKey, String alias,
			ActionListener listener, String toolTipKey) {
		JButton button = new JButton(new ImageIcon(JFSConst.getInstance()
				.getIconUrl(iconKey)));
		button.setActionCommand(alias);
		button.addActionListener(listener);
		button.setToolTipText(JFSTextTranslation.getInstance().get(toolTipKey));
		button.setMargin(new Insets(1, 1, 1, 1));
		return button;
	}
	/**
	 * Creates a menu item.
	 * 
	 * @param nameKey
	 *            Name of the item.
	 * @param alias
	 *            Alias name: the associate command (String) for this menu.
	 * @param listener
	 *            The action listener.
	 * @return The generated element.
	 */
	
	public static JMenuItem getMenuItem(String nameKey, String alias,
			ActionListener listener) {
		JMenuItem mi = new JMenuItem(JFSTextTranslation.getInstance().get(nameKey));
		mi.setActionCommand(alias);
		mi.addActionListener(listener);
		return mi;
	}

	/**
	 * Creates a menu item.
	 * 
	 * @param nameKey
	 *            Name of the item.
	 * @param alias
	 *            Alias name: the associate command (String) for this menu.
	 * @param listener
	 *            The action listener.
	 * @param iconKey
	 *            A valid icon key.
	 * @return The generated element.
	 */
	public static JMenuItem getMenuItem(String nameKey, String alias,
			ActionListener listener, String iconKey) {
		JMenuItem mi = new JMenuItem(JFSTextTranslation.getInstance().get(nameKey));
		mi.setActionCommand(alias);
		mi.addActionListener(listener);
		ImageIcon icon = new ImageIcon(JFSConst.getInstance().getIconUrl(
				iconKey));
		mi.setIcon(icon);
		return mi;
	}
}
