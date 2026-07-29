package g1;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import g1.b;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends b<g> {
    public static final float J = Float.MAX_VALUE;
    public h G;
    public float H;
    public boolean I;

    public g(e eVar) {
        super(eVar);
        this.G = null;
        this.H = Float.MAX_VALUE;
        this.I = false;
    }

    public boolean A() {
        return this.G.f28926b > 0.0d;
    }

    public h B() {
        return this.G;
    }

    public final void C() {
        h hVar = this.G;
        if (hVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d10 = hVar.d();
        if (d10 > this.f28897g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d10 < this.f28898h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public g D(h hVar) {
        this.G = hVar;
        return this;
    }

    public void E() {
        if (!A()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f28896f) {
            this.I = true;
        }
    }

    @Override // g1.b
    public float f(float f10, float f11) {
        return this.G.b(f10, f11);
    }

    @Override // g1.b
    public boolean j(float f10, float f11) {
        return this.G.a(f10, f11);
    }

    @Override // g1.b
    public void v(float f10) {
    }

    @Override // g1.b
    public void w() {
        C();
        this.G.j(i());
        super.w();
    }

    @Override // g1.b
    public boolean y(long j10) {
        if (this.I) {
            float f10 = this.H;
            if (f10 != Float.MAX_VALUE) {
                this.G.h(f10);
                this.H = Float.MAX_VALUE;
            }
            this.f28892b = this.G.d();
            this.f28891a = 0.0f;
            this.I = false;
            return true;
        }
        if (this.H != Float.MAX_VALUE) {
            this.G.d();
            long j11 = j10 / 2;
            b.p pVarK = this.G.k(this.f28892b, this.f28891a, j11);
            this.G.h(this.H);
            this.H = Float.MAX_VALUE;
            b.p pVarK2 = this.G.k(pVarK.f28905a, pVarK.f28906b, j11);
            this.f28892b = pVarK2.f28905a;
            this.f28891a = pVarK2.f28906b;
        } else {
            b.p pVarK3 = this.G.k(this.f28892b, this.f28891a, j10);
            this.f28892b = pVarK3.f28905a;
            this.f28891a = pVarK3.f28906b;
        }
        float fMax = Math.max(this.f28892b, this.f28898h);
        this.f28892b = fMax;
        float fMin = Math.min(fMax, this.f28897g);
        this.f28892b = fMin;
        if (!j(fMin, this.f28891a)) {
            return false;
        }
        this.f28892b = this.G.d();
        this.f28891a = 0.0f;
        return true;
    }

    public void z(float f10) {
        if (k()) {
            this.H = f10;
            return;
        }
        if (this.G == null) {
            this.G = new h(f10);
        }
        this.G.h(f10);
        w();
    }

    public <K> g(K k10, d<K> dVar) {
        super(k10, dVar);
        this.G = null;
        this.H = Float.MAX_VALUE;
        this.I = false;
    }

    public <K> g(K k10, d<K> dVar, float f10) {
        super(k10, dVar);
        this.G = null;
        this.H = Float.MAX_VALUE;
        this.I = false;
        this.G = new h(f10);
    }
}
