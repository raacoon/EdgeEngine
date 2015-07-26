package me.ueltzen.edgeengine.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Keys;

public class Layer {
	
	public Layer() {
		
		m_gameObjects = new ObjectMap<String, GameObject>();
		
	}
	
	public void add(String key, GameObject value) {
		m_gameObjects.put(key, value);
	}
	
	public GameObject get(String key) {
		return m_gameObjects.get(key);
	}
	
	public void updateAll(float delta) {
		
		Keys<String> keys = m_gameObjects.keys();
		for (String key : keys) {
			
			m_gameObjects.get(key).update(delta);
			
		}
		
	}
	
	public void drawAll(SpriteBatch batch) {
		
		Keys<String> keys = m_gameObjects.keys();
		for (String key : keys) {
			
			m_gameObjects.get(key).draw(batch);
			
		}
		
	}
	
	public void dispose() {
		
		Keys<String> keys = m_gameObjects.keys();
		for (String key : keys) {
			
			m_gameObjects.get(key).dispose();
			m_gameObjects.remove(key);
			
		}
		
	}
	
	private ObjectMap<String, GameObject> m_gameObjects;
	
}
