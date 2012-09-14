import java.awt.*;

public abstract class coreDisplay {

    private static DisplayMode modes[] = {
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),

        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0),
    };

    private boolean running;
    protected screenManager screen;

    //Stop method
    public void stop() {
        running = false;
    }

    //call init and gameloop
    public void run() {
        try {
            init();
            gameloop();
        } finally {
        	screen.restoreScreen();
        }
    }

    //set to full screen
    public void init() {
    	screen = new screenManager();
        DisplayMode dm = screen.findFirstCompatibleMode(modes);
        screen.setFullScreen(dm);

        Window w = screen.getFullScreenWindow();
        w.setFont(new Font("Arial", Font.PLAIN, 20));
        w.setBackground(Color.GREEN);
        w.setForeground(Color.WHITE);
        running = true;
    }

    //main game loop
    public void gameloop() {
        long startTime = System.currentTimeMillis();
        long cumTime = startTime;

        while (running) {
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;

            update(timePassed);
            Graphics2D g = screen.getGraphics();
            draw(g);
            g.dispose();
            screen.update();

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
                System.err.println("Error when trying to sleep: " + ex);
            }
        }
    }

    //update animation
    public void update(long timePassed) {
        //empty//
    }

    //draws to the screen
    public abstract void draw(Graphics2D g);

}