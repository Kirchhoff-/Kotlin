package com.example.kirchhoff.kotlin.example.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.kirchhoff.kotlin.R
import kotlinx.android.synthetic.main.a_other.*

/**
 * @author Kirchhoff-
 */
class OtherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_other)
        val argument = "Some argument"
        button.setOnClickListener {
            // Classic variant translation from java
            // val intent = UserDetailActivity.newIntent(this, "some argument")
            // startActivity(intent)

            // Variant with extension function
            // super simple, no arguments for simple Activities but doesn't prevent a crash for this one
            // launchActivity<UserDetailActivity>()

            // Add the required argument
            launchActivity<UserDetailActivity> {
                putExtra(INTENT_USER_ID, argument)
            }

            // add custom flags
            launchActivity<UserDetailActivity> {
                putExtra(INTENT_USER_ID, argument)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }

            // use options for cool animations
            // val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, argument, "avatar")
            // launchActivity<UserDetailActivity>(options = options) {
            //     putExtra(INTENT_USER_ID, argument)
            // }

            // requestCode, why not!?
            launchActivity<UserDetailActivity>(requestCode = 1234) {
                putExtra(INTENT_USER_ID, argument)
            }
        }
    }
}