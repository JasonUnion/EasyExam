package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.common.domain.training.TrainingSectionProcess;
import cn.bestick.easyexam.common.domain.training.UserTraining;
import cn.bestick.easyexam.common.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:44
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface TrainingService {

    /**
     * 获取培训列表
     *
     * @param userId 为-1时，获取所有培训，否则获取userId发布的培训
     * @param page
     * @return
     */
    List<Training> getTrainingList(int userId, Page<Training> page);

    /**
     * 添加培训
     *
     * @param training
     */
    void addTraining(Training training);

    /**
     * 添加章节
     *
     * @param section
     */
    void addTrainingSection(TrainingSection section);

    /**
     * 获取培训章节
     *
     * @param trainingId
     * @param userId     不等于-1则为该用户发布的培训
     * @param page
     * @return
     */
    List<TrainingSection> getTrainingSectionByTrainingId(int trainingId, int userId, Page<TrainingSection> page);

    /**
     * 获取培训章节
     *
     * @param sectionId
     * @param userId    不等于-1则为该用户发布的培训
     * @param page
     * @return
     */
    List<TrainingSection> getTrainingSectionById(int sectionId, int userId, Page<TrainingSection> page);

    /**
     * @param sectionId
     * @param userId    不等于-1则为该用户发布的培训
     */
    void deleteTrainingSection(int sectionId, int userId);

    /**
     * 获取培训id下每个用户的章节培训进度
     *
     * @param trainingId
     * @param searchStr
     * @param idList
     * @return
     */
    Map<Integer, List<TrainingSectionProcess>> getTrainingSectionProcessMapByTrainingId(int trainingId, List<Integer> idList, String searchStr);

    /**
     * 获取培训id下用户培训清单
     *
     * @param trainingId
     * @param userId
     * @param searchStr
     * @param page
     * @return
     */
    List<UserTraining> getUserTrainingList(int trainingId, int userId, String searchStr, Page<UserTraining> page);
}
