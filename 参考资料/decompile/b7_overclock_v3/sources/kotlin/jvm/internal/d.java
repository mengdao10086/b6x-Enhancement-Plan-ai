package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends kotlin.collections.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final double[] f37887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37888b;

    public d(@yt.k double[] array) {
        f0.p(array, "array");
        this.f37887a = array;
    }

    @Override // kotlin.collections.a0
    public double b() {
        try {
            double[] dArr = this.f37887a;
            int i10 = this.f37888b;
            this.f37888b = i10 + 1;
            return dArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37888b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37888b < this.f37887a.length;
    }
}
