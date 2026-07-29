package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;
import xc.d;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    public volatile transient long base;
    public volatile transient int busy;

    @NullableDecl
    public volatile transient Cell[] cells;
    public static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    public static final Random rng = new Random();
    public static final int NCPU = Runtime.getRuntime().availableProcessors();

    public static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public volatile long f21204p0;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        public volatile long f21205p1;

        /* JADX INFO: renamed from: p2, reason: collision with root package name */
        public volatile long f21206p2;

        /* JADX INFO: renamed from: p3, reason: collision with root package name */
        public volatile long f21207p3;

        /* JADX INFO: renamed from: p4, reason: collision with root package name */
        public volatile long f21208p4;

        /* JADX INFO: renamed from: p5, reason: collision with root package name */
        public volatile long f21209p5;

        /* JADX INFO: renamed from: p6, reason: collision with root package name */
        public volatile long f21210p6;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public volatile long f21211q0;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        public volatile long f21212q1;

        /* JADX INFO: renamed from: q2, reason: collision with root package name */
        public volatile long f21213q2;

        /* JADX INFO: renamed from: q3, reason: collision with root package name */
        public volatile long f21214q3;

        /* JADX INFO: renamed from: q4, reason: collision with root package name */
        public volatile long f21215q4;

        /* JADX INFO: renamed from: q5, reason: collision with root package name */
        public volatile long f21216q5;

        /* JADX INFO: renamed from: q6, reason: collision with root package name */
        public volatile long f21217q6;
        public volatile long value;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }

        public Cell(long j10) {
            this.value = j10;
        }

        public final boolean cas(long j10, long j11) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j10, j11);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField(d.W));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e10) {
                throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.cache.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    final boolean casBase(long j10, long j11) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j10, j11);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long j10, long j11);

    final void internalReset(long j10) {
        Cell[] cellArr = this.cells;
        this.base = j10;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j10;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void retryUpdate(long r17, int[] r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.retryUpdate(long, int[], boolean):void");
    }
}
