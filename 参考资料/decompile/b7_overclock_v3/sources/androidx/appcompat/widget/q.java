package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class q extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f2632b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2633a;

    public q(@g.n0 Context context, @g.p0 AttributeSet attributeSet, @g.f int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        y0 y0VarG = y0.G(context, attributeSet, R.styleable.PopupWindow, i10, i11);
        int i12 = R.styleable.PopupWindow_overlapAnchor;
        if (y0VarG.C(i12)) {
            b(y0VarG.a(i12, false));
        }
        setBackgroundDrawable(y0VarG.h(R.styleable.PopupWindow_android_popupBackground));
        y0VarG.I();
    }

    public final void b(boolean z10) {
        if (f2632b) {
            this.f2633a = z10;
        } else {
            androidx.core.widget.p.c(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (f2632b && this.f2633a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f2632b && this.f2633a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    public q(@g.n0 Context context, @g.p0 AttributeSet attributeSet, @g.f int i10, @g.d1 int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f2632b && this.f2633a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
