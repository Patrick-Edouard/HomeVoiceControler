package fr.uds.info907.items;

import fr.uds.info907.view.LampView;

public class Lamp extends AbstractItem {
	
	private String current_state = "off";
	
	public Lamp(){
		
	}

	public void run() {
		view = new LampView("lamp", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));
		
	}

	@Override
	public void proceedComand(String command) {
		String iconPath = this.getStateIcons().get(command);
		if(command.startsWith("switch")){
			if(command.startsWith("on","switch ".length()) || command.startsWith("off","switch ".length())){
				this.changeCurrentState();
			}
			System.out.println("[Lamp]"+this.getStateIcons().get(command));
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
