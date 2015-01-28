package fr.uds.info907.items;

import fr.uds.info907.view.GenericItemView;


public class Speaker extends AbstractItem{
	
	private int volumeMax =0;
	private int volumeMin=0;
	private int volumeCourant=0;
	
	public Speaker(){
		
	}

	public void run() {
		view = new GenericItemView("Speaker", this.getStateIcons().get(AbstractItem.DEFAULT_STATE));	
		
	}

	@Override
	public void proceedComand(String command) {
		String iconPath = this.getStateIcons().get(command);
		//logique pour interagir avec des order (par rapport � la commande)
		
		if(command.startsWith("volume")){
			if(command.startsWith("up","volume ".length())){
				this.volumeUp();
			}
			else if(command.startsWith("down","volume ".length())){
				this.volumeDown();
			}
			System.out.println("[coucou]"+this.getStateIcons().get(command));
			this.view.changeImageIcon(this.getStateIcons().get(command).replaceFirst("x", volumeCourant+""));
		}
		else{
			System.err.println("COMMANDE INVALIDE");
			return;
		}
	}
	
	private void volumeUp(){
		if(getVolumeMax()>=volumeCourant){
			++volumeCourant;
		}
	}
	
	private void volumeDown(){
		if(getVolumeMin()<=volumeCourant){
			--volumeCourant;
		}
	}

	public int getVolumeMin() {
		return volumeMin;
	}

	public void setVolumeMin(int volumeMin) {
		this.volumeMin = volumeMin;
	}

	public int getVolumeMax() {
		return volumeMax;
	}

	public void setVolumeMax(int volumeMax) {
		this.volumeMax = volumeMax;
	}

}
