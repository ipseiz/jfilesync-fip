// JFSTableView.java

package com.fip.jfs.gui;

import java.awt.Frame;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import com.fip.jfs.conf.JFSTextTranslation;


/**
 * This class is responsible for displaying the synchronization table.
 * 
 * @author Fabien Ipseiz
 * @version 20 févr. 2013
 */
public class JFSTableView extends AbstractTableModel {

	/** The corresponding JTable. */
	private final JTable table;

	/**
	 * The default constructor just performs some initialization work.
	 * 
	 * @param parent
	 *            The parent frame.
	 */
	public JFSTableView(Frame parent) {
		// Create column model:
		JFSTextTranslation t = JFSTextTranslation.getInstance();
		DefaultTableColumnModel cm = new DefaultTableColumnModel();

		TableColumn srcFile = new TableColumn(0, 205);
		srcFile.setHeaderValue(t.get("compTable.src"));
		cm.addColumn(srcFile);

		TableColumn srcDate = new TableColumn(1, 120);
		srcDate.setHeaderValue(t.get("compTable.date"));
		cm.addColumn(srcDate);

		TableColumn srcSize = new TableColumn(2, 60);
		srcSize.setHeaderValue(t.get("compTable.size"));
		cm.addColumn(srcSize);

		TableColumn comp = new TableColumn(3, 30);
		comp.setHeaderValue(t.get("compTable.action"));
		cm.addColumn(comp);

		TableColumn tgtFile = new TableColumn(4, 205);
		tgtFile.setHeaderValue(t.get("compTable.tgt"));
		cm.addColumn(tgtFile);

		TableColumn tgtDate = new TableColumn(5, 120);
		tgtDate.setHeaderValue(t.get("compTable.date"));
		cm.addColumn(tgtDate);

		TableColumn tgtSize = new TableColumn(6, 60);
		tgtSize.setHeaderValue(t.get("compTable.size"));
		cm.addColumn(tgtSize);

		// Create table:
		table = new JTable(this, cm);
		//TODO table renderer according to the functions implemented
		//JFSTableRenderer renderer = new JFSTableRenderer(table);
		//table.setDefaultRenderer(String.class, renderer);
		table.getTableHeader().setReorderingAllowed(false);

	}

	/**
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 7;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public JTable getJTable() {
		// TODO Auto-generated method stub
		return table;
	}

}
