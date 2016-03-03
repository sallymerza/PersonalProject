package gui;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


/**
 * @author Sally Al
 * @resource http://stackoverflow.com/questions/17018562/how-to-create-tabs-with-icons-in-javafx
 **/
public class MainTabs {
    private TabPane myTabPane;
    private int myId = 1;
    private int activeTabId = 1;
    private double tabWidth = 200, tabHeight = 200;

    private Map<Integer, Tab> tabMap = new HashMap<>();
    private Map<Integer, StackPane> tabContentMap = new HashMap<>();

    public TabAndContent getActiveTabAndContent(){
        int id = getActiveTabId();
        TabAndContent tempTab = new TabAndContent();
        tempTab.setActiveTabId(id);
        tempTab.setActiveTab(tabMap.get(id));
        tempTab.setActiveTabContent(tabContentMap.get(id));
        return tempTab;
    }

    public MainTabs () {
        myTabPane = new TabPane();
        myTabPane.setPrefSize(tabWidth, tabHeight);

    }

    public void addTab (Group root, Scene scene) {

        Tab myTab = createGeneralTab(root, scene);

        addTextToTab(myTab, String.valueOf(myId));
        myTab.setId(Integer.toString(myId));

        addBehavor(myTab);
        SingleSelectionModel<Tab> selectionModel = myTabPane.getSelectionModel();
        selectionModel.select(myTab);
        tabMap.put(myId, myTab);// not sure
        setActiveTabId(myId);
        myId++;

    }

    Tab createGeneralTab (Group root, Scene scene) {
        resizeHeight(scene.getHeight());
        resizeWidth(scene.getWidth());
        Tab myTab = new Tab();
        tabContentMap.put(myId, createTabContent(scene));
        myTab.setContent(tabContentMap.get(myId));
        myTabPane.getTabs().add(myTab);
        myTabPane.getSelectionModel().select(myTab);

        BorderPane borderPane = new BorderPane();
        borderPane.prefWidthProperty().bind(scene.widthProperty().multiply(1));
        borderPane.setLeft(myTabPane);
        root.getChildren().addAll(borderPane);
        return myTab;
    }

    private StackPane createTabContent (Scene scene) {

        StackPane myStackPane = new StackPane();
        myStackPane.setPrefSize(tabWidth, tabHeight);
        myStackPane.setStyle("-fx-border-color: red;");
        myStackPane.setStyle("-fx-background-color: #8fbc8f;");

        Canvas canvas = new Canvas(tabWidth, tabHeight);
        draw(canvas);
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        canvas.widthProperty().addListener(evt -> draw(canvas));
        canvas.heightProperty().addListener(evt -> draw(canvas));

        Image image = new Image(getClass().getClassLoader().getResourceAsStream("car.gif"));
        ImageView myImage = new ImageView(image);

        myStackPane.getChildren().addAll(canvas, myImage);
        return myStackPane;
    }

    private void draw (Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, tabWidth, tabHeight);
        gc.setFill(Color.DARKSEAGREEN);
        gc.fillRect(0, 0, tabWidth, tabHeight);
    }

    public void resizeHeight (double h) {
        double height = h / 1.5;
        myTabPane.setPrefHeight(height);
        // myStackPane.setPrefHeight(height);
        tabHeight = height;

    }

    public void resizeWidth (double w) {
        double width = w / 1.8;
        myTabPane.setPrefWidth(width);
        // myStackPane.setPrefWidth(width);
        tabWidth = (width);
    }

    private void addBehavor (Tab myTab) {
        myTab.setOnClosed(e -> {
            int idTabToRemove = Integer.parseInt(myTab.getId());
            tabMap.remove(idTabToRemove);
            tabContentMap.remove(idTabToRemove);
            // remove the object and all lines
        });

        myTab.setOnSelectionChanged(e -> {
            setActiveTabId(Integer.parseInt(myTab.getId()));
            myTab.setContent(tabContentMap.get(getActiveTabId()));

        });
    }

    private void addTextToTab (Tab myTab, String value) {
        myTab.setText(value);
    }

    private int getActiveTabId () {
        return activeTabId;
    }

    private void setActiveTabId (int activeTabId) {
        this.activeTabId = activeTabId;
    }

}
