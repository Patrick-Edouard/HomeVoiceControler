package fr.uds.info907.view;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class AbstractItemView extends JDialog{

	private static final long serialVersionUID = 6923897570573385201L;
	private static final String defaultImage = "image-not-found.png";
	
	private String name;
	private String iconPath;
	
	protected AbstractItemView(String name, String iconPath) {
		super();
		this.name=name;
		this.iconPath=iconPath;
		this.initialize();
	}
	
	private void initialize(){
		this.setTitle(this.name);
		this.getContentPane().add(new JLabel(this.getIcon()));
		this.pack();
		this.setVisible(true);
	}
	
	public void changeImageIcon(String newImageIcon){
		this.setIconPath(newImageIcon);
		this.getContentPane().removeAll();
		this.getContentPane().add(new JLabel(this.getIcon()));
		this.repaint();
		this.pack();
	}
	
	private void setIconPath(String iconPath){
		if(iconPath!=null){
			this.iconPath = iconPath;
		}
		else{
			this.iconPath = defaultImage;
		}
	}
	
	private ImageIcon getIcon(){
		InputStream image = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.iconPath);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(image);
			} catch (Exception e) {
				image = Thread.currentThread().getContextClassLoader().getResourceAsStream(AbstractItemView.defaultImage);
				try {
					bufferedImage = ImageIO.read(image);
				} catch (IOException e1) {
					// N'est pas sencé foiré avec une image par défault
					e1.printStackTrace();
				}
			}
		return new ImageIcon(bufferedImage);
	}
}
