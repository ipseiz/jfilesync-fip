// JFSConfigDirectoryView.java
package com.fip.jfs.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.fip.jfs.conf.JFSTextTranslation;
import java.awt.TextField;
import javax.swing.JTextField;

/**
 * This dialog manages adding/changing directory pairs.
 *
 * @author Fabien Ipseiz
 * @version 20 févr. 2013
 */
public class JFSConfigDirectoryView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	/** The source element. */
	private JTextField srcElement;

	/** The target element. */
	private JTextField tgtElement;

	/**
	 * Create the dialog.
	 */
	public JFSConfigDirectoryView() {
		// Get the translation object:
		JFSTextTranslation t = JFSTextTranslation.getInstance();
		
		// Create the dialog frame:
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle(t.get("profile.dir.title"));
		setResizable(false);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			srcElement = new JTextField();
			//contentPanel.add(srcElement);
			srcElement.setColumns(40);
		}
		{
			JLabel srcLabel = new JLabel(t.get("profile.dir"));
			//contentPanel.add(srcLabel);
		}
		{
			JPanel srcRow1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			srcRow1Panel.add(srcLabel);
			srcRow1Panel.add(srcElement);
			getContentPane().add(srcRow1Panel);
		}
		{
			JPanel srcRowPanel = new JPanel(new BorderLayout());
			srcRowPanel.setBorder(new TitledBorder(t.get("profile.dir.table.src")));
			srcRowPanel.add(srcRow1Panel, BorderLayout.NORTH);
			srcRowPanel.add(srcRow2Panel, BorderLayout.SOUTH);
		}
		
		
		// Create source and target panel:
		JPanel dirPanel = new JPanel(new GridLayout(2, 1));
		dirPanel.add(srcRowPanel);
		dirPanel.add(tgtRowPanel);
		getContentPane().add(dirPanel, BorderLayout.CENTER);
		
		{
	JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
