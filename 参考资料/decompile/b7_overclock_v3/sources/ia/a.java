package ia;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f31991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f31992c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f31993d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31994e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31995f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31990a = 0;

    public a(int i10) {
        this.f31991b = new float[i10];
    }

    public abstract void a(T t10);

    public void b(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f31994e = i10;
    }

    public void c(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f31995f = i10;
    }

    public void d() {
        this.f31990a = 0;
    }

    public void e(float f10, float f11) {
        this.f31992c = f10;
        this.f31993d = f11;
    }

    public int f() {
        return this.f31991b.length;
    }
}
