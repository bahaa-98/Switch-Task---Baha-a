package com.example.demo.utils;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.Set;

public class Helper {

    public static ApiMessage getLocaleMessage(String messageKey, ResourceBundleMessageSource messageSource){
        Locale locale = getCurrentLocale();
        return new ApiMessage(messageSource.getMessage(messageKey, null, locale),
                messageSource.getMessage(messageKey + ".code", null, null));
    }

    public static Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }

    public static String getMessageKeyFromException(ConstraintViolationException ex) {

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        ConstraintViolation<?> constraint = violations.iterator().next();
        String messageKey = constraint.getMessageTemplate();

        return messageKey;
    }

    public static boolean
    stringContainsIgnoreCase(String value, String key) {
        return value.toLowerCase().contains(key);
    }
}
