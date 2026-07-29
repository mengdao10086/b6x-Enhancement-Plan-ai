package dl;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseBooleanArray f26294a = new SparseBooleanArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SparseArray<Float> f26295b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f26299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f26301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f26302i;

    public interface a {
        void a(int i10, int i11);

        void b(int i10, int i11, float f10, boolean z10);

        void c(int i10, int i11);

        void d(int i10, int i11, float f10, boolean z10);
    }

    public final void a(int i10) {
        a aVar = this.f26302i;
        if (aVar != null) {
            aVar.a(i10, this.f26296c);
        }
        this.f26294a.put(i10, true);
    }

    public final void b(int i10, float f10, boolean z10, boolean z11) {
        if (this.f26301h || i10 == this.f26297d || this.f26300g == 1 || z11) {
            a aVar = this.f26302i;
            if (aVar != null) {
                aVar.b(i10, this.f26296c, f10, z10);
            }
            this.f26295b.put(i10, Float.valueOf(1.0f - f10));
        }
    }

    public final void c(int i10, float f10, boolean z10, boolean z11) {
        if (!this.f26301h && i10 != this.f26298e && this.f26300g != 1) {
            int i11 = this.f26297d;
            if (((i10 != i11 - 1 && i10 != i11 + 1) || this.f26295b.get(i10, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z11) {
                return;
            }
        }
        a aVar = this.f26302i;
        if (aVar != null) {
            aVar.d(i10, this.f26296c, f10, z10);
        }
        this.f26295b.put(i10, Float.valueOf(f10));
    }

    public final void d(int i10) {
        a aVar = this.f26302i;
        if (aVar != null) {
            aVar.c(i10, this.f26296c);
        }
        this.f26294a.put(i10, false);
    }

    public int e() {
        return this.f26297d;
    }

    public int f() {
        return this.f26300g;
    }

    public int g() {
        return this.f26296c;
    }

    public void h(int i10) {
        this.f26300g = i10;
    }

    public void i(int i10, float f10, int i11) {
        boolean z10;
        float f11 = i10 + f10;
        float f12 = this.f26299f;
        boolean z11 = f12 <= f11;
        if (this.f26300g == 0) {
            for (int i12 = 0; i12 < this.f26296c; i12++) {
                if (i12 != this.f26297d) {
                    if (!this.f26294a.get(i12)) {
                        a(i12);
                    }
                    if (this.f26295b.get(i12, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i12, 1.0f, false, true);
                    }
                }
            }
            b(this.f26297d, 1.0f, false, true);
            d(this.f26297d);
        } else {
            if (f11 == f12) {
                return;
            }
            int i13 = i10 + 1;
            if (f10 == 0.0f && z11) {
                i13 = i10 - 1;
                z10 = false;
            } else {
                z10 = true;
            }
            for (int i14 = 0; i14 < this.f26296c; i14++) {
                if (i14 != i10 && i14 != i13 && this.f26295b.get(i14, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    c(i14, 1.0f, z11, true);
                }
            }
            if (!z10) {
                float f13 = 1.0f - f10;
                c(i13, f13, true, false);
                b(i10, f13, true, false);
            } else if (z11) {
                c(i10, f10, true, false);
                b(i13, f10, true, false);
            } else {
                float f14 = 1.0f - f10;
                c(i13, f14, false, false);
                b(i10, f14, false, false);
            }
        }
        this.f26299f = f11;
    }

    public void j(int i10) {
        this.f26298e = this.f26297d;
        this.f26297d = i10;
        d(i10);
        for (int i11 = 0; i11 < this.f26296c; i11++) {
            if (i11 != this.f26297d && !this.f26294a.get(i11)) {
                a(i11);
            }
        }
    }

    public void k(a aVar) {
        this.f26302i = aVar;
    }

    public void l(boolean z10) {
        this.f26301h = z10;
    }

    public void m(int i10) {
        this.f26296c = i10;
        this.f26294a.clear();
        this.f26295b.clear();
    }
}
