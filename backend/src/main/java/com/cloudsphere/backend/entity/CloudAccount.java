package com.cloudsphere.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cloud_accounts")
public class CloudAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provider is required")
    @Column(nullable = false)
    private String provider;

    @NotBlank(message = "Account Name is required")
    @Size(min = 3, max = 100,
      message = "Account Name must be between 3 and 100 characters")
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @NotBlank(message = "Account Identifier is required")
    @Pattern(
    regexp = "^[A-Za-z0-9_-]{6,20}$",
    message = "Account Identifier must contain 6-20 letters, numbers, _ or -"
    )
    @Column(name = "account_identifier")
    private String accountIdentifier;
    
    @NotBlank(message = "Region is required")
    private String region;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status;

    // Default constructor required by JPA
    public CloudAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}