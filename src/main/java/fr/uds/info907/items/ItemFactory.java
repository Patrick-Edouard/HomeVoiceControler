package fr.uds.info907.items;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ItemFactory {
	
	public static Map<String, AbstractItem> createItemFromXML(String xmlPath){
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlPath);
		
		Map<String, AbstractItem> items = new HashMap<String, AbstractItem>();

		try {
			Element root = saxBuilder.build(inputStream).getRootElement();
			
			//Parcourir l'arbre xml pour instancier des Items
			
			for(Element xmlItem : root.getChild("items").getChildren("item")){
				//xmlItems.getChild(childName).getValue()
				//xmlItems.getAttribute(attributName)
				
				Map<String, String> states = new HashMap<String, String>();
				
				for(Element xmlAction : xmlItem.getChildren("actions")){					
					states.put(xmlAction.getAttributeValue("order"), xmlAction.getAttributeValue("link"));
				}
				
				
				if(xmlItem.getAttribute("stuff").getValue() == "Lamp")
				{
					AbstractItem lamp = new Lamp();
					lamp.setStateIcons(states);
					lamp.setName(xmlItem.getAttributeValue("name"));
					items.put(lamp.getName(), lamp);
				}
				
				
				if(xmlItem.getAttribute("stuff").getValue() == "Speaker")
				{
					AbstractItem speaker = new Speaker();
					speaker.setStateIcons(states);
					speaker.setName(xmlItem.getAttributeValue("name"));
					items.put(speaker.getName(), speaker);
				}
				
				if(xmlItem.getAttribute("stuff").getValue() == "Tv")
				{
					AbstractItem tv = new Tv();
					tv.setStateIcons(states);
					tv.setName(xmlItem.getAttributeValue("name"));
					items.put(tv.getName(), tv);
				}
				
				if(xmlItem.getAttribute("stuff").getValue() == "Heating")
				{
					AbstractItem heat = new Heating();
					heat.setStateIcons(states);
					heat.setName(xmlItem.getAttributeValue("name"));
					items.put(heat.getName(), heat);
				}
				
				
				

				//System.out.println(xmlItem.getAttributeValue("name"));
				//System.out.println();
				
				
			}
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Mauvais flux (retourne une liste vide ?)
			e.printStackTrace();
		}
		
		// parse le fichier xml et créer des objets
		
		// objects d'exemple
		/*
				Map<String, String> states = new HashMap<String, String>();
				states.put("on", "32x32/emotes/face-surprise.png");
				states.put("off", "32x32/emotes/face-tired.png");
				states.put("default", "32x32/emotes/face-tired.png");
				AbstractItem lamp = new Lamp();
				lamp.setStateIcons(states);
				lamp.setName("lamp1");
				Map<String, AbstractItem> items = new HashMap<String,AbstractItem>();
				items.put(lamp.getName(),lamp);
				
		*/

		return items;
	}
}
