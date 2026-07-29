package oa;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f43025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f43026b;

    public j(float f10, float f11) {
        this.f43025a = f10;
        this.f43026b = f11;
    }

    public boolean a(float f10) {
        return f10 > this.f43025a && f10 <= this.f43026b;
    }

    public boolean b(float f10) {
        return f10 > this.f43026b;
    }

    public boolean c(float f10) {
        return f10 < this.f43025a;
    }
}
