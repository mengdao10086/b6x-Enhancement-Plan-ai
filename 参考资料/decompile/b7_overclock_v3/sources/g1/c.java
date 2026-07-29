package g1;

import g.x;
import g1.b;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b<c> {
    public final a G;

    public static final class a implements f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final float f28907d = -4.2f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final float f28908e = 62.5f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f28910b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f28909a = -4.2f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b.p f28911c = new b.p();

        @Override // g1.f
        public boolean a(float f10, float f11) {
            return Math.abs(f11) < this.f28910b;
        }

        @Override // g1.f
        public float b(float f10, float f11) {
            return f11 * this.f28909a;
        }

        public float c() {
            return this.f28909a / (-4.2f);
        }

        public void d(float f10) {
            this.f28909a = f10 * (-4.2f);
        }

        public void e(float f10) {
            this.f28910b = f10 * 62.5f;
        }

        public b.p f(float f10, float f11, long j10) {
            float f12 = j10;
            this.f28911c.f28906b = (float) (((double) f11) * Math.exp((f12 / 1000.0f) * this.f28909a));
            b.p pVar = this.f28911c;
            float f13 = this.f28909a;
            pVar.f28905a = (float) (((double) (f10 - (f11 / f13))) + (((double) (f11 / f13)) * Math.exp((f13 * f12) / 1000.0f)));
            b.p pVar2 = this.f28911c;
            if (a(pVar2.f28905a, pVar2.f28906b)) {
                this.f28911c.f28906b = 0.0f;
            }
            return this.f28911c;
        }
    }

    public c(e eVar) {
        super(eVar);
        a aVar = new a();
        this.G = aVar;
        aVar.e(i());
    }

    public c A(@x(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.G.d(f10);
        return this;
    }

    @Override // g1.b
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c p(float f10) {
        super.p(f10);
        return this;
    }

    @Override // g1.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c q(float f10) {
        super.q(f10);
        return this;
    }

    @Override // g1.b
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c u(float f10) {
        super.u(f10);
        return this;
    }

    @Override // g1.b
    public float f(float f10, float f11) {
        return this.G.b(f10, f11);
    }

    @Override // g1.b
    public boolean j(float f10, float f11) {
        return f10 >= this.f28897g || f10 <= this.f28898h || this.G.a(f10, f11);
    }

    @Override // g1.b
    public void v(float f10) {
        this.G.e(f10);
    }

    @Override // g1.b
    public boolean y(long j10) {
        b.p pVarF = this.G.f(this.f28892b, this.f28891a, j10);
        float f10 = pVarF.f28905a;
        this.f28892b = f10;
        float f11 = pVarF.f28906b;
        this.f28891a = f11;
        float f12 = this.f28898h;
        if (f10 < f12) {
            this.f28892b = f12;
            return true;
        }
        float f13 = this.f28897g;
        if (f10 <= f13) {
            return j(f10, f11);
        }
        this.f28892b = f13;
        return true;
    }

    public float z() {
        return this.G.c();
    }

    public <K> c(K k10, d<K> dVar) {
        super(k10, dVar);
        a aVar = new a();
        this.G = aVar;
        aVar.e(i());
    }
}
