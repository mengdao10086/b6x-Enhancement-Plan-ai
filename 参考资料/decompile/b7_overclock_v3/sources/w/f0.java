package w;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f53449g = "VelocityMatrix";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f53450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f53451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f53452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f53453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f53454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f53455f;

    public void a(float f10, float f11, int i10, int i11, float[] fArr) {
        float f12 = fArr[0];
        float f13 = fArr[1];
        float f14 = (f10 - 0.5f) * 2.0f;
        float f15 = (f11 - 0.5f) * 2.0f;
        float f16 = f12 + this.f53452c;
        float f17 = f13 + this.f53453d;
        float f18 = f16 + (this.f53450a * f14);
        float f19 = f17 + (this.f53451b * f15);
        float radians = (float) Math.toRadians(this.f53455f);
        float radians2 = (float) Math.toRadians(this.f53454e);
        double d10 = radians;
        double d11 = i11 * f15;
        float fSin = f18 + (((float) ((((double) ((-i10) * f14)) * Math.sin(d10)) - (Math.cos(d10) * d11))) * radians2);
        float fCos = f19 + (radians2 * ((float) ((((double) (i10 * f14)) * Math.cos(d10)) - (d11 * Math.sin(d10)))));
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void b() {
        this.f53454e = 0.0f;
        this.f53453d = 0.0f;
        this.f53452c = 0.0f;
        this.f53451b = 0.0f;
        this.f53450a = 0.0f;
    }

    public void c(h hVar, float f10) {
        if (hVar != null) {
            this.f53454e = hVar.c(f10);
        }
    }

    public void d(o oVar, float f10) {
        if (oVar != null) {
            this.f53454e = oVar.c(f10);
            this.f53455f = oVar.a(f10);
        }
    }

    public void e(h hVar, h hVar2, float f10) {
        if (hVar != null) {
            this.f53450a = hVar.c(f10);
        }
        if (hVar2 != null) {
            this.f53451b = hVar2.c(f10);
        }
    }

    public void f(o oVar, o oVar2, float f10) {
        if (oVar != null) {
            this.f53450a = oVar.c(f10);
        }
        if (oVar2 != null) {
            this.f53451b = oVar2.c(f10);
        }
    }

    public void g(h hVar, h hVar2, float f10) {
        if (hVar != null) {
            this.f53452c = hVar.c(f10);
        }
        if (hVar2 != null) {
            this.f53453d = hVar2.c(f10);
        }
    }

    public void h(o oVar, o oVar2, float f10) {
        if (oVar != null) {
            this.f53452c = oVar.c(f10);
        }
        if (oVar2 != null) {
            this.f53453d = oVar2.c(f10);
        }
    }
}
