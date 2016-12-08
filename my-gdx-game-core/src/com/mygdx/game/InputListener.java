package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class InputListener implements InputProcessor {
	private Window window;
	private GameObjectHandler goHandler;

	InputListener(Window window) {
		this.window = window;
		if (window.gameObjectHandler != null) {
			goHandler = window.gameObjectHandler;
		}

	}

	public void update() {
		gdxkeyInput();
	}

	public void gdxkeyInput() {
		if (goHandler != null) {
			for (GameObject go : goHandler.gameObjectList) {

				if (go.id.equals(ObjectID.PLAYER)) {
					if (Gdx.input.isKeyPressed(Input.Keys.W)) {
						go.velocity.y = 5;

					} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
						go.velocity.y = -5;
					}
					if (Gdx.input.isKeyPressed(Input.Keys.A)) {
						go.velocity.x = -5;
					} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
						go.velocity.x = 5;
					}
				}
				go.update();
			}

		}
	}

	@Override
	public boolean keyDown(int keycode) {

		return false;

	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (goHandler != null) {
			for (GameObject go : goHandler.gameObjectList) {
				if (go.bounds.contains(screenX, (window.camera.viewportHeight) - screenY)) {
					System.out.println(go.id);
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
