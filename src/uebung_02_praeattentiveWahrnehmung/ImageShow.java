package uebung_02_praeattentiveWahrnehmung;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class ImageShow {

	/**
	 * Launch the application.
	 * @param args
	 */
	

	
	
	public static void main(String[] args) {
		
		

		

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(528, 535);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		
		TimedImage one = new TimedImage(display, label, 200f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\sample.png");
		
		Button btnSawIt = new Button(shell, SWT.NONE);
		btnSawIt.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		btnSawIt.setBounds(80, 401, 105, 35);
		btnSawIt.setText("Saw it!");
		
		Button btnNoChance = new Button(shell, SWT.NONE);
		btnNoChance.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnNoChance.setBounds(310, 401, 105, 35);
		btnNoChance.setText("No chance");
		
		
		/*Image image = new Image(display,"C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\sample.png");
		label.setImage(image);
		label.setBounds(40, 38, 400, 280);*/

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			
			 one.showImage();
			
			
			
			if (!display.readAndDispatch()) {
			}
		}
	}
}
