package com.vincent.tfg.extension.component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogCutter {

    private LogCutter(){}
    public static List<String> cut(String chunk,String start,String end){
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(String.format("(%s%s%s%s%s)", ".*?",start,".*?", end,".*?\\n"),Pattern.DOTALL);

        Matcher matcher = pattern.matcher(chunk);
        while (matcher.find()) {
            list.add(matcher.group());
        }

        return list;
    }
}
