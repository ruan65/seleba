package org.premiumapp.celeba;

import android.app.Application;
import android.content.Context;

import org.premiumapp.celeba.dependencyinjection.DependencyInjection;

import timber.log.Timber;

/**
 * Created by a on 13.07.17.
 */

public class ThisApp extends Application {

    protected DependencyInjection dependencyInjection = new DependencyInjection();

    {
        Timber.plant(new Timber.DebugTree());
    }

    public static DependencyInjection getDependencyInjection(Context context) {
        return ((ThisApp) context.getApplicationContext()).dependencyInjection;
    }
}
