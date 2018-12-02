package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.InfernosCrest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Inferno's Crest";
		config.width = 1600;
		config.height = 900;
		config.resizable = false;
		config.fullscreen = false;
		new LwjglApplication(new InfernosCrest(), config);
	}
}
