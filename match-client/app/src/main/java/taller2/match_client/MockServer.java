package taller2.match_client;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* This class represent the Aplication Server. Its a test class  */
public class MockServer {
    /* Attributes */
    private Context context;
    private HashMap<String, JSONObject> matches;
    private ArrayList<JSONObject> possibleMatches;

    public MockServer(Context context) {
        this.context = context;
        createMatchList();
        createPossibleMatchList();
    }

    private void createMatchList() {
        /*** MATCHES ***/
        matches = new HashMap<String, JSONObject>();
        try {
            // Interests
            JSONObject interest1 = new JSONObject("{\"category\": \"music/band\", \"value\": \"Pink Floyd\"}");
            JSONObject interest2 = new JSONObject("{\"category\": \"music/band\", \"value\": \"The Beatles\"}");
            JSONObject interest3 = new JSONObject("{\"category\": \"outdoors\", \"value\": \"running\"}");
            JSONObject interest4 = new JSONObject("{\"category\": \"sex\", \"value\": \"men\"}");
            JSONArray interests = new JSONArray();
            interests.put(interest1);
            interests.put(interest2);
            interests.put(interest3);
            interests.put(interest4);

            JSONObject seba = new JSONObject("{\"name\":\"seba\",\"alias\":\"Seba\",\"email\":\"seba@gmail.com\",\"birthday\":\"13/08/1991\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject fede = new JSONObject("{\"name\":\"fede\",\"alias\":\"Fede\",\"email\":\"fede@gmail.com\",\"birthday\":\"13/08/1991\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject eze = new JSONObject("{\"name\":\"eze\",\"alias\":\"Eze\",\"email\":\"eze@gmail.com\",\"birthday\":\"2/10/1993\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject lucas = new JSONObject("{\"birthday\":\"13/08/1993\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\" },\"email\":\"lucas@gmail.com\",\"alias\":\"Lucas\",\"name\":\"lucas\",\"password\":\"contraseña\"}");

            Base64Converter bs64 = new Base64Converter();

            Bitmap photodefault_seba = BitmapFactory.decodeResource(context.getResources(), R.drawable.seba_foto_perfil);
            Bitmap photodefault_fede = BitmapFactory.decodeResource(context.getResources(), R.drawable.fede_foto_perfil);
            Bitmap photodefault_eze = BitmapFactory.decodeResource(context.getResources(), R.drawable.eze_foto_perfil);
            Bitmap photodefault_lucas = BitmapFactory.decodeResource(context.getResources(), R.drawable.lucas_foto_perfil);

            String base64_seba = bs64.bitmapToBase64(photodefault_seba);
            String base64_fede = bs64.bitmapToBase64(photodefault_fede);
            String base64_eze = bs64.bitmapToBase64(photodefault_eze);
            String base64_lucas = bs64.bitmapToBase64(photodefault_lucas);

            seba.put(context.getResources().getString(R.string.profilePhoto), base64_seba);
            fede.put(context.getResources().getString(R.string.profilePhoto), base64_fede);
            eze.put(context.getResources().getString(R.string.profilePhoto), base64_eze);
            lucas.put(context.getResources().getString(R.string.profilePhoto), base64_lucas);
            lucas.put(context.getResources().getString(R.string.interests), interests);

            matches.put("seba@gmail.com", seba);
            matches.put("fede@gmail.com", fede);
            matches.put("eze@gmail.com", eze);
            matches.put("lucas@gmail.com", lucas);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void createPossibleMatchList() {
        /*** POSSIBLE MATCHES ***/
        possibleMatches = new ArrayList<JSONObject>();
        try {
            JSONObject pmatch1 = new JSONObject("{\"name\":\"Wolverine\",\"alias\":\"Wolverine\",\"email\":\"wolverine@gmail.com\",\"birthday\":\"13/08/100\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject pmatch2 = new JSONObject("{\"name\":\"Yoda\",\"alias\":\"Yoda\",\"email\":\"yoda@gmail.com\",\"birthday\":\"13/08/2006\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject pmatch3 = new JSONObject("{\"name\":\"Terminator\",\"alias\":\"Terminator\",\"email\":\"terminator@gmail.com\",\"birthday\":\"13/08/1000\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject pmatch4 = new JSONObject("{\"name\":\"Anonymous\",\"alias\":\"Anonymous\",\"email\":\"anonymous@gmail.com\",\"birthday\":\"13/08/2002\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject pmatch5 = new JSONObject("{\"name\":\"Mario\",\"alias\":\"Mario\",\"email\":\"mario@gmail.com\",\"birthday\":\"13/08/1800\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");
            JSONObject pmatch6 = new JSONObject("{\"name\":\"Soldier\",\"alias\":\"Soldier\",\"email\":\"soldier@gmail.com\",\"birthday\":\"13/08/1995\",\"sex\":\"Male\",\"location\":{ \"longitude\":\"-58.37\",\"latitude\":\"-34.69\"},\"password\":\"contraseña\"}");

            Base64Converter bs64 = new Base64Converter();
            Bitmap pmatch1BitmapPhoto = BitmapFactory.decodeResource(context.getResources(), R.drawable.pmatch1);
            Bitmap pmatch2BitmapPhoto = BitmapFactory.decodeResource(context.getResources(), R.drawable.pmatch2);
            Bitmap pmatch3BitmapPhoto = BitmapFactory.decodeResource(context.getResources(), R.drawable.pmatch3);
            Bitmap pmatch4BitmapPhoto = BitmapFactory.decodeResource(context.getResources(), R.drawable.pmatch4);
            Bitmap pmatch5BitmapPhoto = BitmapFactory.decodeResource(context.getResources(), R.drawable.pmatch5);
            Bitmap pmatch6BitmapPhoto = BitmapFactory.decodeResource(context.getResources(), R.drawable.pmatch6);
            String pmatch1Photo = bs64.bitmapToBase64(pmatch1BitmapPhoto);
            String pmatch2Photo = bs64.bitmapToBase64(pmatch2BitmapPhoto);
            String pmatch3Photo = bs64.bitmapToBase64(pmatch3BitmapPhoto);
            String pmatch4Photo = bs64.bitmapToBase64(pmatch4BitmapPhoto);
            String pmatch5Photo = bs64.bitmapToBase64(pmatch5BitmapPhoto);
            String pmatch6Photo = bs64.bitmapToBase64(pmatch6BitmapPhoto);

            pmatch1.put(context.getResources().getString(R.string.profilePhoto), pmatch1Photo);
            pmatch2.put(context.getResources().getString(R.string.profilePhoto), pmatch2Photo);
            pmatch3.put(context.getResources().getString(R.string.profilePhoto), pmatch3Photo);
            pmatch4.put(context.getResources().getString(R.string.profilePhoto), pmatch4Photo);
            pmatch5.put(context.getResources().getString(R.string.profilePhoto), pmatch5Photo);
            pmatch6.put(context.getResources().getString(R.string.profilePhoto), pmatch6Photo);

            possibleMatches.add(pmatch1);
            possibleMatches.add(pmatch2);
            possibleMatches.add(pmatch3);
            possibleMatches.add(pmatch4);
            possibleMatches.add(pmatch5);
            possibleMatches.add(pmatch6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* Represent Login Request */
    public String Login(JSONObject data) {
        String userEmail = "";
        try {
            userEmail = data.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (matches.containsKey(userEmail)) {
            String profileString = String.valueOf(matches.get(userEmail));
            matches.remove(userEmail);
            return "200:" + profileString;
        }
        return "201:" + "";
    }

    /* Represent Get Matches Request */
    public String getMatches(String userMailJson) {
        JSONArray match_array = new JSONArray();
        int count = 1;
        for (int i = 0; i < count; ++i) {
            if (matches.size() != 0) {
                String email = (String)matches.keySet().toArray()[0];
                JSONObject match = matches.get(email);
                match_array.put(match);
                matches.remove(email);
            }
        }
        JSONObject matchesToSend = new JSONObject();
        try {
            matchesToSend.put("matches",match_array); // array de matches
        } catch (JSONException e) {
            e.printStackTrace();
            return "201:error";
        }
        return "200:" + matchesToSend.toString();
    }

    /* Represent Get Possible Matches Request */
    public String getPossibleMatches(String pmatchRequest) {
        JSONObject possibleMatchesToSend = new JSONObject();
        JSONArray possibleMatchesArray = new JSONArray();
        int count = 0;
        try {
            JSONObject posMatchRequest = new JSONObject(pmatchRequest);
            String userEmail = posMatchRequest.getString("email");
            count = posMatchRequest.getInt("count");

            for (int i = 0; i < count; ++i) {
                if (possibleMatches.size() > 0) {
                    JSONObject pmatch = possibleMatches.get(0); //Get the first pos match
                    possibleMatchesArray.put(pmatch);
                    possibleMatches.remove(0);
                }
            }
            possibleMatchesToSend.put("possibleMatches", possibleMatchesArray);
        } catch (JSONException e) {
            e.printStackTrace();
            return "201:error";
        }
        return "200:" + possibleMatchesToSend.toString();
    }

    /* Represent Get conversation Request */
    public String getConversation(String conversationRequest) {
        JSONObject conversationToSend = new JSONObject();

        JSONObject conversationJson = null;
        String emailSrc = null;
        try {
            conversationJson = new JSONObject(conversationRequest);
            emailSrc = conversationJson.getString("emailSrc");

            JSONObject conversation = new JSONObject();
            JSONObject msg1 = new JSONObject("{\"sendFrom\":" + "\"" + emailSrc + "\"" + ",\"msg\":\"hola, soy " + emailSrc + "\"" + "}");
            JSONObject msg2 = new JSONObject("{\"sendFrom\":" + "\"" + emailSrc + "\"" + ",\"msg\":\"hola, soy " + emailSrc + "\"" + "}");

            JSONArray messages = new JSONArray();
            messages.put(msg1);
            messages.put(msg2);
            conversation.put("messages", messages);
            conversation.put("email", emailSrc);

            conversationToSend.put("conversation", conversation);
        } catch (JSONException e) {
            e.printStackTrace();
            return "201:error";
        }
        return "200:" + conversationToSend.toString();
    }

    /* Represent Send Pos Match Interest Request */
    public String like_dont(String interest) {
        try {
            JSONObject interestJson = new JSONObject(interest);
            String emailSrc = interestJson.getString("emailSrc");
            String emailDst = interestJson.getString("emailDst");
        } catch (JSONException e) {
            e.printStackTrace();
            return "201:error";
        }
        return "200:ok";
    }
}