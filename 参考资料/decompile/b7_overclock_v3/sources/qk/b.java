package qk;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends kotlin.collections.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47392d;

    public b(char c10, char c11, int i10) {
        this.f47389a = i10;
        this.f47390b = c11;
        boolean z10 = true;
        if (i10 <= 0 ? f0.t(c10, c11) < 0 : f0.t(c10, c11) > 0) {
            z10 = false;
        }
        this.f47391c = z10;
        this.f47392d = z10 ? c10 : c11;
    }

    @Override // kotlin.collections.q
    public char b() {
        int i10 = this.f47392d;
        if (i10 != this.f47390b) {
            this.f47392d = this.f47389a + i10;
        } else {
            if (!this.f47391c) {
                throw new NoSuchElementException();
            }
            this.f47391c = false;
        }
        return (char) i10;
    }

    public final int d() {
        return this.f47389a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f47391c;
    }
}
