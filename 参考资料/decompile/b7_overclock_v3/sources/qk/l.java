package qk;

import java.util.NoSuchElementException;
import kotlin.collections.k0;

/* JADX INFO: loaded from: classes5.dex */
public final class l extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47412d;

    public l(int i10, int i11, int i12) {
        this.f47409a = i12;
        this.f47410b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f47411c = z10;
        this.f47412d = z10 ? i10 : i11;
    }

    @Override // kotlin.collections.k0
    public int b() {
        int i10 = this.f47412d;
        if (i10 != this.f47410b) {
            this.f47412d = this.f47409a + i10;
        } else {
            if (!this.f47411c) {
                throw new NoSuchElementException();
            }
            this.f47411c = false;
        }
        return i10;
    }

    public final int d() {
        return this.f47409a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f47411c;
    }
}
