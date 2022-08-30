package com.codegym.pm.service;

import com.codegym.pm.model.SmartPhone;
import com.codegym.pm.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone SmartPhone) {
        return iSmartPhoneRepository.save(SmartPhone);
    }

    @Override
    public void remove(Long id) {
        iSmartPhoneRepository.deleteById(id);
    }
}
