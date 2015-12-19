package gui;

import enums.Titles;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * @author Sally Al
 **/
public class GUIController {

    private Stage myStage;
    private Scene myScene;
    private Group myRoot;
    private MainTabs mainTabs;

    public GUIController (Stage stage) {
        initializeScene(stage);
        mainTabs = new MainTabs();
        addTab();

    }

    protected void addTab () {
       mainTabs.addTab(myRoot, myScene);
    }

    private void initializeScene (Stage stage) {
        myStage = new Stage();
        myStage = stage;
        myRoot = new Group();
        myScene = new Scene(myRoot, 600, 600, Color.BEIGE);
        myStage.setTitle(Titles.Main.getValue());
        myStage.setScene(myScene);
        myStage.show();

    }

}
