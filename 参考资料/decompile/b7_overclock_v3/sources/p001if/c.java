package p001if;

import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f32355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l[] f32356c;

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f32354a = i10;
        this.f32355b = iArr;
        float f10 = i13;
        this.f32356c = new l[]{new l(i11, f10), new l(i12, f10)};
    }

    public l[] a() {
        return this.f32356c;
    }

    public int[] b() {
        return this.f32355b;
    }

    public int c() {
        return this.f32354a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f32354a == ((c) obj).f32354a;
    }

    public int hashCode() {
        return this.f32354a;
    }
}
