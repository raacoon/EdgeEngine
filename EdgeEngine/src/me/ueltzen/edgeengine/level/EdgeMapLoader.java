package me.ueltzen.edgeengine.level;

import com.google.gson.Gson;

public class EdgeMapLoader {
	
	protected EdgeMapLoader() {
		
		m_gson = new Gson();
		
	}
	
	public static synchronized EdgeMapLoader getInstance() {
		
		if(m_instance == null) {
			m_instance = new EdgeMapLoader();
		}
		
		return m_instance;
		
	}
	
	
	private static EdgeMapLoader m_instance;
	
	private Gson m_gson;
	
}
