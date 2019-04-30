package cn.bestick.easyexam.common.daemon;

import org.apache.commons.daemon.Daemon;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/26
 * Time: 23:07
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public abstract class AbstractDaemon implements Daemon {

    protected AnnotationConfigApplicationContext context;
    private boolean shutdownRequested = false;
    protected Thread workThread;

    protected abstract void run();

    protected Thread getWorkThread() {
        return workThread;
    }

    protected void createWorkThread() {
        final AbstractDaemon instance = this;
        workThread = new Thread() {
            @Override
            public synchronized void start() {
                super.start();
            }

            @Override
            public void run() {
                instance.run();
            }
        };
    }

    protected boolean isShutdownRequested() {
        return shutdownRequested;
    }

    /**
     * @param shutdownRequested flag to set
     */
    protected void setShutdownRequested(boolean shutdownRequested) {
        this.shutdownRequested = shutdownRequested;
    }

    @Override
    public void destroy() {
        if (context != null) {
            context.close();
        }
        workThread = null;
    }
}
