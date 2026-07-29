package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/WeakMapCtorCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
public final class a1 extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a1 f38779a = new a1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ReentrantReadWriteLock f38780b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final WeakHashMap<Class<? extends Throwable>, ik.l<Throwable, Throwable>> f38781c = new WeakHashMap<>();

    @Override // kotlinx.coroutines.internal.j
    @yt.k
    public ik.l<Throwable, Throwable> a(@yt.k Class<? extends Throwable> cls) {
        ReentrantReadWriteLock reentrantReadWriteLock = f38780b;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            ik.l<Throwable, Throwable> lVar = f38781c.get(cls);
            if (lVar != null) {
                return lVar;
            }
            ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
            int i10 = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i11 = 0; i11 < readHoldCount; i11++) {
                lock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                WeakHashMap<Class<? extends Throwable>, ik.l<Throwable, Throwable>> weakHashMap = f38781c;
                ik.l<Throwable, Throwable> lVar2 = weakHashMap.get(cls);
                if (lVar2 != null) {
                    return lVar2;
                }
                ik.l<Throwable, Throwable> lVarB = ExceptionsConstructorKt.b(cls);
                weakHashMap.put(cls, lVarB);
                while (i10 < readHoldCount) {
                    lock2.lock();
                    i10++;
                }
                writeLock.unlock();
                return lVarB;
            } finally {
                while (i10 < readHoldCount) {
                    lock2.lock();
                    i10++;
                }
                writeLock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}
