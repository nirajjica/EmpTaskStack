package com.eschool.common;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.springframework.security.core.context.SecurityContextHolder;

import com.eschool.domain.Employee;

public class CommonHelper {
	private static HashMap<String, Object> mapCache = new HashMap<String, Object>();
    public static Employee getAccount() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof Employee ? (Employee) principal : null;
    }

    public static boolean hasClassField(Class<?> clazz, final String field) {
        if (field == null) return true;

        Class<?> tempClass = clazz;
        do {
            try {
                tempClass.getDeclaredField(field);
                return true;
            } catch (NoSuchFieldException e) {
                tempClass = tempClass.getSuperclass();
            }
        } while (tempClass != null);

        return false;
    }
    
    public static synchronized Object getCache(String cacheId) {
    	return mapCache.get(cacheId);
    }
    
    public static synchronized void setCache(String cacheId, Object object) {
    	mapCache.put(cacheId, object);
    }
    
    public static synchronized int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
            (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    public static synchronized Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
