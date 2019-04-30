package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.common.domain.training.TrainingSectionProcess;
import cn.bestick.easyexam.common.domain.training.UserTraining;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.management.persistence.TrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:45
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
    public List<Training> getTrainingList(int userId, Page<Training> page) {
        return trainingMapper.getTrainingList(userId, page);
    }

    @Override
    public void addTraining(Training training) {
        trainingMapper.addTraining(training);
    }

    @Override
    public List<TrainingSection> getTrainingSectionByTrainingId(int trainingId, int userId, Page<TrainingSection> page) {
        return trainingMapper.getTrainingSectionByTrainingId(trainingId, userId, page);
    }

    @Override
    public List<TrainingSection> getTrainingSectionById(int sectionId, int userId, Page<TrainingSection> page) {
        return trainingMapper.getTrainingSectionById(sectionId, userId, page);
    }

    @Override
    public void deleteTrainingSection(int sectionId, int userId) {
        trainingMapper.deleteTrainingSection(sectionId, userId);
    }

    @Override
    public void addTrainingSection(TrainingSection section) {
        trainingMapper.addTrainingSection(section);
    }

    @Override
    public Map<Integer, List<TrainingSectionProcess>> getTrainingSectionProcessMapByTrainingId(int trainingId, List<Integer> idList, String searchStr) {
        if (idList.size() == 0)
            idList = null;
        List<TrainingSectionProcess> processList = trainingMapper.getTrainingSectionProcessListByTrainingId(trainingId, idList, searchStr, null);
        HashMap<Integer, List<TrainingSectionProcess>> map = new HashMap<Integer, List<TrainingSectionProcess>>();
        for (TrainingSectionProcess process : processList) {
            List<TrainingSectionProcess> tmpList = new ArrayList<TrainingSectionProcess>();
            if (map.containsKey(process.getUserId()))
                tmpList = map.get(process.getUserId());
            tmpList.add(process);
            map.put(process.getUserId(), tmpList);
        }
        return map;
    }

    @Override
    public List<UserTraining> getUserTrainingList(int trainingId, int userId, String searchStr, Page<UserTraining> page) {
        return trainingMapper.getUserTrainingList(trainingId, userId, searchStr, page);
    }
}
