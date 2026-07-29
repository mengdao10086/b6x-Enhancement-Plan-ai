package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import ja.e;
import oa.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChartTouchListener<T extends e<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16643f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16644g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f16645h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16646i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f16647j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f16648k = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f16649l = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChartGesture f16650a = ChartGesture.NONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16651b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f16652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GestureDetector f16653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f16654e;

    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t10) {
        this.f16654e = t10;
        this.f16653d = new GestureDetector(t10.getContext(), this);
    }

    public static float a(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f11;
        float f15 = f12 - f13;
        return (float) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    public void b(MotionEvent motionEvent) {
        b onChartGestureListener = this.f16654e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.h(motionEvent, this.f16650a);
        }
    }

    public ChartGesture c() {
        return this.f16650a;
    }

    public int d() {
        return this.f16651b;
    }

    public void e(d dVar, MotionEvent motionEvent) {
        if (dVar == null || dVar.a(this.f16652c)) {
            this.f16654e.F(null, true);
            this.f16652c = null;
        } else {
            this.f16654e.F(dVar, true);
            this.f16652c = dVar;
        }
    }

    public void f(d dVar) {
        this.f16652c = dVar;
    }

    public void g(MotionEvent motionEvent) {
        b onChartGestureListener = this.f16654e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f16650a);
        }
    }
}
