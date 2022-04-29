package uebung_02_praeattentiveWahrnehmung;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Resultwindow {
	private Table table;
	private boolean[] results;
	private Text txtPerceptionTestResults;
	private Text txtHereYouCan;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Resultwindow window = new Resultwindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setResults(boolean[] values) {
		results = values;
	}
	

	private void setValues(boolean[] values) {
		 TableItem[] items = this.table.getItems();
		 int columns = this.table.getColumnCount();
		 System.out.println("valuesSize: " + values.length);

		 
		 for(int i = 0; i< items.length; i++) {
			 for(int c = 1; c< columns; c++ ) {
				 System.out.println("col: " +c);
				 items[i].
				 setText(c, ""+
				 values[ (c-1)*(items.length-1)+ i]);
			 }
		 }
	}
	
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(882, 647);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 106, 826, 390);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(142);
		tblclmnNewColumn.setText("Eigenschaften");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("150ms");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("250ms");
		
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("New TableItem");
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText("New TableItem");
		
		TableItem tableItem_2 = new TableItem(table, SWT.NONE);
		tableItem_2.setText("New TableItem");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		
		TableItem tableItem_3 = new TableItem(table, SWT.NONE);
		tableItem_3.setText("New TableItem");
		
		TableItem tableItem_4 = new TableItem(table, SWT.NONE);
		tableItem_4.setText("New TableItem");
		
		TableItem tableItem_5 = new TableItem(table, SWT.NONE);
		tableItem_5.setText("New TableItem");
		
		TableItem tableItem_6 = new TableItem(table, SWT.NONE);
		tableItem_6.setText("New TableItem");
		
		TableItem tableItem_7 = new TableItem(table, SWT.NONE);
		tableItem_7.setText("New TableItem");
		
		TableItem tableItem_8 = new TableItem(table, SWT.NONE);
		tableItem_8.setText("New TableItem");
		
		TableItem tableItem_9 = new TableItem(table, SWT.NONE);
		tableItem_9.setText("New TableItem");
		
		TableItem tableItem_10 = new TableItem(table, SWT.NONE);
		tableItem_10.setText("New TableItem");
		
		TableItem tableItem_11 = new TableItem(table, SWT.NONE);
		tableItem_11.setText("New TableItem");
		
		txtPerceptionTestResults = new Text(shell, SWT.BORDER);
		txtPerceptionTestResults.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtPerceptionTestResults.setText("Perception Test Results");
		txtPerceptionTestResults.setBounds(10, 10, 255, 38);
		
		txtHereYouCan = new Text(shell, SWT.BORDER);
		txtHereYouCan.setText("Here you can see the results for different tests to different durations.");
		txtHereYouCan.setBounds(10, 69, 605, 31);
		
		setValues(results);

		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
