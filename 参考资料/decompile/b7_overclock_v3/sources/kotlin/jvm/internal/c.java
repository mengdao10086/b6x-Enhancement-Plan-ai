package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends kotlin.collections.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final char[] f37885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37886b;

    public c(@yt.k char[] array) {
        f0.p(array, "array");
        this.f37885a = array;
    }

    @Override // kotlin.collections.q
    public char b() {
        try {
            char[] cArr = this.f37885a;
            int i10 = this.f37886b;
            this.f37886b = i10 + 1;
            return cArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37886b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37886b < this.f37885a.length;
    }
}
