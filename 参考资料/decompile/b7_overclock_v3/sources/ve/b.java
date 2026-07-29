package ve;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f53123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public af.b f53124b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f53123a = aVar;
    }

    public b a(int i10, int i11, int i12, int i13) {
        return new b(this.f53123a.a(this.f53123a.e().a(i10, i11, i12, i13)));
    }

    public af.b b() throws NotFoundException {
        if (this.f53124b == null) {
            this.f53124b = this.f53123a.b();
        }
        return this.f53124b;
    }

    public af.a c(int i10, af.a aVar) throws NotFoundException {
        return this.f53123a.c(i10, aVar);
    }

    public int d() {
        return this.f53123a.d();
    }

    public int e() {
        return this.f53123a.f();
    }

    public boolean f() {
        return this.f53123a.e().g();
    }

    public boolean g() {
        return this.f53123a.e().h();
    }

    public b h() {
        return new b(this.f53123a.a(this.f53123a.e().i()));
    }

    public b i() {
        return new b(this.f53123a.a(this.f53123a.e().j()));
    }

    public String toString() {
        try {
            return b().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
