package org.premiumapp.celeba;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by a on 13.07.17.
 */

public class ThisApp extends Application {

    {
        Timber.plant(new Timber.DebugTree());
    }
}
