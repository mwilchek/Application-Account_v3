package Core;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;

public class Restaurant implements Comparable<Restaurant>, Serializable {
    private StringProperty name;
    private StringProperty streetAddress;
    private StringProperty city;
    private StringProperty state;
    private StringProperty zip;
    private StringProperty latitude;
    private StringProperty longitude;
    private StringProperty phoneNum;
    private StringProperty photo;

    /**Default restaurant properties */
    public Restaurant() {
        this.name = new SimpleStringProperty("");
        this.streetAddress = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty("");
        this.longitude = new SimpleStringProperty("");
        this.phoneNum = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");
    }

    /**Restaurant properties defaulted, but with specific location recorded */
    public Restaurant(String latitude, String longitude) {
        this.name = new SimpleStringProperty("");
        this.streetAddress = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.phoneNum = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");
    }

    /**Restaurant properties set to specific data */
    public Restaurant(String name, String streetAddress, String city, String state, String zip, String latitude, String longitude, String phoneNum, String photo) {
        this.name = new SimpleStringProperty(name);
        this.streetAddress = new SimpleStringProperty(streetAddress);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.zip = new SimpleStringProperty(zip);
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.phoneNum = new SimpleStringProperty(phoneNum);
        this.photo = new SimpleStringProperty(photo);
    }

    /**Get restaurant name */
    public String getName() {
        return name.get();
    }

    /**Set restaurant name */
    public void setName(String name) {
        this.name.set(name);
    }

    /**Get restaurant property name */
    public StringProperty nameProperty() {
        return name;
    }

    /**Get restaurant address */
    public String getStreetAddress() {
        return streetAddress.get();
    }

    /**Set restaurant name */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress.set(streetAddress);
    }

    /**Get restaurant property address */
    public StringProperty streetAddressProperty() {
        return streetAddress;
    }

    /**Get restaurant city */
    public String getCity() {
        return city.get();
    }

    /**Set restaurant city */
    public void setCity(String city) {
        this.city.set(city);
    }

    /**Get restaurant property city */
    public StringProperty cityProperty() {
        return city;
    }

    /**Get restaurant state location */
    public String getState() {
        return state.get();
    }

    /**Set restaurant state location */
    public void setState(String state) {
        this.state.set(state);
    }

    /**Get restaurant property state */
    public StringProperty stateProperty() {
        return state;
    }

    /**Get restaurant zip code */
    public String getZip() {
        return zip.get();
    }

    /**Set restaurant zip */
    public void setZip(String zip) {
        this.zip.set(zip);
    }

    /**Get restaurant property zip */
    public StringProperty zipProperty() {
        return zip;
    }

    /**Get restaurant latitude coords */
    public String getLatitude() {
        return latitude.get();
    }

    /**Set restaurant latitude coords */
    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }

    /**Get restaurant property latitude coords */
    public StringProperty latitudeProperty() {
        return latitude;
    }

    /**Get restaurant longitude coords */
    public String getLongitude() {
        return longitude.get();
    }

    /**Set restaurant longitude coords */
    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }

    /**Get restaurant property longitude coords */
    public StringProperty longitudeProperty() {
        return longitude;
    }

    /**Get restaurant phone number */
    public String getPhoneNum() {
        return phoneNum.get();
    }

    /**Set restaurant phone number */
    public void setPhoneNum(String phoneNo) {
        this.phoneNum.set(phoneNo);
    }

    /**Get restaurant property phone number */
    public StringProperty phoneNoProperty() {
        return phoneNum;
    }

    /**Get restaurant photo */
    public String getPhoto() {
        return photo.get();
    }

    /**Set restaurant photo */
    public void setPhoto(String photo) {
        this.photo.set(photo);
    }

    /**Get restaurant property photo */
    public StringProperty photoProperty() {
        return photo;
    }

    /**Prints restaurant data to the console */
    @Override
    public String toString() {
        return "Restaurant{" +
                "Name=" + name.get() +
                ", Street Address=" + streetAddress.get() +
                ", City=" + city.get() +
                ", State=" + state.get() +
                ", Zip=" + zip.get() +
                ", Latitude=" + latitude.get() +
                ", Longitude=" + longitude.get() +
                ", Phone Number=" + phoneNum.get() +
                ", Photo=" + photo.get() +
                '}';
    }

    /**CompareTo method for Lat/Long data */
    @Override
    public int compareTo(Restaurant data) {
        int compare = this.latitude.get().compareTo(data.getLatitude());
        return (compare == 0) ? this.longitude.get().compareTo(data.getLongitude()) : compare;
    }
}
