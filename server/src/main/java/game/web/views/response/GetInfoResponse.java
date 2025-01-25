package game.web.views.response;

import game.logic.Info;

@SuppressWarnings("unused")
public class GetInfoResponse extends ResponseWithHiddenStatus {

    public GetInfoResponse() {
        super(200);
    }

    public String getVersion(){
        return Info.getVersion();
    }

    public String getAuthor(){
        return Info.getAuthor();
    }
}
