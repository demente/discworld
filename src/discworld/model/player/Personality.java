package discworld.model.player;

public enum Personality {
	VETINARI("Lord Vetinari"),
	SELACHII("Lord Selachii"),
	RUST("Lord Rust"),
	WORDE("Lord de Worde"),
	DRAGONKING("Dragon King of Arms"),
	CHRYSOPRASE("Chrysoprase"),
	VIMES("Commander Vimes");

	private String name;
	
	private Personality(String name){
		this.name = name;
	}
	
}
