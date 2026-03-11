package com.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public HBox menuBarHBox;
    public Pane contentPane;

    private final String CONTENT_VIEW_FOLDER = "content_view/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // load a default site
        loadContentView("home-view.fxml");
    }

    /**
     * gets the name of the fxml file that should be loaded to `contentPane` from the Button ID
     * and calls loadContentView with that value
     * @param actionEvent clicked Button
     */
    public void onMenuBarButtonClicked(ActionEvent actionEvent) {
        Button src = (Button) actionEvent.getSource();
        String target = src.getId();

        if (!target.isEmpty()) {
            System.out.println("Trying to load: " + getClass().getResource(CONTENT_VIEW_FOLDER + target));
            loadContentView(target);
        }
    }

    /**
     * loads a fxml file in `contentPane`
     * @param view fxml file in resources/com/frontend/'CONTENT_VIEW_FOLDER'
     */
    private void loadContentView(String view) {
        try {
            FXMLLoader contentLoader = new FXMLLoader(getClass().getResource(CONTENT_VIEW_FOLDER + view));

            // should prevent flickering over .clear();, .add();
            contentPane.getChildren().setAll(Collections.singleton(contentLoader.load()));
        } catch (IOException e) {
            System.out.println("[MainController] Could not find target fxml");
        }
    }
}
