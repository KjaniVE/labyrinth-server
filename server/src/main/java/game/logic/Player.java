package game.logic;

import game.web.LabyrinthUser;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final LabyrinthUser user;
    private final Set<Treasure> treasuresFound = new HashSet<>();
    private PlayerStatus state = PlayerStatus.WAITING;
    private Treasure objective;

    public Player(LabyrinthUser user) {
        this.user = user;
    }

    public LabyrinthUser getUser() {
        return user;
    }

    public Set<Treasure> getTreasuresFound() {
        return treasuresFound;
    }

    public PlayerStatus getState() {
        return state;
    }

    public void setState(PlayerStatus state) {
        this.state = state;
    }

    public Treasure getObjective() {
        return objective;
    }

    public void setObjective(Treasure objective) {
        this.objective = objective;
    }
}
