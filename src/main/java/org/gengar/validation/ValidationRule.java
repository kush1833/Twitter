package org.gengar.validation;

import java.util.List;

public interface ValidationRule {
    List<String> validate(String input);
}
