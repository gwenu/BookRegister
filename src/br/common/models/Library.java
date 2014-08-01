package br.common.models;

public class Library {
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private class Address {
        private String city;
        private String region;
        private String street;
        private Integer index;
    }
}
