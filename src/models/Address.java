package models;

import exception.*;

public class Address extends BaseModel{

    private String city;
    private String zipCode;
    private String houseNumber;
    private String landmark;
    private String state;
    private String country;
    private String fullAddress;

    public Address(Builder builder) {
        super(builder.id, builder.createdBy);
        this.city = builder.city;
        this.zipCode = builder.zipCode;
        this.houseNumber = builder.houseNumber;
        this.landmark = builder.landmark;
        this.state = builder.state;
        this.country = builder.country;
        this.fullAddress = builder.fullAddress;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public static class Builder{
        private int id;
        private String createdBy;
        private String city;
        private String zipCode;
        private String houseNumber;
        private String landmark;
        private String state;
        private String country;
        private String fullAddress;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder zipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public Builder houseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder landmark(String landmark){
            this.landmark = landmark;
            return this;
        }

        public Builder state(String state){
            this.state = state;
            return this;
        }

        public Builder country(String country){
            this.country = country;
            return this;
        }

        public Builder fullAddress(String fullAddress){
            this.fullAddress = fullAddress;
            return this;
        }

        public Address build() throws InvalidHouseNumberException, InvalidAddressLineException, InvalidCountryException, InvalidZipCodeException, InvalidStateException, InvalidCityException {
            verify();
            return new Address(this);
        }

        private void verify() throws InvalidCityException, InvalidStateException, InvalidCountryException, InvalidZipCodeException, InvalidHouseNumberException, InvalidAddressLineException {
            verifyCity();
            verifyState();
            verifyCountry();
            verifyZipCode();
            verifyHouseNumber();
            verifyAddressLine();
        }

        private void verifyAddressLine() throws InvalidAddressLineException {
            if(this.fullAddress == null || this.fullAddress.isEmpty()){
                throw new InvalidAddressLineException("Address cannot be null or empty");
            }
        }

        private void verifyHouseNumber() throws InvalidHouseNumberException {
            if(this.houseNumber == null || this.houseNumber.isEmpty()){
                throw new InvalidHouseNumberException("House Number cannot be null or empty");
            }
        }

        private void verifyZipCode() throws InvalidZipCodeException {
            if(this.zipCode == null || this.zipCode.isEmpty()){
                throw new InvalidZipCodeException("ZipCode cannot be null or empty");
            }
        }

        private void verifyCountry() throws InvalidCountryException {
            if(this.country == null || this.country.isEmpty()){
                throw new InvalidCountryException("Country cannot be null or empty");
            }
        }

        private void verifyState() throws InvalidStateException {
            if(this.state == null || this.state.isEmpty()){
                throw new InvalidStateException("State cannot be null or empty");
            }
        }

        private void verifyCity() throws InvalidCityException {
            if(this.city == null || this.city.isEmpty()){
                throw new InvalidCityException("City cannot be null or empty");
            }
        }


    }

}
