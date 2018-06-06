package com.globallogic.framework;

public class TestConstants {

    public static final String LINK_DEPUTAT_LIST = "http://w1.c1.rada.gov.ua/pls/site2/p_deputat_list";

    public static final String XPATH_PRESENCE = "//a[contains(text(), \"Реєстрація депутата за допомогою електронної системи\")]";
    public static final String XPATH_SEARCH_BUTTON = "search_button1";
    public static final String XPATH_FULL_NAME = "//table[@class=\"simple_info\"]/tbody/tr[1]/td[2]/h2";

    public static final String XPATH_PRESENCE_NUM = "//*[@id='Data_fr']/b[contains(text(), \"Присутн\")]/font";
    public static final String XPATH_ABSENCE_NUM = "//*[@id='Data_fr']/b[contains(text(), \"Відсутн\")]/font";

    public static final String XPATH_DECLARED_DEPUTIES_NUMBER = "//div[@id=\"search_results\"]/p";
    public static final String XPATH_SEARCH_RESULTS_BLOCK = "//div[@id='search_results']/ul/li";
    public static final String XPATH_SEARCH_RESULTS_NUMBER = "//div[@class=\"information_block_ins\"]/h3/a[@class=\"show_section\"]";
    public static final String XPATH_SEARCH_GO_TO_TOP_ = "//ul[@class='search-filter-results search-filter-results-thumbnails']/li/p/a[@href='#top']";
    public static final String XPATH_SEARCH_RESULTS_MESSAGE = "//div[@id=\"search_results\"]/p";
    public static final String XPATH_DEPUTIES_NAMES = "//div[@id=\"search_results\"]/ul/li[%s]/p/a";
    public static final String XPATH_DEPUTIES_PROFILE_LINKS = "//div[@id=\"search_results\"]/ul/li[%s]/p[@class=\"title\"]/a";
}
