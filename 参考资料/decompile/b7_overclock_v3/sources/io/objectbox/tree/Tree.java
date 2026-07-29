package io.objectbox.tree;

import ii.i;
import io.objectbox.BoxStore;
import java.io.Closeable;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import li.b;

/* JADX INFO: loaded from: classes5.dex */
@b
public class Tree implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f32969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BoxStore f32970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f32971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32972d = "\\.";

    public Tree(BoxStore boxStore, String str) {
        this.f32970b = boxStore;
        if (boxStore == null) {
            throw new IllegalArgumentException("store must not be null");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("uid must be 0 or not empty");
        }
        this.f32969a = nativeCreateWithUid(boxStore.z1(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object T(Callable callable) throws Exception {
        boolean zNativeSetTransaction = nativeSetTransaction(this.f32969a, i.h(i.c(this.f32970b)));
        try {
            return callable.call();
        } finally {
            if (zNativeSetTransaction) {
                nativeClearTransaction(this.f32969a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(Runnable runnable) {
        boolean zNativeSetTransaction = nativeSetTransaction(this.f32969a, i.h(i.c(this.f32970b)));
        try {
            runnable.run();
        } finally {
            if (zNativeSetTransaction) {
                nativeClearTransaction(this.f32969a);
            }
        }
    }

    public static native long nativeCreate(long j10, long j11);

    public static native long nativeCreateWithUid(long j10, String str);

    public static native void nativeDelete(long j10);

    public long C1(long j10, long j11, long j12, long j13) {
        return nativePutValueInteger(this.f32969a, j10, j11, j12, j13);
    }

    public long F0(long j10, long j11, long j12, @Nullable String str) {
        return nativePutBranch(this.f32969a, j10, j11, j12, str);
    }

    public long G0(long j10, long j11, @Nullable String str) {
        return nativePutBranch(this.f32969a, 0L, j10, j11, str);
    }

    public Branch I() {
        return new Branch(this, nativeGetRootId(this.f32969a));
    }

    public long L() {
        return this.f32971c;
    }

    public long L1(long j10, long j11, long j12, String str) {
        return nativePutValueString(this.f32969a, j10, j11, j12, str);
    }

    public BoxStore M() {
        return this.f32970b;
    }

    public long M0(long j10, long j11, String str) {
        return nativePutMetaBranch(this.f32969a, j10, j11, str, null);
    }

    @Nullable
    public String P(long j10) {
        wi.b bVarU = u(j10);
        if (bVarU != null) {
            return bVarU.c();
        }
        return null;
    }

    public long V1(long j10, long j11, String str) {
        return nativePutValueString(this.f32969a, 0L, j10, j11, str);
    }

    public void Y1(Runnable runnable) {
        this.f32970b.C2(k(runnable));
    }

    public long Z(wi.b bVar) {
        long jF = bVar.f();
        long jI = bVar.i();
        long jH = bVar.h();
        short sL = bVar.l();
        if (sL != 23) {
            switch (sL) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return nativePutValueInteger(this.f32969a, jF, jI, jH, bVar.g());
                case 7:
                case 8:
                    return nativePutValueFP(this.f32969a, jF, jI, jH, bVar.e());
                case 9:
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported value type: " + ((int) bVar.l()));
            }
        }
        return nativePutValueString(this.f32969a, jF, jI, jH, bVar.j());
    }

    public long b0(long j10, long j11) {
        return nativePutBranch(this.f32969a, 0L, j10, j11, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nativeDelete(this.f32969a);
        this.f32969a = 0L;
    }

    public <T> T d(Callable<T> callable) {
        return (T) this.f32970b.k(i(callable));
    }

    public long d1(long j10, long j11, String str, @Nullable String str2) {
        return nativePutMetaBranch(this.f32969a, j10, j11, str, str2);
    }

    public <T> T f(Callable<T> callable) throws Exception {
        return (T) this.f32970b.m(i(callable));
    }

    public void f2(Runnable runnable) {
        this.f32970b.D2(k(runnable));
    }

    public <T> T h(Callable<T> callable) {
        try {
            return (T) this.f32970b.m(i(callable));
        } catch (Exception e10) {
            throw new RuntimeException("Callable threw exception", e10);
        }
    }

    public long[] h1(long j10, String[] strArr) {
        return nativePutMetaBranches(this.f32969a, j10, strArr);
    }

    public void h2(String str) {
        this.f32972d = str;
    }

    public final <T> Callable<T> i(final Callable<T> callable) {
        return new Callable() { // from class: wi.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f54709a.T(callable);
            }
        };
    }

    public long[] i1(String[] strArr) {
        return nativePutMetaBranches(this.f32969a, 0L, strArr);
    }

    public final Runnable k(final Runnable runnable) {
        return new Runnable() { // from class: wi.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f54707a.W(runnable);
            }
        };
    }

    public long k1(long j10, long j11, String str, short s10) {
        return nativePutMetaLeaf(this.f32969a, j10, j11, str, s10, false, null);
    }

    @Nullable
    public Double l(long j10) {
        wi.b bVarU = u(j10);
        if (bVarU != null) {
            return bVarU.a();
        }
        return null;
    }

    public long m() {
        return this.f32969a;
    }

    public long m1(long j10, long j11, String str, short s10, boolean z10) {
        return nativePutMetaLeaf(this.f32969a, j10, j11, str, s10, z10, null);
    }

    @Nullable
    public Long n(long j10) {
        wi.b bVarU = u(j10);
        if (bVarU != null) {
            return bVarU.b();
        }
        return null;
    }

    public native void nativeClearTransaction(long j10);

    public native LeafNode nativeGetLeafById(long j10, long j11);

    public native long nativeGetRootId(long j10);

    public native long nativePutBranch(long j10, long j11, long j12, long j13, @Nullable String str);

    public native long nativePutMetaBranch(long j10, long j11, long j12, String str, @Nullable String str2);

    public native long[] nativePutMetaBranches(long j10, long j11, String[] strArr);

    public native long nativePutMetaLeaf(long j10, long j11, long j12, String str, short s10, boolean z10, @Nullable String str2);

    public native long nativePutValueFP(long j10, long j11, long j12, long j13, double d10);

    public native long nativePutValueInteger(long j10, long j11, long j12, long j13, long j14);

    public native long nativePutValueString(long j10, long j11, long j12, long j13, @Nullable String str);

    public native boolean nativeSetTransaction(long j10, long j11);

    public long p1(long j10, long j11, String str, short s10, boolean z10, @Nullable String str2) {
        return nativePutMetaLeaf(this.f32969a, j10, j11, str, s10, z10, str2);
    }

    public long s1(long j10, long j11, double d10) {
        return nativePutValueFP(this.f32969a, 0L, j10, j11, d10);
    }

    @Nullable
    public wi.b u(long j10) {
        LeafNode leafNodeNativeGetLeafById = nativeGetLeafById(this.f32969a, j10);
        if (leafNodeNativeGetLeafById == null) {
            return null;
        }
        return new wi.b(leafNodeNativeGetLeafById);
    }

    public long u1(long j10, long j11, long j12) {
        return nativePutValueInteger(this.f32969a, 0L, j10, j11, j12);
    }

    public String z() {
        return this.f32972d;
    }

    public long z1(long j10, long j11, long j12, double d10) {
        return nativePutValueFP(this.f32969a, j10, j11, j12, d10);
    }

    public Tree(BoxStore boxStore, long j10) {
        this.f32970b = boxStore;
        this.f32971c = j10;
        if (boxStore != null) {
            this.f32969a = nativeCreate(boxStore.z1(), j10);
            return;
        }
        throw new IllegalArgumentException("store must not be null");
    }
}
