package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {
    public f(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.a
    public void D(ConstraintLayout container) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f4116v0.c2(0);
        bVar.f4116v0.y1(0);
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
    }

    @Override // androidx.constraintlayout.widget.a
    public void r(ConstraintLayout container) {
        q(container);
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        p();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        p();
    }

    @Override // androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4173e = false;
    }

    public f(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public f(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
