package com.example.config;


import com.example.core.Crypto;

public class BaseConfig {

    private static int timeout;
    private static int delay;
    private static String baseUrl;
    private static String browser;
    private static String pathDocument;

    private static String pathOpenCV;
    private static String pathOCR;
    private static String userN;
    private static String pwd;


    public BaseConfig(int xTimeout,int xDelay,String xBaseUrl,String xBrowser,
                      String xPathDocument,String xPathOpenCV,
                      String xPathOCR, String xUserN, String xPwd) {
        this.timeout = xTimeout;
        this.delay = xDelay;
        this.baseUrl = xBaseUrl;
        this.browser = xBrowser;
        this.pathDocument = xPathDocument;
        this.pathOCR = xPathOCR;
        this.pathOpenCV = xPathOpenCV;
        this.userN = Crypto.performDecrypt(xUserN);
        this.pwd  = Crypto.performDecrypt(xPwd);
    }

    public static int getTimeout() {
        return timeout;
    }

    public static int getDelay() {
        return delay;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getPathDocument() {
        return pathDocument;
    }

    public static String getPathOpenCV() {
        return pathOpenCV;
    }

    public static String getPathOCR() {
        return pathOCR;
    }
}
