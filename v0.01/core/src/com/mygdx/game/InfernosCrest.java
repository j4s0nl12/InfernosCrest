package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.gameobject.MyCamera;
import com.mygdx.game.managers.ScreenManager;

public class InfernosCrest extends Game {

	private MyCamera gameCamera;
	private MyCamera HUDCamera;
	private static Viewport viewport;
	private static ScreenManager sm;

	@Override
	public void create(){
		gameCamera = new MyCamera();
		HUDCamera = new MyCamera();
		viewport = new ExtendViewport(Utility.getVirtualWidth(), Utility.getVirtualHeight(), gameCamera);
		Utility.SRSetAuto();
		sm = new ScreenManager(this);
	}

	public void resize(int width, int height){
		viewport.update(width, height, true);
	}

	@Override
	public void dispose(){

	}

	public MyCamera getGameCamera(){
		return gameCamera;
	}

	public MyCamera getHUDCamera(){
		return HUDCamera;
	}

	public static Viewport getViewport(){
		return viewport;
	}
}
