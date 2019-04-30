package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.common.domain.training.TrainingSectionProcess;
import cn.bestick.easyexam.common.domain.training.UserTrainingHistory;
import cn.bestick.easyexam.common.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:42
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface TrainingService {

    /**
     * 获取培训列表
     *
     * @param page
     * @return
     */
    List<Training> getTrainingList(Page<Training> page);

    /**
     * 获取培训章节
     *
     * @param trainingId
     * @param page
     * @return
     */
    List<TrainingSection> getTrainingSectionByTrainingId(int trainingId, Page<TrainingSection> page);

    /**
     * 获取培训章节
     *
     * @param sectionId
     * @param page
     * @return
     */
    List<TrainingSection> getTrainingSectionById(int sectionId, Page<TrainingSection> page);

    /**
     * 获取用户培训历史
     *
     * @param sectionId
     * @param userId
     * @return
     */
    UserTrainingHistory getTrainingHistBySectionId(int sectionId, int userId);

    /**
     * 增加或更新用户培训历史
     *
     * @param hist
     */
    void setUserTrainingHistory(UserTrainingHistory hist);

    /**
     * 获取用户培训进度清单
     *
     * @param userId
     * @return
     */
    Map<Integer, List<TrainingSectionProcess>> getTrainingSectionProcessMapByUserId(int userId);
}
