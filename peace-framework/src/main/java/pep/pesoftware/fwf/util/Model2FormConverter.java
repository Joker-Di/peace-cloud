package pep.pesoftware.fwf.util;

import org.springframework.cglib.core.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Model2FormConverter implements Converter {

    SimpleDateFormat sdf;
    SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");

    public Model2FormConverter(){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public Model2FormConverter(boolean isShort){
        if(isShort){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else{
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    }

    @Override
    public Object convert(Object value, Class aClass, Object o1) {
        if((value instanceof Date) && "String".equals(aClass.getSimpleName())){
            return sdf.format((Date)value);
        }else if(value instanceof String && "Date".equals(aClass.getSimpleName())){
            try {
                if(((String) value).length() == 10)
                    return sdfShort.parse((String) value);
                else
                    return sdf.parse((String) value);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        return value;
    }

}
