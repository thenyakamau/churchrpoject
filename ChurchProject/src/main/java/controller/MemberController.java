package controller;

import interfaces.MembersInterface;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.MembersDatum;
import presenters.MembersPresenter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberController implements Initializable, MembersInterface {

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


    private MembersPresenter membersPresenter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        membersPresenter = new MembersPresenter(this);
        Platform.runLater(() -> membersPresenter.getMembersList());
    }

    @Override
    public void membersData(List<MembersDatum> membersDatumList) {

        Platform.runLater(() -> {
            Node[] nodes = new Node[membersDatumList.size()];

            for(int i = 0; i< nodes.length; i++){

                MembersDatum membersDatum = membersDatumList.get(i);
                MembersItemController membersItemController = new MembersItemController(membersDatum);
                String fmlFile = "/fxml/members_item.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    loader.setController(membersItemController);
                    nodes[i] = (Parent) loader.load(getClass().getResourceAsStream(fmlFile));
                    pnItems.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
