// JFSMainView.java

package com.fip.jfs.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import com.fip.jfs.conf.JFSConst;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.fip.jfs.conf.JFSConfig;
import com.fip.jfs.conf.JFSTextTranslation;
import com.fip.jfs.conf.JFSSettings;
import com.fip.jfs.gui.JFSGuiSupport;
import javax.swing.JToolBar;
import javax.swing.JButton;


/**
 * This class represents the main Java Swing frame of the JFS application.
 *
 * @author Fabien Ipseiz
 * @version 15 févr. 2013
 */

@SuppressWarnings("serial")
public class JFSMainView extends JFrame implements ActionListener, ComponentListener {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFSMainView(){
		
		// Get translation object and set default locale:
		JFSTextTranslation t = JFSTextTranslation.getInstance();
		JComponent.setDefaultLocale(t.getLocale());
		
		JFSConfig config = JFSConfig.getInstance();
		
		// Start main window of application:		
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFSMainView.class.getResource("/com/fip/jfs/resources/icons/JFileSync.gif")));
		setTitle(t.get("general.appName") + " " + JFSConst.getInstance().getString("jfs.version") 
				+ " - " + config.getTitle());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override	// Using WindowAdapter class instead windowListener interface to handle the exit window even 
		    public void windowClosing(WindowEvent e) {
		    	actionPerformed("EXIT");
		     }
		});
		addComponentListener(this);
		
		// Set some frame attributes:
		JFSSettings s = JFSSettings.getInstance();
		setBounds(s.getWindowX(), s.getWindowY(), s.getWindowWidth(), s.getWindowHeight());

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Create main menus:
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFile = new JMenu(t.get("menu.file"));
		menuBar.add(mnFile);
		JMenu mnView = new JMenu(t.get("menu.view"));
		menuBar.add(mnView);
		JMenu mnMode = new JMenu(t.get("menu.mode"));
		menuBar.add(mnMode);
		JMenu mnTools = new JMenu(t.get("menu.tools"));
		menuBar.add(mnTools);
		JMenu mnHelp = new JMenu(t.get("menu.help"));
		menuBar.add(mnHelp);

		// Create file menu:
		mnFile.add(JFSGuiSupport.getMenuItem("menu.new", "NEW", this,"jfs.icon.new"));
		mnFile.add(JFSGuiSupport.getMenuItem("menu.open", "OPEN", this,"jfs.icon.open"));
		mnFile.add(JFSGuiSupport.getMenuItem("menu.save", "SAVE", this,"jfs.icon.save"));
		mnFile.add(JFSGuiSupport.getMenuItem("menu.saveAs", "SAVE_AS", this,"jfs.icon.saveAs"));
		mnFile.addSeparator();
		mnFile.add(JFSGuiSupport.getMenuItem("menu.reset", "general.reset", this));
		mnFile.addSeparator();
		/*for (int i = 0; i < JFSConst.LAST_OPENED_PROFILES_SIZE; i++) {
			lastOpenedProfiles[i] = JFSGuiSupport.getMenuItem("", "OPEN_" + i,
					this);
			fileMenu.add(lastOpenedProfiles[i]);
		}*/
		//updateLastOpenedProfiles();
		mnFile.addSeparator();
		mnFile.add(JFSGuiSupport.getMenuItem("menu.exit", "EXIT", this));
		
		// Create control panel:
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		contentPane.add(toolBar, BorderLayout.NORTH);
		//toolBar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.new", "NEW", this, "menu.new"));
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.open", "OPEN", this, "menu.open"));
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.save", "SAVE", this, "menu.save"));
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.saveAs", "SAVE_AS", this,"menu.saveAs"));
		toolBar.addSeparator();
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.profile", "OPTIONS", this,"menu.options"));
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.compare", "COMPARE", this,"menu.compare"));
		toolBar.add(JFSGuiSupport.getButton("jfs.icon.synchronize", "SYNCHRONIZE",	this, "menu.synchronize"));
		toolBar.addSeparator();
		JButton assistant = JFSGuiSupport.getButton("jfs.icon.assistant","ASSISTANT", this, "menu.assistant");
		assistant.setText(t.get("menu.assistant"));
		toolBar.add(assistant);
		
		// Create tools menu:
		mnTools.add(JFSGuiSupport.getMenuItem("menu.assistant", "ASSISTANT",this, "jfs.icon.assistant"));
		mnTools.addSeparator();
		mnTools.add(JFSGuiSupport.getMenuItem("menu.options", "OPTIONS", this,"jfs.icon.profile"));
		mnTools.add(JFSGuiSupport.getMenuItem("menu.compare", "COMPARE", this,"jfs.icon.compare"));
		mnTools.add(JFSGuiSupport.getMenuItem("menu.synchronize", "SYNCHRONIZE",this, "jfs.icon.synchronize"));
		mnTools.addSeparator();
		mnTools.add(JFSGuiSupport.getMenuItem("menu.history", "HISTORY", this));
		mnTools.addSeparator();
		mnTools.add(JFSGuiSupport.getMenuItem("menu.outLog", "OUTPUT_LOG", this,"jfs.icon.log"));
		mnTools.add(JFSGuiSupport.getMenuItem("menu.errLog", "error.log", this,"jfs.icon.log"));
	}
	
	
	/**
	 * @see ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();

		actionPerformed(cmd);
	}

	/**
	 * Action Listener of the main frame.
	 * 
	 * @param cmd
	 *            The transmitted command string.
	 */
	public void actionPerformed(String cmd) {
		// Get translation objects, configuration, settings, and task:
		JFSTextTranslation t = JFSTextTranslation.getInstance();
		//JFSConfig config = JFSConfig.getInstance();
		JFSSettings s = JFSSettings.getInstance();
		
		if (cmd.equals("EXIT")) {
			// Ask for exiting the program:
			JLabel msg = new JLabel(t.get("message.exit"));
			int result = JOptionPane.showConfirmDialog(this, msg, t
					.get("general.warning"), JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				// Store last entered profile data:
				//config.storeDefaultFile();

				// Save settings:
				s.store();

				// Close window and go back to main program:
				setVisible(false);
				dispose();

				// Exit application:
				System.exit(0);
			}
		}
	}
	
	/**
	 * @see ComponentListener#componentResized(ComponentEvent)
	 */
	public void componentResized(ComponentEvent arg0) {
		JFSSettings s = JFSSettings.getInstance();
		int state = this.getExtendedState();
		Rectangle r = this.getBounds();

		if (state == Frame.NORMAL) {
			s.setWindowBounds(r.x, r.y, r.width, r.height);
			System.out.println("r.x = " + r.x + " r.y = " + r.y + " r.width = " + r.width +" r.height = " + r.height);
		/*} else if (state == Frame.MAXIMIZED_VERT) {
			settings.setWindowX(r.x);
			settings.setWindowWidth(r.width);
		} else if (state == Frame.MAXIMIZED_HORIZ) {
			settings.setWindowY(r.y);
			settings.setWindowHeight(r.height);
		*/
		}	
	}

	/**
	 * @see ComponentListener#componentResized(ComponentEvent)
	 */
	@Override
	public void componentHidden(ComponentEvent e) {
	}

	/**
	 * @see ComponentListener#componentResized(ComponentEvent)
	 */
	@Override
	public void componentMoved(ComponentEvent e) {
		componentResized(e);
	}

	/**
	 * @see ComponentListener#componentResized(ComponentEvent)
	 */
	@Override
	public void componentShown(ComponentEvent e) {
	}

}
