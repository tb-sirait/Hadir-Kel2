package com.example.utils;

public enum TestScenarios {
    //Scenario Modul Login Page
    T1("Check access url login page"),
    T2("Check Login is Falied with invalid username"),
    T3("Check Login is Failed with invalid password"),
    T4("Check Login is Failed with null username"),
    T5("Check Login is Falied with null password"),
    T6("Check Login is falied with null username and password"),
    T7("Check Login is success with valid credentials"),

    //Scenario Dashboard Page
    T8("Check Total Progress Summary - Prospect"),
    T9("Check Total Progress Summary - Share Compro"),
    T10("Check Total Progress Summary - Initial Meeting"),
    T11("Check Total Progress Summary - Client Assessment"),
    T12("Check Total Progress Summary - Complete"),
    T13("Check Total Progress Summary - Client Drop"),

    //Scenario List CLient Page
    T14("Access List Client Menu"),
    T15("Filter status progress - Prospect"),
    T16("Filter status progress - Share Compro"),
    T17("Filter status progress - Initial Meeting"),
    T18("Filter status progress - Client Assessment"),
    T19("Filter status progress - Drop"),
    T20("Filter status progress - Completed"),
    T21("Access create new client form"),
    T22("Create New Client with null Company Name"),
    T23("Create New Client with null Source Client"),
    T24("Create New Client is Success with valid input form"),
    T25("View modal detail client "),
    T26("Access edit data client form"),
    T27("Edit data client with null company name"),
    T28("Edit data client with null source client"),
    T29("Edit data client with valid credentials"),

    //Scenario Progress Page - SHARE COMPRO
    T30("Show activity page"),
    T31("Drag prospect to share compro"),
    T32("Input form Share compro with null company name"),
    T33("Input form Share compro with null product name"),
    T34("Input form Share compro with null company address"),
    T35("Input form Share compro with null type business"),
    T36("Input form Share compro with null PIC name"),
    T37("Input form Share compro with null telp PIC"),
    T38("Input form Share compro with null Source"),
    T39("Input form Share compro with duplicate data"),
    T40("Input form Share compro with null Source"),
    T41("Test Search by kombinasi karakter [aA3265$%?]"),
    T42("Test Search by nama project"),
    T43("Test Search by nama klien"),
    T44("Test Search by jenis kerjasama"),
    T45("Test Search by nama posisi"),
    T46("Test Search by status kontrak"),
    T47("Test Search by penempatan"),
    T48("Test Search by jam kerja"),
    T49("Test Search by pendidikan"),
    T50("Test View detail data recruitment request aktif"),
    T51("Test back to data aktif page"),
    T52("Test Success Update Status "),
    T53("Test Invalid Update Status - Status null "),
    T54("Test Invalid Update Status - Status dan note null"),
    T55("Test Cancel Update Status"),
    T56("Download data aktif"),

    //Scenario Approve RRF Data Pengajuan
    T57("View Halaman Approve RRF"),
    T58("View from data pengajuan"),
    T59("Search by Client Name"),  //Valid Keyword
    T60("Search by Project Name"),
    T61("Search by Position Name"),
    T62("Search by Placement Name"),
    T63("Search by Kontrak Name"),
    T64("Search by Kontrak Name"),
    T65("Search by Kontrak Name"),
    T66("Search by Kontrak Name"),
    T67("Input Invalid Keyword TOPAN33"), //Invalid Keyword
    T68("Input Invalid Keyword a@#$R23"),
    T69("Refresh from data pengajuan"),
    T70("Approve from data pengajuan IT"),
    T71("Cancel Approve from data pengajuan IT"),
    T72("Approve from data pengajuan NON IT"),
    T73("Cancel Approve from data pengajuan NON IT"),
    T74("Return from data pengajuan"),
    T75("Cancel Return from data pengajuan"),
    T76("Pilih value show entries"),

    //Scenario Approve RRF Data Aktif
    T77("View Halaman Data Aktif"),
    T78("Pilih value show entries Data Aktif"),
    T79("Search by Client Name"),  //Valid Keyword
    T80("Search by Project Name"),
    T81("Search by Position Name"),
    T82("Search by Placement Name"),
    T83("Search by Kontrak Name"),
    T84("Search by Kontrak Name"),
    T85("Search by Kontrak Name"),
    T86("Search by Kontrak Name"),
    T87("Input Invalid Keyword TOPAN33"), //Invalid Keyword
    T88("Input Invalid Keyword a@#$R23"),
    T89("Refresh from Data Aktif"),
    T90("View Data Aktif"),
    T91("Download Data"),
    T92("Logout"),

    //Test Scenario Modul Recruitment Request - Data Pengajuan
    T93(""),
    T94(""),
    T95(""),
    T96(""),
    T97(""),
    T98(""),
    T99(""),
    T100("");

    private String testCaseName;

    TestScenarios(String value) {
        testCaseName = value;
    }

    public String getTestCaseName() {
        return testCaseName;
    }
}

