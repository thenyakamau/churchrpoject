package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.MembersDatum;

import java.net.URL;
import java.util.ResourceBundle;

public class MembersItemController implements Initializable {

    @FXML
    private Label members_item_name;

    private MembersDatum membersDatum;

    public MembersItemController(MembersDatum membersDatum) {
        this.membersDatum = membersDatum;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        members_item_name.setText(membersDatum.getName());

    }
}
