module ChurchProject {

    requires javafx.fxml;
    requires javafx.controls;
    requires okhttp3;
    requires retrofit2;
    requires com.google.gson;
    requires converter.gson;
    requires okio;
    requires adapter.rxjava2;
    requires com.jfoenix;


    opens home;
    opens controller;
    opens fxml;
    opens model;

}