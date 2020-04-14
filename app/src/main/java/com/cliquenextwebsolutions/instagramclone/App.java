package com.cliquenextwebsolutions.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("YZagioapoxT407kfBuORePUiWSSDFGpvgqAOxcjC")
            .clientKey("JSpYpu2xulDsidCoa9hJgg3XJcSdnBPGPsBBrKqO")
            .server("https://parseapi.back4app.com/")
            .build()
        );
    }
}
