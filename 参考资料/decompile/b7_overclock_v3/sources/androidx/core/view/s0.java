package androidx.core.view;

import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class s0 {
    @Deprecated
    public static float a(VelocityTracker velocityTracker, int i10) {
        return velocityTracker.getXVelocity(i10);
    }

    @Deprecated
    public static float b(VelocityTracker velocityTracker, int i10) {
        return velocityTracker.getYVelocity(i10);
    }
}
