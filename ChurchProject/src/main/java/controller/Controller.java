package controller;

import interfaces.MembersInterface;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.MemberModel;
import model.MembersDatum;
import networking.Api;
import networking.ApiInterface;
import presenters.MembersPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private AnchorPane anchor_pane_main;

    @FXML
    private Button btn_dashboard;

    @FXML
    private ImageView menu_home_image_view;

    @FXML
    private Button btn_members;

    @FXML
    private Button btn_deacons;

    @FXML
    private Button btn_elders;

    @FXML
    private Pane pane_members;

    @FXML
    private VBox pnItems;

    @FXML
    private VBox total_members_vbox;

    @FXML
    private Label total_members_label;

    @FXML
    private VBox total_children_vbox;

    @FXML
    private Label total_children_label;

    @FXML
    private VBox total_youth_vbox;

    @FXML
    private Label total_youth_label;

    @FXML
    private VBox total_elders_vbox;

    @FXML
    private Label total_elders_label;

    @FXML
    private Pane pane_deacons;

    @FXML
    private Pane pane_elders;

    @FXML
    private Pane pane_dashboard;

    private MembersPresenter membersPresenter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*Image image = new Image(getClass().getResourceAsStream("/images/icons8_Home_32px.png"));
        menu_home_image_view.setImage(image);*/

        String fmlFile3 = "/fxml/dashboard.fxml";

        try {
            FXMLLoader loader1 = new FXMLLoader();
            Node node = (Parent) loader1.load(getClass().getResourceAsStream(fmlFile3));
            anchor_pane_main.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }


        btn_dashboard.setOnMouseClicked(mouseEvent -> {

           String fmlFile2 = "/fxml/dashboard.fxml";

            try {
                FXMLLoader loader1 = new FXMLLoader();
                Node node = (Parent) loader1.load(getClass().getResourceAsStream(fmlFile2));
                anchor_pane_main.getChildren().setAll(node);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
        btn_members.setOnMouseClicked(mouseEvent -> {

            String fmlFile = "/fxml/members.fxml";
            FXMLLoader loader = new FXMLLoader();

            try {
                Node node = (Parent) loader.load(getClass().getResourceAsStream(fmlFile));
                anchor_pane_main.getChildren().setAll(node);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


   /* public void handleClicks(ActionEvent actionEvent){


    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == btn_dashboard){

            pane_dashboard.toFront();
            btn_deacons.setVisible(false);

        }else if (mouseEvent.getSource() == btn_deacons){

            pane_deacons.toFront();

        }else if (mouseEvent.getSource() == btn_elders){

            pane_elders.toFront();

        }else if (mouseEvent.getSource() == btn_members){

            btn_members.toFront();
        }

    }*/
}
