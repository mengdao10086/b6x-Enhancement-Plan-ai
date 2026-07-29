package p001if;

import ee.a;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32353b;

    public b(int i10, int i11) {
        this.f32352a = i10;
        this.f32353b = i11;
    }

    public final int a() {
        return this.f32353b;
    }

    public final int b() {
        return this.f32352a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f32352a == bVar.f32352a && this.f32353b == bVar.f32353b;
    }

    public final int hashCode() {
        return this.f32352a ^ this.f32353b;
    }

    public final String toString() {
        return this.f32352a + a.f26978c + this.f32353b + ')';
    }
}
