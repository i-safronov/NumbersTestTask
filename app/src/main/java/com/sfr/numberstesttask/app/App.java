package com.sfr.numberstesttask.app;

import android.app.Application;

import com.sfr.numberstesttask.di.dagger.AppComponent;
import com.sfr.numberstesttask.di.dagger.AppModule;
import com.sfr.numberstesttask.di.dagger.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    public App() {
        super();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(App.this)).build();
    }

}
