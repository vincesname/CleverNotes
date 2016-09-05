package com.apps.mangel.clevernotes.BaseDeDonnees;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Créé by Vincent on 05/09/2016.
 */
public class MySqlConnector extends AsyncTask<String, Void, String> {


    //  new LongOperation().execute("");


    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    protected String doInBackground(String... params) {
        for (int i = 0; i < 5; i++) {

            try {
                // This will load the MySQL driver, each DB has its own driver
                Class.forName("com.mysql.jdbc.Driver");
                // Setup the connection with the DB
                connect = DriverManager.getConnection("jdbc:mysql://212.227.108.163:3306/clevernotes?"
                        + "user=clevernotes&password=cleve3er");

                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
                // Result set get the result of the SQL query
                resultSet = statement.executeQuery("call clevernotes.test_ps");
                // writeResultSet(resultSet);

//            // PreparedStatements can use variables and are more efficient
//            preparedStatement = connect
//                    .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
//            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//            // Parameters start with 1
//            preparedStatement.setString(1, "Test");
//            preparedStatement.setString(2, "TestEmail");
//            preparedStatement.setString(3, "TestWebpage");
//            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//            preparedStatement.setString(5, "TestSummary");
//            preparedStatement.setString(6, "TestComment");
//            preparedStatement.executeUpdate();

                preparedStatement = connect
                        .prepareStatement("call test_ps");
                resultSet = preparedStatement.executeQuery();
                //  writeResultSet(resultSet);

                // Remove again the insert comment
//            preparedStatement = connect
//                    .prepareStatement("delete from feedback.comments where myuser= ? ; ");
//            preparedStatement.setString(1, "Test");
//            preparedStatement.executeUpdate();

                resultSet = statement
                        .executeQuery("call test_ps");
                //   writeMetaData(resultSet);

            } catch (Exception e) {
                String fdzfz = e.getMessage();
                fdzfz += "";
            } finally {
                close();
            }
        }
        return "Executed";
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void onPostExecute(String result) {

        // might want to change "executed" for the returned string passed
        // into onPostExecute() but that is upto you
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}