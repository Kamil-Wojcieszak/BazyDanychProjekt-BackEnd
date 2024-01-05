package com.BazyDanych2Projekt.BazyDanychProjekt.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Address> getAddressesList() {
        return jdbcTemplate.query("SELECT * FROM address", BeanPropertyRowMapper.newInstance(Address.class));
    }

    public Address getAddressById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM address WHERE address_id = ?", BeanPropertyRowMapper.newInstance(Address.class), id);
    }

    public String saveAddresses(List<Address> addresses) {
        addresses.forEach(address -> jdbcTemplate.update("INSERT INTO address (address_id, city, street, post_code, building_number, unit_number)" +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                address.getAddress_id(),
                address.getCity(),
                address.getStreet(),
                address.getPost_code(),
                address.getBuilding_number(),
                address.getUnit_number()));

        return "Success!";
    }

    public int updateAddress(Address address) {
        return jdbcTemplate.update("UPDATE address SET city = ?, street = ?, post_code = ?, building_number = ?, unit_number = ? WHERE address_id = ?",
                address.getCity(), address.getStreet(), address.getPost_code(), address.getBuilding_number(), address.getUnit_number(), address.getAddress_id());
    }

    public String deleteAddress(int id) {
        jdbcTemplate.update("DELETE FROM address WHERE address_id = ?", id);

        return "Success!";
    }
}
