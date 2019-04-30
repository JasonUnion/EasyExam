package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.common.domain.training.TrainingSectionProcess;
import cn.bestick.easyexam.common.domain.training.UserTrainingHistory;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.portal.persistence.TrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
@Service("trainingService")
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingMapper trainingMapper;

    @Override
    public List<Training> getTrainingList(Page<Training> page) {
        return trainingMapper.getTrainingList(page);
    }

    @Override
    public List<TrainingSection> getTrainingSectionByTrainingId(int trainingId, Page<TrainingSection> page) {
        return trainingMapper.getTrainingSectionByTrainingId(trainingId, page);
    }

    @Override
    public List<TrainingSection> getTrainingSectionById(int sectionId, Page<TrainingSection> page) {
        return trainingMapper.getTrainingSectionById(sectionId, page);
    }

    @Override
    public UserTrainingHistory getTrainingHistBySectionId(int sectionId, int userId) {
        return trainingMapper.getTrainingHistBySectionId(sectionId, userId);
    }

    @Override
    public void setUserTrainingHistory(UserTrainingHistory hist) {
        trainingMapper.setUserTrainingHistory(hist);
    }

    @Override
    public Map<Integer, List<TrainingSectionProcess>> getTrainingSectionProcessMapByUserId(int userId) {

        List<TrainingSectionProcess> processList = trainingMapper.getTrainingSectionProcessListByUserId(userId, null);
        HashMap<Integer, List<TrainingSectionProcess>> map = new HashMap<Integer, List<TrainingSectionProcess>>();
        for (TrainingSectionProcess process : processList) {
            List<TrainingSectionProcess> tmpList = new ArrayList<TrainingSectionProcess>();
            if (map.containsKey(process.getTrainingId()))
                tmpList = map.get(process.getTrainingId());
            tmpList.add(process);
            map.put(process.getTrainingId(), tmpList);
        }
        return map;
    }
}
