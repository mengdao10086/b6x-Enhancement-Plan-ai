package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void b(MotionEvent motionEvent, float f10, float f11);

    void c(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11);

    void d(MotionEvent motionEvent);

    void e(MotionEvent motionEvent);

    void f(MotionEvent motionEvent);

    void g(MotionEvent motionEvent, float f10, float f11);

    void h(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);
}
