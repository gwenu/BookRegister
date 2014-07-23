package br.common.models;

public class Library {
    private String name;
    private Address address;

    private class Address {
        private String city;
        private String region;
        private String street;
        private Integer index;
    }
}
