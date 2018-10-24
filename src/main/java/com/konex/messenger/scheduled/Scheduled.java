package com.konex.messenger.scheduled;

import com.konex.messenger.service.UploadingPlan.UploadingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Component
public class Scheduled {

    @Autowired
    private UploadingPlanService uploadingPlanService;


}
