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

    @PostMapping("/save")
    public String add(@RequestBody List<Address> addresses) {
        return addressRepository.saveAddresses(addresses);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable("id") int id) {
        return addressRepository.deleteAddress(id);
    }
}
