package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends kotlin.collections.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final float[] f37894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37895b;

    public e(@yt.k float[] array) {
        f0.p(array, "array");
        this.f37894a = array;
    }

    @Override // kotlin.collections.c0
    public float b() {
        try {
            float[] fArr = this.f37894a;
            int i10 = this.f37895b;
            this.f37895b = i10 + 1;
            return fArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37895b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37895b < this.f37894a.length;
    }
}
