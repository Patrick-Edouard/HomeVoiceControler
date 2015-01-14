package fr.uds.info907.items;

import fr.uds.info907.view.GenericItemView;

public class Tv extends AbstractItem{
	
public Tv(){
		
	}

	public void run() {
		view = new GenericItemView("TV", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));	
		
	}

	@Override
	public void proceedComand(String command) {
		String iconPath = this.getStateIcons().get(command);
		if(iconPath!=null){
			this.view.changeImageIcon(this.getStateIcons().get(command));
		}
		else{
			System.err.println("COMMANDE INVALIDE");
		}
	}

}
