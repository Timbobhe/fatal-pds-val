package com.esiag.pds.messagegenerator.equipement;

public class Equipement {
	private String idEquipement;
	private String nameEquipement;
	
	public Equipement() {
		// TODO Auto-generated constructor stub
	}

	public Equipement(String idEquipement, String nameEquipement) {
		super();
		this.idEquipement = idEquipement;
		this.nameEquipement = nameEquipement;
	}

	public String getIdEquipement() {
		return idEquipement;
	}

	public void setIdEquipement(String idEquipement) {
		this.idEquipement = idEquipement;
	}

	public String getNameEquipement() {
		return nameEquipement;
	}

	public void setNameEquipement(String nameEquipement) {
		this.nameEquipement = nameEquipement;
	}

	@Override
	public String toString() {
		return "Equipement [idEquipement=" + idEquipement + ", nameEquipement="
				+ nameEquipement + "]";
	}
	
}
