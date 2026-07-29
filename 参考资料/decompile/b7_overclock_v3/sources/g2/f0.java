package g2;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28954a = "android:visibilityPropagation:visibility";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f28955b = "android:visibilityPropagation:center";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f28956c = {f28954a, f28955b};

    public static int d(q qVar, int i10) {
        int[] iArr;
        if (qVar == null || (iArr = (int[]) qVar.f28972a.get(f28955b)) == null) {
            return -1;
        }
        return iArr[i10];
    }

    @Override // g2.p
    public void a(q qVar) {
        View view = qVar.f28973b;
        Integer numValueOf = (Integer) qVar.f28972a.get(androidx.transition.a0.N7);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        qVar.f28972a.put(f28954a, numValueOf);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        qVar.f28972a.put(f28955b, iArr);
    }

    @Override // g2.p
    public String[] b() {
        return f28956c;
    }

    public int e(q qVar) {
        Integer num;
        if (qVar == null || (num = (Integer) qVar.f28972a.get(f28954a)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(q qVar) {
        return d(qVar, 0);
    }

    public int g(q qVar) {
        return d(qVar, 1);
    }
}
