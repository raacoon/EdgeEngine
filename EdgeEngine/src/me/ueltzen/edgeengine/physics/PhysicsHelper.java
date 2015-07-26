package me.ueltzen.edgeengine.physics;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class PhysicsHelper {
	
	public static Body createBox(float x, float y, float width, float height, BodyType type) {
		
		FixtureDef boxFixtureDef = new FixtureDef();
		boxFixtureDef.density = 0.25f;
		boxFixtureDef.friction = .5f;
		
		return createBox(x, y, width, height, type, boxFixtureDef);
		
	}
	
	public static Body createBox(float x, float y, float width, float height, BodyType type, FixtureDef fixtureDef) {
		
		BodyDef boxDef = new BodyDef();
		boxDef.type = type;
		boxDef.position.set(x, y);
		
		PolygonShape boxShape = new PolygonShape();
		boxShape.setAsBox(width, height);
		
		fixtureDef.shape = boxShape;
		
		Body box = PhysicsManager.getInstance().getBox2DWorld().createBody(boxDef);
		box.createFixture(fixtureDef);
		
		boxShape.dispose();
		
		return box;
		
	}
	
	public static Body createCircle(float x, float y, float radius, BodyType type) {
		
		FixtureDef circleFixtureDef = new FixtureDef();
		circleFixtureDef.density = 0.5f;
		
		return createCircle(x, y, radius, type, circleFixtureDef);
		
	}
	
	public static Body createCircle(float x, float y, float radius, BodyType type, FixtureDef fixtureDef) {
		
		BodyDef circleDef = new BodyDef();
		circleDef.type = type;
		circleDef.position.set(x, y);
		
		CircleShape circleShape = new CircleShape();
		circleShape.setRadius(radius);
		
		fixtureDef.shape = circleShape;
		
		Body circle = PhysicsManager.getInstance().getBox2DWorld().createBody(circleDef);
		circle.createFixture(fixtureDef);
		
		circleShape.dispose();
		
		return circle;
		
	}
	
}
