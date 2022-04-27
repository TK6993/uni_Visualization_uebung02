package uebung_02_praeattentiveWahrnehmung;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class TimedImage {
	
	public Image image;
	public float timeToShow = -1f;
	
	private Display display;
	private Label label;
	private String path;
	
	public boolean isShown = false;
	private long start = 0;
	private long elapsedTime = 0;
	
	
	public TimedImage(Display display, Label label , float timetoLive, String path) {
		this.display = display;
		this.label = label;
		this.path = path;
		this.image = new Image(display,path);
		this.timeToShow = timetoLive;

		
	}
	
	
	
	public void showImage() {
		
		if(!isShown) {
			label.setImage(image);
			label.setBounds(40, 38, 400, 280);
			start = System.currentTimeMillis(); 
			isShown = true;
		 }
		
		if(elapsedTime< timeToShow) {
			long finish = System.currentTimeMillis();
			elapsedTime = finish - start;
			 
		}
		else {
			
			if(timeToShow >= 0) { 
				label.setImage(null);
				label.setBounds(40, 38, 400, 280);
				System.out.print("vorbei");
			}
		}
	}
	
	
	

}
