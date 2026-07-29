package gm;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h[] f29704d = new h[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f29705e = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h[] f29706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29708c;

    public i() {
        this(10);
    }

    public i(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f29706a = i10 == 0 ? f29704d : new h[i10];
        this.f29707b = 0;
        this.f29708c = false;
    }

    public static h[] d(h[] hVarArr) {
        return hVarArr.length < 1 ? f29704d : (h[]) hVarArr.clone();
    }

    public void a(h hVar) {
        Objects.requireNonNull(hVar, "'element' cannot be null");
        int length = this.f29706a.length;
        int i10 = this.f29707b + 1;
        if (this.f29708c | (i10 > length)) {
            h(i10);
        }
        this.f29706a[this.f29707b] = hVar;
        this.f29707b = i10;
    }

    public void b(i iVar) {
        Objects.requireNonNull(iVar, "'other' cannot be null");
        f(iVar.f29706a, "'other' elements cannot be null");
    }

    public void c(h[] hVarArr) {
        Objects.requireNonNull(hVarArr, "'others' cannot be null");
        f(hVarArr, "'others' elements cannot be null");
    }

    public h[] e() {
        int i10 = this.f29707b;
        if (i10 == 0) {
            return f29704d;
        }
        h[] hVarArr = new h[i10];
        System.arraycopy(this.f29706a, 0, hVarArr, 0, i10);
        return hVarArr;
    }

    public final void f(h[] hVarArr, String str) {
        int length = hVarArr.length;
        if (length < 1) {
            return;
        }
        int length2 = this.f29706a.length;
        int i10 = this.f29707b + length;
        int i11 = 0;
        if ((i10 > length2) | this.f29708c) {
            h(i10);
        }
        do {
            h hVar = hVarArr[i11];
            Objects.requireNonNull(hVar, str);
            this.f29706a[this.f29707b + i11] = hVar;
            i11++;
        } while (i11 < length);
        this.f29707b = i10;
    }

    public h g(int i10) {
        if (i10 < this.f29707b) {
            return this.f29706a[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10 + " >= " + this.f29707b);
    }

    public final void h(int i10) {
        h[] hVarArr = new h[Math.max(this.f29706a.length, i10 + (i10 >> 1))];
        System.arraycopy(this.f29706a, 0, hVarArr, 0, this.f29707b);
        this.f29706a = hVarArr;
        this.f29708c = false;
    }

    public int i() {
        return this.f29707b;
    }

    public h[] j() {
        int i10 = this.f29707b;
        if (i10 == 0) {
            return f29704d;
        }
        h[] hVarArr = this.f29706a;
        if (hVarArr.length == i10) {
            this.f29708c = true;
            return hVarArr;
        }
        h[] hVarArr2 = new h[i10];
        System.arraycopy(hVarArr, 0, hVarArr2, 0, i10);
        return hVarArr2;
    }
}
