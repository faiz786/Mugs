package com.bebetterprogrammer.mugs.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bebetterprogrammer.mugs.R
import com.bebetterprogrammer.mugs.databinding.ActivityGoogleLoginBinding
import com.bebetterprogrammer.mugs.model.Users
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class GoogleLogin : AppCompatActivity() {

    lateinit var binding: ActivityGoogleLoginBinding
    lateinit var mAuth: FirebaseAuth
    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var databaseUsers: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_google_login)

        initView()
    }

    private fun initView() {
        databaseUsers = FirebaseDatabase.getInstance().getReference("users")
        googleSignIn()
        signOut()
    }

    private fun googleSignIn() {
        mAuth = FirebaseAuth.getInstance()
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        binding.btnGoogleSignIn.setOnClickListener(View.OnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, 1)
         })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1)
        {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {
        try {
            val account: GoogleSignInAccount? = task?.getResult(ApiException::class.java)
            Toast.makeText(this, "SignIn Successfully",Toast.LENGTH_SHORT).show()
            firebaseGoogleAuth(account)
        } catch (e: ApiException) {
            Log.w("Prashant", "signInResult:failed code=" + e.statusCode)
            Toast.makeText(this, "SignIn Failed",Toast.LENGTH_SHORT).show()
            firebaseGoogleAuth(null)
        }
    }

    private fun firebaseGoogleAuth(account: GoogleSignInAccount?) {
        var authCredential: AuthCredential = GoogleAuthProvider.getCredential(account?.idToken, null)
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, OnCompleteListener {
            if(it.isSuccessful)
            {
                Toast.makeText(this, "SignIn Successfully",Toast.LENGTH_SHORT).show()
                var user: FirebaseUser? = mAuth.currentUser
                updateUI(user)
            }
            else
            {
                Toast.makeText(this, "SignIn failed",Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        })

    }

    // to get user informations
    private fun updateUI(user: FirebaseUser?) {
        val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(applicationContext)
        if(account != null)
        {
            //access users information here
            val username = account.displayName
            val user_id = user?.uid

            storeInUserTable(user_id, username)
            binding.btnSignOut.visibility = View.VISIBLE
            val intent = Intent(this, Dashboard::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
        }
    }

    // to sign out and disconnect the account
    private fun signOut()
    {
        binding.btnSignOut.setOnClickListener(View.OnClickListener {
            mGoogleSignInClient.signOut()
                .addOnCompleteListener(this) {
                    // ...
                }
            Toast.makeText(this, "Signed Out",Toast.LENGTH_SHORT).show()
            binding.btnSignOut.visibility = View.GONE
        })
    }

    // To store information in the 'users' table
    private fun storeInUserTable(userId: String?, username: String?) {
        val user = Users(userId, username, 0)
        if (userId != null) {
            databaseUsers.child(userId).setValue(user)
        }
    }
}
