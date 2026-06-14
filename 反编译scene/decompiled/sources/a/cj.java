package a;

import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f405a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f407b;
    public float c;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f406a = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f410c = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f408b = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f409c = 0;
    public int d = 0;

    public void a() {
        if (this.f408b == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float fG = g(e(jCurrentAnimationTimeMillis));
        long j = jCurrentAnimationTimeMillis - this.f408b;
        this.f408b = jCurrentAnimationTimeMillis;
        float f = j * fG;
        this.f409c = (int) (this.f5799a * f);
        this.d = (int) (f * this.b);
    }

    public int b() {
        return this.f409c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        float f = this.f5799a;
        return (int) (f / Math.abs(f));
    }

    public final float e(long j) {
        if (j < this.f406a) {
            return 0.0f;
        }
        long j2 = this.f410c;
        if (j2 < 0 || j < j2) {
            return ej.e((j - this.f406a) / this.f405a, 0.0f, 1.0f) * 0.5f;
        }
        long j3 = j - j2;
        float f = this.c;
        return (1.0f - f) + (f * ej.e(j3 / this.e, 0.0f, 1.0f));
    }

    public int f() {
        float f = this.b;
        return (int) (f / Math.abs(f));
    }

    public final float g(float f) {
        return ((-4.0f) * f * f) + (f * 4.0f);
    }

    public boolean h() {
        return this.f410c > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f410c + ((long) this.e);
    }

    public void i() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.e = ej.f((int) (jCurrentAnimationTimeMillis - this.f406a), 0, this.f407b);
        this.c = e(jCurrentAnimationTimeMillis);
        this.f410c = jCurrentAnimationTimeMillis;
    }

    public void j(int i) {
        this.f407b = i;
    }

    public void k(int i) {
        this.f405a = i;
    }

    public void l(float f, float f2) {
        this.f5799a = f;
        this.b = f2;
    }

    public void m() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f406a = jCurrentAnimationTimeMillis;
        this.f410c = -1L;
        this.f408b = jCurrentAnimationTimeMillis;
        this.c = 0.5f;
        this.f409c = 0;
        this.d = 0;
    }
}
