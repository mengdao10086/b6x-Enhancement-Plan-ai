package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class f extends kotlin.collections.k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final int[] f37897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37898b;

    public f(@yt.k int[] array) {
        f0.p(array, "array");
        this.f37897a = array;
    }

    @Override // kotlin.collections.k0
    public int b() {
        try {
            int[] iArr = this.f37897a;
            int i10 = this.f37898b;
            this.f37898b = i10 + 1;
            return iArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37898b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37898b < this.f37897a.length;
    }
}
