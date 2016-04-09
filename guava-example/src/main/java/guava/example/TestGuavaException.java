/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.io.IOException;
import java.sql.SQLException;

import com.google.common.base.Throwables;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月10日上午11:03:14
 */
public class TestGuavaException {
    public static void main(String[] args) throws IOException, SQLException {
        try {
               int a = 1/0;
            } catch (Exception t) {
                Throwables.propagateIfInstanceOf(t, IOException.class);
                Throwables.propagateIfInstanceOf(t, SQLException.class);
                Throwables.propagateIfPossible(t);
                System.out.println(Throwables.getStackTraceAsString(t));
                //throw Throwables.propagate(t);
            } catch (Throwable t) {
                Throwables.propagateIfInstanceOf(t, IOException.class);
                Throwables.propagateIfInstanceOf(t, SQLException.class);
                throw Throwables.propagate(t);
            }

    }
}

