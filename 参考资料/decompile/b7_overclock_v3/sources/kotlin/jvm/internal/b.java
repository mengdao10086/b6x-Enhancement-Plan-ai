package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends kotlin.collections.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final byte[] f37883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37884b;

    public b(@yt.k byte[] array) {
        f0.p(array, "array");
        this.f37883a = array;
    }

    @Override // kotlin.collections.p
    public byte b() {
        try {
            byte[] bArr = this.f37883a;
            int i10 = this.f37884b;
            this.f37884b = i10 + 1;
            return bArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37884b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37884b < this.f37883a.length;
    }
}
