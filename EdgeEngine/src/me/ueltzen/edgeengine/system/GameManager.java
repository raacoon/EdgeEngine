package me.ueltzen.edgeengine.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Keys;

public class GameManager {
	
	private GameManager() {
		
		m_layers = new ObjectMap<String, Layer>();
		
	}
	
	public static synchronized GameManager getInstance() {
		if(m_instance == null) {
			m_instance = new GameManager();
		}
		
		return m_instance;
	}
	
	public int createLayer(String layerName) {
		
		m_layers.put(layerName, new Layer());
		
		return m_layers.size-1;
		
	}
	
	public void add(String layerName, String key, GameObject value) {
		
		m_layers.get(layerName).add(key, value);
		
	}
	
	public GameObject get(String layerName, String key) {
		return m_layers.get(layerName).get(key);
	}
	
	public void updateLayer(String layerName, float delta) {
		
		m_layers.get(layerName).updateAll(delta);
		
	}
	
	public void drawLayer(String layerName, SpriteBatch batch) {
		
		m_layers.get(layerName).drawAll(batch);
		
	}
	
	public void dispose() {
		
		Keys<String> keys = m_layers.keys();
		for (String key : keys) {
			
			m_layers.get(key).dispose();
			m_layers.remove(key);
			
		}
		
	}
	
	private static GameManager m_instance;
	
	private World m_box2DWorld;
	
	private ObjectMap<String, Layer> m_layers;
	
}
