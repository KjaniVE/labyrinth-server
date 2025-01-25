package game.web;

import game.logic.LabyrinthService;
import game.logic.LabyrinthServiceImpl;
import game.web.tokens.PlainTextTokens;
import game.web.tokens.TokenManager;
import game.web.views.request.*;
import game.web.views.response.*;
import io.vertx.ext.web.handler.BearerAuthHandler;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LabyrinthOpenApiBridge extends OpenApiBridge { // NOSONAR this is not a monster class, it is a bridge :-)

    private static final Logger LOGGER = Logger.getLogger(LabyrinthOpenApiBridge.class.getName());

    private final TokenManager tokenManager;
    private final LabyrinthService service;

    public LabyrinthOpenApiBridge() {
        this(new LabyrinthServiceImpl(), new PlainTextTokens());
    }

    LabyrinthOpenApiBridge(LabyrinthService service, TokenManager tokenManager) {
        setSecurityHandlers(Map.ofEntries(
                Map.entry("playerToken", BearerAuthHandler.create(tokenManager)))
        );

        this.service = service;
        this.tokenManager = tokenManager;

        if (this.tokenManager == null || this.service == null) {
            LOGGER.log(Level.SEVERE, "TokenManager and LabyrinthService are not provided ...");
        }
    }


    @Operation("get-info")
    public ResponseWithHiddenStatus getInfo(GetInfoRequest ctx) {
        LOGGER.log(Level.INFO, "In request handler of: get-info");
        return new GetInfoResponse();
    }

    @Operation("get-treasures")
    public ResponseWithHiddenStatus getTreasures(GetTreasuresRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: get-treasures");
        return new GetTreasuresResponse(service.getTreasures());
    }


    @Operation("get-games")
    public ResponseWithHiddenStatus getGames(GetGamesRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: get-games");
        return new GetGamesResponse(service.getGames(request.isAccepting()));
    }


    @Operation("create-game")
    public ResponseWithHiddenStatus createGame(CreateGameRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: create-game");
        service.createGame(request.getGameId(), request.getPlayer(), request.getMaximumPlayers());

        return new CreateGameResponse(request.getGameId().toString(), tokenManager.createToken(request.getPlayer().getUser()), request.getPlayer().getUser().getPlayerName().toString());
    }

    @Operation("delete-games")
    public ResponseWithHiddenStatus deleteGames(DeleteGamesRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: delete-games");
        return new MessageResponse(501, "NYI: delete-games");
    }

    @Operation("get-game-details")
    public ResponseWithHiddenStatus sendGetGameDetailsResponse(GetGameDetailsRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: get-game-details");
        return new MessageResponse(501, "NYI: get-game-details");
    }


    @Operation("shove-tile")
    public ResponseWithHiddenStatus shoveTile(ShoveTileRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: shove-tile");
        return new MessageResponse(501, "NYI: shove-tile");
    }

    @Operation("get-reachable-locations")
    public ResponseWithHiddenStatus getReachableLocations(GetReachableLocationsRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: get-reachable-locations");
        return new MessageResponse(501, "NYI: get-reachable-locations");
    }

    @Operation("get-player-details")
    public ResponseWithHiddenStatus getPlayerDetails(GetPlayerDetailsRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: get-player-details");
        return new MessageResponse(501, "NYI: get-player-details");
    }

    @Operation("join-game")
    public ResponseWithHiddenStatus joinGame(JoinGameRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: join-game");
        return new MessageResponse(501, "NYI: join-game");
    }

    @Operation("leave-game")
    public ResponseWithHiddenStatus leaveGame(LeaveGameRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: leave-game");
        return new MessageResponse(501, "NYI: leave-game");
    }

    @Operation("move-player")
    public ResponseWithHiddenStatus movePlayer(MovePlayerRequest request) {
        LOGGER.log(Level.INFO, "In request handler of: move-player");
        return new MessageResponse(501, "NYI: move-player");
    }


}
