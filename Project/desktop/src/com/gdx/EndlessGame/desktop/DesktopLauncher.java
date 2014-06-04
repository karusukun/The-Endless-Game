package com.gdx.EndlessGame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.EndlessGame.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                
                config.width = 800;
                config.height = 480;
                config.title = "EndlessGame";
                
		new LwjglApplication(new Main(), config);
	}
}
