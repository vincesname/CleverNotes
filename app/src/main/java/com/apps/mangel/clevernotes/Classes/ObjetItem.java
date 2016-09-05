package com.apps.mangel.clevernotes.Classes;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class ObjetItem {

    //region Déclaration des variables
    private String mTexte;
    private int mLigne;
    private Boolean mStatut;
    //endregion Déclaration des variables

    //region Get/Set des variables
    //VM - IsActif
    public Boolean GetStatut() {
        return this.mStatut;
    }

    public void SetStatut(Boolean pBool) {
        this.mStatut = pBool;
    }

    //VM - Points
    public int GetLigne() {
        return this.mLigne;
    }

    public void SetLigne(int pLigne) {
        this.mLigne = pLigne;
    }

    //VM - Texte
    public String GetTexte() {
        return this.mTexte;
    }

    public void SetDTexte(String pString) {
        this.mTexte = pString;
    }
    //endregion Get/Set des variables

    /**
     * Constructeur
     * @param pTexte Texte
     * @param pLigne Ligne
     * @param pStatut Etat Actif/Coché
     */
    public ObjetItem(String pTexte, int pLigne, Boolean pStatut) {
        this.mTexte = pTexte;
        this.mLigne = pLigne;
        this.mStatut = pStatut;
    }

    @Override
    public String toString() {
        return this.mTexte + "µ*µ"+this.mLigne + "µ*µ"+this.mStatut.toString() + "µ*µ";
    }
}
