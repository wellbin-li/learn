package com.lwb.learn.GarbageCollection;

/**
 * finalize方法实践
 *
 * 从执行结果可以看出：
 * 第一次发生GC时，finalize方法的确执行了，并且在被回收之前成功逃脱；
 * 第二次发生GC时，由于finalize方法只会被JVM调用一次，object被回收。
 *
 * 当然了，在实际项目中应该尽量避免使用finalize方法。
 */
public class FinalizeTest {
    public static FinalizeTest finalizeTest;

    public void isAlive(){
        System.out.println("I'm alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("method finalize is running");
        finalizeTest = this;
    }

    public static void main(String[] args) throws Exception {
        finalizeTest = new FinalizeTest();

        // 第一次执行，finalize方法会自救
        finalizeTest = null;
        System.gc();
        Thread.sleep(500);
        if (finalizeTest != null) {
            finalizeTest.isAlive();
        } else {
            System.out.println("I'm dead");
        }

        // 第二次执行，finalize方法已经执行过
        finalizeTest = null;
        System.gc();

        Thread.sleep(500);
        if (finalizeTest != null) {
            finalizeTest.isAlive();
        } else {
            System.out.println("I'm dead");
        }
    }
}
