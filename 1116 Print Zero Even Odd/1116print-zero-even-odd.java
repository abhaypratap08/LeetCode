import java.util.concurrent.atomic.AtomicInteger;

class ZeroEvenOdd {
    private int n;
    private AtomicInteger counter;
    private AtomicInteger machine;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.counter = new AtomicInteger(0);
        this.machine = new AtomicInteger(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (counter.get() < n) {
            while (machine.get() != 0 && machine.get() != 2) {}
            if (counter.get() < n) printNumber.accept(0);
            machine.incrementAndGet();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (counter.get() < n) {
            while (machine.get() != 3) {}
            if (counter.get() < n) printNumber.accept(counter.incrementAndGet());
            machine.set(0);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (counter.get() < n) {
            while (machine.get() != 1) {}
            if (counter.get() < n) printNumber.accept(counter.incrementAndGet());
            machine.incrementAndGet();
        }
    }
}