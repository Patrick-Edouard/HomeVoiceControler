package fr.uds.info907.items;

import java.util.Map;

import fr.uds.info907.view.AbstractItemView;

public abstract class AbstractItem implements Runnable{

	public static final String DEFAULT_STATE = "default";
	private Map<String, String> stateIcons;
	protected AbstractItemView view;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract void proceedComand(String comande);
	
	public Map<String, String> getStateIcons() {
		return stateIcons;
	}
	public void setStateIcons(Map<String, String> stateIcons) {
		this.stateIcons = stateIcons;
	}
	
}
