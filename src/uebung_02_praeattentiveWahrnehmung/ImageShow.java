package uebung_02_praeattentiveWahrnehmung;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class ImageShow {

	/**
	 * Launch the application.
	 * @param args
	 * 
	 * 
	 */
	private Display display;
	private Label label;
	private int imageindex;
	public  ArrayList<TimedImage> allImages;
	
	
	public ImageShow(Display display, Label label) {
		this.display = display;
		this.label =label;
		this.allImages = new ArrayList<TimedImage>();
		this.imageindex = 0;
		createImages(this.display, this.label );
	}
	
	
	
	public  void createImages(Display display, Label label) {
		TimedImage one = new TimedImage(display, label, 500f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\sample.png");
		TimedImage two = new TimedImage(display, label, 1500f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\visualization.png");
		TimedImage three = new TimedImage(display, label, 250f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\infographic.png");

		allImages.add(one);
		allImages.add(two);
		allImages.add(three);
		
	}
	
	public TimedImage getcurrentImage() {
		 TimedImage toReturn = allImages.get(imageindex);
		 return toReturn;
	}
	
	public void setToNextImage() {
		imageindex++;
	}
	
	
	
	public static void main(String[] args) {
		
		

		

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(528, 535);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		ImageShow program = new ImageShow(display, label);
		
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
			
			boolean currentImageIsShown = program.getcurrentImage().showImage();
			if(!currentImageIsShown)program.setToNextImage();
			
			 //one.showImage();

			if (!display.readAndDispatch()) {
			}
		}
	}
}
