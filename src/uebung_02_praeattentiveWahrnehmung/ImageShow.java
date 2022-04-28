package uebung_02_praeattentiveWahrnehmung;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ImageShow {

	/**
	 * Launch the application.
	 * @param args
	 * 
	 * 
	 */
	private Display display;
	private Label label;
	public  ArrayList<TimedImage> infoImages;
	public  boolean testactive = false;
	private int infoImageindex;
	
	public  ArrayList<TimedImage> perceptionImages;
	private int imageindex;
	private boolean[] perceptionResults;
	private float[] milisecondsToShow = new float[]{150,400,1000,2500};
	private int secondsIndex = 0;

	
	private Button[] buttons;
	
	public void  setButtons(Button[] buttons) {
		this.buttons = buttons;

	}
	
	
	
	public ImageShow(Display display, Label label) {
		this.display = display;
		this.label =label;
		this.perceptionImages = new ArrayList<TimedImage>();
		this.infoImages = new ArrayList<TimedImage>();
		this.imageindex = 0;
		this.infoImageindex =0;
		createImages(this.display, this.label );
		perceptionResults = new boolean[perceptionImages.size()];
	}
	
	
	
	public  void createImages(Display display, Label label) {
		TimedImage a = new TimedImage(display, label, milisecondsToShow[0], "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\sample.png");
		TimedImage b = new TimedImage(display, label, milisecondsToShow[0], "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\visualization.png");
		TimedImage c = new TimedImage(display, label, milisecondsToShow[0], "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\infographic.png");

		
		
		
		TimedImage three = new TimedImage(display, label, -1f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\number-3.png");
		TimedImage two = new TimedImage(display, label, 700f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\number-2.png");
		TimedImage one = new TimedImage(display, label, 700f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\number-1.png");
		TimedImage go = new TimedImage(display, label, 900f, "C:\\Users\\keoma\\workspace\\uebung_02_praeattentiveWahrnehmung\\img\\go.png");

		perceptionImages.add(a);
		perceptionImages.add(b);
		perceptionImages.add(c);
		
	
		
		infoImages.add(three);
		infoImages.add(two);
		infoImages.add(one);
		infoImages.add(go);



		
	}
	
	
	
	public TimedImage getcurrentImage() {
		 TimedImage toReturn = perceptionImages.get(imageindex);
		 return toReturn;
	}
	
	public TimedImage getcurrentInfoImage() {
		 TimedImage toReturn = infoImages.get(infoImageindex);
		 return toReturn;
	}
	
	public void setToNextInfoImage() {
		getcurrentInfoImage().resetImage();
		infoImageindex++;
		System.out.print(infoImageindex);
		if(infoImageindex >= infoImages.size()) {
			infoImageindex= 0;
			testactive = true;
		}
		
	}
	
	public void setToNextImage() {
		getcurrentImage().resetImage();
		imageindex++;
		if(imageindex >= perceptionImages.size()) {
			imageindex= 0;		
			secondsIndex++;

			
		}
		
		testactive = false;
		buttons[0].setVisible(true);
		buttons[1].setVisible(true);


	}
	
	public void setCurrentTest(boolean testresult) {
		perceptionResults[imageindex] = testresult;
		//System.out.print(testresult);
	}
	
	
	public static void main(String[] args) {
		
		

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(528, 535);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		ImageShow program = new ImageShow(display, label);
				
		Button btnSawIt = new Button(shell, SWT.NONE);
		btnSawIt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				program.setCurrentTest(true);
				program.buttons[0].setVisible(false);
				program.buttons[1].setVisible(false);
				program.buttons[2].setVisible(true);

			}
		});
		btnSawIt.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		btnSawIt.setBounds(80, 401, 105, 35);
		btnSawIt.setText("Saw it!");
		
		Button btnNoChance = new Button(shell, SWT.NONE);
		btnNoChance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				program.setCurrentTest(false);
				program.buttons[0].setVisible(false);
				program.buttons[1].setVisible(false);
				program.buttons[2].setVisible(true);
			}
		});
		btnNoChance.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnNoChance.setBounds(310, 401, 105, 35);
		btnNoChance.setText("No chance");
		
		Button btnNextPerception = new Button(shell, SWT.NONE);
		btnNextPerception.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				program.setToNextInfoImage();
				program.buttons[2].setVisible(false);
			}
		});
		btnNextPerception.setBounds(185, 350, 136, 35);
		btnNextPerception.setText("Next Perception");
		
		Button[] buttons = new Button[] {btnSawIt,btnNoChance,btnNextPerception};
		buttons[0].setVisible(false);
		buttons[1].setVisible(false);
		program.setButtons(buttons);
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			
			
			if(program.testactive) {
				program.getcurrentImage().setShowDuration(program.milisecondsToShow[program.secondsIndex]);
				boolean currentTestImageIsShown = program.getcurrentImage().showImage();
				if(!currentTestImageIsShown) {
					program.setToNextImage();
				}
			}
			else {
				boolean currentInfoImageIsShown = program.getcurrentInfoImage().showImage();
				if(!currentInfoImageIsShown) {
					program.setToNextInfoImage();
				}
			}
			
			
			 //one.showImage();

			if (!display.readAndDispatch()) {
			}
		}
	}
}
