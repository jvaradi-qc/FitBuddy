package com.groupsix.fitbuddy

import android.app.Application
import com.groupsix.fitbuddy.fragments.HealthData
import com.groupsix.fitbuddy.fragments.HealthData2
import com.parse.Parse
import com.parse.ParseObject
import com.groupsix.fitbuddy.fragments.Post

class FitBuddyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ParseObject.registerSubclass(Post::class.java)
        ParseObject.registerSubclass(HealthData::class.java)
        ParseObject.registerSubclass(HealthData2::class.java)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );
    }
}