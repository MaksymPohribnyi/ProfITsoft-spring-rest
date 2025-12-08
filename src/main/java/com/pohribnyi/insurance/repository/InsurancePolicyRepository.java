package com.pohribnyi.insurance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pohribnyi.insurance.model.entity.InsurancePolicy;

public interface InsurancePolicyRepository
		extends JpaRepository<InsurancePolicy, UUID>, JpaSpecificationExecutor<InsurancePolicy> {

	boolean existsByPolicyNumber(String policyNumber);

}
