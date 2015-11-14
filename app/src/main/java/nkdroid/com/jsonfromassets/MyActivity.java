
package nkdroid.com.jsonfromassets;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import nkdroid.com.jsonfromassets.BeanPost;


public class MyActivity extends Activity {

    private ProgressDialog progressDialog;
    private TextView txtPostList;
    private ArrayList<BeanPost> beanPostArrayList;
    private StringBuffer postList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        txtPostList=(TextView)findViewById(R.id.txtPostList);
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog=new ProgressDialog(MyActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                Type listType = new TypeToken<ArrayList<BeanPost>>(){}.getType();
                beanPostArrayList = new GsonBuilder().create().fromJson(loadJSONFromAsset(), listType);
                postList=new StringBuffer();
                for(BeanPost post: beanPostArrayList){
                    postList.append("\n title: "+post.getPost_name()+"\n auther: "+post.getAuther()+"\n date: "+post.getDate()+"\n description: "+post.getDescription()+"\n\n");
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                progressDialog.dismiss();
                txtPostList.setText(postList);

            }
        }.execute();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
       } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
