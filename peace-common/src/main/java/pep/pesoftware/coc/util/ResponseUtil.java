package pep.pesoftware.coc.util;

import pep.pesoftware.coc.constant.PeaceConstant;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map errorData(Object data){
        Map<String, Object> map = new HashMap<>();
        map.put(PeaceConstant.RESPONSE_DATA_FLAG,false);
        map.put(PeaceConstant.RESPONSE_DATA_DATA,data);
        return map;
    }

    public static Map successData(Object data){
        Map<String, Object> map = new HashMap<>();
        map.put(PeaceConstant.RESPONSE_DATA_FLAG,true);
        map.put(PeaceConstant.RESPONSE_DATA_DATA,data);
        return map;
    }

}
