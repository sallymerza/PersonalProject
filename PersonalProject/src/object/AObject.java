package object;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** @author Sally Al **/
public class AObject {
    private String myName;
    private int id =1;
    private ImageView myImage;
    private double myX;
    private double myY;

    //if no imgae set the origina
    // if no location set 0 0
    //can set image and location
    public AObject(Group root){
        Image image = new Image(getClass().getClassLoader().getResourceAsStream("car.gif"));
        myImage = new ImageView(image);
        root.getChildren().add(myImage);


    }


}
