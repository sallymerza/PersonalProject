package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


/**
 * @author Sally Al
 **/
public class Console {
    private TabPane myTabPane = new TabPane();

    protected void addConsole (Group root, Scene scene) {
        BorderPane borderPane = new BorderPane();
        TextArea myTextArea = createTextArea();
        Tab myTab = new Tab();
        myTab.setClosable(false);
        myTabPane.getTabs().add(myTab);
        myTab.setContent(myTextArea);
        borderPane.prefWidthProperty().bind(scene.widthProperty().multiply(1));
         borderPane.prefHeightProperty().bind(scene.heightProperty().multiply(1));
        // borderPane.setLayoutY(scene.getHeight() / 1.5);
        borderPane.setBottom(myTabPane);
        borderPane.setStyle("-fx-border-color: lightgray;");
        myTab.setText(("CONSOLE"));
        go(myTabPane);
        undo(myTabPane);
        root.getChildren().add(borderPane);
        resizeHeight(scene.getHeight());

    }

    public void resizeHeight (double height) {
        myTabPane.setPrefHeight(height / 3.5);

    }

    private void undo (TabPane myTabPane) {
        Button undo = addButton(myTabPane, "undo.png");
        undo.setOnAction(e -> {
            System.out.println("undo");
        });
    }

    private void go (TabPane myTabPane) {
        Button add = addButton(myTabPane, "go.png");
        add.setOnAction(e -> {
            System.out.println("go");
        });

    }

    private Button addButton (TabPane myTabPane, String s) {
        Tab tab = new Tab();
        tab.setClosable(false);
        tab.setStyle("-fx-padding:0 0 3 0 ;");
        Button add = new Button();
        add.setStyle("-fx-padding:9 4 9 4 ;");
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(s));
        add.setGraphic(new ImageView(image));
        tab.setGraphic(add);
        myTabPane.getTabs().add(tab);
        return add;
    }

    private TextArea createTextArea () {
        TextArea myTextArea = new TextArea();
        myTextArea = new TextArea();
        myTextArea.setWrapText(true);
        myTextArea.setEditable(true);
        return myTextArea;
    }

}
