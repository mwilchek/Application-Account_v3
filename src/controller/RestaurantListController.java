package controller;

import Core.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import views.ProfileDriver;
import views.RestaurantListDriver;
import java.io.IOException;

public class RestaurantListController {

    public static Restaurant row;

    @FXML
    private TextField searchKey;
    @FXML
    private TableView<Restaurant> restaurantTable;
    @FXML
    private TableColumn<Restaurant, String> nameColumn;
    @FXML
    private TableColumn<Restaurant, String> streetAddressColumn;
    @FXML
    private TableColumn<Restaurant, String> cityColumn;
    @FXML
    private TableColumn<Restaurant, String> stateColumn;
    @FXML
    private TableColumn<Restaurant, String> zipColumn;
    @FXML
    private TableColumn<Restaurant, String> latitudeColumn;
    @FXML
    private TableColumn<Restaurant, String> longitudeColumn;
    @FXML
    private TableColumn<Restaurant, String> phoneNumColumn;
    @FXML
    private TableColumn<Restaurant, String> photoColumn;

    // Reference to the main application.
    private RestaurantListDriver restaurantApp;

    /** Initializes the controller class. This method is automatically called after the fxml file has been loaded */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        streetAddressColumn.setCellValueFactory(cellData -> cellData.getValue().streetAddressProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        zipColumn.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
        latitudeColumn.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
        longitudeColumn.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
        phoneNumColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
        photoColumn.setCellValueFactory(cellData -> cellData.getValue().photoProperty());
    }

    public void setRestaurantListApp(RestaurantListDriver restaurantApp) {
        this.restaurantApp = restaurantApp;

        // Add observable list data to the table
        restaurantTable.setItems(restaurantApp.getRestaurantData());
    }

    /** Search logic and update table view for the result */
    public void handleEnterPressed(KeyEvent event) {
        String latitude = "";
        String longitude = "";
        String key = "";
        boolean coordinate = false;
        boolean state = false;
        boolean name = false;
        Restaurant restaurantKey;
        ObservableList<Restaurant> searchRestaurantResultTable = FXCollections.observableArrayList();

        if (event.getCode() == KeyCode.ENTER) {
            key = searchKey.getText();

            // Check if text entered is a coordinate by looking for ','
            if (key.indexOf(',') >= 0) {
                coordinate = true;
                name = false;
                state = false;
            }

            //if key is empty
            if (key.equals("")) {
                restaurantTable.setItems(restaurantApp.getRestaurantData());
            }

            //if coordinate
            if (coordinate) {
                latitude = key.split(", ")[0]; // example 1: 38.340889,-90.399952
                longitude = key.split(", ")[1]; // example 2: 38.7517314, -77.4727505
                System.out.println(latitude + " " + longitude);
                restaurantKey = new Restaurant(latitude, longitude);
                if (restaurantApp.getRestaurantBSTree().contains(restaurantKey)) {
                    //create the new observable list and add the result to this list
                    searchRestaurantResultTable.add(restaurantApp.getRestaurantBSTree().get(restaurantKey));
                    //set new result of search to observrable list
                    //update view
                    restaurantTable.setItems(searchRestaurantResultTable);
                } else {
                    //reset the observable list
                    searchRestaurantResultTable.clear();
                    //set new result of search to observrable list
                    //update view
                    restaurantTable.setItems(searchRestaurantResultTable);
                }
            }

            // Can't figure out how to do .contains() with just a string
        }
    }

    @FXML
    private void handleRowSelect(MouseEvent event) {
        if (event.getClickCount() == 2) {
            row = restaurantTable.getSelectionModel().getSelectedItem();
            if (row == null) return;
            if (row != null) {
                System.out.println(row.toString());
                try {
                    new ProfileDriver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
