package org.gengar.validation;

import java.util.ArrayList;
import java.util.List;

public class TweetContentValidationRule implements ValidationRule {
    @Override
    public List<String> validate(String input) {
        List<String> errors = new ArrayList<>();
        if (input.length() > 280) {
            errors.add("Tweet content is too long");
        }
        return errors;
    }
}
