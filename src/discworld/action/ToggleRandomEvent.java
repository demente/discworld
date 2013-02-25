package discworld.action;

import discworld.dice.Dice;
import discworld.map.MapArea;
import discworld.model.minion.Minion;
import discworld.model.minion.MinionType;

public class ToggleRandomEvent implements Action {

	@Override
	public void toggleAction(ActionParameters params) {
		switch (params.getRandomEvent()) {
		case DRAGON:
			MapArea mapArea = params.getMapAreaByNumber(Dice.roll());
			mapArea.removeBuilding();
			mapArea.removeTroubleMarker();
			for(Minion m: mapArea.getMinions()){
				m.remove(mapArea);
			}
//			Roll the die to determine which area on the board will be hit 
//			by the dragon. Remove all minions (including demons and 
//			trolls), any trouble marker, and any building from the area 
//			affected.
			break;
		case FLOOD:
			MapArea mapArea1 = params.getMapAreaByNumber(Dice.roll());
			MapArea mapArea2 = params.getMapAreaByNumber(Dice.roll());
//			Roll the die twice to see which areas are affected by flood. 
//			Areas rolled that are adjacent to the river are affected by flood. 
//			In player order, starting with the active player, each player 
//			must move their minions from the affected areas to adjacent 
//			areas. You cannot move your minion to another area affected 
//			by flood. You can still move to an area adjacent to the river. 
//			Buildings, trolls, and demons remain in the areas and are not 
//			affected by flooding
			break;
		case FIRE:
			mapArea = params.getMapAreaByNumber(Dice.roll());
			if(mapArea.getBuilding()!=null){
				mapArea.removeBuilding();	
			}
			
//			Roll the die to establish the area of the fire. If there is no 
//			building in the rolled area then the random event ends 
//			without effect. If there is a building in the area then remove it 
//			from the board and roll the die again. If the next area rolled is 
//			adjacent to the previous area and there is a building in it then 
//			remove that building too (the fire has spread). You continue 
//			rolling in this manner until you roll an area that either does 
//			not contain a building or that is not adjacent to the last area 
//			you rolled.
			break;
		case FOG:
//			Draw and discard the top five cards from the draw pile. Make 
//			sure you and the rest of the players can see which cards have 
//			been discarded
			break;
		case RIOTS:
//			If there are eight or more trouble markers on the board then 
//			the game ends immediately. You now work out who has won 
//			by adding up points (see page 6). Please note that if a player 
//			is Commander Vimes then they do not win at this stage, 
//			although they may still win on points.
			break;
		case EXPLOSION:
//			Roll the die and remove any building in the area of the 
//			same number
			break;
		case MURDERS:
//			You roll one die and remove a minion of your choice from the 
//			area of the same number. You then pass the die to the player 
//			to your left, who rolls it and removes a minion of their choice 
//			from the area of the same number. Repeat this procedure until 
//			all players have rolled the die once. If you roll an area and only 
//			you have minions there then you must remove one of them.
			break;
		case DEMONS:
//			Roll the die four times and place one demon minion piece in 
//			each of the areas matching the numbers rolled. More than one 
//			demon can end up in an area. If there is not a trouble marker 
//			in the area that a demon is placed in then place such a marker, 
//			even if there is no other minion in the area. While there are 
//			one or more demons in an area the power on the City Area 
//			card cannot be used and any building there has a value of zero. 
//			The area also cannot be controlled by any player nor does it 
//			count as an occupied area for Vetinari. If an area still has one 
//			or more demons in it at the end of the game then nobody 
//			scores any points for minions or buildings there. Demons 
//			can be moved or removed from the board in the same way 
//			as minions.
			break;
		case SUBSIDENCE:
//			All players must pay $2 for each building they have on the 
//			board. If they cannot pay for a building then it is removed 
//			from the board
			break;
		case STUPIDJOHNSON:
//			Roll the die. If the City Area Card of the same number is 
//			in play then it is set to one side and is no longer in the game, 
//			i.e. the power on the card is not in effect. Also, the owner 
//			of the card must remove one minion from the same area as 
//			the card. The building still counts towards control of the 
//			area and retains its monetary value at the end of the game.
			break;
		case TROLLS:
			for(int i=0;i<3;i++){
				mapArea = params.getMapAreaByNumber(Dice.roll());
				mapArea.getMinions().add(new Minion(MinionType.TROLL));
				}
//			Roll the die three times and place one troll piece in each 
//			area of the same number. More than one troll can end up 
//			in an area. Remember to place a trouble marker if there 
//			is already one or more minions in the area. Trolls are like 
//			minions, except they do not belong to any player. They affect 
//			your ability to control an area, in that you must treat them as 
//			belonging to �another player�. You can move or remove them 
//			from the board in the same way as a minion.
			break;
		case EARTHQUAKE:
			for(int i=0;i<2;i++){
			mapArea = params.getMapAreaByNumber(Dice.roll());
			mapArea.removeBuilding();
			}
//			Roll the die twice and remove any buildings from the areas 
//			of the same number, if any.
			break;
		}
	}

}
