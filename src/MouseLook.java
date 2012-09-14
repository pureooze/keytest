import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;


public class MouseLook extends coreDisplay implements MouseMotionListener, KeyListener {

	private    Image    bg;
	private    Robot    robot;
	private    Point    mouseLoc;
	private    Point    centerLoc;
	private    Point    imageLoc;
    private    boolean  centering;
    
    
	public static void main(String[] args) {
		
		new Look().run();
	}
	
	//init
	public void init(){
		super.init();
		mouseLoc = new Point();
		centerLoc = new Point();
		imageLoc = new Point();
		centering = false;
	
		try{
			robot = new Robot();
			recenterMouse();
			mouseLoc.x = centerLoc.x;
			mouseLoc.y = centerLoc.y;
		}catch(Exception ex){
			System.out.println("Exception: " + ex + " at line 37 of MouseLook.java");
		}
		
		Window w = screen.getFullScreenWindow();
		w.addMouseMotionListener(this);
		w.addKeyListener(this);
		bg = new ImageIcon("C:\\Users\\User\\newboston\\sprites\\Images\\bg.jpg").getImage();
		
	}
	
	//draw
	public synchronized void draw(Graphics2D g){
		
		int w = screen.getWidth();
		int h = screen.getHeight();
		
		imageLoc.x %= w;
		imageLoc.y %= h;
		
		if(imageLoc.x < 0){
			imageLoc.x += w;
		}
		
		if(imageLoc.y < 0){
			imageLoc.y += h;
		}
		
		int     x     = imageLoc.x;
		int     y     = imageLoc.y;
		
		g.drawImage(bg, x, y, null);
		g.drawImage(bg, x - w, y, null);
		g.drawImage(bg, x, y - h, null);
		g.drawImage(bg, x - w, y - h, null);
	}
    
}
