package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
    private ImageView menu_home_image_view;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Node[] nodes = new Node[10];

        for(int i = 0; i< nodes.length; i++){

            String fmlFile = "/fxml/members_item.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                nodes[i] = (Parent) loader.load(getClass().getResourceAsStream(fmlFile));
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Image image = new Image("/images/icons8_Home_32px");
        menu_home_image_view.setImage(image);

    }
}
