package mvcIntelliJIdea.validator;

import java.security.InvalidParameterException;

public class TypeValidator {

    public static void validateString(String str) {
        if (str == null || str.equals("")) {
            throw new InvalidParameterException("Invalid parameter");
        }
    }

}
