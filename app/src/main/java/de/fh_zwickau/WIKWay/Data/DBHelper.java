package de.fh_zwickau.WIKWay.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import de.fh_zwickau.WIKWay.Job;

public class DBHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "favorites";

    // Table Names

    public static final String LOGTAG = "FAVORITE";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase db;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){
        Log.i(LOGTAG, "Database Opened");
        db = dbhandler.getWritableDatabase();
    }

    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + DB_Job.FavoriteEntry.TABLE_FAVORITE + " (" +
                DB_Job.FavoriteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DB_Job.FavoriteEntry.KEY_bewerbenkontaktfirma + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_bezeichnungderStelle + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_anschreibenZurStelle + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_artDerStelle + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_einsqtzort + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_umfang + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_strasse + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_PLZ + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_aufgabengebiet + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_kontaktZuBewerben + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_bewerbenkontakt + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_abteilung + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_Ansprechpartner + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_ORT + " TEXT, " +
                DB_Job.FavoriteEntry.KEY_URLImage + " TEXT" +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_Job.FavoriteEntry.TABLE_FAVORITE);
        onCreate(sqLiteDatabase);

    }

    public void addFavorite(Job job){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_Job.FavoriteEntry.KEY_bewerbenkontaktfirma, job.getBewerbenkontaktfirma());
        values.put(DB_Job.FavoriteEntry.KEY_bezeichnungderStelle, job.getBezeichnungderStelle());
        values.put(DB_Job.FavoriteEntry.KEY_anschreibenZurStelle, job.getAnschreibenZurStelle());
        values.put(DB_Job.FavoriteEntry.KEY_artDerStelle, job.getArtDerStelle());
        values.put(DB_Job.FavoriteEntry.KEY_einsqtzort, job.getEinsqtzort());
        values.put(DB_Job.FavoriteEntry.KEY_umfang, job.getUmfang());
        values.put(DB_Job.FavoriteEntry.KEY_strasse, job.getStrasse());
        values.put(DB_Job.FavoriteEntry.KEY_PLZ, job.getPLZ());
        values.put(DB_Job.FavoriteEntry.KEY_aufgabengebiet, job.getAufgabengebiet());
        values.put(DB_Job.FavoriteEntry.KEY_kontaktZuBewerben, job.getKontaktZuBewerben());
        values.put(DB_Job.FavoriteEntry.KEY_bewerbenkontakt, job.getBewerbenkontakt());
        values.put(DB_Job.FavoriteEntry.KEY_abteilung, job.getAbteilung());
        values.put(DB_Job.FavoriteEntry.KEY_Ansprechpartner, job.getAnsprechpartner());
        values.put(DB_Job.FavoriteEntry.KEY_ORT, job.getORT());
        values.put(DB_Job.FavoriteEntry.KEY_URLImage, job.getURLImage());

        db.insert(DB_Job.FavoriteEntry.TABLE_FAVORITE, null, values);
        db.close();
    }

    public void deleteFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_Job.FavoriteEntry.TABLE_FAVORITE, DB_Job.FavoriteEntry._ID+ "=" + id, null);
    }

    public List<Job> getAllFavorite(){
        String[] columns = {
                DB_Job.FavoriteEntry._ID,
                        DB_Job.FavoriteEntry.KEY_bewerbenkontaktfirma,
                        DB_Job.FavoriteEntry.KEY_bezeichnungderStelle,
                        DB_Job.FavoriteEntry.KEY_anschreibenZurStelle,
                        DB_Job.FavoriteEntry.KEY_artDerStelle,
                        DB_Job.FavoriteEntry.KEY_einsqtzort,
                        DB_Job.FavoriteEntry.KEY_umfang,
                        DB_Job.FavoriteEntry.KEY_strasse,
                        DB_Job.FavoriteEntry.KEY_PLZ,
                        DB_Job.FavoriteEntry.KEY_aufgabengebiet,
                        DB_Job.FavoriteEntry.KEY_kontaktZuBewerben,
                        DB_Job.FavoriteEntry.KEY_bewerbenkontakt,
                        DB_Job.FavoriteEntry.KEY_abteilung,
                        DB_Job.FavoriteEntry.KEY_Ansprechpartner,
                        DB_Job.FavoriteEntry.KEY_ORT,
                        DB_Job.FavoriteEntry.KEY_URLImage

        };
        String sortOrder =
                DB_Job.FavoriteEntry._ID + " ASC";
        List<Job> favoriteList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB_Job.FavoriteEntry.TABLE_FAVORITE,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if (cursor.moveToFirst()){
            do {
                Job job = new Job();
                job.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry._ID))));
                job.setBewerbenkontaktfirma(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_bewerbenkontaktfirma)));
                job.setBezeichnungderStelle(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_bezeichnungderStelle)));
                job.setAnschreibenZurStelle(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_anschreibenZurStelle)));
                job.setArtDerStelle(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_artDerStelle)));
                job.setEinsqtzort(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_einsqtzort)));
                job.setUmfang(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_umfang)));
                job.setStrasse(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_strasse)));
                job.setPLZ(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_PLZ)));
                job.setAufgabengebiet(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_aufgabengebiet)));
                job.setKontaktZuBewerben(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_kontaktZuBewerben)));
                job.setBewerbenkontakt(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_bewerbenkontakt)));
                job.setAbteilung(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_abteilung)));
                job.setAnsprechpartner(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_Ansprechpartner)));
                job.setORT(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_ORT)));
                job.setURLImage(cursor.getString(cursor.getColumnIndex(DB_Job.FavoriteEntry.KEY_URLImage)));
                favoriteList.add(job);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return favoriteList;
    }

}