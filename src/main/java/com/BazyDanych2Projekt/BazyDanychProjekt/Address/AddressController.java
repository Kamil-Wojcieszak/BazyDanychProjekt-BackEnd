package com.BazyDanych2Projekt.BazyDanychProjekt.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/list")
    public List<Address> getAddressesList() {
        return addressRepository.getAddressesList();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") int id) {
        return addressRepository.getAddressById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody List<Address> addresses) {
        return addressRepository.saveAddresses(addresses);
    }

    @PatchMapping("/{id}")
    public String updateAddress(@PathVariable("id") int id, @RequestBody Address updatedAddress) {
        Address address = addressRepository.getAddressById(id);

        if (address != null) {
            if (updatedAddress.getAddress_id() > 0) {
                address.setAddress_id(updatedAddress.getAddress_id());
            }

            if (updatedAddress.getCity() != null) {
                address.setCity(updatedAddress.getCity());
            }

            if (updatedAddress.getStreet() != null) {
                address.setStreet(updatedAddress.getStreet());
            }

            if (updatedAddress.getPost_code() != null) {
                address.setPost_code(updatedAddress.getPost_code());
            }

            if (updatedAddress.getBuilding_number() != null) {
                address.setBuilding_number(updatedAddress.getBuilding_number());
            }

            if (updatedAddress.getUnit_number() != null) {
                address.setUnit_number(updatedAddress.getUnit_number());
            }

            addressRepository.updateAddress(address);

            return "Success!";
        } else {
            return "Error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable("id") int id) {
        return addressRepository.deleteAddress(id);
    }
}
