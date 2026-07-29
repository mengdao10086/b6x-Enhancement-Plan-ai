package io.objectbox;

import java.io.Closeable;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
public class KeyValueCursor implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f32639b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f32640c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f32641d = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32642a;

    public KeyValueCursor(long j10) {
        this.f32642a = j10;
    }

    public static native void nativeDestroy(long j10);

    public static native byte[] nativeGetCurrent(long j10);

    public static native byte[] nativeGetEqualOrGreater(long j10, long j11);

    public static native byte[] nativeGetFirst(long j10);

    public static native long nativeGetKey(long j10);

    public static native void nativeGetKey(long j10, long j11);

    public static native byte[] nativeGetLast(long j10);

    public static native byte[] nativeGetLongKey(long j10, long j11);

    public static native byte[] nativeGetNext(long j10);

    public static native byte[] nativeGetPrev(long j10);

    public static native void nativePutLongKey(long j10, long j11, byte[] bArr);

    public static native boolean nativeRemoveAt(long j10, long j11);

    public static native boolean nativeSeek(long j10, long j11);

    public byte[] a(long j10) {
        return nativeGetLongKey(this.f32642a, j10);
    }

    public byte[] c() {
        return nativeGetCurrent(this.f32642a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nativeDestroy(this.f32642a);
    }

    public byte[] d(long j10) {
        return nativeGetEqualOrGreater(this.f32642a, j10);
    }

    public byte[] f() {
        return nativeGetFirst(this.f32642a);
    }

    public long h() {
        return nativeGetKey(this.f32642a);
    }

    public byte[] i() {
        return nativeGetLast(this.f32642a);
    }

    public byte[] k() {
        return nativeGetNext(this.f32642a);
    }

    public byte[] l() {
        return nativeGetPrev(this.f32642a);
    }

    public void m(long j10, byte[] bArr) {
        nativePutLongKey(this.f32642a, j10, bArr);
    }

    public boolean n(long j10) {
        return nativeRemoveAt(this.f32642a, j10);
    }

    public boolean u(long j10) {
        return nativeSeek(this.f32642a, j10);
    }
}
