package fr.uds.info907.items;

import fr.uds.info907.view.LampView;

public class Lamp extends AbstractItem {
	
	
	public Lamp(){
		
	}

	public void run() {
		view = new LampView("lamp", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));	
		
	}

	@Override
	public void proceedComand(String comande) {
		String iconPath = this.getStateIcons().get(comande);
		if(iconPath!=null){
			this.view.changeImageIcon(this.getStateIcons().get(comande));
		}
		else{
			System.err.println("COMMANDE INVALIDE");
		}
	}

}