package com.konex.messenger.service.UploadingPlan;

import com.konex.messenger.entity.UploadingPlan;
import com.konex.messenger.repository.UploadingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Service
public class UploadingPlanServiceImpl implements UploadingPlanService {

    @Autowired
    private UploadingPlanRepository planRepository;

    @Override
    public List<UploadingPlan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public List<UploadingPlan> findAll(Specification specification) {
        return null;
    }

    @Override
    public UploadingPlan findById(Long id) {
        return planRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public void save(UploadingPlan uploadingPlan) {
        planRepository.save(uploadingPlan);
    }

    @Override
    public void update(UploadingPlan uploadingPlan) {
        planRepository.saveAndFlush(uploadingPlan);
    }

    @Override
    public void saveList(List<UploadingPlan> elementList) {
        planRepository.saveAll(elementList);
    }

    @Override
    public Stream<UploadingPlan> streamAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UploadingPlan> getAllWhereUploadingTimeIsNull() {
        return planRepository.getAllByTimeCreateIsNull();
    }
}
