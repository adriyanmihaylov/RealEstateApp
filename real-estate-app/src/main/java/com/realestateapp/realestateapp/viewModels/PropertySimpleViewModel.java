package com.realestateapp.realestateapp.viewModels;

import com.realestateapp.realestateapp.models.Address;
import com.realestateapp.realestateapp.models.Material;
import com.realestateapp.realestateapp.models.Property;
import com.realestateapp.realestateapp.models.Type;

import java.util.Date;

public class PropertySimpleViewModel {
    public long id;

    public String title;

    public String description;

    private Date date;

    private int size;

    private int bedrooms;

    private int baths;

    private int price;

    private Material material;

    private Type type;

    private Address address;


    public static PropertySimpleViewModel fromModel(Property property) {
        PropertySimpleViewModel vm = new PropertySimpleViewModel();

        vm.id = property.getId();
        vm.type = property.getType();
        vm.size = property.getSize();
        vm.price = property.getPrice();
        vm.baths = property.getBaths();
        vm.bedrooms = property.getBedrooms();
        vm.title = property.getTitle();
        vm.description = property.getDescription();
        return vm;
    }
}
