package qc;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import g.p0;
import g.v0;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f47209g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f47210h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f47211i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47212j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f47213k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47214l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f47215m = new a(-1, -16777216, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f47219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f47220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final Typeface f47221f;

    /* JADX INFO: renamed from: qc.a$a, reason: collision with other inner class name */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0542a {
    }

    public a(int i10, int i11, int i12, int i13, int i14, @p0 Typeface typeface) {
        this.f47216a = i10;
        this.f47217b = i11;
        this.f47218c = i12;
        this.f47219d = i13;
        this.f47220e = i14;
        this.f47221f = typeface;
    }

    @v0(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return u0.f31154a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @v0(19)
    public static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @v0(21)
    public static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f47215m.f47216a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f47215m.f47217b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f47215m.f47218c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f47215m.f47219d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f47215m.f47220e, captionStyle.getTypeface());
    }
}
