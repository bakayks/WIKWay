package de.fh_zwickau.WIKWay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import de.fh_zwickau.WIKWay.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity{

    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://www.wikway.de/companies/offers-json?password=ain1018";

    ArrayList<Job> jobArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobArrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Job itemChosen = (Job) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, MoreInfoActivity.class);
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
        new GetContacts().execute();
    }


    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    // Getting JSON Array node
                    JSONArray contacts = new JSONArray(jsonStr);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String art_der_stelle = c.getString("Art der Stelle");
                        String bezeichnung_der_stelle = c.getString("Bezeichnung der Stelle");
                        String email = c.getString("E-Mail");
                        String url = c.getString("Logo");
                        String bewerberkontakt_firma = c.getString("Bewerberkontakt Firma");
                        String anschreiben = c.getString("Anschreiben zur Stelle");
                        String einsatzort = c.getString("Einsatzort");
                        String umfang = c.getString("Umfang");
                        String aufgabengebiet = c.getString("Aufgabengebiet");
                        String abteilung = c.getString("Abteilung");
                        String ansprechpartner = c.getString("Ansprechpartner");
                        String ort = c.getString("Ort");
                        String strasse = c.getString("Straße");
                        String PLZ = c.getString("PLZ");
                        Job job = new Job();
                        job.setArtDerStelle(art_der_stelle);
                        job.setBezeichnungderStelle(bezeichnung_der_stelle);
                        job.setKontaktZuBewerben(email);
                        job.setBewerbenkontaktfirma(bewerberkontakt_firma);
                        job.setAnschreibenZurStelle(anschreiben);
                        job.setEinsqtzort(einsatzort);
                        job.setUmfang(umfang);
                        job.setAufgabengebiet(aufgabengebiet);
                        job.setAbteilung(abteilung);
                        job.setAnsprechpartner(ansprechpartner);
                        job.setURLImage(url);
                        job.setORT(ort);
                        job.setStrasse(strasse);
                        job.setPLZ(PLZ);
//                        contact.put("mobile", mobile);

                        // adding contact to contact list
                        jobArrayList.add(job);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            MyAdapter adapter = new MyAdapter(
                    getApplicationContext(), R.layout.list_item, jobArrayList
            );
            lv.setAdapter(adapter);
        }

    }
}
