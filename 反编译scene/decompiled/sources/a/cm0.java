package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f5808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Double[] f430a = new Double[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer[] f431a = new Integer[0];
    public int b;

    public final Integer[] a() {
        return this.f431a;
    }

    public final Double[] b() {
        return this.f430a;
    }

    public final double c() {
        return this.f5808a;
    }

    public final int d() {
        return this.f429a;
    }

    public final int e() {
        return this.b;
    }

    public final void f(Integer[] numArr) {
        f92.d(numArr, "<set-?>");
        this.f431a = numArr;
    }

    public final void g(Double[] dArr) {
        f92.d(dArr, "<set-?>");
        this.f430a = dArr;
    }

    public final void h(double d) {
        this.f5808a = d;
    }

    public final void i(int i) {
        this.f429a = i;
    }

    public final void j(int i) {
        this.b = i;
    }
}
