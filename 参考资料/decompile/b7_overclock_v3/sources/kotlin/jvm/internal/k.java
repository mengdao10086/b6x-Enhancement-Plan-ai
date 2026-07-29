package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.f1;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final short[] f37909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37910b;

    public k(@yt.k short[] array) {
        f0.p(array, "array");
        this.f37909a = array;
    }

    @Override // kotlin.collections.f1
    public short b() {
        try {
            short[] sArr = this.f37909a;
            int i10 = this.f37910b;
            this.f37910b = i10 + 1;
            return sArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f37910b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f37910b < this.f37909a.length;
    }
}
