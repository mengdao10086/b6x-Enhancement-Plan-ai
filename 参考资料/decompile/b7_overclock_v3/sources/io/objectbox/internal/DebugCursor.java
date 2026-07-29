package io.objectbox.internal;

import ii.i;
import io.objectbox.Transaction;
import io.objectbox.exception.DbException;
import java.io.Closeable;
import li.a;

/* JADX INFO: loaded from: classes5.dex */
@a
public class DebugCursor implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Transaction f32775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32777c;

    public DebugCursor(Transaction transaction, long j10) {
        this.f32775a = transaction;
        this.f32776b = j10;
    }

    public static DebugCursor a(Transaction transaction) {
        long jNativeCreate = nativeCreate(i.h(transaction));
        if (jNativeCreate != 0) {
            return new DebugCursor(transaction, jNativeCreate);
        }
        throw new DbException("Could not create native debug cursor");
    }

    public static native long nativeCreate(long j10);

    public static native void nativeDestroy(long j10);

    public static native byte[] nativeGet(long j10, byte[] bArr);

    public static native byte[] nativeSeekOrNext(long j10, byte[] bArr);

    public byte[] c(byte[] bArr) {
        return nativeGet(this.f32776b, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f32777c) {
            this.f32777c = true;
            Transaction transaction = this.f32775a;
            if (transaction != null && !transaction.k().isClosed()) {
                nativeDestroy(this.f32776b);
            }
        }
    }

    public byte[] d(byte[] bArr) {
        return nativeSeekOrNext(this.f32776b, bArr);
    }

    public void finalize() throws Throwable {
        if (this.f32777c) {
            return;
        }
        close();
        super.finalize();
    }
}
