package discworld.model.player;

import java.util.List;

public enum Personality {
	VETINARI("Lord Vetinari"), SELACHII("Lord Selachii"), RUST("Lord Rust"), WORDE(
			"Lord de Worde"), DRAGONKING("Dragon King of Arms"), CHRYSOPRASE(
			"Chrysoprase"), VIMES("Commander Vimes");

	private String name;

	private Personality(String name) {
		this.name = name;
	}

	public static Personality getRandomPersonality(List<Personality> inUse) {
		Personality[] personalities = Personality.values();
		int n = (int) (Math.random() * personalities.length);
		if (!inUse.contains(personalities[n])) {
			return personalities[n];
		} else {
			return getRandomPersonality(inUse);
		}
	}
}
