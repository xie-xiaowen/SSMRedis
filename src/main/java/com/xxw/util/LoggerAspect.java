package com.xxw.util;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * XML配置增强
 */
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    /**
     * 前置信息
     * @param joinPoint
     * @throws Exception
     */
    public void logBefore(JoinPoint joinPoint) throws  Exception{
        logger.info(getInformation(joinPoint)+"---- start");
    }

    /**
     * 后置信息
     * @param joinPoint
     * @throws Exception
     */
    public void logAfter(JoinPoint joinPoint) throws  Exception{
        logger.info(getInformation(joinPoint)+"---- end");
    }

    /**
     * 生成描述信息
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private String getInformation(JoinPoint joinPoint) throws  Exception{
        // 获取类名
        String targetName = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date())+"----:"+targetName+"."+methodName;
    }

}
