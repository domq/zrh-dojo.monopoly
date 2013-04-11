package com.google.dojo.monopoly;

public class MonopolyProperty {
	
	MonopolyPlayer owner;

	public void setOwner(MonopolyPlayer newOwner) {
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
	}
}
