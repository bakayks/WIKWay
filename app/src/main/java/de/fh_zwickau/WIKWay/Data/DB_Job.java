package de.fh_zwickau.WIKWay.Data;


import android.provider.BaseColumns;

/**
 * Created by delaroy on 5/27/17.
 */
public class DB_Job {

    public static final class FavoriteEntry implements BaseColumns{
        public static final String TABLE_FAVORITE = "favorite";


        public static final String KEY_ID = "id";
        public static final String KEY_bewerbenkontaktfirma = "bewerbenkontaktfirma";
        public static final String KEY_bezeichnungderStelle = "bezeichnungderStelle";
        public static final String KEY_anschreibenZurStelle = "anschreibenZurStelle";
        public static final String KEY_artDerStelle = "artDerStelle";
        public static final String KEY_einsqtzort = "einsqtzort";
        public static final String KEY_umfang = "umfang";
        public static final String KEY_strasse = "strasse";
        public static final String KEY_PLZ = "PLZ";
        public static final String KEY_aufgabengebiet = "aufgabengebiet";
        public static final String KEY_kontaktZuBewerben = "kontaktZuBewerben";
        public static final String KEY_bewerbenkontakt = "bewerbenkontakt";
        public static final String KEY_abteilung = "abteilung";
        public static final String KEY_Ansprechpartner = "Ansprechpartner";
        public static final String KEY_ORT = "ORT";
        public static final String KEY_URLImage = "URLImage";
    }
}