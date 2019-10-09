package com.bytetree.lintcode.design.ood;

/**
 * 204. Singleton
 * <p>
 * Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, we call this design as singleton. For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * <p>
 * You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.
 * <p>
 * Example
 * <p>
 * In Java:
 * <p>
 * A a = A.getInstance();
 * A b = A.getInstance();
 * <p>
 * a should equal to b.
 * <p>
 * Challenge
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 * <p>
 * <a href="https://www.lintcode.com/problem/singleton/description">204. Singleton</a>
 * <p>
 * Created by vencial on 2019-10-09.
 */
public class Singleton {

    private Singleton() {}
    private static volatile Singleton sINSTANCE;

    /**
     * @return: The same instance of this class every time
     */
    public static Singleton getInstance() {
        // write your code here
        if (sINSTANCE == null) {
            synchronized(Singleton.class) {
                if (sINSTANCE == null) {
                    sINSTANCE = new Singleton();
                }
            }
        }

        return sINSTANCE;
    }
}
