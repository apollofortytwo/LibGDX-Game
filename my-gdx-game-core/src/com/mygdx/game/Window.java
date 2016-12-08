package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Window extends Game implements Screen{
	private Game game;
	private SpriteBatch batch;
	private int HEIGHT = 500, WIDTH = 500;
	GameObject player;
	GameObject block;

	GameObjectHandler gameObjectHandler;
	MouseInput mouseInput;
	
	Window(LibgdxGame game) {
		this.resize(HEIGHT, WIDTH);
		
		this.game = game;
		this.batch = game.batch;

		player = new GameObject(ObjectID.PLAYER, 0, 0, 50, 50);
		block = new GameObject(ObjectID.BLOCK, 100, 100, 50, 50);

		gameObjectHandler = new GameObjectHandler();

		gameObjectHandler.addGameObject(player);
		gameObjectHandler.addGameObject(block);
		mouseInput = new MouseInput(this);
	}

	private void draw() {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 1, 1, 0);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.end();

		ShapeRenderer sr = new ShapeRenderer();

		sr.setAutoShapeType(true);
		sr.setColor(Color.BLUE);
		sr.begin();
		gameObjectHandler.render(sr);
		sr.end();

	}

	private void update() {
		mouseInput.update();
		gameObjectHandler.update();

	}

	private void tick() {

	}

	float elapsed = 0;
	int frames = 0;

	public void render(float delta) {
		frames++;
		elapsed += delta;
		update();
		draw();
		if (elapsed > 1) {
			Gdx.graphics.setTitle("FPS: " + Integer.toString(frames));
			elapsed = 0;
			tick();
			frames = 0;
		}

	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

}
