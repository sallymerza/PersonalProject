package gui;

import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;


/**
 * @author Sally Al
 * @resource http://stackoverflow.com/questions/17018562/how-to-create-tabs-with-icons-in-javafx
 **/
public class MainTabs {
    private TabPane myTabPane;
    private int myId = 0;
    private Map<Integer, Tab> map = new HashMap<>();
    private int hack = 0;
    private int activeTabId = 1;

    public MainTabs () {
        myTabPane = new TabPane();
    }

    public void addTab (Group root, Scene scene) {
        if (hack == 0) {
            PlusTab(root, scene);
            hack++;
        }
        Tab myTab = createGeneralTab(root, scene);
        addTextToTab(myTab, "Tab");
        myTab.setId(Integer.toString(myId));
        addBehavor(myTab);
        map.put(myId, myTab);// not sure
        setActiveTabId(myId);
        myId++;

    }

    private void PlusTab (Group root, Scene scene) {
        Tab plusTab = createGeneralTab(root, scene);
        plusTab.setClosable(false);
        plusTab.setStyle("-fx-padding:0 0 03 0 ;");
        Button add = new Button("+");
        add.setOnAction(e -> {
            addTab(root, scene);
        });
        plusTab.setGraphic(add);

    }

    private Tab createGeneralTab (Group root, Scene scene) {
        HBox myHBox = new HBox();
        myHBox.setAlignment(Pos.CENTER);
        myHBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("whitesmoke"), null, null)));
        Tab myTab = new Tab();
        myTab.setContent(myHBox);
        myTabPane.getTabs().add(myTab);
        BorderPane borderPane = new BorderPane();
        borderPane.prefWidthProperty().bind(scene.widthProperty().multiply(0.5));
        borderPane.prefHeightProperty().bind(scene.heightProperty().multiply(0.5));
        borderPane.setCenter(myTabPane);
        root.getChildren().add(borderPane);
        return myTab;
    }

    private void addBehavor (Tab myTab) {
        myTab.setOnClosed(e -> {
            map.remove(Integer.parseInt(myTab.getId()));
        });

        myTab.setOnSelectionChanged(e -> {
            setActiveTabId(Integer.parseInt(myTab.getId()));
        });
    }

    private void addTextToTab (Tab myTab, String value) {
        myTab.setText(value);

    }

    public int getActiveTabId () {
        return activeTabId;
    }

    private void setActiveTabId (int activeTabId) {
        this.activeTabId = activeTabId;
    }

}
// You need to create a new border pane for each new tab
// otherwise invocation error
