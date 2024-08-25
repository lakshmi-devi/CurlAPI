package base;

import java.util.HashMap;
import java.util.Map;

public class HeadersList extends BaseClass{

    BaseClass baseClass = new BaseClass();
    public Map<String, String> headerList(String value) {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "*/*");
        headers.put("content-type", "application/json");
        headers.put("origin", "https://pro.turtlemint.com");
        headers.put("priority", "u=1, i");
        headers.put("referer", "https://pro.turtlemint.com/health-insurance/health-profile/profile-gender");
        headers.put("sec-ch-ua", "\"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("sec-ch-ua-platform", "macOS");
        headers.put("sec-fetch-dest", "empty");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-site", "same-origin");
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36");
        headers.put("x-instana-l", "1,correlationType=web;correlationId=6d5925b49ac1fb94");
        headers.put("x-instana-s", value);
        headers.put("x-instana-t",value);
        headers.put("cookie",baseClass.getCookies());
        return headers;
    }
}
