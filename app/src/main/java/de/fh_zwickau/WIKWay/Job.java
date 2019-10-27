package de.fh_zwickau.WIKWay;

public class Job {
    private String bewerbenkontaktfirma;
    private String bezeichnungderStelle;
    private String anschreibenZurStelle;

    /* Art der Stelle */
    private String artDerStelle;
    private String einsqtzort;
    private String[] berufsfeld;
    private String umfang;
    private String strasse;
    private String PLZ;

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getAnschreibenZurStelle() {
        return anschreibenZurStelle;
    }

    public void setAnschreibenZurStelle(String anschreibenZurStelle) {
        this.anschreibenZurStelle = anschreibenZurStelle;
    }

    /* Aufgabengebiet */
    private String aufgabengebiet;

    /* Kontakt zu bewerben */
    private String kontaktZuBewerben;

    /* Anschritt */
    private String bewerbenkontakt;
    private String abteilung;
    private String Ansprechpartner;
    private String ORT;

    private String URLImage;

    public String getURLImage() {
        return URLImage;
    }

    public void setURLImage(String URLImage) {
        this.URLImage = URLImage;
    }

    public Job() {

    }

    public Job(String bewerbenkontaktfirma, String bezeichnungderStelle, String artDerStelle, String einsqtzort, String[] berufsfeld, String umfang, String aufgabengebiet, String kontaktZuBewerben, String bewerbenkontakt, String abteilung, String ansprechpartner, String ORT) {
        this.bewerbenkontaktfirma = bewerbenkontaktfirma;
        this.bezeichnungderStelle = bezeichnungderStelle;
        this.artDerStelle = artDerStelle;
        this.einsqtzort = einsqtzort;
        this.berufsfeld = berufsfeld;
        this.umfang = umfang;
        this.aufgabengebiet = aufgabengebiet;
        this.kontaktZuBewerben = kontaktZuBewerben;
        this.bewerbenkontakt = bewerbenkontakt;
        this.abteilung = abteilung;
        Ansprechpartner = ansprechpartner;
        this.ORT = ORT;
    }

    public String getBewerbenkontaktfirma() {
        return bewerbenkontaktfirma;
    }

    public void setBewerbenkontaktfirma(String bewerbenkontaktfirma) {
        this.bewerbenkontaktfirma = bewerbenkontaktfirma;
    }

    public String getBezeichnungderStelle() {
        return bezeichnungderStelle;
    }

    public void setBezeichnungderStelle(String bezeichnungderStelle) {
        this.bezeichnungderStelle = bezeichnungderStelle;
    }

    public String getArtDerStelle() {
        return artDerStelle;
    }

    public void setArtDerStelle(String artDerStelle) {
        this.artDerStelle = artDerStelle;
    }

    public String getEinsqtzort() {
        return einsqtzort;
    }

    public void setEinsqtzort(String einsqtzort) {
        this.einsqtzort = einsqtzort;
    }

    public String[] getBerufsfeld() {
        return berufsfeld;
    }

    public void setBerufsfeld(String[] berufsfeld) {
        this.berufsfeld = berufsfeld;
    }

    public String getUmfang() {
        return umfang;
    }

    public void setUmfang(String umfang) {
        this.umfang = umfang;
    }

    public String getAufgabengebiet() {
        return aufgabengebiet;
    }

    public void setAufgabengebiet(String aufgabengebiet) {
        this.aufgabengebiet = aufgabengebiet;
    }

    public String getKontaktZuBewerben() {
        return kontaktZuBewerben;
    }

    public void setKontaktZuBewerben(String kontaktZuBewerben) {
        this.kontaktZuBewerben = kontaktZuBewerben;
    }

    public String getBewerbenkontakt() {
        return bewerbenkontakt;
    }

    public void setBewerbenkontakt(String bewerbenkontakt) {
        this.bewerbenkontakt = bewerbenkontakt;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getAnsprechpartner() {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        Ansprechpartner = ansprechpartner;
    }

    public String getORT() {
        return ORT;
    }

    public void setORT(String ORT) {
        this.ORT = ORT;
    }
}