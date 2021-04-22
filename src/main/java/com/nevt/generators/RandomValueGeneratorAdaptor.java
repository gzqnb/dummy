package com.nevt.generators;

import java.lang.reflect.Field;

public class RandomValueGeneratorAdaptor<T> {

    protected T generateCommon(Class<T> dataClass) {
        System.out.println("start generator: " + dataClass.getSimpleName());
        T realParam = null;
        try {
            realParam = dataClass.getDeclaredConstructor().newInstance();
        } catch (Exception ignore) {
        }
        Field[] fields = null;

        try {
            fields = dataClass.getDeclaredFields();

            for (Field field : fields) {

                field.setAccessible(true);
                String type = field.getType().getCanonicalName();

                switch (type) {
                    case ("float"):
                        field.set(realParam, (float) Math.random());
                        break;
                    case "int":
                        field.set(realParam, (int) (Math.random() * 100));
                        break;
                    case "short":
                        field.set(realParam, (short) (Math.random() * 100));
                        break;
                    case "long":
                        field.set(realParam, (long) (Math.random() * 1000));
                        break;
                    case "int[]":
                        int[] tempInt = new int[10];
                        for (int j = 0; j < 10; j++)
                            tempInt[j] = (int) (Math.random() * 100);
                        field.set(realParam, tempInt);
                        break;
                    case "float[]":
                        float[] tempFloat = new float[10];
                        for (int j = 0; j < 10; j++) {
                            tempFloat[j] = (float) Math.random();
                        }
                        field.set(realParam, tempFloat);
                        break;
                    case "long[]":
                        long[] tempLong = new long[10];
                        for (int j = 0; j < 10; j++) {
                            tempLong[j] = (long) (Math.random() * 1000);
                        }
                        field.set(realParam, tempLong);
                        break;
                    default:
                        field.set(realParam, null);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return realParam;
    }
}
