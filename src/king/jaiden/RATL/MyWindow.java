package king.jaiden.RATL;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

public abstract class MyWindow {
	public int WINDOW_WIDTH, WINDOW_HEIGHT, tick;
	
	/**
	 * Creates a new LWJGL window with GL_BLEND, GL_DEPTH_TEST, and GL_CULL_FACE enabled
	 * in a 3d environment.
	 * @param w Window width
	 * @param h Window height
	 * @param fov Vertical(?) field of view
	 * @param title The title of the window
	 */
	public MyWindow(int w,int h, int fov, String title){
		WINDOW_WIDTH = w;
		WINDOW_HEIGHT = h;
		// Setup the Display
		try {
			Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT));
			Display.create();
			Display.setTitle(title);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		glViewport(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
		// Setup the Matrix
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(100, WINDOW_WIDTH/(float)WINDOW_HEIGHT, 0.1f, 10000);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);	
		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LESS);
		glEnable(GL_CULL_FACE);

		init();
		
		while (!Display.isCloseRequested()){
			input();
			tick();
			draw();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	public abstract void init();
	public abstract void input();
	public void tick(){
		tick++;
	}
	public void draw(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
}
