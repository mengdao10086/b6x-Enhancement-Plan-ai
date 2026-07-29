package oa;

import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f43013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f43014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f43015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f43016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f43017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f43018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f43019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public YAxis.AxisDependency f43020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f43021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f43022j;

    public d(float f10, float f11, int i10) {
        this.f43017e = -1;
        this.f43019g = -1;
        this.f43013a = f10;
        this.f43014b = f11;
        this.f43018f = i10;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f43018f == dVar.f43018f && this.f43013a == dVar.f43013a && this.f43019g == dVar.f43019g && this.f43017e == dVar.f43017e;
    }

    public YAxis.AxisDependency b() {
        return this.f43020h;
    }

    public int c() {
        return this.f43017e;
    }

    public int d() {
        return this.f43018f;
    }

    public float e() {
        return this.f43021i;
    }

    public float f() {
        return this.f43022j;
    }

    public int g() {
        return this.f43019g;
    }

    public float h() {
        return this.f43013a;
    }

    public float i() {
        return this.f43015c;
    }

    public float j() {
        return this.f43014b;
    }

    public float k() {
        return this.f43016d;
    }

    public boolean l() {
        return this.f43019g >= 0;
    }

    public void m(int i10) {
        this.f43017e = i10;
    }

    public void n(float f10, float f11) {
        this.f43021i = f10;
        this.f43022j = f11;
    }

    public String toString() {
        return "Highlight, x: " + this.f43013a + ", y: " + this.f43014b + ", dataSetIndex: " + this.f43018f + ", stackIndex (only stacked barentry): " + this.f43019g;
    }

    public d(float f10, int i10, int i11) {
        this(f10, Float.NaN, i10);
        this.f43019g = i11;
    }

    public d(float f10, float f11, float f12, float f13, int i10, YAxis.AxisDependency axisDependency) {
        this.f43017e = -1;
        this.f43019g = -1;
        this.f43013a = f10;
        this.f43014b = f11;
        this.f43015c = f12;
        this.f43016d = f13;
        this.f43018f = i10;
        this.f43020h = axisDependency;
    }

    public d(float f10, float f11, float f12, float f13, int i10, int i11, YAxis.AxisDependency axisDependency) {
        this(f10, f11, f12, f13, i10, axisDependency);
        this.f43019g = i11;
    }
}
