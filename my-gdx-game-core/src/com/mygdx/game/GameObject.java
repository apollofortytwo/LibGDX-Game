package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public Vector2 velocity = new Vector2(0, 0);
	public Rectangle bounds;
	public ObjectID id;
	private Vector2 position;

	GameObject(ObjectID id, float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Rectangle(x, y, width, height);
		this.id = id;
	}

	public void render(ShapeRenderer sr) {
		sr.setColor(Color.BLUE);
		sr.rect(position.x, position.y, bounds.width, bounds.height);
		
	}

	public void update() {
		position.x += velocity.x;
		position.y += velocity.y;
		bounds.setPosition(position);		
		velocity.set(0, 0);
	}

	public Rectangle getTopRectangle() {
		float scale = 0.8f;
		float hScale = 0.1f;
		return new Rectangle((position.x + (bounds.width * (1 - scale)) / 2),
				position.y + (bounds.height - (bounds.height * hScale)), bounds.width * scale, bounds.height * hScale);

	}

	public Rectangle getRightRectangle() {
		float scale = 0.8f;
		float wScale = 0.1f;
		return new Rectangle(position.x + (bounds.width - (bounds.width * wScale)),
				(position.y + (bounds.height * (1 - scale)) / 2), bounds.width * wScale, bounds.height * scale);
	}

	public Rectangle getLeftRectangle() {
		float scale = 0.8f;
		float wScale = 0.1f;
		return new Rectangle(position.x, (position.y + (bounds.height * (1 - scale)) / 2), bounds.width * wScale,
				bounds.height * scale);

	}

	public Rectangle getBottomRectangle() {
		float scale = 0.8f;
		float hScale = 0.1f;
		return new Rectangle((position.x + (bounds.width * (1 - scale)) / 2), position.y, bounds.width * scale,
				bounds.height * hScale);
	}
}
