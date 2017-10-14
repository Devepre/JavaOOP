package lection01.task04;

import java.util.ArrayList;

public class Network {
	private final int limitNumPhones = 10;
	private String name;
	private ArrayList<Phone> phones = new ArrayList<>(limitNumPhones);

	public Network(String name) {
		super();
		this.name = name;
	}

	public Network() {
		super();
	}

	public boolean registerNewPhone(Phone phone) {
		boolean result = false;

		if (phones.size() < limitNumPhones) {
			if (phone.getSimNumber() != null && !phone.getSimNumber().isEmpty()) {
				Phone test = findPhone(phone.getSimNumber());
				if (test == null) {
					phones.add(phone);
					result = true;					
				} else {
					System.out.println("[Network error] sim-card " + phone.getSimNumber() + " is already registered");
				}
			} else {
				System.out.println("[Network error] Can't register phone without sim-card");				
			}
		} else {
			System.out.println("[Network error] Limit of " + limitNumPhones + " is reached");			
		}

		return result;
	}

	public void makeCall(Phone phone, String simNumber) {
		Phone recieverPhone = findPhone(simNumber);
		if (recieverPhone != null) {
			if (!phone.getSimNumber().equals(simNumber)) {
				recieverPhone.acceptCall(phone);
			} else {
				System.out.println("[Network error] Can't call to itself");
			}
		} else {
			System.out.println("[Network issue] Error. Can't find " + simNumber + " registered");
		}
	}

	private Phone findPhone(String simNumber) {
		Phone foundPhone = null;
		for (Phone phone : phones) {
			if (phone.getSimNumber().equals(simNumber)) {
				foundPhone = phone;
				break;
			}
		}
		return foundPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Network [limitNumPhones=" + limitNumPhones + ", name=" + name + ", phones=" + phones + "]";
	}

}
