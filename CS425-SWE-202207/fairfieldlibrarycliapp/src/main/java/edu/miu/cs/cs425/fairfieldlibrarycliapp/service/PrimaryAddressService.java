package edu.miu.cs.cs425.fairfieldlibrarycliapp.service;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.PrimaryAddress;
import org.springframework.stereotype.Service;

@Service
public interface PrimaryAddressService {
    
    PrimaryAddress addNewPrimaryAddress(PrimaryAddress primaryAddress);
}
