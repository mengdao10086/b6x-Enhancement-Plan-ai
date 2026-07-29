package io.reactivex.observers;

import com.blankj.utilcode.util.i0;
import dj.r;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import xi.y;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f35275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Thread f35276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f35277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f35279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f35280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f35281j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f35273b = new VolatileSizeArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Throwable> f35274c = new VolatileSizeArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f35272a = new CountDownLatch(1);

    public enum TestWaitStrategy implements Runnable {
        SPIN { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        },
        YIELD { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        public static void sleep(int i10) {
            try {
                Thread.sleep(i10);
            } catch (InterruptedException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static String Y(Object obj) {
        if (obj == null) {
            return i0.f11859x;
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ee.a.f26979d;
    }

    public final U A(int i10) {
        int size = this.f35273b.size();
        if (size == i10) {
            return this;
        }
        throw T("Value counts differ; expected: " + i10 + " but was: " + size);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
    
        if (r3 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        if (r2 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        throw T("Fewer values received than expected (" + r1 + ee.a.f26979d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
    
        throw T("More values received than expected (" + r1 + ee.a.f26979d);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final U B(java.lang.Iterable<? extends T> r6) {
        /*
            r5 = this;
            java.util.List<T> r0 = r5.f35273b
            java.util.Iterator r0 = r0.iterator()
            java.util.Iterator r6 = r6.iterator()
            r1 = 0
        Lb:
            boolean r2 = r6.hasNext()
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L57
            if (r2 != 0) goto L18
            goto L57
        L18:
            java.lang.Object r2 = r6.next()
            java.lang.Object r3 = r0.next()
            boolean r4 = io.reactivex.internal.functions.a.c(r2, r3)
            if (r4 == 0) goto L29
            int r1 = r1 + 1
            goto Lb
        L29:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Values at position "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = " differ; expected: "
            r6.append(r0)
            java.lang.String r0 = Y(r2)
            r6.append(r0)
            java.lang.String r0 = " but was: "
            r6.append(r0)
            java.lang.String r0 = Y(r3)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.AssertionError r6 = r5.T(r6)
            throw r6
        L57:
            java.lang.String r6 = ")"
            if (r3 != 0) goto L77
            if (r2 != 0) goto L5e
            return r5
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Fewer values received than expected ("
            r0.append(r2)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.AssertionError r6 = r5.T(r6)
            throw r6
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "More values received than expected ("
            r0.append(r2)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.AssertionError r6 = r5.T(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.BaseTestConsumer.B(java.lang.Iterable):io.reactivex.observers.BaseTestConsumer");
    }

    public final U C(Iterable<? extends T> iterable) {
        return (U) t().B(iterable).l().p();
    }

    public final U D(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            o();
            return this;
        }
        for (T t10 : this.f35273b) {
            if (!collection.contains(t10)) {
                throw T("Value not in the expected collection: " + Y(t10));
            }
        }
        return this;
    }

    public final U E(Collection<? extends T> collection) {
        return (U) t().D(collection).l().p();
    }

    public final U F(T... tArr) {
        int size = this.f35273b.size();
        if (size != tArr.length) {
            throw T("Value count differs; expected: " + tArr.length + i0.f11861z + Arrays.toString(tArr) + " but was: " + size + i0.f11861z + this.f35273b);
        }
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = this.f35273b.get(i10);
            T t11 = tArr[i10];
            if (!io.reactivex.internal.functions.a.c(t11, t10)) {
                throw T("Values at position " + i10 + " differ; expected: " + Y(t11) + " but was: " + Y(t10));
            }
        }
        return this;
    }

    public final U G(T... tArr) {
        return (U) t().F(tArr).l().p();
    }

    public final U H() throws InterruptedException {
        if (this.f35272a.getCount() == 0) {
            return this;
        }
        this.f35272a.await();
        return this;
    }

    public final boolean I(long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10 = this.f35272a.getCount() == 0 || this.f35272a.await(j10, timeUnit);
        this.f35281j = !z10;
        return z10;
    }

    public final U J(int i10) {
        return (U) L(i10, TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U K(int i10, Runnable runnable) {
        return (U) L(i10, runnable, 5000L);
    }

    public final U L(int i10, Runnable runnable, long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j10 > 0 && System.currentTimeMillis() - jCurrentTimeMillis >= j10) {
                this.f35281j = true;
                break;
            }
            if (this.f35272a.getCount() == 0 || this.f35273b.size() >= i10) {
                break;
            }
            runnable.run();
        }
        return this;
    }

    public final U M(long j10, TimeUnit timeUnit) {
        try {
            if (!this.f35272a.await(j10, timeUnit)) {
                this.f35281j = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e10) {
            dispose();
            throw ExceptionHelper.f(e10);
        }
    }

    public final boolean N() {
        try {
            H();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final boolean O(long j10, TimeUnit timeUnit) {
        try {
            return I(j10, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U P() {
        this.f35281j = false;
        return this;
    }

    public final long Q() {
        return this.f35275d;
    }

    public final int R() {
        return this.f35274c.size();
    }

    public final List<Throwable> S() {
        return this.f35274c;
    }

    public final AssertionError T(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append(str);
        sb2.append(" (");
        sb2.append("latch = ");
        sb2.append(this.f35272a.getCount());
        sb2.append(", ");
        sb2.append("values = ");
        sb2.append(this.f35273b.size());
        sb2.append(", ");
        sb2.append("errors = ");
        sb2.append(this.f35274c.size());
        sb2.append(", ");
        sb2.append("completions = ");
        sb2.append(this.f35275d);
        if (this.f35281j) {
            sb2.append(", timeout!");
        }
        if (isDisposed()) {
            sb2.append(", disposed!");
        }
        CharSequence charSequence = this.f35280i;
        if (charSequence != null) {
            sb2.append(", tag = ");
            sb2.append(charSequence);
        }
        sb2.append(')');
        AssertionError assertionError = new AssertionError(sb2.toString());
        if (!this.f35274c.isEmpty()) {
            if (this.f35274c.size() == 1) {
                assertionError.initCause(this.f35274c.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.f35274c));
            }
        }
        return assertionError;
    }

    public final List<List<Object>> U() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a0());
        arrayList.add(S());
        ArrayList arrayList2 = new ArrayList();
        for (long j10 = 0; j10 < this.f35275d; j10++) {
            arrayList2.add(y.a());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean V() {
        return this.f35272a.getCount() == 0;
    }

    public final boolean W() {
        return this.f35281j;
    }

    public final Thread X() {
        return this.f35276e;
    }

    public final int Z() {
        return this.f35273b.size();
    }

    public final U a() {
        long j10 = this.f35275d;
        if (j10 == 0) {
            throw T("Not completed");
        }
        if (j10 <= 1) {
            return this;
        }
        throw T("Multiple completions: " + j10);
    }

    public final List<T> a0() {
        return this.f35273b;
    }

    public final U b() {
        return (U) t().o().l().p();
    }

    public final U b0(CharSequence charSequence) {
        this.f35280i = charSequence;
        return this;
    }

    public final U c(r<Throwable> rVar) {
        int size = this.f35274c.size();
        if (size == 0) {
            throw T("No errors");
        }
        boolean z10 = false;
        Iterator<Throwable> it2 = this.f35274c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            try {
                if (rVar.a(it2.next())) {
                    z10 = true;
                    break;
                }
            } catch (Exception e10) {
                throw ExceptionHelper.f(e10);
            }
        }
        if (!z10) {
            throw T("Error not present");
        }
        if (size == 1) {
            return this;
        }
        throw T("Error present but other errors as well");
    }

    public final U d(Class<? extends Throwable> cls) {
        return (U) c(Functions.l(cls));
    }

    public final U e(Throwable th2) {
        return (U) c(Functions.i(th2));
    }

    public final U f(String str) {
        int size = this.f35274c.size();
        if (size == 0) {
            throw T("No errors");
        }
        if (size != 1) {
            throw T("Multiple errors");
        }
        String message = this.f35274c.get(0).getMessage();
        if (io.reactivex.internal.functions.a.c(str, message)) {
            return this;
        }
        throw T("Error message differs; exptected: " + str + " but was: " + message);
    }

    public final U g(r<Throwable> rVar, T... tArr) {
        return (U) t().F(tArr).c(rVar).p();
    }

    public final U h(Class<? extends Throwable> cls, T... tArr) {
        return (U) t().F(tArr).d(cls).p();
    }

    public final U i(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) t().F(tArr).d(cls).f(str).p();
    }

    public final U j(r<? super T> rVar) {
        int size = this.f35273b.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                if (rVar.a(this.f35273b.get(i10))) {
                    throw T("Value at position " + i10 + " matches predicate " + rVar.toString() + ", which was not expected.");
                }
            } catch (Exception e10) {
                throw ExceptionHelper.f(e10);
            }
        }
        return this;
    }

    public final U k(T t10) {
        int size = this.f35273b.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (io.reactivex.internal.functions.a.c(this.f35273b.get(i10), t10)) {
                throw T("Value at position " + i10 + " is equal to " + Y(t10) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U l() {
        if (this.f35274c.size() == 0) {
            return this;
        }
        throw T("Error(s) present: " + this.f35274c);
    }

    public final U n() {
        if (this.f35281j) {
            throw T("Timeout?!");
        }
        return this;
    }

    public final U o() {
        return (U) A(0);
    }

    public final U p() {
        long j10 = this.f35275d;
        if (j10 == 1) {
            throw T("Completed!");
        }
        if (j10 <= 1) {
            return this;
        }
        throw T("Multiple completions: " + j10);
    }

    public abstract U q();

    public final U r() {
        if (this.f35272a.getCount() != 0) {
            return this;
        }
        throw T("Subscriber terminated!");
    }

    public final U s(T... tArr) {
        return (U) t().F(tArr).l().a();
    }

    public abstract U t();

    public final U u() {
        if (this.f35272a.getCount() != 0) {
            throw T("Subscriber still running!");
        }
        long j10 = this.f35275d;
        if (j10 > 1) {
            throw T("Terminated with multiple completions: " + j10);
        }
        int size = this.f35274c.size();
        if (size > 1) {
            throw T("Terminated with multiple errors: " + size);
        }
        if (j10 == 0 || size == 0) {
            return this;
        }
        throw T("Terminated with multiple completions and errors: " + j10);
    }

    public final U v() {
        if (this.f35281j) {
            return this;
        }
        throw T("No timeout?!");
    }

    public final U w(r<T> rVar) {
        y(0, rVar);
        if (this.f35273b.size() <= 1) {
            return this;
        }
        throw T("Value present but other values as well");
    }

    public final U x(T t10) {
        if (this.f35273b.size() != 1) {
            throw T("expected: " + Y(t10) + " but was: " + this.f35273b);
        }
        T t11 = this.f35273b.get(0);
        if (io.reactivex.internal.functions.a.c(t10, t11)) {
            return this;
        }
        throw T("expected: " + Y(t10) + " but was: " + Y(t11));
    }

    public final U y(int i10, r<T> rVar) {
        if (this.f35273b.size() == 0) {
            throw T("No values");
        }
        if (i10 >= this.f35273b.size()) {
            throw T("Invalid index: " + i10);
        }
        try {
            if (rVar.a(this.f35273b.get(i10))) {
                return this;
            }
            throw T("Value not present");
        } catch (Exception e10) {
            throw ExceptionHelper.f(e10);
        }
    }

    public final U z(int i10, T t10) {
        int size = this.f35273b.size();
        if (size == 0) {
            throw T("No values");
        }
        if (i10 >= size) {
            throw T("Invalid index: " + i10);
        }
        T t11 = this.f35273b.get(i10);
        if (io.reactivex.internal.functions.a.c(t10, t11)) {
            return this;
        }
        throw T("expected: " + Y(t10) + " but was: " + Y(t11));
    }
}
