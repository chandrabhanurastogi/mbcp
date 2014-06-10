
package com.ifli.mbcp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

/**
 * The Class ValidationHelper.
 */
public final class IFLIValidationUtils {

   
    private IFLIValidationUtils() {

    }

    /**
     * Name validate.
     * @param name
     *            the name
     * @return true, if successful
     */
    public static boolean nameValidate(final String name) {
        boolean valid = true;
        if (name == null || name.isEmpty()) {
            valid = false;
        }
        final char[] str = new char[name.length()];
        name.getChars(0, name.length(), str, 0);
        for (int i = 0; i < str.length; i++) {
            if ((Character.getNumericValue(str[i]) < 10 || Character
                    .getNumericValue(str[i]) > 35)
                    && !Character.isSpaceChar(str[i])) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Contains only numbers.
     * @param str
     *            the str
     * @return true, if successful
     */
    public static boolean containsOnlyNumbers(final String str) {
        boolean valid = true;
        if (str == null || str.isEmpty()) {
            valid = false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    /**
     * Check email.
     * @param field
     *            the field
     * @param value
     *            the value
     * @param errors
     *            the errors
     */
    public static void checkEmail(final String field, final String value,
            final Errors errors) {
        checkEmail(field, value, errors, "error.invalid.emailaddress");
    }

    /**
     * Check email.
     * @param field
     *            the field
     * @param value
     *            the value
     * @param errors
     *            the errors
     * @param message
     *            the message
     */
    public static void checkEmail(final String field, final String value,
            final Errors errors, String message) {
        /*
         * if (!errors.hasFieldErrors(field) &&
         * !value.matches(".+@.+\\.[a-z]+")) {
         * errors.rejectValue(field, message);
         */

        final String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        // Set the email pattern string
        final Pattern pattern = Pattern.compile(emailPattern);

        // Match the given string with the pattern
        final Matcher matcher = pattern.matcher(value);

        // check whether match is found
        final boolean matchFound = matcher.matches();

        if (!errors.hasFieldErrors(field) && !matchFound) {
            errors.rejectValue(field, message);
        }
    }

    /**
     * Check phone number.
     * @param field
     *            the field
     * @param value
     *            the value
     * @param errors
     *            the errors
     */
    public static void checkPhoneNumber(final String field, final String value,
            final Errors errors) {
        checkPhoneNumber(field, value, errors, "error.invalid.phonenumber");
    }

    /**
     * Check number.
     * @param field
     *            the field
     * @param value
     *            the value
     * @param errors
     *            the errors
     * @param message
     *            the message
     */
    public static void checkPhoneNumber(final String field, final String value,
            final Errors errors, final String message) {
        if (!errors.hasFieldErrors(field)
                && (value == null || value.isEmpty() || value.length() != 10 || !(containsOnlyNumbers(value) && checkMinimum(
                        value, 1000000000L)))) {
            errors.rejectValue(field, message);
        }
    }

    /**
     * Check number.
     * @param field the field
     * @param value the value
     * @param errors the errors
     * @param message the message
     */
    public static void checkNumber(final String field, final String value,
            final Errors errors, final String message) {
        if (!errors.hasFieldErrors(field)
                && (value == null || value.isEmpty() || !containsOnlyNumbers(value))) {
            errors.rejectValue(field, message);
        }
    }

    
    public static void checkDob(final String field, final String value,
            final Errors errors, final String message) {
        if (!errors.hasFieldErrors(field)
                && (value != null && !value.isEmpty())) {
        	SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        	try{
        	Date givenDate = df.parse(value);
        	Date today = Calendar.getInstance().getTime();
        	if(givenDate.after(today)){
        		 errors.rejectValue(field, message);
        	}
        	}catch(Exception e){
        		e.printStackTrace();
        	}
           
        }
    }
    public static void checkDob(final String field, final String value,
            final Errors errors) {
        checkDob(field, value, errors, "error.dob.invalid");
    }
    /**
     * Check date.
     * @param field the field
     * @param value the value
     * @param errors the errors
     */
    /*public static void checkDate(final String field, final String value,
            final Errors errors) {
        if (!errors.hasFieldErrors(field)) {
            SimpleDateFormat df = new SimpleDateFormat(
                    DateUtils.DEFAULT_DATE_FORMAT);
            Date testDate = null;
            try {
                testDate = df.parse(value);
            } catch (ParseException e) {
                // invalid date format
                errors.rejectValue(field, "error.date.invalid");
            }
            if (testDate != null) {
                // initialise the calendar to midnight to prevent
                // the current day from being rejected
                Calendar cal = DateUtils.convertStringToCalendar(value,
                        DateUtils.DEFAULT_DATE_FORMAT);

                Calendar today = Calendar.getInstance();
                today.set(Calendar.HOUR_OF_DAY, 0);
                today.set(Calendar.MINUTE, 0);
                today.set(Calendar.SECOND, 0);
                today.set(Calendar.MILLISECOND, 0);

                if (cal.getTime().after(today.getTime())) {
                    errors.rejectValue(field, "error.date.future");
                }
            }
        }
    }*/

    /**
     * Check name.
     * @param field
     *            the field
     * @param value
     *            the value
     * @param errors
     *            the errors
     */
    public static void checkName(final String field, final String value,
            final Errors errors) {
        checkName(field, value, errors, "error.invalid.name");
    }

    /**
     * Check name.
     * @param field
     *            the field
     * @param value
     *            the value
     * @param errors
     *            the errors
     * @param message
     *            the message
     */
    public static void checkName(final String field, final String value,
            final Errors errors, final String message) {
        if (!errors.hasFieldErrors(field) && !nameValidate(value)) {
            errors.rejectValue(field, message);
        }
    }

    /**
     * Check the image file extension.
     * @param field the field
     * @param imgFileName the image file name
     * @param errors the errors
     * @param message the message
     * @return true, if is valid img file ext
     */
    public static boolean isValidImgFileExt(String field, String imgFileName,
            Errors errors, String message) {
        boolean bValid = true;
        final String regEx = "(.*?)\\.(jpg|jpeg|gif|png)";
        if (!(imgFileName.toLowerCase(Locale.ENGLISH)).matches(regEx)) {
            errors.rejectValue(field, message);
            bValid = false;
        }
        return bValid;
    }

    /**
     * Validation method for special character.
     * @param value the value
     * @return true, if successful
     */
    public static boolean specialCharValidation(final String value) {
        boolean bValid = true;
        if (!value.matches("^[a-zA-Z0-9]{1,}$")) {
            bValid = false;
        }
        return bValid;
    }

    /**
     * Special char without space.
     * @param name the name
     * @return true, if successful
     */
    public static boolean specialCharWithoutSpace(final String name) {
        boolean bValid = true;
        if (!name.matches("^[a-zA-Z0-9.]{1,}$")) {
            bValid = false;
        }
        return bValid;
    }

    /**
     * Address validation.
     * @param name the name
     * @return true, if successful
     */
    public static boolean addressValidation(final String name) {
        boolean bValid = true;
        if (!name.matches("^[a-zA-Z0-9., #-/]{1,}$")) {
            bValid = false;
        }
        return bValid;
    }

    /**
     * Name without space validation.
     * @param name the name
     * @return true, if successful
     */
    public static boolean nameWithoutSpaceValidation(final String name) {
        boolean bValid = true;
        if (!name.matches("^[a-zA-Z]{1,}$")) {
            bValid = false;
        }
        return bValid;
    }

    /**
     * Name validate withour space.
     * @param name the name
     * @return true, if successful
     */
    public static boolean nameValidateWithourSpace(final String name) {
        boolean valid = true;
        if (name == null || name.isEmpty()) {
            valid = false;
        }
        final char[] str = new char[name.length()];
        name.getChars(0, name.length(), str, 0);
        for (int i = 0; i < str.length; i++) {
            if ((Character.getNumericValue(str[i]) < 10 || Character
                    .getNumericValue(str[i]) > 35)
                    && Character.isSpaceChar(str[i])) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Checks if is numeric text.
     * @param value the value
     * @return true, if is numeric text
     */
    public static boolean isNumericText(final String value) {
        final String pattern = "^[0-9]*$";

        if (!value.matches(pattern)) {
            return true;
        }
        return false;

    }

    /**
     * Checks if is alpha text.
     * @param value the value
     * @return true, if is alpha text
     */
    public static boolean isAlphaText(final String value) {

        final String pattern = "^[a-zA-Z]*$";

        if (!value.matches(pattern)) {
            return true;
        }
        return false;

    }

    /**
     * Check minimum.
     * @param value the value
     * @param minimumVal the minimum val
     * @return true, if successful
     */
    public static boolean checkMinimum(String value, long minimumVal) {
        boolean valid = true;
        Long val = Long.parseLong(value);
        if (val < minimumVal) {
            valid = false;
        }
        return valid;

    }

    /**
     * Keyword validation.
     * @param name the name
     * @return true, if successful
     */
    public static boolean keywordValidation(final String name) {
        boolean bValid = true;
        if (!name.matches("^[a-zA-Z0-9. @]{1,}$")) {
            bValid = false;
        }
        return bValid;
    }

    /**
     * Checks if is alpha text.
     * @param value the value
     * @return true, if is alpha text
     */
    public static boolean isAlphaNumericHypen(final String value) {

        final String pattern = "([A-Za-z0-9-\\s])*$";

        if (!value.matches(pattern)) {
            return true;
        }
        return false;

    }

    /**
     * Checks if is numeric decimal optional.
     * @param value the value
     * @return true, if is numeric decimal optional
     */
    public static boolean isNumericDecimalOptional(String value) {
        boolean bValid = false;
        String pattern = "((-)?[0-9]*(\\.[0-9]+)?)+";
        if (value != null && value.trim().matches(pattern)) {
            bValid = true;
        }
        return bValid;
    }
    /**
     * Checks if is isAlphaTextWithSpace.
     * @param value the value
     * @return true, if is alpha text
     */
    public static boolean isAlphaTextWithSpace(final String value) {

        final String pattern = "([A-Za-z\\s])*$";

        if (!value.matches(pattern)) {
            return true;
        }
        return false;

    }
}