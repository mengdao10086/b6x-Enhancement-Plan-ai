package ra;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.components.YAxis;
import xa.h;
import xa.i;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public class c extends b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static h<c> f47889t = h.a(8, new c(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f47890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f47891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f47892o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f47893p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public YAxis f47894q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f47895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Matrix f47896s;

    @SuppressLint({"NewApi"})
    public c(l lVar, View view, i iVar, YAxis yAxis, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, long j10) {
        super(lVar, f11, f12, iVar, view, f13, f14, j10);
        this.f47896s = new Matrix();
        this.f47892o = f15;
        this.f47893p = f16;
        this.f47890m = f17;
        this.f47891n = f18;
        this.f47885i.addListener(this);
        this.f47894q = yAxis;
        this.f47895r = f10;
    }

    public static c j(l lVar, View view, i iVar, YAxis yAxis, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, long j10) {
        c cVar = (c) f47889t.b();
        cVar.f47899d = lVar;
        cVar.f47900e = f11;
        cVar.f47901f = f12;
        cVar.f47902g = iVar;
        cVar.f47903h = view;
        cVar.f47887k = f13;
        cVar.f47888l = f14;
        cVar.f47894q = yAxis;
        cVar.f47895r = f10;
        cVar.h();
        cVar.f47885i.setDuration(j10);
        return cVar;
    }

    @Override // xa.h.a
    public h.a a() {
        return new c(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // ra.b
    public void g() {
    }

    @Override // ra.b, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // ra.b, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((ja.b) this.f47903h).p();
        this.f47903h.postInvalidate();
    }

    @Override // ra.b, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // ra.b, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // ra.b, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f10 = this.f47887k;
        float f11 = this.f47900e - f10;
        float f12 = this.f47886j;
        float f13 = f10 + (f11 * f12);
        float f14 = this.f47888l;
        float f15 = f14 + ((this.f47901f - f14) * f12);
        Matrix matrix = this.f47896s;
        this.f47899d.g0(f13, f15, matrix);
        this.f47899d.S(matrix, this.f47903h, false);
        float fX = this.f47894q.I / this.f47899d.x();
        float fW = this.f47895r / this.f47899d.w();
        float[] fArr = this.f47898c;
        float f16 = this.f47890m;
        float f17 = (this.f47892o - (fW / 2.0f)) - f16;
        float f18 = this.f47886j;
        fArr[0] = f16 + (f17 * f18);
        float f19 = this.f47891n;
        fArr[1] = f19 + (((this.f47893p + (fX / 2.0f)) - f19) * f18);
        this.f47902g.o(fArr);
        this.f47899d.i0(this.f47898c, matrix);
        this.f47899d.S(matrix, this.f47903h, true);
    }
}
