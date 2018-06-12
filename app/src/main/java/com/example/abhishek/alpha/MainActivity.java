package com.example.abhishek.alpha;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callContact(View view){
        TextView numberView = (TextView)findViewById(R.id.number);
        String number = numberView.getText().toString();
        //if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
          //      != PackageManager.PERMISSION_GRANTED) {
           // Toast.makeText(this,"Enable permission to use this feature", Toast.LENGTH_SHORT).show();
        //}
        //else{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+number));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);

        }
    }
    public void openweb(View view){
        TextView webView = (TextView)findViewById(R.id.website);
        String website = webView.getText().toString();
        //Log.v("MainActivity",website);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://"+website));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
    }
    public void showMap(View view){
        TextView addressView = (TextView)findViewById(R.id.address);
        String address = addressView.getText().toString();
        //Log.v("MainActivity",address);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:?q="+address));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


}
