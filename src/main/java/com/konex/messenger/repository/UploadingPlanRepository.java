package com.konex.messenger.repository;

import com.konex.messenger.entity.UploadingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface UploadingPlanRepository extends JpaRepository<UploadingPlan, Long> {
    List<UploadingPlan> getAllByTimeCreateIsNull();
}
