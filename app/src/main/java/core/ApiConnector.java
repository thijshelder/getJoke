package core;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiConnector extends AsyncTask {

    String urlString = "";
    String result = "";

    public void setURl(String url)
    {
        this.urlString = url;
    }

    public String getResult()
    {
        return result;
    }

    public void getApiText()
    {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    result = "";
                    StringBuilder resultSb = new StringBuilder();
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()))) {
                        for (String line; (line = reader.readLine()) != null; ) {
                            resultSb.append(line);
                        }
                    }
                    result = resultSb.toString();
                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
      thread.start();
}

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}
