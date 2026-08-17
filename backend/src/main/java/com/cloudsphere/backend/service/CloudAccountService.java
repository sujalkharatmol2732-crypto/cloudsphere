package com.cloudsphere.backend.service;

import com.cloudsphere.backend.entity.CloudAccount;
import com.cloudsphere.backend.exception.ResourceNotFoundException;
import com.cloudsphere.backend.repository.CloudAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudAccountService {

    private final CloudAccountRepository cloudAccountRepository;

    public CloudAccountService(CloudAccountRepository cloudAccountRepository) {
        this.cloudAccountRepository = cloudAccountRepository;
    }

    public CloudAccount createAccount(CloudAccount cloudAccount) {
        return cloudAccountRepository.save(cloudAccount);
    }

    public List<CloudAccount> getAllAccounts() {
        return cloudAccountRepository.findAll();
    }

    public CloudAccount getAccountById(Long id) {
        return cloudAccountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud Account not found with id: " + id));
    }

    public CloudAccount updateAccount(Long id, CloudAccount updatedAccount) {

        CloudAccount existingAccount = cloudAccountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud Account not found with id: " + id));

        existingAccount.setAccountName(updatedAccount.getAccountName());
        existingAccount.setProvider(updatedAccount.getProvider());
        existingAccount.setAccountIdentifier(updatedAccount.getAccountIdentifier());
        existingAccount.setRegion(updatedAccount.getRegion());
        existingAccount.setStatus(updatedAccount.getStatus());

        return cloudAccountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id) {

        CloudAccount account = cloudAccountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud Account not found with id: " + id));

        cloudAccountRepository.delete(account);
    }
}