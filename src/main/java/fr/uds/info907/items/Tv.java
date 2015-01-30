package fr.uds.info907.items;

import fr.uds.info907.view.GenericItemView;

public class Tv extends AbstractItem{
	
	private String current_state = "off";
	
public Tv(){
		
	}

	public void run() {
		view = new GenericItemView("TV", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));	
		
	}

	@Override
	public void proceedComand(String command) {
		String iconPath = this.getStateIcons().get(command);
		if(command.startsWith("switch")){
			if(command.startsWith("on","switch ".length()) || command.startsWith("off","switch ".length())){
				this.changeCurrentState();
			}
			System.out.println("[TV]"+this.getStateIcons().get(command));
			this.view.changeImageIcon(this.getStateIcons().get(command));
		}
		else{
			System.err.println("COMMANDE INVALIDE");
		}
	}

	private void changeCurrentState(){
		if(getCurrentSate().equals("off")){
			this.setCurrentState("on");
		}
		else if(getCurrentSate().equals("on")){
			this.setCurrentState("off");
		}
	}

	public String getCurrentSate() {
		return this.current_state;
	}

	public void setCurrentState(String current_state) {
		this.current_state = current_state;
	}
}
