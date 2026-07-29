package ka;

import android.graphics.Typeface;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f37107a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f37108b = 5.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f37109c = 5.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Typeface f37110d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f37111e = k.e(10.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37112f = -16777216;

    public int a() {
        return this.f37112f;
    }

    public float b() {
        return this.f37111e;
    }

    public Typeface c() {
        return this.f37110d;
    }

    public float d() {
        return this.f37108b;
    }

    public float e() {
        return this.f37109c;
    }

    public boolean f() {
        return this.f37107a;
    }

    public void g(boolean z10) {
        this.f37107a = z10;
    }

    public void h(int i10) {
        this.f37112f = i10;
    }

    public void i(float f10) {
        if (f10 > 24.0f) {
            f10 = 24.0f;
        }
        if (f10 < 6.0f) {
            f10 = 6.0f;
        }
        this.f37111e = k.e(f10);
    }

    public void j(Typeface typeface) {
        this.f37110d = typeface;
    }

    public void k(float f10) {
        this.f37108b = k.e(f10);
    }

    public void l(float f10) {
        this.f37109c = k.e(f10);
    }
}
