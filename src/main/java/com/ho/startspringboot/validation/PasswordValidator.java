package com.ho.startspringboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator implements ConstraintValidator<Password, String> {
  private static final int MIN_LENGTH = 4;
  private static final int MAX_LENGTH = 30;
  private static final int MIN_COMPLEX_RULES = 2;
  private static final int MAX_REPETITIVE_CHARS = 1;
  private static final int MIN_SPECIAL_CASE_CHARS = 1;
  private static final int MIN_UPPER_CASE_CHARS = 1;
  private static final int MIN_LOWER_CASE_CHARS = 1;
  private static final int MIN_DIGIT_CASE_CHARS = 1;

  @Override
  public boolean isValid(String password, ConstraintValidatorContext context) {
    List<Rule> rules = new ArrayList<>();
    rules.add(new LengthRule(MIN_LENGTH, MAX_LENGTH));
    CharacterCharacteristicsRule characterCharacteristicsRule = new CharacterCharacteristicsRule(MIN_COMPLEX_RULES,
        new CharacterRule(EnglishCharacterData.Special, MIN_SPECIAL_CASE_CHARS),
        new CharacterRule(EnglishCharacterData.UpperCase, MIN_UPPER_CASE_CHARS),
        new CharacterRule(EnglishCharacterData.LowerCase, MIN_LOWER_CASE_CHARS),
        new CharacterRule(EnglishCharacterData.Digit, MIN_DIGIT_CASE_CHARS)
    );

    rules.add(characterCharacteristicsRule);
    rules.add(new RepeatCharacterRegexRule(MAX_REPETITIVE_CHARS));
    org.passay.PasswordValidator passwordValidator = new org.passay.PasswordValidator(rules);
    PasswordData passwordData = new PasswordData(password);
    RuleResult result = passwordValidator.validate(passwordData);

    return result.isValid();
  }
}
