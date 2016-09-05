package com.apps.mangel.clevernotes.Classes;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class TypeRappel {

    //region Déclaration des variables
    private String mLibelle;
    private TypeReplanification mTypeReplan;
    private int mNbMinutes;
    private int mNbFois;
    //endregion Déclaration des variables

    //region Get/Set des variables
    //VM - Libelle
    public String GetLibelle() {
        return this.mLibelle;
    }

    public void SetLibelle(String pLibelle) {
        this.mLibelle = pLibelle;
    }

    //VM - TypeReplanification
    public TypeReplanification GetTypeReplan() {
        return this.mTypeReplan;
    }

    public void SetTypeReplan(TypeReplanification pTypeReplan) {
        this.mTypeReplan = pTypeReplan;
    }

    //VM - Nb Minutes
    public int GetNbMinutes() {
        return this.mNbMinutes;
    }

    public void SetNbMinutes(int pInt) {
        this.mNbMinutes = pInt;
    }

    //VM - Nb Fois
    public int GetNbFois() {
        return this.mNbFois;
    }

    public void SetNbFois(int pInt) {
        this.mNbFois = pInt;
    }
    //endregion Get/Set des variables

    /**
     * Constructeur
     * @param pLibelle Libelle
     * @param pNbMinutes Nb de minutes
     * @param pNbFois Nb de fois à rappeller
     */
    public TypeRappel(String pLibelle, int pNbMinutes, int pNbFois) {
        this.mLibelle = pLibelle;
        this.mNbMinutes = pNbMinutes;
        this.mNbFois = pNbFois;
    }
}
