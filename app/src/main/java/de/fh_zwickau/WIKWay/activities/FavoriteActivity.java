package de.fh_zwickau.WIKWay.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import de.fh_zwickau.WIKWay.Job;
import de.fh_zwickau.WIKWay.R;

public class FavoriteActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Job itemChosen = (Job) parent.getItemAtPosition(position);
                Intent intent = new Intent(FavoriteActivity.this, MoreInfoActivity.class);
                intent.putExtra("art der stelle", itemChosen.getAnsprechpartner());
                intent.putExtra("bezeichnung der stelle", itemChosen.getBezeichnungderStelle());
                intent.putExtra("email", itemChosen.getKontaktZuBewerben());
                intent.putExtra("url", itemChosen.getURLImage());
                intent.putExtra("bewerberkontakt firma", itemChosen.getBewerbenkontakt());
                intent.putExtra("anschreiben", itemChosen.getAnschreibenZurStelle());
                intent.putExtra("einsatzort", itemChosen.getEinsqtzort());
                intent.putExtra("umfang", itemChosen.getUmfang());
                intent.putExtra("aufgabengebiet", itemChosen.getAufgabengebiet());
                intent.putExtra("abteilung", itemChosen.getAbteilung());
                intent.putExtra("ansprechpartner", itemChosen.getAnsprechpartner());
                intent.putExtra("ort", itemChosen.getORT());
                intent.putExtra("strasse", itemChosen.getStrasse());
                intent.putExtra("PLZ", itemChosen.getPLZ());
                startActivity(intent);
            }
        });
    }


    // Здесь получить данные из базы данных и вывести в onCreate
    // Еще доделать узнать больше при нажатии on Item CLick
}