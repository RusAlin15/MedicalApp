package net.javaguides.springboot.enums;

public enum DiseaseStatus {
	ACUTA("Afectiune Acuta"), ACCIDENT("Accident"), PUSEU_CRONIC("Puseu Acut al Unei Boli Cronice"),
	PUSEU_EXISTENT("Puseu Acut al Unei Afectiuni PreExistente"), MONITORIZARE("Monitorizare Boala Cronica");

	private String deseaseStatus;

	private DiseaseStatus(String deseaseStatus) {
		this.deseaseStatus = deseaseStatus;
	}

	public String getDeseaseStatus() {
		return deseaseStatus;
	}

	public void setDeseaseStatus(String deseaseStatus) {
		this.deseaseStatus = deseaseStatus;
	}

	public static boolean isValid(String deseaseStatus) {
		for (DiseaseStatus ds : DiseaseStatus.values()) {
			if (ds.getDeseaseStatus().equals(deseaseStatus)) {
				return true;
			}
		}
		return false;
	}

}
