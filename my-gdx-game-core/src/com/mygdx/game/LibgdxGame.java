package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LibgdxGame extends Game {

	SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		Window gameWindow = new Window(this);
		this.setScreen(gameWindow);
	}

	@Override
	public void render() {
		super.render();
	}
	
	public SpriteBatch getBatch(){
		return batch;
	}
}
