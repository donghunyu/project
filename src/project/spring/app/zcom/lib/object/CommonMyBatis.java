package project.spring.app.zcom.lib.object;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class CommonMyBatis {
    
    /**
     * Object 값이 null 또는 빈 값 여부
     * @param object Object 값
     * @return true null 또는 빈 값, false Object 값 존재
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object object) {
        if (object instanceof String) {
            return object == null || "".equals(object.toString());
        } else if(object instanceof List) {
            return object == null || ((List) object).isEmpty();
        } else if(object instanceof Map) {
            return object == null || ((Map) object).isEmpty();
        } else if(object instanceof Object[]) {
            return object == null || Array.getLength(object) == 0;
        } else {
            return object == null;
        }
    }
    
    /**
     * Object 값이 null 또는 빈 값 여부
     * @param object Object 값
     * @return true Object 값 존재, false null 또는 빈 값 
     */
    public static boolean isNotEmpty(Object object) {
        return ! isEmpty(object);
    }
    
    
	public static boolean isNull(Object object) {
		boolean result = false;
		
		if ( object == null ) {
			result = true;
		}
		
		return result;
	}

	public static boolean isNotNull(Object object) {
		boolean result = false;
		
		if ( object != null ) {
			result = true;
		}
		
		return result;
	}

	public static boolean isEqual(Object object, Object compareValue) {
		boolean result = false;
		
		if ( object instanceof String ) {
		    
		    String str = compareValue + "";
		    
			if ( str.equals(object) ) {
				result = true;
			}
		}
		
		return result;
	}

	public static boolean isNotEqual(Object object, Object compareValue) {
		boolean result = false;
		
		if ( object instanceof String ) {
			if ( !compareValue.equals(object) ) {
				result = true;
			}
		}
		
		return result;
	}

}
