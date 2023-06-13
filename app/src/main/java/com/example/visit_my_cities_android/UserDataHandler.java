package com.example.visit_my_cities_android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class UserDataHandler extends SQLiteOpenHelper
{
    public static final String  DROP_DATABASE_USER= "DROP TABLE IF EXISTS vmc_utilisateur_sbg;";
    public static final String CREATE_DATABASE_USER =
            "CREATE TABLE vmc_utilisateur_sbg (userId INTEGER PRIMARY KEY AUTOINCREMENT, userPseudo VARCHAR, userMail VARCHAR, userPassword VARCHAR, userPicture TEXT, userRole VARCHAR);";
    public static final String INSERT_DATABASE_USER = " INSERT INTO vmc_utilisateur_sbg(userPseudo, userMail, userPassword, userPicture, userRole) VALUES ";

    public UserDataHandler(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE_USER);
        db.execSQL(INSERT_DATABASE_USER + "('Thurtwings', 'thurtwings@gmail.com', 'Admin', NULL, 'Administrator');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_DATABASE_USER);
        onCreate(db);
    }


    public void addNewUser(SQLiteDatabase db, String pseudo, String mail, String password) {
        String query = "INSERT INTO vmc_utilisateur_sbg (userPseudo, userMail, userPassword, userPicture, userRole) VALUES (?, ?, ?, ?, ?)";
        db.execSQL(query, new String[] {pseudo, mail, password});
    }


    public String getUserInfo(String column, String what, String value)
    {
        String result = null;


        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + column + " FROM vmc_utilisateur_sbg WHERE " + what + " = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{value});

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(column);

            // Check if the column exists in the cursor
            if (columnIndex != -1) {
                result = cursor.getString(columnIndex);
            }
        }

        // Close the cursor and database connection
        if (cursor != null) {
            cursor.close();
        }
        db.close();

        // Return the result
        return result;
    }

    public void printUserList() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM vmc_utilisateur_sbg", null);

        if (cursor.moveToFirst())
        {
            int userIdIndex = cursor.getColumnIndex("userId");
            int userPseudoIndex = cursor.getColumnIndex("userPseudo");
            int userMailIndex = cursor.getColumnIndex("userMail");
            int userPasswordIndex = cursor.getColumnIndex("userPassword");
            int userPictureIndex = cursor.getColumnIndex("userPicture");
            int userRoleIndex = cursor.getColumnIndex("userRole");

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
    public void truncateUserTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM vmc_utilisateur_sbg");
        db.execSQL("UPDATE sqlite_sequence SET seq = 0 WHERE name = 'User';");
        db.close();
    }

}
