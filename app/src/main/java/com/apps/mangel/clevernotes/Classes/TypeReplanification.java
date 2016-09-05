package com.apps.mangel.clevernotes.Classes;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class TypeReplanification {

    //region Déclaration des variables
    private String mLibelle;
    private int mNbMinutes;
    //endregion Déclaration des variables

    //region Get/Set des variables
    //VM - Libelle
    public String GetLibelle() {
        return this.mLibelle;
    }

    public void SetLibelle(String pString) {
        this.mLibelle = pString;
    }

    //VM - Nb Minutes
    public int GetNbMinutes() {
        return this.mNbMinutes;
    }

    public void SetNbMinutes(int pInt) {
        this.mNbMinutes = pInt;
    }
    //endregion Get/Set des variables

    /**
     * Constructeur
     * @param pLibelle Libelle
     * @param pNbMinutes Nb de minutes
     */
    public TypeReplanification(String pLibelle, int pNbMinutes) {
        this.mLibelle = pLibelle;
        this.mNbMinutes = pNbMinutes;
    }
}
