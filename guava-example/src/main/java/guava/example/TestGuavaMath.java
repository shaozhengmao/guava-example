/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.math.BigInteger;
import java.math.RoundingMode;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月8日下午11:46:59
 */
public class TestGuavaMath {
    public static void main(String[] args) {
        System.out.println(IntMath.checkedAdd(4, 5));
        int logFloor = LongMath.log2(10, RoundingMode.FLOOR);
        System.out.println(logFloor);
        int mustNotOverflow = IntMath.checkedMultiply(5, 6);
        System.out.println(mustNotOverflow);
        long quotient = LongMath.divide(33, 3, RoundingMode.UNNECESSARY); // fail fast on non-multiple of 3
        System.out.println(quotient);
        BigInteger nearestInteger = DoubleMath.roundToBigInteger(99.5, RoundingMode.HALF_EVEN);
        System.out.println(nearestInteger);
        BigInteger sideLength = BigIntegerMath.sqrt(BigInteger.TEN.pow(99), RoundingMode.CEILING);
        System.out.println(sideLength);
        long maxgcd = LongMath.gcd(50, 100);
        System.out.println(maxgcd);
        long mod = LongMath.mod(10, 100);
        System.out.println(mod);
        long pow = LongMath.pow(2, 3);
        System.out.println(pow);
        System.out.println(LongMath.isPowerOfTwo(4));
        System.out.println(LongMath.factorial(5));
        System.out.println(LongMath.binomial(6, 5));
        
    }

}

