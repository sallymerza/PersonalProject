package gui;

import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;

/** @author Sally Al **/
public class TabAndContent {

    private Tab activeTab;
    private StackPane activeTabContent;
    private int activeTabId;



    public Tab getActiveTab () {
        return activeTab;
    }
    public void setActiveTab (Tab activeTab) {
        this.activeTab = activeTab;
    }
    public StackPane getActiveTabContent () {
        return activeTabContent;
    }
    public void setActiveTabContent (StackPane activeTabContent) {
        this.activeTabContent = activeTabContent;
    }
    public int getActiveTabId () {
        return activeTabId;
    }
    public void setActiveTabId (int activeTabId) {
        this.activeTabId = activeTabId;
    }

}
