package net.modificationstation.stationloader.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import net.modificationstation.stationloader.events.common.Event;

public class ReflectionHelper
{
    public static class UnableToFindMethodException extends RuntimeException
    {
        private String[] methodNames;

        public UnableToFindMethodException(String[] methodNames, Exception failed)
        {
            super(failed);
            this.methodNames = methodNames;
        }

    }

    public static class UnableToFindClassException extends RuntimeException
    {
        private String[] classNames;

        public UnableToFindClassException(String[] classNames, Exception err)
        {
            super(err);
            this.classNames = classNames;
        }

    }

    public static class UnableToAccessFieldException extends RuntimeException
    {

        private String[] fieldNameList;

        public UnableToAccessFieldException(String[] fieldNames, Exception e)
        {
            super(e);
            this.fieldNameList = fieldNames;
        }
    }

    public static class UnableToFindFieldException extends RuntimeException
    {
        private String[] fieldNameList;
        public UnableToFindFieldException(String[] fieldNameList, Exception e)
        {
            super(e);
            this.fieldNameList = fieldNameList;
        }
    }

    public static Field findField(Class<?> clazz, String... fieldNames)
    {
        Exception failed = null;
        for (String fieldName : fieldNames)
        {
            try
            {
                Field f = clazz.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f;
            }
            catch (Exception e)
            {
                failed = e;
            }
        }
        throw new UnableToFindFieldException(fieldNames, failed);
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T getPrivateValue(Class <? super E > classToAccess, E instance, int fieldIndex)
    {
        try
        {
            Field f = classToAccess.getDeclaredFields()[fieldIndex];
            f.setAccessible(true);
            return (T) f.get(instance);
        }
        catch (Exception e)
        {
            throw new UnableToAccessFieldException(new String[0], e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T getPrivateValue(Class <? super E > classToAccess, E instance, String... fieldNames)
    {
        try
        {
            return (T) findField(classToAccess, fieldNames).get(instance);
        }
        catch (Exception e)
        {
            throw new UnableToAccessFieldException(fieldNames, e);
        }
    }

    public static <T, E> void setPrivateValue(Class <? super T > classToAccess, T instance, E value, int fieldIndex)
    {
        try
        {
            Field f = classToAccess.getDeclaredFields()[fieldIndex];
            f.setAccessible(true);
            f.set(instance, value);
        }
        catch (Exception e)
        {
            throw new UnableToAccessFieldException(new String[0] , e);
        }
    }

    public static <T, E> void setPrivateValue(Class <? super T > classToAccess, T instance, E value, String... fieldNames)
    {
        try
        {
            findField(classToAccess, fieldNames).set(instance, value);
        }
        catch (Exception e)
        {
            throw new UnableToAccessFieldException(fieldNames, e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Class<? super Object> getClass(ClassLoader loader, String... classNames)
    {
        Exception err = null;
        for (String className : classNames)
        {
            try
            {
                return (Class<? super Object>) Class.forName(className, false, loader);
            }
            catch (Exception e)
            {
                err = e;
            }
        }

        throw new UnableToFindClassException(classNames, err);
    }


    public static <E> Method findMethod(Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes)
    {
        Exception failed = null;
        for (String methodName : methodNames)
        {
            try
            {
                Method m = clazz.getDeclaredMethod(methodName, methodTypes);
                m.setAccessible(true);
                return m;
            }
            catch (Exception e)
            {
                failed = e;
            }
        }
        throw new UnableToFindMethodException(methodNames, failed);
    }

    public static Method getMethodAnnotation(final Class<?> clazz, final Class<? extends Annotation> annotation, final Class<?>...parameterTypes) {
        Method method = null;
        for (Method m : clazz.getDeclaredMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a.annotationType().equals(annotation) && m.getParameterTypes().length == parameterTypes.length && Arrays.asList(m.getParameterTypes()).equals(Arrays.asList(parameterTypes))){
                    method = m;
                }
            }
        }
        return method;
    }
}