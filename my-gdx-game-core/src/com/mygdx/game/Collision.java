package com.mygdx.game;

public class Collision {
	
	public static boolean collisionCheckGameObjectTop(GameObject go1, GameObject go2){
		return go1.getTopRectangle().overlaps(go2.bounds);
	}
	
	public static boolean collisionCheckGameObjectRight(GameObject go1, GameObject go2){
		return go1.getRightRectangle().overlaps(go2.bounds);
	}
	
	public static boolean collisionCheckGameObjectLeft(GameObject go1, GameObject go2){
		return go1.getLeftRectangle().overlaps(go2.bounds);
	}
	
	public static boolean collisionCheckGameObjectBottom(GameObject go1, GameObject go2){
		return go1.getBottomRectangle().overlaps(go2.bounds);
	}
	
	
}
