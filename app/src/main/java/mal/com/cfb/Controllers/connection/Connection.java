package mal.com.cfb.Controllers.connection;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mal.com.cfb.exception.ExceptionUtil;
import mal.com.cfb.exception.NetworkException;

/**
 * Created by user on 8/5/16.
 */

public class Connection extends AsyncTask{

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;

    RequestDataSource requestDataSource;

    @Override
    protected Object doInBackground(Object[] objects) {

        URL url = requestDataSource.getRequestUrl();

        // Create the request to OpenWeatherMap, and open the connection
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            String response = buffer.toString();
        } catch (IOException e) {
            ExceptionUtil.getSharedInstance().throwException(NetworkException.class);
        }

        return null;
    }

}
