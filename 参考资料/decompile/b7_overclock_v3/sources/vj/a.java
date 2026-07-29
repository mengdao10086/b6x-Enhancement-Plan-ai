package vj;

import bk.f;
import hk.h;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "LocksKt")
@t0({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
public final class a {
    @f
    public static final <T> T a(ReentrantReadWriteLock reentrantReadWriteLock, ik.a<? extends T> action) {
        f0.p(reentrantReadWriteLock, "<this>");
        f0.p(action, "action");
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            return action.o();
        } finally {
            c0.d(1);
            lock.unlock();
            c0.c(1);
        }
    }

    @f
    public static final <T> T b(Lock lock, ik.a<? extends T> action) {
        f0.p(lock, "<this>");
        f0.p(action, "action");
        lock.lock();
        try {
            return action.o();
        } finally {
            c0.d(1);
            lock.unlock();
            c0.c(1);
        }
    }

    @f
    public static final <T> T c(ReentrantReadWriteLock reentrantReadWriteLock, ik.a<? extends T> action) {
        f0.p(reentrantReadWriteLock, "<this>");
        f0.p(action, "action");
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return action.o();
        } finally {
            c0.d(1);
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
            c0.c(1);
        }
    }
}
