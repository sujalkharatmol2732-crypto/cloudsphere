package com.cloudsphere.backend.repository;

import com.cloudsphere.backend.entity.CloudAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudAccountRepository extends JpaRepository<CloudAccount, Long> {
}