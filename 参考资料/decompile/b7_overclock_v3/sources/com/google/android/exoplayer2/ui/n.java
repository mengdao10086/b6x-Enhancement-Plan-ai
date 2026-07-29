package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import cd.j0;
import com.google.android.exoplayer2.ui.SubtitleView;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f19000h = 1.2f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f19001i = "default_bg";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.ui.a f19002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f19003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<qc.b> f19004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qc.a f19005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f19006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f19008g;

    public class a extends WebView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19010a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f19010a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19010a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19010a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(Context context) {
        this(context, null);
    }

    public static int b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@p0 Layout.Alignment alignment) {
        if (alignment == null) {
            return xc.d.f55081l0;
        }
        int i10 = b.f19010a[alignment.ordinal()];
        return i10 != 1 ? i10 != 2 ? xc.d.f55081l0 : "end" : xc.d.f55084n0;
    }

    public static String d(qc.a aVar) {
        int i10 = aVar.f47219d;
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "unset" : u0.I("-0.05em -0.05em 0.15em %s", cd.f.b(aVar.f47220e)) : u0.I("0.06em 0.08em 0.15em %s", cd.f.b(aVar.f47220e)) : u0.I("0.1em 0.12em 0.15em %s", cd.f.b(aVar.f47220e)) : u0.I("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", cd.f.b(aVar.f47220e));
    }

    public static String f(int i10) {
        return i10 != 1 ? i10 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public static String h(qc.b bVar) {
        float f10 = bVar.f47247p;
        if (f10 == 0.0f) {
            return "";
        }
        int i10 = bVar.f47246o;
        return u0.I("%s(%.2fdeg)", (i10 == 2 || i10 == 1) ? "skewY" : "skewX", Float.valueOf(f10));
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<qc.b> list, qc.a aVar, float f10, int i10, float f11) {
        this.f19005d = aVar;
        this.f19006e = f10;
        this.f19007f = i10;
        this.f19008g = f11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            qc.b bVar = list.get(i11);
            if (bVar.f47234c != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f19004c.isEmpty() || !arrayList2.isEmpty()) {
            this.f19004c = arrayList2;
            i();
        }
        this.f19002a.a(arrayList, aVar, f10, i10, f11);
        invalidate();
    }

    public final String e(int i10, float f10) {
        float fA = j0.a(i10, f10, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fA == -3.4028235E38f ? "unset" : u0.I("%.2fpx", Float.valueOf(fA / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.f19003b.destroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.n.i():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || this.f19004c.isEmpty()) {
            return;
        }
        i();
    }

    public n(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19004c = Collections.emptyList();
        this.f19005d = qc.a.f47215m;
        this.f19006e = 0.0533f;
        this.f19007f = 0;
        this.f19008g = 0.08f;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f19002a = aVar;
        a aVar2 = new a(context, attributeSet);
        this.f19003b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }
}
