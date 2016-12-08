package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameObjectHandler {
	ArrayList<GameObject> gameObjectList = new ArrayList<GameObject>();

	GameObjectHandler() {

	}

	public void addGameObject(GameObject go) {
		gameObjectList.add(go);
	}

	public void removeGameObject(GameObject go) {
		gameObjectList.remove(go);
	}

	public void render(ShapeRenderer sr) {
		for (GameObject go : gameObjectList) {
			go.render(sr);
		}
	}

	public void update() {
		for (GameObject go : gameObjectList) {

			
			for (GameObject go1 : gameObjectList) {
				if (!go1.equals(go)) {
					if (Collision.collisionCheckGameObjectTop(go, go1)) {
						go.velocity.y = -5;
					}
					if (Collision.collisionCheckGameObjectRight(go, go1)) {
						go.velocity.x = -5;
					}
					if (Collision.collisionCheckGameObjectLeft(go, go1)) {
						go.velocity.x = 5;
					}
					if (Collision.collisionCheckGameObjectBottom(go, go1)) {
						go.velocity.y = 5;
					}

				}
			}
			
			go.update();

		}
		for (GameObject go : gameObjectList) {
			
		}

	}
}
