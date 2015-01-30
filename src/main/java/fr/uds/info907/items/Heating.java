package fr.uds.info907.items;

import fr.uds.info907.view.GenericItemView;

public class Heating extends AbstractItem{
	
	private int tempMax = 40;
	private int tempMin = 0;
	private int tempMoy = 20;
	
public Heating(){
		
	}

	public void run() {
		view = new GenericItemView("Heating", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));	
		
	}

	@Override
	public void proceedComand(String command) {
		String iconPath = this.getStateIcons().get(command);
		if(command.startsWith("heating")){
			if(command.startsWith("up","heating ".length())){
				this.tempUp();
			}
			else if(command.startsWith("down","heating ".length())){
				this.tempDown();
			}
			System.out.println("[Heating]"+this.getStateIcons().get(command));
			this.view.changeImageIcon(this.getStateIcons().get(command).replaceFirst("x", tempMoy+""));
		}
		else{
			System.err.println("COMMANDE INVALIDE");
			return;
		}
	}
	
	private void tempUp(){
		if(getTempMax()>=tempMoy){
			tempMoy = tempMoy + 5;
		}
	}
	
	private void tempDown(){
		if(getTempMin()<=tempMoy){
			tempMoy = tempMoy - 5;
		}
	}

	public int getTempMin() {
		return tempMin;
	}

	public void setTempMin(int volumeMin) {
		this.tempMin = volumeMin;
	}

	public int getTempMax() {
		return tempMax;
	}

	public void setTempMax(int volumeMax) {
		this.tempMax = volumeMax;
	}

}
