package a;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f8110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3910a;

    @Deprecated
    public float b;

    @Deprecated
    public float c;

    @Deprecated
    public float d;

    @Deprecated
    public float e;

    @Deprecated
    public float f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<xz> f3909a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<yz> f3911b = new ArrayList();

    public zz() {
        n(0.0f, 0.0f);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        vz vzVar = new vz(f, f2, f3, f4);
        vzVar.s(f5);
        vzVar.t(f6);
        this.f3909a.add(vzVar);
        tz tzVar = new tz(vzVar);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        c(tzVar, f5, z ? (180.0f + f7) % 360.0f : f7);
        double d = f7;
        r(((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))));
        s(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))));
    }

    public final void b(float f) {
        if (g() == f) {
            return;
        }
        float fG = ((f - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        vz vzVar = new vz(i(), j(), i(), j());
        vzVar.s(g());
        vzVar.t(fG);
        this.f3911b.add(new tz(vzVar));
        p(f);
    }

    public final void c(yz yzVar, float f, float f2) {
        b(f);
        this.f3911b.add(yzVar);
        p(f2);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f3909a.size();
        for (int i = 0; i < size; i++) {
            this.f3909a.get(i).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f3910a;
    }

    public yz f(Matrix matrix) {
        b(h());
        return new sz(this, new ArrayList(this.f3911b), matrix);
    }

    public final float g() {
        return this.e;
    }

    public final float h() {
        return this.f;
    }

    public float i() {
        return this.c;
    }

    public float j() {
        return this.d;
    }

    public float k() {
        return this.f8110a;
    }

    public float l() {
        return this.b;
    }

    public void m(float f, float f2) {
        wz wzVar = new wz();
        wzVar.f7836a = f;
        wzVar.b = f2;
        this.f3909a.add(wzVar);
        uz uzVar = new uz(wzVar, i(), j());
        c(uzVar, uzVar.c() + 270.0f, uzVar.c() + 270.0f);
        r(f);
        s(f2);
    }

    public void n(float f, float f2) {
        o(f, f2, 270.0f, 0.0f);
    }

    public void o(float f, float f2, float f3, float f4) {
        t(f);
        u(f2);
        r(f);
        s(f2);
        p(f3);
        q((f3 + f4) % 360.0f);
        this.f3909a.clear();
        this.f3911b.clear();
        this.f3910a = false;
    }

    public final void p(float f) {
        this.e = f;
    }

    public final void q(float f) {
        this.f = f;
    }

    public final void r(float f) {
        this.c = f;
    }

    public final void s(float f) {
        this.d = f;
    }

    public final void t(float f) {
        this.f8110a = f;
    }

    public final void u(float f) {
        this.b = f;
    }
}
