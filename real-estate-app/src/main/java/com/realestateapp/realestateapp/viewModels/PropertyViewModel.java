package com.realestateapp.realestateapp.viewModels;

import com.realestateapp.realestateapp.models.*;

import java.util.Date;

public class PropertyViewModel {
    public long id;

    public String title;

    public String description;

    public Date date;

    public int size;

    public int bedrooms;

    public int baths;

    public int price;

    public Material material;

    public Type type;

    public Address address;

    public UserSimpleViewModel author;

    public static PropertyViewModel fromModel(Property property) {
        PropertyViewModel vm = new PropertyViewModel();

        vm.id = property.getId();
        vm.type = property.getType();
        vm.size = property.getSize();
        vm.price = property.getPrice();
        vm.baths = property.getBaths();
        vm.bedrooms = property.getBedrooms();
        vm.title = property.getTitle();
        vm.description = property.getDescription();
        vm.author = UserSimpleViewModel.fromModel(property.getAuthor());
        return vm;
    }
}
