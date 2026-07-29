package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f2185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f2186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f2187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f2188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f2189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f2190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f2191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f2192h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@g.n0 Context context) {
        this(context, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void b(int i10, int i11, int i12, int i13) {
        this.f2191g.set(i10, i11, i12, i13);
        if (androidx.core.view.u0.U0(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2189e == null) {
            this.f2189e = new TypedValue();
        }
        return this.f2189e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2190f == null) {
            this.f2190f = new TypedValue();
        }
        return this.f2190f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2187c == null) {
            this.f2187c = new TypedValue();
        }
        return this.f2187c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2188d == null) {
            this.f2188d = new TypedValue();
        }
        return this.f2188d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2185a == null) {
            this.f2185a = new TypedValue();
        }
        return this.f2185a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2186b == null) {
            this.f2186b = new TypedValue();
        }
        return this.f2186b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f2192h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f2192h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f2192h = aVar;
    }

    public ContentFrameLayout(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2191g = new Rect();
    }
}
