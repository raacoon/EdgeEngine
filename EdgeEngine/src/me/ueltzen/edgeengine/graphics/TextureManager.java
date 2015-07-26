package me.ueltzen.edgeengine.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Keys;

public class TextureManager {
	
	public TextureManager() {
		
		m_textures = new ObjectMap<String, Texture>();
		
	}

	public static TextureManager getInstance() {
		if(m_Instance == null) {
			m_Instance = new TextureManager();
		}
		
		return m_Instance;
	}
	
	public void loadTexture(String key, String filepath) {
		
		Texture value = new Texture(Gdx.files.internal(filepath));
		
		m_textures.put(key, value);
		
	}
	
	public void disposeTeture(String key) {
		
		m_textures.get(key).dispose();
		m_textures.remove(key);
		
	}
	
	public Texture getTexture(String key) {
		
		return m_textures.get(key);
		
	}
	
	public void dispose() {
		
		Keys<String> keys = m_textures.keys();
		for (String key : keys) {
			
			m_textures.get(key).dispose();
			m_textures.remove(key);
			
		}
		
	}
	
	private static TextureManager m_Instance;
	
	private ObjectMap<String, Texture> m_textures;
	
}
