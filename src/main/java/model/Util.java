package model;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * Copyright (C), 2019-2019
 * FileName: Util
 * Author:   s·D·bs
 * Date:     2019-12-24 18:06
 * Description:
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2019-12-24 18:06          0.0.0
 */

public class Util {
    public static void println(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) throws ParseException {
        FastDateFormat fdf = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT;
        Date parse = fdf.parse("2006-03-21");
        println(parse);
    }
}

    
  