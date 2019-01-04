package com.bootdo.common.generator;


import com.bootdo.common.utils.IdWorkerPropertiesUtils;

/**
 * @author lijie.zh
 */
public final class IdWorkerInstance {

    private IdWorkerInstance() {

    }

    private static final IdWorker ID_WORKER = new IdWorker(IdWorkerPropertiesUtils.getWorkerId(), IdWorkerPropertiesUtils.getDatacenterId());

    private static IdWorker getInstance() {
        return ID_WORKER;
    }

    public static Long getId() {
        return getInstance().nextId();
    }

    public static String getIdStr() {
        return getInstance().nextId() + "";
    }
}
