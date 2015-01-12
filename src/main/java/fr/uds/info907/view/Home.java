package fr.uds.info907.view;

import java.util.Map;
import java.util.Map.Entry;

import fr.uds.info907.items.AbstractItem;
import fr.uds.info907.items.ItemFactory;

/**
 * Virtual home containing items (lamps, TV and stuff)
 * @author patrick-edouard
 *
 */
public class Home {

	private Map<String, AbstractItem> items;
	
	public Home(){
		setItems(ItemFactory.createItemFromXML("items.xml"));
		for(Entry<String, AbstractItem> entry : items.entrySet()){
			Thread t = new Thread(entry.getValue());
			t.start();
		}
	}

	public Map<String, AbstractItem> getItems() {
		return items;
	}

	public void setItems(Map<String, AbstractItem> items) {
		this.items = items;
	}
	
	public void proceedComande(String order){
		String itemName = order.substring(0, order.indexOf(" "));
		items.get(itemName).proceedComand(order.substring(itemName.length()+1, order.length()));
	}
}
