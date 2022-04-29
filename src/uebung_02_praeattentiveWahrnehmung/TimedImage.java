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
	
	public void resetImage() {
		isShown= false;
		elapsedTime = 0;
		start = 0;
	}
	
	public void setShowDuration(float newDuration) {
		timeToShow = newDuration;
	}
	
	
	public boolean showImage() {

		if(!isShown) {
			label.setImage(image);
			label.setBounds(100, 0, 700, 700);
			label.redraw();
			start = System.currentTimeMillis(); 
			isShown = true;
			return true;
		 	}
		else if(elapsedTime< timeToShow) {
			long finish = System.currentTimeMillis();
			elapsedTime = finish - start;	
			return true;
		 	}
		else {
			//If this Image has a timeToShow it will be set to null because the time is up
			if(timeToShow >= 0) { 
				label.setImage(null);
				label.setBounds(100, 0, 700, 700);
				return false;
			}
			return true;
		}
	}
	
	
	

}
