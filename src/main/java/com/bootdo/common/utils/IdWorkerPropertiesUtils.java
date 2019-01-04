package com.bootdo.common.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author lijie.zh
 */
public class IdWorkerPropertiesUtils {

    private static Long workerId;

    private static Long datacenterId;

    static {
        loads();
    }

    private static synchronized void loads() {

        if (workerId == null || datacenterId == null) {
            InputStream is = IdWorkerPropertiesUtils.class.getResourceAsStream("/idWorker.properties");
            Properties dproperties = new Properties();
            try {
                dproperties.load(is);

                workerId = Long.parseLong(dproperties.getProperty("workerId"));
                datacenterId = Long.parseLong(dproperties.getProperty("datacenterId"));

            } catch (Exception e) {
                System.err.println("不能读取属性文件. " + "请确保 idWorker.properties 在CLASSPATH指定的路径中");
            }
        }

    }

    public static Long getWorkerId() {
        return workerId;
    }

    public static Long getDatacenterId() {
        return datacenterId;
    }


}
