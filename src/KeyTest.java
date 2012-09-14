import java.awt.*;
import java.awt.event.*;


public class KeyTest extends coreDisplay implements KeyListener {
   
    public static void main(String[] args) {
        new KeyTest().run();
    }
   
    private String mess = "";
   
    //init also call init from super class
    public void init() {
        super.init();
        Window w = screen.getFullScreenWindow();
        w.setFocusTraversalKeysEnabled(false);
        w.addKeyListener(this);
        mess = "Press escape to exit";
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

    //draw method
    public synchronized void draw(Graphics2D g) {
        Window w = screen.getFullScreenWindow();
        g.setColor(w.getBackground());
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
        g.setColor(w.getForeground());
        g.drawString(mess, 30, 30);
    }


}