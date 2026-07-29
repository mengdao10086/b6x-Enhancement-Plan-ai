package g2;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class c extends f0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f28942d = 3.0f;

    public static float h(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        return (float) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    @Override // g2.p
    public long c(ViewGroup viewGroup, androidx.transition.q qVar, q qVar2, q qVar3) {
        int i10;
        int iRound;
        int iCenterX;
        if (qVar2 == null && qVar3 == null) {
            return 0L;
        }
        if (qVar3 == null || e(qVar2) == 0) {
            i10 = -1;
        } else {
            qVar2 = qVar3;
            i10 = 1;
        }
        int iF = f(qVar2);
        int iG = g(qVar2);
        Rect rectH = qVar.H();
        if (rectH != null) {
            iCenterX = rectH.centerX();
            iRound = rectH.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fH = h(iF, iG, iCenterX, iRound) / h(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jG = qVar.G();
        if (jG < 0) {
            jG = 300;
        }
        return Math.round(((jG * ((long) i10)) / this.f28942d) * fH);
    }

    public void i(float f10) {
        if (f10 == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.f28942d = f10;
    }
}
