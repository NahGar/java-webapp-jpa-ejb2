package org.ngarcia.webapp.repositories;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, METHOD, TYPE, PARAMETER, FIELD})
public @interface RepositoryJdbc {
}
