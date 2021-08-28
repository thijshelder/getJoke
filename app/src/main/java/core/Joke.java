package core;

import org.json.JSONException;
import org.json.JSONObject;

public class Joke {

    Integer id;
    String type;
    String setup;
    String punchline;

    public Joke(String json)  {
        try {
            JSONObject joke = new JSONObject(json);
            id = (Integer) joke.get("id");
            type = joke.getString("type");
            setup = joke.getString("setup");
            punchline = joke.getString("punchline");


        }
        catch (JSONException e)
        {
            throw new RuntimeException("we didn't get the joke today "+e.getMessage(), e.getCause());
        }
    }

    public Integer getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }

    public String getSetup()
    {
        return setup;
    }

    public String getPunchline()
    {
        return punchline;
    }


}
