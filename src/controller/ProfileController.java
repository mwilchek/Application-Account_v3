package controller;

import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import static controller.RestaurantListController.row;

public class ProfileController implements Initializable, MapComponentInitializedListener {

    private GoogleMap map;

    @FXML
    TextField name;
    @FXML
    TextField city;
    @FXML
    TextField address;
    @FXML
    TextField state;
    @FXML
    TextField zip;
    @FXML
    TextField phone;
    @FXML
    ImageView profilePic;
    @FXML
    GoogleMapView location;
    @FXML
    public Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(row.getName());
        address.setText(row.getStreetAddress());
        city.setText(row.getCity());
        state.setText(row.getState());
        zip.setText(row.getZip().substring(0, 5));
        phone.setText(row.getPhoneNum());

        location.addMapInializedListener(this);
    }

    public void logOff() {
        System.exit(0);
    }

    @FXML
    public void close() {
        closeButton.getScene().getWindow().hide();
    }

    @Override
    public void mapInitialized() {
        MapOptions mapOptions = new MapOptions();

        double lat = Double.parseDouble(row.getLatitude());
        double lon = Double.parseDouble(row.getLongitude());

        mapOptions.center(new LatLong(lat, lon))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = location.createMap(mapOptions);

        //Add a marker to the map
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position( new LatLong(lat, lon) )
                .visible(Boolean.TRUE)
                .title(row.getName() + "'s Location");

        Marker marker = new Marker( markerOptions );

        map.addMarker(marker);


        URL url2 = null;
        try {
            url2 = new URL(row.getPhoto());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            try {
                url2 = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png");
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }
        Image image = new Image(String.valueOf(url2));
        profilePic.setImage(image);
    }

}
