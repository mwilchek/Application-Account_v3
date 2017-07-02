package tests;

import Core.Restaurant;
import Core.ReadExcel;
import dataStructures.BinarySearchTree;
import org.junit.Test;
import java.util.List;

public class ReadExcelTest {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phoneNum;
    private String photo;

    @Test
    public void readExcel() throws Exception {
        BinarySearchTree<Restaurant> restaurantBSTree = new BinarySearchTree<Restaurant>();
        List restaurantList = ReadExcel.ReadExcel("restaurants.xls");

        System.out.println("Testing showExcelData(): ");
        ReadExcel.showExcelData(restaurantList);
        System.out.println();
        System.out.println("Number of records in the excel document: " + restaurantList.size());

        System.out.println();
        System.out.println("Get values of List data: ");
        for (int i = 1; i < restaurantList.size(); i++) {
            List record = (List) restaurantList.get(i);
            System.out.println(record);
            name = String.valueOf(record.get(1));
            streetAddress = String.valueOf(record.get(2));
            System.out.println("Name and Address: " + name + " - " + streetAddress);
            city = String.valueOf(record.get(3));
            state = String.valueOf(record.get(4));
            zip = String.valueOf(record.get(5));
            latitude = String.valueOf(record.get(6));
            longitude = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));
        }

    }
}