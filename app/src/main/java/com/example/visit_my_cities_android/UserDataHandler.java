package com.example.visit_my_cities_android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Classe pour gérer les données de l'utilisateur
public class UserDataHandler extends SQLiteOpenHelper
{
    // Commandes SQL pour créer et supprimer la base de données
    public static final String  DROP_DATABASE_USER= "DROP TABLE IF EXISTS vmc_utilisateur_sbg;";
    public static final String CREATE_DATABASE_USER =
            "CREATE TABLE vmc_utilisateur_sbg (utilisateur_id INTEGER PRIMARY KEY AUTOINCREMENT, utilisateur_pseudo VARCHAR, utilisateur_email VARCHAR, utilisateur_mdp VARCHAR, utilisateur_photo TEXT, utilisateur_role VARCHAR);";
    public static final String INSERT_DATABASE_USER = " INSERT INTO vmc_utilisateur_sbg(utilisateur_pseudo, utilisateur_email, utilisateur_mdp, utilisateur_photo, utilisateur_role) VALUES ";

    // Constructeur
    public UserDataHandler(Context context) {
        super(context, "database.db", null, 1);
    }

    // Cette méthode est appelée lors de la création de la base de données
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE_USER);
        db.execSQL(INSERT_DATABASE_USER + "('Thurtwings', 'thurtwings@gmail.com', 'Admin', NULL, 'Administrator');");
    }

    // Cette méthode est appelée lors de la mise à jour de la base de données
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_DATABASE_USER);
        onCreate(db);
    }

    // Méthode pour ajouter un nouvel utilisateur
    public void addNewUser(SQLiteDatabase db, String pseudo, String mail, String password, String photo, String role) {
        String query = "INSERT INTO vmc_utilisateur_sbg (utilisateur_pseudo, utilisateur_email, utilisateur_mdp, utilisateur_photo, utilisateur_role) VALUES (?, ?, ?, ?, ?)";
        db.execSQL(query, new String[] {pseudo, mail, password, photo, role});
    }

    // Méthode pour récupérer les informations de l'utilisateur
    public String getUserInfo(String column, String what, String value)
    {
        String result = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + column + " FROM vmc_utilisateur_sbg WHERE " + what + " = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{value});

        // Vérifie si le curseur n'est pas null et se déplace vers le premier élément
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(column);

            // Vérifie si la colonne existe dans le curseur
            if (columnIndex != -1) {
                result = cursor.getString(columnIndex);
            }
        }

        // Ferme le curseur et la connexion à la base de données
        if (cursor != null) {
            cursor.close();
        }
        db.close();

        // Renvoie le résultat
        return result;
    }

    // Méthode pour imprimer la liste des utilisateurs
    public void printUserList() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM vmc_utilisateur_sbg", null);

        // Si le curseur peut se déplacer vers le premier élément
        if (cursor.moveToFirst())
        {
            int userIdIndex = cursor.getColumnIndex("utilisateur_id");
            int userPseudoIndex = cursor.getColumnIndex("utilisateur_pseudo");
            int userMailIndex = cursor.getColumnIndex("utilisateur_email");
            int userPasswordIndex = cursor.getColumnIndex("utilisateur_mdp");
            int userPictureIndex = cursor.getColumnIndex("utilisateur_photo");
            int userRoleIndex = cursor.getColumnIndex("utilisateur_role");

            do
            {
                int userId = cursor.getInt(userIdIndex);
                String userPseudo = cursor.getString(userPseudoIndex);
                String userMail = cursor.getString(userMailIndex);
                String userPassword = cursor.getString(userPasswordIndex);
                String userPicture = cursor.getString(userPictureIndex);
                String userRole = cursor.getString(userRoleIndex);

                System.out.println("User ID: " + userId);
                System.out.println("Pseudo: " + userPseudo);
                System.out.println("Mail: " + userMail);
                System.out.println("Password: " + userPassword);
                System.out.println("Picture: " + userPicture);
                System.out.println("Role: " + userRole);
                System.out.println("--------------------------");
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
    }

    // Méthode pour vider la table des utilisateurs
    public void truncateUserTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM vmc_utilisateur_sbg");
        db.execSQL("UPDATE sqlite_sequence SET seq = 0 WHERE name = 'vmc_utilisateur_sbg';");
        db.close();
    }
}