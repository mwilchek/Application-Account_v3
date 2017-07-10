package views;

import Core.ReadExcel;
import Core.Restaurant;
import dataStructures.BinarySearchTree;
import controller.RestaurantListController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import static controller.LoginController.restaurant;

public class RestaurantListDriver {
    private static Stage restaurantListStage = new Stage();
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phoneNum;
    private String photo;
    private ObservableList<Restaurant> restaurantData = FXCollections.observableArrayList();
    private BinarySearchTree<Restaurant> restaurantBSTree;
    private BorderPane rootLayout;

    public RestaurantListDriver() throws IOException {
        loadRestaurant();
        initRootLayout();
        showRestaurantData();

        restaurantListStage.setTitle("Restaurant List Page");
    }

    public BinarySearchTree<Restaurant> getRestaurantBSTree() {
        return restaurantBSTree;
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RestaurantListDriver.class.getResource("RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            restaurantListStage.setScene(scene);
            restaurantListStage.setResizable(true);

            restaurantListStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**Loads the Restaurant Data File recorded in the user account as a BST */
    public void loadRestaurant() {
        restaurantBSTree = new BinarySearchTree<Restaurant>();
        List restaurantList = null;

        try {
            restaurantList = ReadExcel.ReadExcel(restaurant.getDataFile());
        } catch (Exception e) {
            System.err.println("Problem reading " + restaurant.getDataFile() + " file.");
            e.printStackTrace();
        }
        //ReadExcelFile.showExcelData(restaurantList);
        for (int i = 0; i < restaurantList.size(); i++) {
            List record = (List) restaurantList.get(i);
            //System.out.println(record);
            //System.out.println(record.get(col));
            name = String.valueOf(record.get(0));
            streetAddress = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            phoneNum = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));
            Restaurant restaurant = new Restaurant(name, streetAddress, city, state, zip, latitude, longitude, phoneNum, photo);
            restaurantBSTree.add(restaurant);
            restaurantData.add(restaurant);
        }
        restaurantBSTree.reset(BinarySearchTree.INORDER); //Set the order of the BST as Inorder
    }

    public void showRestaurantData() {
        try {
            // Load restaurant overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RestaurantListDriver.class.getResource("RestaurantInfo.fxml"));
            SplitPane restaurantOverview = loader.load();

            // Set restaurant overview into the center of root layout.
            rootLayout.setCenter(restaurantOverview);
            ScrollPane pane = new ScrollPane();
            pane.prefWidthProperty().bind(restaurantOverview.widthProperty());
            pane.prefHeightProperty().bind(restaurantOverview.heightProperty());
            pane.setContent(restaurantOverview);
            pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            // Give the controller access to the main app.
            RestaurantListController controller = loader.getController();
            controller.setRestaurantListApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Returns the data as an observable list of Restaurants. @return */
    public ObservableList<Restaurant> getRestaurantData() {
        return restaurantData;
    }

    public void setRestaurantData(ObservableList<Restaurant> restaurantData) {
        this.restaurantData = restaurantData;
    }
}
