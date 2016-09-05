package com.apps.mangel.clevernotes.Classes;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class Visibilite {

    //region Déclaration des variables
    private String mLibelle;
    //endregion Déclaration des variables

    //region Get/Set des variables
    //VM - Libelle
    public String GetLibelle() {
        return this.mLibelle;
    }

    public void SetLibelle(String pString) {
        this.mLibelle = pString;
    }
    //endregion Get/Set des variables

    /**
     * Constructeur
     * @param pLibelle Libelle
     */
    public Visibilite(String pLibelle) {
        this.mLibelle = pLibelle;
    }
}
