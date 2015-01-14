package fr.uds.info907.items;

import fr.uds.info907.view.GenericItemView;


public class Speaker extends AbstractItem{
	
public Speaker(){
		
	}

	public void run() {
		view = new GenericItemView("Speaker", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));	
		
	}

	@Override
	public void proceedComand(String command) {
		String iconPath = this.getStateIcons().get(command);
		if(iconPath!=null){
			//logique pour interagir avec des order (par rapport à la commande)
 			this.view.changeImageIcon(this.getStateIcons().get(command));
		}
		else{
			System.err.println("COMMANDE INVALIDE");
		}
	}

}
