package com.groupsix.fitbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseUser
import com.groupsix.fitbuddy.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        if (ParseUser.getCurrentUser() != null) {
            goToMainActivity()
        }

//        val firstObject = ParseObject("NewClass")
//        firstObject.put("message","Hey ! First message from android. Parse is now connected")
//        firstObject.saveInBackground {
//            if (it != null){
//                it.localizedMessage?.let { message -> Log.e("MainActivity", message) }
//                Toast.makeText(this, "Something went horribly wrong!", Toast.LENGTH_SHORT).show()
//            }else{
//                Log.d(TAG,"Object saved.")
//                Toast.makeText(this, "Class Created Successfully", Toast.LENGTH_SHORT).show()
//            }
//        }

        findViewById<Button>(R.id.login_btn).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            loginUser(username, password)
        }

        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            signUpUser(username, password)
        }
    }


    private fun signUpUser(username: String, password: String) {
        // Create the ParseUser
        val user = ParseUser()

// Set fields for the user to be created
        user.setUsername(username)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if (e == null) {
                Log.i(TAG, "Successfully signed in")
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show()
                //User has successfully created a new account
                //TODO: Navigate the user to the MainActivity
                //TODO: Show a toast to indicate that user successfully signed up for an account
                // Hooray! Let them use the app now.
            } else {
                //TODO: Show a toast that user sign up was not successful
                e.printStackTrace()
                Toast.makeText(this, "Sign Up Unsuccessful", Toast.LENGTH_SHORT).show()
                // Sign up didn't succeed. Look at the ParseException
                // to figure out what went wrong
            }
        }
    }

    private fun loginUser(username: String, password: String) {
        ParseUser.logInInBackground(
            username, password, ({ user, e ->
                if (user != null) {
                    Log.i(TAG, "Successfully logged in user")
                    // Hooray!  The user is logged in.
                    goToMainActivity()
                } else {
                    e.printStackTrace()
                    Toast.makeText(this, "Error logging in", Toast.LENGTH_SHORT).show()
                    // Signup failed.  Look at the ParseException to see what happened.
                }
            })
        )
    }


    private fun goToMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val TAG = "LoginActivity"
    }
}