package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class MouseInput extends InputAdapter {
	private Window window;

	MouseInput(Window window) {
		this.window = window;
		
		
		
	}
	

	public void update() {
		if (window.gameObjectHandler != null) {
			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				int x = Gdx.input.getX();
				int y = (window.getHEIGHT() - 25) - Gdx.input.getY();
				for (GameObject go : window.gameObjectHandler.gameObjectList) {
					if (go.bounds.contains(x, y)) {
						System.out.println(go.id);
					}
				}
			}
		}
	}


}
