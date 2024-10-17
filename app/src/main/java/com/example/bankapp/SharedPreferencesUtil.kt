package com.example.bankapp

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SharedPreferencesUtil {


    fun getJwtToken(context: Context): String? {

         val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build();
            val sharedPrefs = EncryptedSharedPreferences.create(
            context,
            "MyPrefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

            return sharedPrefs.getString("token",null)
        }


    }
