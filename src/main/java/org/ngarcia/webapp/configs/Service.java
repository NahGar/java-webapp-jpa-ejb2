package org.ngarcia.webapp.configs;

import jakarta.enterprise.context.*;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;
import java.lang.annotation.*;
import org.ngarcia.webapp.interceptors.*;

@RequestScoped
@Logging
@Stereotype
@Named
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
   
}
