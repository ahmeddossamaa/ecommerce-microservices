package com.user.config;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class XSSUtil {
    public static String sanitize(String input) {
        return Jsoup.clean(input, Safelist.basic());
    }
}