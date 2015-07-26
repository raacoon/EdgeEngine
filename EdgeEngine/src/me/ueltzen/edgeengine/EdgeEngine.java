package me.ueltzen.edgeengine;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class EdgeEngine {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "EdgeEngine Development Build";
	
	public static void main(String[] args) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = 800;
		config.height = 600;
		
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		
		config.fullscreen = false;
		
		new LwjglApplication(new EdgeRunnable(), config);
		
	}
}
