package lection01.task04;

public class Phone {
	private String model;
	private String simNumber;
	private boolean on;
	private Network registeredToNetowrk;

	public Phone(String model, String simNumber) {
		super();
		this.model = model;
		this.simNumber = simNumber;
	}

	public Phone() {
		super();
	}

	public void registerToNetwork(Network network) {
		if (network.registerNewPhone(this)) {
			registeredToNetowrk = network;
		}
	}

	public void call(String simNumber) {
		if (isOn()) {
			if (registeredToNetowrk != null) {
				System.out.println(this.getSimNumber() + " Calling to " + simNumber);
				registeredToNetowrk.makeCall(this, simNumber);
			} else {
				System.out.println("Can't call from unregistered phone");
			}
		}
	}

	public boolean acceptCall(Phone phone) {
		boolean result = false;

		if (isOn()) {
			System.out.println(this.getSimNumber() + " Accepting call from " + phone.getSimNumber());
			result = true;
		}

		return result;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Phone [model=" + model + ", simNumber=" + simNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((simNumber == null) ? 0 : simNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (simNumber == null) {
			if (other.simNumber != null)
				return false;
		} else if (!simNumber.equals(other.simNumber))
			return false;
		return true;
	}

}
