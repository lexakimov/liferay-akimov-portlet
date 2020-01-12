package ru.isands.akimov.annotations;

import ru.isands.akimov.portlet.ExtendedMVCPortlet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для методов асинхронных действий портлета.
 *
 * @author akimov
 * created at 14.12.19 9:08
 * @see ExtendedMVCPortlet
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AsyncActionMethod {

}
