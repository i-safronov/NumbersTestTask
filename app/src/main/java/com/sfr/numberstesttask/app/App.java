package com.sfr.numberstesttask.app;

import android.app.Application;

import com.sfr.numberstesttask.di.dagger.AppComponent;
import com.sfr.numberstesttask.di.dagger.AppModule;
import com.sfr.numberstesttask.di.dagger.DaggerAppComponent;

import dagger.Component;

public class App extends Application {

    private AppComponent appComponent;

    public App() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(App.this)).build();
    }

}
