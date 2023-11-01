package models;

import exception.InvalidAddressException;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;

import javax.naming.InvalidNameException;

public class Operator extends BaseModel{

    private String name;
    private Address address;
    private String phoneNumber;
    private String email;
    private String password;

    public Operator(Builder builder) {
        super(builder.id, builder.createdBy);
        this.name = builder.name;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{
        private int id;
        private String createdBy;
        private String name;
        private Address address;
        private String phoneNumber;
        private String email;
        private String password;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Operator build() throws InvalidNameException, InvalidEmailException, InvalidAddressException, InvalidPasswordException {
            verify();
            return new Operator(this);
        }

        private void verify() throws InvalidNameException, InvalidEmailException, InvalidAddressException, InvalidPasswordException {
            verifyName();
            verifyEmail();
            verifyAddress();
            verifyPassword();
        }

        private void verifyPassword() throws InvalidPasswordException {
            if(password == null || password.isEmpty()){
                throw new InvalidPasswordException("Password cannot be null or empty");
            }
        }

        private void verifyAddress() throws InvalidAddressException {
            if(address == null){
                throw new InvalidAddressException("Address cannot be null");
            }
        }


        private void verifyEmail() throws InvalidEmailException {
            if(email == null || email.isEmpty()){
                throw new InvalidEmailException("Email cannot be null or empty");
            }
        }

        private void verifyName() throws InvalidNameException {
            if(name == null || name.isEmpty()){
                throw new InvalidNameException("Name cannot be null or empty");
            }
        }
    }

}
