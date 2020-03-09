package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class M_DashBoard implements Initializable {

    @FXML
    private AnchorPane dashboard_anchor_pane;

    @FXML
    private JFXHamburger hamburger_javafx;

    @FXML
    private JFXDrawer drawer_jfx_menu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         String fxmlFile = "/fxml/drawer_content.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane box = loader.load(getClass().getResourceAsStream(fxmlFile));
            drawer_jfx_menu.setSidePane(box);
            drawer_jfx_menu.setOverLayVisible(false);
            System.out.println("Called");

            for (Node node: box.getChildren()){

                node.setOnMouseClicked(e->{

                    if (node.getAccessibleText() != null){



                    }

                });

            }

            HamburgerBackArrowBasicTransition basicTransition = new HamburgerBackArrowBasicTransition(hamburger_javafx);
            basicTransition.setRate(-1);

            hamburger_javafx.setOnMousePressed(e -> {

                basicTransition.setRate(basicTransition.getRate() * -1);
                basicTransition.play();

                if (drawer_jfx_menu.isOpened()) {
                    drawer_jfx_menu.close();
                } else {

                    drawer_jfx_menu.open();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
