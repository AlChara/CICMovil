package org.cic.cicmovil.threads;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.cic.cicmovil.utils.Constants.POST;

/**
 * Created by PERSONAL on 06/04/2017.
 */

public class PostThreadTask extends AsyncTask<String, Integer, String> {
    public static final String TAG = "PostThreadTask";
    private String url_address;
    private String post_data;
    private URL url;
    private HttpURLConnection conexion;
    private Callback mCallback;

    public interface Callback{
        void result(String json_response);
    }

    public PostThreadTask(Callback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        url_address = "";
        post_data = "";
        url = null;
        conexion = null;
    }

    @Override
    protected String doInBackground(String... params) {
        url_address = params[0];
        post_data = params[1];
        try {
            url = new URL(url_address);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod(POST);
            conexion.setFixedLengthStreamingMode(post_data.getBytes().length);
            conexion.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");

            conexion.setDoInput(true);
            conexion.setDoInput(true);

            OutputStream out = conexion.getOutputStream();
            BufferedWriter bufferWrite = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            bufferWrite.write(post_data);
            out.flush();
            out.close();

            bufferWrite.flush();
            bufferWrite.close();

            out.close();

            int response = conexion.getResponseCode();
            String json_object = "";
            Log.e(TAG, "Response from the server was code " + response);
            if (response == HttpURLConnection.HTTP_OK){
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                while ((line=br.readLine()) != null) {
                    json_object += line;
                }
                return json_object;
            }
            else{
                return json_object;
            }

        }
        catch (Exception e){
            if (e != null) Log.e(TAG, "Error caused by " + e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCallback.result(s);
    }
}
