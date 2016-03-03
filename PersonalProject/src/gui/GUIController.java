package gui;

import enums.Titles;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * @author Sally Al
 **/
public class GUIController {

    private Stage myStage;
    private Scene myScene;
    private Group myRoot;
    private MainTabs myMainTabs;
    private SideBar mySideBar;
    private Console myConsole;

    public GUIController (Stage stage) {
        initializeScene(stage);
         myConsole = new Console();
         myConsole.addConsole(myRoot, myScene);
         mySideBar = new SideBar(myRoot, myScene);
         myMainTabs = new MainTabs();
         addPlusTab();
        myMainTabs.addTab(myRoot, myScene);


    }

    private void addPlusTab () {
        Tab plusTab = myMainTabs.createGeneralTab(myRoot, myScene);
        plusTab.setClosable(false);
        plusTab.setStyle("-fx-padding:0 0 03 0 ;");
        Button add = new Button("+");
        add.setOnAction(e -> {
            myMainTabs.addTab(myRoot, myScene);
        });
        plusTab.setGraphic(add);
    }

    private void initializeScene (Stage stage) {
        myStage = new Stage();
        myStage = stage;
        myRoot = new Group();
        myScene = new Scene(myRoot, 600, 600, Color.BEIGE);
        setSize();
        myStage.setTitle(Titles.Main.getValue());
        myStage.setScene(myScene);
        myStage.show();

    }

    private void setSize () {
        myScene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed (ObservableValue<? extends Number> observableValue,
                                 Number oldSceneWidth,
                                 Number newSceneWidth) {
                mySideBar.resizeWidth((double) newSceneWidth);
                myMainTabs.resizeWidth((double) newSceneWidth);
            }
        });

        myScene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed (ObservableValue<? extends Number> observable,
                                 Number oldValue,
                                 Number newSceneHeight) {
                mySideBar.resizeHeight((double) newSceneHeight);
                myMainTabs.resizeHeight((double) newSceneHeight);
                myConsole.resizeHeight((double) newSceneHeight);
            }
        });
    }

}
