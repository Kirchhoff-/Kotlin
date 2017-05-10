package com.example.kirchhoff.kotlin.example.intent

import android.app.Activity
import android.os.Bundle

/**
 * @author Kirchhoff-
 */
/*
*  From Article
*
*  https://medium.com/@passsy/starting-activities-with-kotlin-my-journey-8b7307f1e460
*
* */

//If use Extension function need to use this constant
const val INTENT_USER_ID = "user_id"

class UserDetailActivity : Activity() {

    //Classic variant translation from Java
    /* companion object {

         private val INTENT_USER_ID = "user_id"

         fun newIntent(context: Context, user: String): Intent {
             val intent = Intent(context, UserDetailActivity::class.java)
             intent.putExtra(INTENT_USER_ID, user)
             return intent
         }
     } */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Classic variant translation from Java
        //val userId = intent.getStringExtra(INTENT_USER_ID)
        //?: throw IllegalStateException("field $INTENT_USER_ID missing in Intent")

        // Variant with Extensions
        val userId = intent.getStringExtra(INTENT_USER_ID)
        requireNotNull(userId) { "no user_id provided in Intent extras" }
    }

}