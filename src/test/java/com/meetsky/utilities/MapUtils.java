package com.meetsky.utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MapUtils {

    public static List<Map<String, Object>> sortByValue(List<Map<String, Object>> listofMapUnsorted, String stringValue, Object valueToBeCompared) {
        List<Map<String, Object>> sortedMap = new ArrayList<>(listofMapUnsorted);
        sortedMap.sort(Comparator.comparing((Map<String, Object> map) -> (Long) map.get(valueToBeCompared))
                .thenComparing((Map<String, Object> map) -> (String) map.get(stringValue))
        );
        return sortedMap;
    }


}
