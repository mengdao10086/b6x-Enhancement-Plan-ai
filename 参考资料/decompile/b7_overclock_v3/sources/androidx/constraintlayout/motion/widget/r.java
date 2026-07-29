package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r implements Interpolator {
    public abstract float a();

    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float v10);
}
