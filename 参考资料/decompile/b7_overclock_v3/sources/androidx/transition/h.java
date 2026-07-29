package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class h extends a0 {
    public static final TimeInterpolator U7 = new DecelerateInterpolator();
    public static final TimeInterpolator V7 = new AccelerateInterpolator();
    public static final String W7 = "android:explode:screenBounds";
    public int[] T7;

    public h() {
        this.T7 = new int[2];
        D0(new g2.c());
    }

    private void H0(g2.q qVar) {
        View view = qVar.f28973b;
        view.getLocationOnScreen(this.T7);
        int[] iArr = this.T7;
        int i10 = iArr[0];
        int i11 = iArr[1];
        qVar.f28972a.put(W7, new Rect(i10, i11, view.getWidth() + i10, view.getHeight() + i11));
    }

    public static float Q0(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    public static float R0(View view, int i10, int i11) {
        return Q0(Math.max(i10, view.getWidth() - i10), Math.max(i11, view.getHeight() - i11));
    }

    @Override // androidx.transition.a0
    @p0
    public Animator L0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        if (qVar2 == null) {
            return null;
        }
        Rect rect = (Rect) qVar2.f28972a.get(W7);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        S0(viewGroup, rect, this.T7);
        int[] iArr = this.T7;
        return x.a(view, qVar2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, U7, this);
    }

    @Override // androidx.transition.a0
    @p0
    public Animator N0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        float f10;
        float f11;
        if (qVar == null) {
            return null;
        }
        Rect rect = (Rect) qVar.f28972a.get(W7);
        int i10 = rect.left;
        int i11 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) qVar.f28973b.getTag(R.id.transition_position);
        if (iArr != null) {
            f10 = (iArr[0] - rect.left) + translationX;
            f11 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f10 = translationX;
            f11 = translationY;
        }
        S0(viewGroup, rect, this.T7);
        int[] iArr2 = this.T7;
        return x.a(view, qVar, i10, i11, translationX, translationY, f10 + iArr2[0], f11 + iArr2[1], V7, this);
    }

    public final void S0(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.T7);
        int[] iArr2 = this.T7;
        int i10 = iArr2[0];
        int i11 = iArr2[1];
        Rect rectH = H();
        if (rectH == null) {
            width = (view.getWidth() / 2) + i10 + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i11 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectH.centerX();
            iCenterY = rectH.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fQ0 = Q0(fCenterX, fCenterY);
        float fR0 = R0(view, width - i10, iCenterY - i11);
        iArr[0] = Math.round((fCenterX / fQ0) * fR0);
        iArr[1] = Math.round(fR0 * (fCenterY / fQ0));
    }

    @Override // androidx.transition.a0, androidx.transition.q
    public void j(@n0 g2.q qVar) {
        super.j(qVar);
        H0(qVar);
    }

    @Override // androidx.transition.a0, androidx.transition.q
    public void m(@n0 g2.q qVar) {
        super.m(qVar);
        H0(qVar);
    }

    public h(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T7 = new int[2];
        D0(new g2.c());
    }
}
