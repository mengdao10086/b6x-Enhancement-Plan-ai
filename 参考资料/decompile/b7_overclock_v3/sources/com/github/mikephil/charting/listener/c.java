package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.listener.ChartTouchListener;
import ja.h;
import java.util.ArrayList;
import xa.g;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class c extends ChartTouchListener<h<?>> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f16669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f16670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<a> f16671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f16672p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16673q;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f16674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16675b;

        public a(long j10, float f10) {
            this.f16674a = j10;
            this.f16675b = f10;
        }
    }

    public c(h<?> hVar) {
        super(hVar);
        this.f16669m = g.c(0.0f, 0.0f);
        this.f16670n = 0.0f;
        this.f16671o = new ArrayList<>();
        this.f16672p = 0L;
        this.f16673q = 0.0f;
    }

    public final float h() {
        if (this.f16671o.isEmpty()) {
            return 0.0f;
        }
        a aVar = this.f16671o.get(0);
        ArrayList<a> arrayList = this.f16671o;
        a aVar2 = arrayList.get(arrayList.size() - 1);
        a aVar3 = aVar;
        for (int size = this.f16671o.size() - 1; size >= 0; size--) {
            aVar3 = this.f16671o.get(size);
            if (aVar3.f16675b != aVar2.f16675b) {
                break;
            }
        }
        float f10 = (aVar2.f16674a - aVar.f16674a) / 1000.0f;
        if (f10 == 0.0f) {
            f10 = 0.1f;
        }
        boolean z10 = aVar2.f16675b >= aVar3.f16675b;
        if (Math.abs(r1 - r6) > 270.0d) {
            z10 = !z10;
        }
        float f11 = aVar2.f16675b;
        float f12 = aVar.f16675b;
        if (f11 - f12 > 180.0d) {
            aVar.f16675b = (float) (((double) f12) + 360.0d);
        } else if (f12 - f11 > 180.0d) {
            aVar2.f16675b = (float) (((double) f11) + 360.0d);
        }
        float fAbs = Math.abs((aVar2.f16675b - aVar.f16675b) / f10);
        return !z10 ? -fAbs : fAbs;
    }

    public void i() {
        if (this.f16673q == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f16673q *= ((h) this.f16654e).getDragDecelerationFrictionCoef();
        T t10 = this.f16654e;
        ((h) t10).setRotationAngle(((h) t10).getRotationAngle() + (this.f16673q * ((jCurrentAnimationTimeMillis - this.f16672p) / 1000.0f)));
        this.f16672p = jCurrentAnimationTimeMillis;
        if (Math.abs(this.f16673q) >= 0.001d) {
            k.K(this.f16654e);
        } else {
            m();
        }
    }

    public final void j() {
        this.f16671o.clear();
    }

    public final void k(float f10, float f11) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f16671o.add(new a(jCurrentAnimationTimeMillis, ((h) this.f16654e).a0(f10, f11)));
        for (int size = this.f16671o.size(); size - 2 > 0 && jCurrentAnimationTimeMillis - this.f16671o.get(0).f16674a > 1000; size--) {
            this.f16671o.remove(0);
        }
    }

    public void l(float f10, float f11) {
        this.f16670n = ((h) this.f16654e).a0(f10, f11) - ((h) this.f16654e).getRawRotationAngle();
    }

    public void m() {
        this.f16673q = 0.0f;
    }

    public void n(float f10, float f11) {
        T t10 = this.f16654e;
        ((h) t10).setRotationAngle(((h) t10).a0(f10, f11) - this.f16670n);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f16650a = ChartTouchListener.ChartGesture.LONG_PRESS;
        b onChartGestureListener = ((h) this.f16654e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.e(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f16650a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        b onChartGestureListener = ((h) this.f16654e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.d(motionEvent);
        }
        if (!((h) this.f16654e).M()) {
            return false;
        }
        e(((h) this.f16654e).x(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            android.view.GestureDetector r6 = r5.f16653d
            boolean r6 = r6.onTouchEvent(r7)
            r0 = 1
            if (r6 == 0) goto La
            return r0
        La:
            T extends ja.e<?> r6 = r5.f16654e
            ja.h r6 = (ja.h) r6
            boolean r6 = r6.e0()
            if (r6 == 0) goto Lc2
            float r6 = r7.getX()
            float r1 = r7.getY()
            int r2 = r7.getAction()
            if (r2 == 0) goto La3
            if (r2 == r0) goto L6f
            r3 = 2
            if (r2 == r3) goto L29
            goto Lc2
        L29:
            T extends ja.e<?> r2 = r5.f16654e
            ja.h r2 = (ja.h) r2
            boolean r2 = r2.I()
            if (r2 == 0) goto L36
            r5.k(r6, r1)
        L36:
            int r2 = r5.f16651b
            r3 = 6
            if (r2 != 0) goto L5d
            xa.g r2 = r5.f16669m
            float r4 = r2.f54987c
            float r2 = r2.f54988d
            float r2 = com.github.mikephil.charting.listener.ChartTouchListener.a(r6, r4, r1, r2)
            r4 = 1090519040(0x41000000, float:8.0)
            float r4 = xa.k.e(r4)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L5d
            com.github.mikephil.charting.listener.ChartTouchListener$ChartGesture r6 = com.github.mikephil.charting.listener.ChartTouchListener.ChartGesture.ROTATE
            r5.f16650a = r6
            r5.f16651b = r3
            T extends ja.e<?> r6 = r5.f16654e
            ja.h r6 = (ja.h) r6
            r6.t()
            goto L6b
        L5d:
            int r2 = r5.f16651b
            if (r2 != r3) goto L6b
            r5.n(r6, r1)
            T extends ja.e<?> r6 = r5.f16654e
            ja.h r6 = (ja.h) r6
            r6.invalidate()
        L6b:
            r5.b(r7)
            goto Lc2
        L6f:
            T extends ja.e<?> r2 = r5.f16654e
            ja.h r2 = (ja.h) r2
            boolean r2 = r2.I()
            if (r2 == 0) goto L95
            r5.m()
            r5.k(r6, r1)
            float r6 = r5.h()
            r5.f16673q = r6
            r1 = 0
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 == 0) goto L95
            long r1 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r5.f16672p = r1
            T extends ja.e<?> r6 = r5.f16654e
            xa.k.K(r6)
        L95:
            T extends ja.e<?> r6 = r5.f16654e
            ja.h r6 = (ja.h) r6
            r6.w()
            r6 = 0
            r5.f16651b = r6
            r5.b(r7)
            goto Lc2
        La3:
            r5.g(r7)
            r5.m()
            r5.j()
            T extends ja.e<?> r7 = r5.f16654e
            ja.h r7 = (ja.h) r7
            boolean r7 = r7.I()
            if (r7 == 0) goto Lb9
            r5.k(r6, r1)
        Lb9:
            r5.l(r6, r1)
            xa.g r7 = r5.f16669m
            r7.f54987c = r6
            r7.f54988d = r1
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
