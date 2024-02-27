package com.example.http.timer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) // чтобы ставить над классами и над методами
@Retention(RetentionPolicy.RUNTIME) // чтобы антотация была доступна в runtime
public @interface Timer {
}
