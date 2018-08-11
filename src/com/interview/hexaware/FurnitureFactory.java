package com.interview.hexaware;

interface Furniture {
	public int getIgnitionPoint();
}

interface Material {
	final Material STEEL = new Steel();
	final Material OAK = new Oak();

	int getIgnitionPoint();
}

class Steel implements Material {
	private final int STEEL_IGNITION_POINT = 1500;

	@Override
	public int getIgnitionPoint() {
		return STEEL_IGNITION_POINT;
	}
}

class Oak implements Material {
	private final int OAK_IGNITION_POINT = 900;

	@Override
	public int getIgnitionPoint() {
		return OAK_IGNITION_POINT;
	}
}

class Desk implements Furniture {
	private final Material material;

	public Desk(Material material) {
		this.material = material;
	}

	@Override
	public int getIgnitionPoint() {
		return material.getIgnitionPoint();
	}
}

class Chair implements Furniture {
	private final Material material;

	public Chair(Material material) {
		this.material = material;
	}

	@Override
	public int getIgnitionPoint() {
		return material.getIgnitionPoint();
	}
}

public class FurnitureFactory {
	public Furniture createChair(Material material) {
		return new Chair(material);
	}

	public Furniture createDesk(Material material) {
		return new Desk(material);
	}

	public static void main(String[] args) {
		FurnitureFactory factory = new FurnitureFactory();
		Furniture desk = factory.createDesk(Material.STEEL);
		int ignitionPoint = desk.getIgnitionPoint();
		System.out.println("ignitionPoint = " + ignitionPoint);

	}
}
