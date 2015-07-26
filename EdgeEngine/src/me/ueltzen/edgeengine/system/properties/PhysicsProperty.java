package me.ueltzen.edgeengine.system.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import me.ueltzen.edgeengine.system.GameObject;
import me.ueltzen.edgeengine.system.Property;

public class PhysicsProperty implements Property {

	public PhysicsProperty(Body body) {
		
		m_body = body;
		
	}
	
	public Body getBody() {
		return m_body;
	}
	
	public void setParent(GameObject parent) {
		m_parent = parent;
	}
	
	private GameObject m_parent;
	
	private Body m_body;
	
}
