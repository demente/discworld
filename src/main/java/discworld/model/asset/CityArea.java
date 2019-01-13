package discworld.model.asset;

import discworld.model.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityArea {

    private CityAreaName name;
    private Integer buildingPrice;
    private boolean nextToTheRiver;
    private List<CityArea> adjacentAreas = new ArrayList<>();
    private Object effect;

    //a way to distinguish between player with the house and the owner of the card?
    private Building building;
    private Player owner;

    private List<Minion> minions = new ArrayList<>();
    private boolean troubleMarker;

    public CityArea(CityAreaName name, Integer buildingPrice, boolean nextToTheRiver) {
        this.name = name;
        this.buildingPrice = buildingPrice;
        this.nextToTheRiver = nextToTheRiver;
    }

    public CityArea(CityAreaName name, Integer buildingPrice) {
        this(name, buildingPrice, true);
    }

    public List<CityArea> getAdjacentAreas() {
        return Collections.unmodifiableList(adjacentAreas);
    }

    public void setAdjacentAreas(List<CityArea> adjacentAreas) {
        this.adjacentAreas = adjacentAreas;
    }

    public CityAreaName getName() {
        return name;
    }

    public boolean hasTroubleMarker() {
        return troubleMarker;
    }

    public void setTroubleMarker(boolean troubleMarker) {
        this.troubleMarker = troubleMarker;
    }

    public List<Minion> getMinions() {
        return Collections.unmodifiableList(minions);
    }

    public void setMinions(List<Minion> minions) {
        this.minions = minions;
    }

    public List<PlayerMinion> getPlayerMinions() {
        return getMinions().stream().filter(minion -> minion instanceof PlayerMinion)
                .map(minion -> (PlayerMinion) minion).collect(Collectors.toList());
    }

    public void addMinion(Minion e) {
        if (getMinions().size() > 0) {
            setTroubleMarker(true);
        }

        minions.add(e);
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public boolean hasDemons() {
        return minions.stream().anyMatch(minion -> minion instanceof Demon);
    }

    public Integer getTrollsAmount() {
        return minions.stream().filter(minion -> minion instanceof Troll).collect(Collectors.toList()).size();
    }

    public Player getControllingPlayer() {
        if (hasDemons()) {
            return null;
        }

        Map<Player, Long> playerMinions = getPlayerMinionsCount();

        Long maxMinions = Collections.max(playerMinions.values());

        if (maxMinions <= getTrollsAmount()) {
            return null;
        }

        List<Player> playerWithMostMinions = playerMinions.entrySet().stream()
                .filter(entry -> entry.getValue() == maxMinions)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        return playerWithMostMinions.size() > 1 ? null : playerWithMostMinions.get(0);
    }

    private Map<Player, Long> getPlayerMinionsCount() {
        Map<Player, Long> playerMinions = getPlayerMinions().stream().collect(Collectors.groupingBy(minion -> minion.getOwner(), Collectors.counting()));
        if (building != null && building.getOwner() != null) {
            playerMinions.put(building.getOwner(), playerMinions.get(building.getOwner()) + 1);
        }
        return playerMinions;
    }
}
