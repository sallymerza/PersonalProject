package gui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;


/**
 * @author Sally Al
 **/
public class SideBar {
    private TabPane myTabPane = new TabPane();

    protected SideBar (Group root, Scene scene) {
        addTabs(root, scene, "History");
        addTabs(root, scene, "User Commands");
    }

    private void addTabs (Group root, Scene scene, String value) {

        HBox myHBox = new HBox();
        myHBox.setAlignment(Pos.CENTER);
        myHBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("whitesmoke"), null,null)));
        Tab myTab = new Tab();
        myTab.setContent(myHBox);
        myTabPane.getTabs().add(myTab);
        resizeWidth(scene.getWidth());
        resizeHeight(scene.getHeight());
        BorderPane borderPane = new BorderPane();
        myHBox.setStyle("-fx-border-color: lightgray;");
        borderPane.prefWidthProperty().bind(scene.widthProperty().multiply(1));
        borderPane.setRight(myTabPane);
        addTextToTab(myTab, value);
        root.getChildren().add(borderPane);


    }


    public void resizeHeight (double height) {
        myTabPane.setPrefHeight(height/1.5);

    }

    public void resizeWidth (double width) {
        myTabPane.setPrefWidth(width/3);
    }

    private void addTextToTab (Tab myTab, String value) {
        myTab.setText(value);
    }

}
