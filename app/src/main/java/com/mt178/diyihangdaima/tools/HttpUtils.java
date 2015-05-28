package com.mt178.diyihangdaima.tools;

import org.apache.http.HttpConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by llh on 2015/3/19.
 */
public class HttpUtils {
    public static void sendHttpRequest(final String address) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpConnection = null;
                try {
                    URL url = new URL(address);
                    httpConnection = (HttpURLConnection) url.openConnection();
                    httpConnection.setRequestMethod("POSt");
                    httpConnection.setConnectTimeout(8000);
                    httpConnection.setReadTimeout(8000);
                    httpConnection.setDoInput(true);
                    httpConnection.setDoOutput(true);
                    InputStream in = httpConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (httpConnection != null) {
                        httpConnection.disconnect();
                    }
                }

            }
        }).start();
    }
}
