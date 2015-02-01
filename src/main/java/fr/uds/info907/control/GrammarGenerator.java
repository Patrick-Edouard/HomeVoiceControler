package fr.uds.info907.control;

import java.util.Map;
import java.util.Map.Entry;

import fr.uds.info907.items.AbstractItem;
import fr.uds.info907.items.ItemFactory;

public class GrammarGenerator {

	public static void main(String[] args){
		Map<String, AbstractItem> items = ItemFactory.createItemFromXML("items.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("#JSGF V1.0;\n"+
				"/**\n"+
				" * JSGF Grammar for Hello World example\n"+
				" */\n"+
				"grammar hello;\n");
		/*
		sb.append("(");
		for(Entry<String, AbstractItem> item : items.entrySet()){
			sb.append(item.getKey());
			sb.append(" | ");
		}
		sb.setLength(sb.length()-2);
		sb.append(") ( ");
		
		for(Entry<String, AbstractItem> item : items.entrySet()){
			for(Entry<String, String> order : (item.getValue()).getStateIcons().entrySet()){
				sb.append(order.getKey());
				sb.append(" | ");
			}
			sb.setLength(sb.length()-2);
		}
		
		sb.append(");");
		*/
		
		
		for(Entry<String, AbstractItem> item : items.entrySet()){
			sb.append("public <"+item.getValue().getName()+"> = ( "+item.getValue().getName()+" ) ( ");
			for(Entry<String, String> order : (item.getValue()).getStateIcons().entrySet()){
				sb.append(order.getKey());
				sb.append(" | ");
			}
			sb.setLength(sb.length()-2);
			sb.append(");\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
