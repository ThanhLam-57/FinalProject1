package Common;

import java.util.regex.Pattern;

public class Common {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PHONE_REGEX =
            Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_DATE_REGEX =
            Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_NOT_EMPTY_REGEX =
            Pattern.compile("^[a-zA-Z0-9]+$", Pattern.CASE_INSENSITIVE);
}
