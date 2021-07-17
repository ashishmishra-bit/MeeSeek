package co.kit.gfg.chatapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class UserInfo {


    private static final String MY_PREFERENCE_NAME = "co.kit.gfg.chatapp";
    private static final String MY_USERNAME = "my_username";
    private static final String MY_BLUETOOTH_NAME = "my_bluetooth_name";
    private static final String is_Logged_In="logged";

    public static void saveDetails(Context context, String bluetootName, String userName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        Editor sharedPreferencesEditor=sharedPreferences.edit();
        sharedPreferencesEditor.putString(MY_BLUETOOTH_NAME,bluetootName);
        sharedPreferencesEditor.putString(MY_USERNAME,userName);
        sharedPreferencesEditor.putBoolean(is_Logged_In,true);
        sharedPreferencesEditor.apply();

    }
    public static String Username(Context context)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(MY_USERNAME,null);
    }

    public static String BluetoothName(Context context)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(MY_BLUETOOTH_NAME,null);
    }
    public static boolean isLoggedIn(Context context)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(is_Logged_In,false);
    }
    public static void logout(Context context)
    {

        SharedPreferences sharedPreferences=context.getSharedPreferences(MY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        Editor sharedPreferencesEditor=sharedPreferences.edit();

        sharedPreferencesEditor.clear();
        sharedPreferencesEditor.apply();
        //Starting Login Activity
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);




    }



}