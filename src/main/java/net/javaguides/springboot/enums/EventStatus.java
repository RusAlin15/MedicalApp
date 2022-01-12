package net.javaguides.springboot.enums;

public enum EventStatus {
	OPEN("Open"), CLOSED("Closed");

	private String eventStatus;

	private EventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public static boolean isValid(String eventStatus) {
		for (EventStatus es : EventStatus.values()) {
			if (es.getEventStatus().equals(eventStatus)) {
				return true;
			}
		}
		return false;
	}
}
