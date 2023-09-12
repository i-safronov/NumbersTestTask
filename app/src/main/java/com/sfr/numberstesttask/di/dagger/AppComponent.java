package com.sfr.numberstesttask.di.dagger;

import dagger.Component;

@Component(modules = {AppModule.class, DomainModule.class, DataModule.class})
public interface AppComponent {
    
}
