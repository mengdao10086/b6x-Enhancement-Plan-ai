package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.g0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FitWindowsLinearLayout extends LinearLayout implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0.a f2194a;

    public FitWindowsLinearLayout(@g.n0 Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        g0.a aVar = this.f2194a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.g0
    public void setOnFitSystemWindowsListener(g0.a aVar) {
        this.f2194a = aVar;
    }

    public FitWindowsLinearLayout(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
