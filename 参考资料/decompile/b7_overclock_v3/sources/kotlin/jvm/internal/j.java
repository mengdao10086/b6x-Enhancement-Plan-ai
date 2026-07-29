package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends kotlin.collections.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final long[] f37906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37907b;

    public j(@yt.k long[] array) {
        f0.p(array, "array");
        this.f37906a = array;
    }

    @Override // kotlin.collections.l0
    public long b() {
        try {
            long[] jArr = this.f37906a;
            int i10 = this.f37907b;
            this.f37907b = i10 + 1;
            return jArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37907b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37907b < this.f37906a.length;
    }
}
