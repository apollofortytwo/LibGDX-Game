package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Window extends ScreenAdapter {
	private Game game;
	private SpriteBatch batch;

	GameObject player;

	Window(LibgdxGame game) {
		this.resize(500, 500);

		this.game = game;
		this.batch = game.batch;
		player = new GameObject(0, 0, 50, 50);
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

		sr.rect(player.position.x, player.position.y, player.bounds.width, player.bounds.height);
		sr.end();

	}

	InputListener inputListener = new InputListener();

	private void update() {

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			player.position.y += 5;
		} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.position.y -= 5;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			player.position.x -= 5;
		} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.position.x += 5;
		}

	}

	private void tick() {
		System.out.println("tick");
		player.position.x += 5;
	}

	float elapsed = 0;
	int frames = 0;

	@Override
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

}
