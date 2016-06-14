package taller2.match_client;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/* Proxy Class that contain and manage a MatchManager class */
public class MatchManagerProxy implements MatchManagerInterface {
    private static final MatchManagerProxy matchManagerProxy = new MatchManagerProxy();
    private MatchManager matchManager;

    /* Return an instance */
    public static MatchManagerProxy getInstance() {
        return matchManagerProxy;
    }

    /* Initialize */
    public void initialize(String userEmail, Context context) {
        matchManager = new MatchManager(userEmail, context);
    }

    /* Add match */
    public void addMatch(JSONObject matchData) throws JSONException {
        matchManager.addMatch(matchData);
    }

    /* Add a conversation with some match */
    public boolean addConversation(JSONObject completeConversation) {
        return matchManager.addConversation(completeConversation);
    }

    /* Return the match list. */
    public List<JSONObject> getMatches() {
        return matchManager.getMatches();
    }

    /* Return match */
    public JSONObject getMatch(String matchEmail) {
        return matchManager.getMatch(matchEmail);
    }

    /* Return chat conversation of match */
    public ChatConversation getConversation(String matchEmail) {
        return matchManager.getConversation(matchEmail);
    }

    /* Return Match List */
    public MatchList getMatchList() {
        return matchManager.getMatchList();
    }

    /* Return User Email */
    public String getEmail() {
        return matchManager.getEmail();
    }
}