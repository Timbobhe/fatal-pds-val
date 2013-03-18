package com.esiag.pds.messagegenerator.messagehelper;

import com.esiag.pds.datasource.DataSource;
import com.esiag.pds.messagegenerator.messages.MessageModel;

public class Simulateur implements MessageHelper{

	private String sourceDonne;
	private int posXRam;
	private int posYRam;
	private DataSource dataSource;
	public Simulateur() {
		dataSource = new DataSource();
	}
	
	
	public String getSourceDonne() {
		return sourceDonne;
	}


	public void setSourceDonne(String sourceDonne) {
		this.sourceDonne = sourceDonne;
	}


	public int getPosXRam() {
		return posXRam;
	}


	public void setPosXRam(int posXRam) {
		this.posXRam = posXRam;
	}


	public int getPosYRam() {
		return posYRam;
	}


	public void setPosYRam(int posYRam) {
		this.posYRam = posYRam;
	}


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public Simulateur(String sourceDonne, int posXRam, int posYRam) {
		super();
		this.sourceDonne = sourceDonne;
		this.posXRam = posXRam;
		this.posYRam = posYRam;
		dataSource = new DataSource();
	}


	public byte[] transformeMessageToByte(MessageModel message) {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageModel transformeByteToMessage(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}
	public String validateLenght(String s, int lenght){
		int j = lenght - s.length();
		String add = "";
		for(int i = 0; i < j; i++){
			add = add + "0";
		}
		return add + s;
	}
	public String generateData(){
		String posX = Integer.toBinaryString(posXRam);
		String posY = Integer.toBinaryString(posYRam);
		return validateLenght(posX, 5) + validateLenght(posY, 5);
	}
	public MessageModel generateStream() {
		MessageModel messageModel = new MessageModel();
		//recover source
		String source = dataSource.getSourcesEquipements().get(sourceDonne);
		messageModel.setSource(source);
		//recover idSource
		String idSource = dataSource.initializeIdSourceEquipement();
		messageModel.setIdSource(idSource);
		//recover capteur source
		String capteurSource = dataSource.getCapteursSouces().get("CapteurPositionTrain");
		messageModel.setCapteurSource(capteurSource);
		//recover iCapteurSource
		String idCapteurSource = dataSource.initializeIdCapteurSource();
		messageModel.setIdCapteurSource(idCapteurSource);
		//recover type
		String type = dataSource.getTypes().get("Position");
		messageModel.setType(type);
		//recover capteurIntelligent
		String capteurIntelligent = dataSource.getCapteurIntelligence().get("NonIntelligent");
		messageModel.setCapteurIntelligent(capteurIntelligent);
		
		messageModel.setData(generateData());
		return messageModel;
	}


	public byte[] transformeMessageToByte(Transformer messageModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
