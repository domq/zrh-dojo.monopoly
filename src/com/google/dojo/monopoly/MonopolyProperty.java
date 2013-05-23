package com.google.dojo.monopoly;

public class MonopolyProperty {
	
	private MonopolyPlayer owner;
	private int propertyValue;

	public MonopolyProperty(int value) {
		propertyValue = value;
	}

	public MonopolyProperty() {
		propertyValue = 200;
	}

	void setOwner(MonopolyPlayer newOwner) {
		owner = newOwner;
	}

	public Object getOwner() {
		return owner;
	}

	public Boolean isForSale() {
		if (getOwner() == null) {
			return true;
		} else {
			return false;
		}
	}

	public void sellFromBank(MonopolyPlayer buyer) {
		// Only allowed if no owner:
		if (! isForSale()) {
			throw new ForbiddenSaleException("Cannot sell, already taken");
		}
		owner = buyer;
		buyer.chargeMoney(propertyValue);
	}

	public int getValue() {
		return propertyValue;
	}
}
