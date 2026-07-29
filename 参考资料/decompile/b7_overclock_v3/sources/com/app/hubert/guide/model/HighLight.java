package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface HighLight {

    public enum Shape {
        CIRCLE,
        RECTANGLE,
        OVAL,
        ROUND_RECTANGLE
    }

    float b();

    RectF c(View view);

    @p0
    b d();

    Shape e();

    int f();
}
