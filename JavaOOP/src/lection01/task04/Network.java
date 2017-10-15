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
		if (phones.size() == limitNumPhones) {
			System.out.println("[Network error] Limit of " + limitNumPhones + " is reached");
			return false;
		}

		if (phone.getSimNumber() == null || phone.getSimNumber().isEmpty()) {
			System.out.println("[Network error] Can't register phone without sim-card");
			return false;
		}

		if (phones.contains(phone)) {
			System.out.println("[Network error] phone " + phone + " is already registered");
			return false;
		}

		Phone testPhone = findPhone(phone.getSimNumber());
		if (testPhone != null) {
			System.out.println("[Network error] sim-card " + phone.getSimNumber() + " is already registered");
			return false;
		}
		phones.add(phone);

		return true;
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
