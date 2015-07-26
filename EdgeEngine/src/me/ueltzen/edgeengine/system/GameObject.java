package me.ueltzen.edgeengine.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ObjectMap;

public abstract class GameObject {
	
	public GameObject(float x, float y, float width, float height) {
		
		m_bounds = new Rectangle(x, y, width, height);
		m_attachedProperties = new ObjectMap<String, Property>();
		
	}
	
	abstract public void update(float delta);
	
	abstract public void draw(SpriteBatch batch);
	
	abstract public void dispose();
	
	public void setBounds(Rectangle bounds) {
		bounds.set(bounds);
	}
	public void setX(float x) {
		m_bounds.setX(x);
	}
	public void setY(float y) {
		m_bounds.setY(y);
	}
	public void setWidth(float width) {
		m_bounds.setWidth(width);
	}
	public void setHeight(float height) {
		m_bounds.setHeight(height);
	}
	
	public Rectangle getBounds() {
		return m_bounds;
	}
	public float getX() {
		return m_bounds.getX();
	}
	public float getY() {
		return m_bounds.getY();
	}
	public float getWidth() {
		return m_bounds.getWidth();
	}
	public float getHeight() {
		return m_bounds.getHeight();
	}
	
	public void attach(String name, Property property) {
		m_attachedProperties.put(name, property);
	}
	public void detach(String name) {
		m_attachedProperties.remove(name);
	}
	public Property getAttachedProperty(String name) {
		return m_attachedProperties.get(name);
	}
	
	private Rectangle m_bounds;
	
	private ObjectMap<String, Property> m_attachedProperties;

}
