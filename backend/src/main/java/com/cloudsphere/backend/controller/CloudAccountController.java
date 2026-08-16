package com.cloudsphere.backend.controller;

import com.cloudsphere.backend.entity.CloudAccount;
import com.cloudsphere.backend.service.CloudAccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cloud-accounts")
public class CloudAccountController {

    private final CloudAccountService cloudAccountService;

    public CloudAccountController(CloudAccountService cloudAccountService) {
        this.cloudAccountService = cloudAccountService;
    }

    @PostMapping
    public ResponseEntity<CloudAccount> createAccount(
            @RequestBody CloudAccount cloudAccount) {

        CloudAccount savedAccount =
                cloudAccountService.createAccount(cloudAccount);

        return ResponseEntity.ok(savedAccount);
    }

    @GetMapping
    public ResponseEntity<List<CloudAccount>> getAllAccounts() {

        List<CloudAccount> accounts =
                cloudAccountService.getAllAccounts();

        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
public ResponseEntity<CloudAccount> getAccountById(@PathVariable Long id) {

    CloudAccount account = cloudAccountService.getAccountById(id);

    return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}")
public ResponseEntity<CloudAccount> updateAccount(
        @PathVariable Long id,
        @RequestBody CloudAccount cloudAccount) {

    CloudAccount updatedAccount =
            cloudAccountService.updateAccount(id, cloudAccount);

    return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {

    cloudAccountService.deleteAccount(id);

    return ResponseEntity.noContent().build();
    }
}