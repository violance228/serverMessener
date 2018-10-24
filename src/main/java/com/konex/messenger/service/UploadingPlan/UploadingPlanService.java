package com.konex.messenger.service.UploadingPlan;

import com.konex.messenger.entity.UploadingPlan;
import com.konex.messenger.service.BaseMethods;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface UploadingPlanService extends BaseMethods<UploadingPlan> {
    List<UploadingPlan> getAllWhereUploadingTimeIsNull();
}
