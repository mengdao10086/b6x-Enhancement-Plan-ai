package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends kotlin.collections.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final boolean[] f37881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37882b;

    public a(@yt.k boolean[] array) {
        f0.p(array, "array");
        this.f37881a = array;
    }

    @Override // kotlin.collections.o
    public boolean b() {
        try {
            boolean[] zArr = this.f37881a;
            int i10 = this.f37882b;
            this.f37882b = i10 + 1;
            return zArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37882b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37882b < this.f37881a.length;
    }
}
