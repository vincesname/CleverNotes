package com.apps.mangel.clevernotes.Classes;

import java.sql.Date;

/**
 * Créé by Vincent on 23/06/2016.
 */
public class Evenement extends Objet{

    //region Déclaration des variables
    //TYPE RAPPEL
    //VISIBILITE
    private static Boolean mIsActif;
    private static int mPoints;
    //CATEGORIE
    private static Date mDateFin;
    //endregion Déclaration des variables

    //region Get/Set des variables
    //VM - IsActif
    public static Boolean GetIsActif() {
        return mIsActif;
    }

    public static void SetIsActif(Boolean pBool) {
        mIsActif = pBool;
    }

    //VM - Points
    public static int GetPoints() {
        return mPoints;
    }

    public static void SetPoints(int pPoints) {
        mPoints = pPoints;
    }

    //VM - Date fin
    public static Date GetDate() {
        return mDateFin;
    }

    public static void SetDate(Date pDate) {
        mDateFin = pDate;
    }
    //endregion Get/Set des variables

    /**
     * Constructeur
     * @param pTitre Titre
     * @param pDescription Description
     * @param pDateCreation Date de création
     * @param pIsActif Evenement actif ?
     * @param pPoints Nb de point public
     * @param pDateFin Echéance
     */
    public Evenement(String pTitre, String pDescription, Date pDateCreation,
                     Enums.TypeObjet pTypeObjet, Boolean pIsActif, int pPoints, Date pDateFin) {
        super(pTitre, pDescription, pDateCreation, pTypeObjet);
        this.mIsActif = pIsActif;
        this.mPoints = pPoints;
        this.mDateFin = pDateFin;
    }
}
