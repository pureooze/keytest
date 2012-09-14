import java.awt.event.*;
import java.awt.*;


public class mouseInput extends coreDisplay implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener{

	public static void main(String[] args) {
		new mouseInput().run();
	}
	
	private String mess = "";
	
	//init calls super init
	public void init(){
		super.init();
		Window w = screen.getFullScreenWindow();
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);
	}
	
	//draw
	public synchronized void draw(Graphics2D g){
		
		Window w = screen.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 800, 500);
	}
	
	//mouse listener interface
	public void mousePressed(MouseEvent e){
		mess = "Mouse pressed";
	}
	
	public void mouseReleased(MouseEvent e){
		mess = "Mouse released";
	}
	
	public void mouseClicked(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	//mouse motion interface
	public void mouseDragged(MouseEvent e){
		mess = "Mouse is being dragged";
	}
	
	public void mouseMoved(MouseEvent e){
		mess = "Mouse is moving (not dragged)";
	}
	
	//wheel interface
	public void mouseWheelMoved(MouseWheelEvent e){
		mess = "Mouse wheel moving";
	}
	
	//key pressed
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ESCAPE) {
            stop();
        } else {
            mess = "Pressed: " + KeyEvent.getKeyText(keyCode);
            e.consume();
        }
    }

    //key released
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        mess = "Released: " + KeyEvent.getKeyText(keyCode);
        e.consume();
    }

    //last method from interface
    public void keyTyped(KeyEvent e) {
        e.consume();
    }
	
}
