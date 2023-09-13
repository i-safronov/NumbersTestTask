package com.sfr.numberstesttask.di.dagger;

import com.sfr.numberstesttask.presentation.screen.fragment.main_page.FragmentMainPage;
import com.sfr.numberstesttask.presentation.screen.fragment.number_details.FragmentNumberDetails;

import javax.inject.Inject;
import dagger.Component;

@Component(modules = {AppModule.class, DomainModule.class, DataModule.class})
public interface AppComponent {

    void inject(FragmentMainPage fragmentMainPage);
    void inject(FragmentNumberDetails fragmentNumberDetails);

}
