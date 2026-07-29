package com.google.android.flexbox;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
interface FlexItem extends Parcelable {

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f19317t1 = 1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final float f19318u1 = 0.0f;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final float f19319w1 = 1.0f;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final float f19320x1 = 0.0f;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final float f19321y1 = -1.0f;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final int f19322z1 = 16777215;

    float A();

    float E();

    int I();

    int K();

    boolean L();

    int N();

    void Q(int alignSelf);

    int R();

    void c(float flexGrow);

    void f(float flexBasisPercent);

    int getHeight();

    int getMarginEnd();

    int getMarginStart();

    int getOrder();

    int getWidth();

    void k(int order);

    int l();

    float m();

    void o(boolean wrapBefore);

    int p();

    void q(float flexShrink);

    void r(int minWidth);

    void setHeight(int height);

    void setMaxHeight(int maxHeight);

    void setMaxWidth(int maxWidth);

    void setWidth(int width);

    int t();

    int u();

    int x();

    void y(int minHeight);
}
