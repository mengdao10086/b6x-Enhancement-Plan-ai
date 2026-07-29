package q2;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f47105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f47106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f47108d;

    public b(boolean isConnected, boolean isValidated, boolean isMetered, boolean isNotRoaming) {
        this.f47105a = isConnected;
        this.f47106b = isValidated;
        this.f47107c = isMetered;
        this.f47108d = isNotRoaming;
    }

    public boolean a() {
        return this.f47105a;
    }

    public boolean b() {
        return this.f47107c;
    }

    public boolean c() {
        return this.f47108d;
    }

    public boolean d() {
        return this.f47106b;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof b)) {
            return false;
        }
        b bVar = (b) o10;
        return this.f47105a == bVar.f47105a && this.f47106b == bVar.f47106b && this.f47107c == bVar.f47107c && this.f47108d == bVar.f47108d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r02 = this.f47105a;
        int i10 = r02;
        if (this.f47106b) {
            i10 = r02 + 16;
        }
        int i11 = i10;
        if (this.f47107c) {
            i11 = i10 + 256;
        }
        return this.f47108d ? i11 + 4096 : i11;
    }

    @n0
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f47105a), Boolean.valueOf(this.f47106b), Boolean.valueOf(this.f47107c), Boolean.valueOf(this.f47108d));
    }
}
