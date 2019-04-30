package cn.bestick.easyexam.scoremarker;

import cn.bestick.easyexam.common.domain.exam.AnswerSheet;
import cn.bestick.easyexam.scoremarker.config.ScoreMarkConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/5/21
 * Time: 15:58
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Component
public class ScoreMarkerWin {

    private static boolean stop = false;

    @Autowired
    private QueueingConsumer consumer;
    @Autowired
    private ScoreCalcuService scoreCalcuService;
    @Autowired
    private ObjectMapper mapper;
    private static boolean waitingForMessage = false;

    private static final Logger LOGGER = Logger.getLogger(ScoreMarkerWin.class);

    public void init() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ScoreMarkConfig.class);
        context.refresh();
        scoreCalcuService = context.getBean(ScoreCalcuService.class);
        consumer = context.getBean(QueueingConsumer.class);
        mapper = context.getBean(ObjectMapper.class);
        LOGGER.info("ScoreMarker daemon init done.");
    }

    public ScoreMarkerWin(){

    }
    public static void start(String[] args) {
        ScoreMarkerWin win = new ScoreMarkerWin();
        win.init();
        System.out.println("start");
        Thread thread = new Thread(){

            @Override
            public void run() {
                win.run();
            }
        };
        thread.start();
    }

    public static void stop(String[] args) {
        System.out.println("stop");
        stop = true;
        System.exit(0);
    }

    public static void main(String[] args) {
        ScoreMarkerWin scoreMarkerWin = new ScoreMarkerWin();
        scoreMarkerWin.init();
        scoreMarkerWin.run();
    }

    protected void run() {
        while(!stop){
            try {
                LOGGER.info("scoreMaker checking next delivery from message queue");
                waitingForMessage = true;
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                waitingForMessage = false;
                AnswerSheet answerSheet = mapper.readValue(delivery.getBody(),
                        AnswerSheet.class);
                scoreCalcuService.calcuScore(answerSheet);

            } catch (ShutdownSignalException e) {
                LOGGER.error("scoreMaker received ShutdownSignalException: ", e);
                try {
                    // Sleep some time to release the CPU time slices if
                    // connection with RabbitMQ server
                    // is disconnected, otherwise CPU usage will be high if
                    // connection is disconnected.
                    Thread.sleep(100);
                } catch (Throwable ex) {
                    LOGGER.error("scoreMaker sleep exception: ", ex);
                }
            } catch (IOException | ConsumerCancelledException | InterruptedException e) {
                LOGGER.error("scoreMaker received exception", e);
            }
        }
    }
}