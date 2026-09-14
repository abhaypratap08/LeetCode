class FooBar {
    private int n;
    private AtomicBoolean aDone = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (aDone.get()) {}
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            aDone.set(true);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!aDone.get()) {}
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            aDone.set(false);
        }
    }
}