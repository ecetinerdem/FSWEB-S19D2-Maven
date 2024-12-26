package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.exceptions.AddressException;
import com.workintech.s18d4.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressException("Address with given id does not exist " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address delete(Long id) {
        Address toBeDeleted = find(id);
        addressRepository.delete(toBeDeleted);
        return toBeDeleted;
    }
}
