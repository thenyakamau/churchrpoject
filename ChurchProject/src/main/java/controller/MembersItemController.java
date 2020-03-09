package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MembersDatum;
import networking.Api;

import java.net.URL;
import java.util.ResourceBundle;

public class MembersItemController implements Initializable {

    @FXML
    private ImageView members_item_image_view;

    @FXML
    private Label members_item_name;

    @FXML
    private Label members_item_email;

    @FXML
    private Label members_item_number;

    @FXML
    private Label members_item_age;

    @FXML
    private Label members_item_affliation;

    @FXML
    private Label members_item_marital_status;

    @FXML
    private Button members_item_active_status;

    @FXML
    private MenuItem members_item_option_view;

    @FXML
    private MenuItem members_item_option_delete;

    private MembersDatum membersDatum;

    public MembersItemController(MembersDatum membersDatum) {
        this.membersDatum = membersDatum;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        members_item_name.setText(membersDatum.getName());
        members_item_email.setText(membersDatum.getEmail());

        System.out.println(Api.getBaseUrl()+membersDatum.getImage());

        Image image = new Image(Api.getBaseUrl()+membersDatum.getImage());
        members_item_image_view.setImage(image);

    }
}
