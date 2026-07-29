package io.objectbox;

import ee.a;
import io.objectbox.exception.DbException;
import java.io.Closeable;
import javax.annotation.concurrent.NotThreadSafe;
import li.b;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
@c
@NotThreadSafe
public class Transaction implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c
    public static boolean f32644g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BoxStore f32646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f32647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f32648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f32650f;

    public Transaction(BoxStore boxStore, long j10, int i10) {
        this.f32646b = boxStore;
        this.f32645a = j10;
        this.f32649e = i10;
        this.f32647c = nativeIsReadOnly(j10);
        this.f32648d = f32644g ? new Throwable() : null;
    }

    public void I() {
        c();
        this.f32649e = this.f32646b.f32634s;
        nativeRenew(this.f32645a);
    }

    @b
    public void L() {
        c();
        this.f32649e = this.f32646b.f32634s;
        nativeReset(this.f32645a);
    }

    public void a() {
        c();
        nativeAbort(this.f32645a);
    }

    public void c() {
        if (this.f32650f) {
            throw new IllegalStateException("Transaction is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f32650f) {
            this.f32650f = true;
            this.f32646b.T2(this);
            if (!nativeIsOwnerThread(this.f32645a)) {
                boolean zNativeIsActive = nativeIsActive(this.f32645a);
                boolean zNativeIsRecycled = nativeIsRecycled(this.f32645a);
                if (zNativeIsActive || zNativeIsRecycled) {
                    String str = " (initial commit count: " + this.f32649e + ").";
                    if (zNativeIsActive) {
                        System.err.println("Transaction is still active" + str);
                    } else {
                        System.out.println("Hint: use closeThreadResources() to avoid finalizing recycled transactions" + str);
                        System.out.flush();
                    }
                    if (this.f32648d != null) {
                        System.err.println("Transaction was initially created here:");
                        this.f32648d.printStackTrace();
                    }
                    System.err.flush();
                }
            }
            if (!this.f32646b.isClosed()) {
                nativeDestroy(this.f32645a);
            }
        }
    }

    public void d() {
        c();
        this.f32646b.S2(this, nativeCommit(this.f32645a));
    }

    public boolean e0() {
        return this.f32647c;
    }

    public void f() {
        d();
        close();
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public <T> Cursor<T> h(Class<T> cls) {
        c();
        EntityInfo<T> entityInfoP1 = this.f32646b.p1(cls);
        ni.b<T> cursorFactory = entityInfoP1.getCursorFactory();
        long jNativeCreateCursor = nativeCreateCursor(this.f32645a, entityInfoP1.getDbName(), cls);
        if (jNativeCreateCursor != 0) {
            return cursorFactory.createCursor(this, jNativeCreateCursor, this.f32646b);
        }
        throw new DbException("Could not create native cursor");
    }

    public KeyValueCursor i() {
        c();
        return new KeyValueCursor(nativeCreateKeyValueCursor(this.f32645a));
    }

    public boolean isClosed() {
        return this.f32650f;
    }

    public BoxStore k() {
        return this.f32646b;
    }

    @c
    public long l() {
        return this.f32645a;
    }

    public boolean m() {
        c();
        return nativeIsActive(this.f32645a);
    }

    public boolean n() {
        return this.f32649e != this.f32646b.f32634s;
    }

    public native void nativeAbort(long j10);

    public native int[] nativeCommit(long j10);

    public native long nativeCreateCursor(long j10, String str, Class<?> cls);

    public native long nativeCreateKeyValueCursor(long j10);

    public native void nativeDestroy(long j10);

    public native boolean nativeIsActive(long j10);

    public native boolean nativeIsOwnerThread(long j10);

    public native boolean nativeIsReadOnly(long j10);

    public native boolean nativeIsRecycled(long j10);

    public native void nativeRecycle(long j10);

    public native void nativeRenew(long j10);

    public native void nativeReset(long j10);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TX ");
        sb2.append(Long.toString(this.f32645a, 16));
        sb2.append(" (");
        sb2.append(this.f32647c ? "read-only" : "write");
        sb2.append(", initialCommitCount=");
        sb2.append(this.f32649e);
        sb2.append(a.f26979d);
        return sb2.toString();
    }

    public boolean u() {
        c();
        return nativeIsRecycled(this.f32645a);
    }

    public void z() {
        c();
        nativeRecycle(this.f32645a);
    }
}
