package edu.miu.cs.cs425.fairfieldlibrarycliapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="primary_addresses")
public class PrimaryAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer addressId;
    @Column(nullable=false)
    private String street;
    @Column(nullable=false)
    private String city;
    @Column(nullable=false)
    private String state;
    @Column(nullable=false)
    private String zipcode;
    @OneToOne(mappedBy="primaryAddress") // the one has mapped by is the one not the owner of the r/p
    private Publisher publisher;

//    public PrimaryAddress(Integer addressId, String city, String state, String zipcode, String s) {
//        this.addressId = addressId;
//        this.city = city;
//        this.state = state;
//        this.zipcode = zipcode;
//    }
//
//    public PrimaryAddress() {
//
//    }
//
//    public Integer getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Integer addressId) {
//        this.addressId = addressId;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
     public String toString(){
       return String.format("{AddressId: %d, Street: %s, City: %s, ZipCode: %s}",addressId,street,city,state,zipcode) ;
     }

}
