package de.fh_zwickau.WIKWay.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import de.fh_zwickau.WIKWay.R;

//import com.squareup.picasso.Picasso;

public class MoreInfoActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_info);

        textView = (TextView) findViewById(R.id.artderstelle);
        textView.setText(getIntent().getStringExtra("art der stelle"));
        textView = (TextView) findViewById(R.id.bezeichnungderstelle);
        textView.setText(getIntent().getStringExtra("bezeichnung der stelle"));
        textView = (TextView) findViewById(R.id.email);
        textView.setText(getIntent().getStringExtra("email"));
        textView = (TextView) findViewById(R.id.bewerberkontakt);
        textView.setText(getIntent().getStringExtra("bewerberkontakt firma"));
        textView = (TextView) findViewById(R.id.anschreiben);
        textView.setText(getIntent().getStringExtra("anschreiben"));
        textView = (TextView) findViewById(R.id.einsatzort);
        textView.setText(getIntent().getStringExtra("einsatzort"));
        textView = (TextView) findViewById(R.id.umfang);
        textView.setText(getIntent().getStringExtra("umfang"));
        textView = (TextView) findViewById(R.id.aufgabengebiet);
        textView.setText(getIntent().getStringExtra("aufgabengebiet"));
        textView = (TextView) findViewById(R.id.abteilung);
        textView.setText(getIntent().getStringExtra("abteilung"));
        textView = (TextView) findViewById(R.id.ansprechpartner);
        textView.setText(getIntent().getStringExtra("ansprechpartner"));
        textView = (TextView) findViewById(R.id.ort);
        textView.setText(getIntent().getStringExtra("ort"));
        textView = (TextView) findViewById(R.id.strasse);
        textView.setText(getIntent().getStringExtra("strasse"));
        textView = (TextView) findViewById(R.id.PLZ);
        textView.setText(getIntent().getStringExtra("PLZ"));
//        view = (ImageView) view.findViewById(R.id.imageView);
//        Picasso.with().load(getIntent().getStringExtra("url")).into(view);
    }


}

