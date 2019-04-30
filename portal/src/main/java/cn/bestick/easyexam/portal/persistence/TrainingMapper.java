package cn.bestick.easyexam.portal.persistence;

import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.common.domain.training.TrainingSectionProcess;
import cn.bestick.easyexam.common.domain.training.UserTrainingHistory;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 00:11
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface TrainingMapper {

    /**
     * 获取培训列表
     *
     * @param page
     * @return
     */
    List<Training> getTrainingList(@Param("page") Page<Training> page);

    /**
     * 获取培训章节
     *
     * @param trainingId
     * @param page
     * @return
     */
    List<TrainingSection> getTrainingSectionByTrainingId(@Param("trainingId") int trainingId, @Param("page") Page<TrainingSection> page);

    /**
     * 获取培训章节
     *
     * @param sectionId
     * @param page
     * @return
     */
    List<TrainingSection> getTrainingSectionById(@Param("sectionId") int sectionId, @Param("page") Page<TrainingSection> page);

    /**
     * 获取用户培训历史
     *
     * @param sectionId
     * @param userId
     * @return
     */
    UserTrainingHistory getTrainingHistBySectionId(@Param("sectionId") int sectionId, @Param("userId") int userId);

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
     * @param page
     * @return
     */
    List<TrainingSectionProcess> getTrainingSectionProcessListByUserId(@Param("userId") int userId, @Param("page") Page<TrainingSectionProcess> page);
}
