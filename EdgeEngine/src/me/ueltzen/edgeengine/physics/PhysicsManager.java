package me.ueltzen.edgeengine.physics;

import me.ueltzen.edgeengine.system.GameManager;
import me.ueltzen.edgeengine.system.Layer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ObjectMap;

public class PhysicsManager {
	
	private PhysicsManager() {
		
		m_box2DWorld = new World(new Vector2(0, -10), true);
		
		m_physicsBodys = new ObjectMap<String, Body>();
		
	}
	
	public static synchronized PhysicsManager getInstance() {
		
		if(m_instance == null) {
			m_instance = new PhysicsManager();
		}
		
		return m_instance;
		
	}
	
	public void setBox2DWorld(World world) {
		m_box2DWorld = world;
	}
	public World getBox2DWorld() {
		return m_box2DWorld;
	}
	public void box2DStep(float timeStep, int velocityIterations, int positionIterations) {
		m_box2DWorld.step(timeStep, velocityIterations, positionIterations);
	}
	
	public Body add(String name, Body physicsBody) {
		m_physicsBodys.put(name, physicsBody);
		
		return physicsBody;
	}
	public Body get(String name) {
		return m_physicsBodys.get(name);
	}
	
	/*public float worldtoBox2D(float value) {
		return value * m_worldToBox2D;
	}
	public float box2DToWorld(float value) {
		return value * m_box2DToWorld;
	}*/

	private static PhysicsManager m_instance;
	
	private World m_box2DWorld;
	
	private ObjectMap<String, Body> m_physicsBodys;
	
	private static float m_worldToBox2D = 0.01f;
	private static float m_box2DToWorld = 100.f;
}
