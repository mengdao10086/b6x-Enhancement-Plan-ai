package qk;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.l1;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public final class x implements Iterator<l1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f47434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47436d;

    public x(int i10, int i11, int i12) {
        this.f47433a = i11;
        boolean z10 = true;
        if (i12 <= 0 ? Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) < 0 : Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) > 0) {
            z10 = false;
        }
        this.f47434b = z10;
        this.f47435c = l1.j(i12);
        this.f47436d = this.f47434b ? i10 : i11;
    }

    public /* synthetic */ x(int i10, int i11, int i12, kotlin.jvm.internal.u uVar) {
        this(i10, i11, i12);
    }

    public int a() {
        int i10 = this.f47436d;
        if (i10 != this.f47433a) {
            this.f47436d = l1.j(this.f47435c + i10);
        } else {
            if (!this.f47434b) {
                throw new NoSuchElementException();
            }
            this.f47434b = false;
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f47434b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ l1 next() {
        return l1.d(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
