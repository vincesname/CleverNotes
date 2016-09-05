package com.apps.mangel.clevernotes.Classes;

/**
 * Créé by Vincent on 12/07/2016.
 */
public class Enums {

    public enum TypeObjet {
        Brouillon,
        Liste,
        ListeDesordonee,
        ListeEtapes
    }

    public static String GetTitreFromTypeObjet(TypeObjet pType)
    {
        switch (pType){
            case Brouillon :
                return "Edition du brouillon";
            case Liste :
                return "Edition de la liste";
            case ListeDesordonee :
                return "Edition de la liste désordonnée";
            case ListeEtapes :
                return "Edition de la liste à étapes";
            default :
                return "Edition";
        }
    }

    public static String ToString(TypeObjet pType) {
            switch (pType){
                case Brouillon :
                    return "BROUILLON";
                case Liste :
                    return "LISTE";
                case ListeDesordonee :
                    return "LISTEDESORDONEE";
                case ListeEtapes :
                    return "LISTETAPES";
                default:
                    return "BROUILLON";
            }
    }

    public static Enums.TypeObjet FromString(String pString) {
        switch (pString){
            case "BROUILLON" :
                return TypeObjet.Brouillon;
            case "LISTE" :
                return TypeObjet.Liste;
            case "LISTEDESORDONEE" :
                return TypeObjet.ListeDesordonee;
            case "LISTETAPES" :
                return TypeObjet.ListeEtapes;
            default:
                return TypeObjet.Brouillon;
        }
    }
}
