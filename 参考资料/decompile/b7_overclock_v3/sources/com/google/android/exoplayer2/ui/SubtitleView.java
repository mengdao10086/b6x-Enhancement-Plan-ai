package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import g.p0;
import g.r;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qc.b;

/* JADX INFO: loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements qc.k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f18657k = 0.0533f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f18658l = 0.08f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f18659m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f18660n = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<qc.b> f18661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qc.a f18662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f18664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f18665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f18669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f18670j;

    public interface a {
        void a(List<qc.b> list, qc.a aVar, float f10, int i10, float f11);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private List<qc.b> getCuesWithStylingPreferencesApplied() {
        if (this.f18666f && this.f18667g) {
            return this.f18661a;
        }
        ArrayList arrayList = new ArrayList(this.f18661a.size());
        for (int i10 = 0; i10 < this.f18661a.size(); i10++) {
            arrayList.add(a(this.f18661a.get(i10)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (u0.f31154a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private qc.a getUserCaptionStyle() {
        if (u0.f31154a < 19 || isInEditMode()) {
            return qc.a.f47215m;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? qc.a.f47215m : qc.a.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t10) {
        removeView(this.f18670j);
        View view = this.f18670j;
        if (view instanceof n) {
            ((n) view).g();
        }
        this.f18670j = t10;
        this.f18669i = t10;
        addView(t10);
    }

    @Override // qc.k
    public void I(List<qc.b> list) {
        setCues(list);
    }

    public final qc.b a(qc.b bVar) {
        CharSequence charSequence = bVar.f47232a;
        if (!this.f18666f) {
            b.c cVarB = bVar.a().B(-3.4028235E38f, Integer.MIN_VALUE).b();
            if (charSequence != null) {
                cVarB.z(charSequence.toString());
            }
            return cVarB.a();
        }
        if (this.f18667g || charSequence == null) {
            return bVar;
        }
        b.c cVarB2 = bVar.a().B(-3.4028235E38f, Integer.MIN_VALUE);
        if (charSequence instanceof Spanned) {
            SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
            for (AbsoluteSizeSpan absoluteSizeSpan : (AbsoluteSizeSpan[]) spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), AbsoluteSizeSpan.class)) {
                spannableStringValueOf.removeSpan(absoluteSizeSpan);
            }
            for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), RelativeSizeSpan.class)) {
                spannableStringValueOf.removeSpan(relativeSizeSpan);
            }
            cVarB2.z(spannableStringValueOf);
        }
        return cVarB2.a();
    }

    public void b(@r int i10, float f10) {
        Context context = getContext();
        d(2, TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void c(float f10, boolean z10) {
        d(z10 ? 1 : 0, f10);
    }

    public final void d(int i10, float f10) {
        this.f18663c = i10;
        this.f18664d = f10;
        g();
    }

    public void e() {
        setStyle(getUserCaptionStyle());
    }

    public void f() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void g() {
        this.f18669i.a(getCuesWithStylingPreferencesApplied(), this.f18662b, this.f18664d, this.f18663c, this.f18665e);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f18667g = z10;
        g();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f18666f = z10;
        g();
    }

    public void setBottomPaddingFraction(float f10) {
        this.f18665e = f10;
        g();
    }

    public void setCues(@p0 List<qc.b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f18661a = list;
        g();
    }

    public void setFractionalTextSize(float f10) {
        c(f10, false);
    }

    public void setStyle(qc.a aVar) {
        this.f18662b = aVar;
        g();
    }

    public void setViewType(int i10) {
        if (this.f18668h == i10) {
            return;
        }
        if (i10 == 1) {
            setView(new com.google.android.exoplayer2.ui.a(getContext()));
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new n(getContext()));
        }
        this.f18668h = i10;
    }

    public SubtitleView(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18661a = Collections.emptyList();
        this.f18662b = qc.a.f47215m;
        this.f18663c = 0;
        this.f18664d = 0.0533f;
        this.f18665e = 0.08f;
        this.f18666f = true;
        this.f18667g = true;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f18669i = aVar;
        this.f18670j = aVar;
        addView(aVar);
        this.f18668h = 1;
    }
}
