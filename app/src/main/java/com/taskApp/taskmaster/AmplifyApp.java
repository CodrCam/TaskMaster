package com.taskApp.taskmaster;

import android.app.Application;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;

public class AmplifyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        try {
            // Add these lines to add the AWSApiPlugin plugins
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());

            System.out.println("Initialized Amplify");
        } catch (AmplifyException e) {
            System.err.println("Failed to initialize Amplify");
            e.printStackTrace();
        }
    }
}
