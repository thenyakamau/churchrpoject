module ChurchProject {

    requires javafx.fxml;
    requires javafx.controls;
    requires okhttp3;
    requires retrofit2;
    requires com.google.gson;
    requires retrofit2.converter.gson;
    requires okio;
    requires adapter.rxjava2;
    requires com.jfoenix;
    requires fontawesomefx;

    opens home;
    opens controller;
    opens fxml;
    opens model;
    opens presenters;
    opens interfaces;

}