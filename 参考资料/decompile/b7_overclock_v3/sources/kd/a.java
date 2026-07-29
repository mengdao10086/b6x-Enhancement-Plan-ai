package kd;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import com.google.common.collect.LinkedHashMultimap;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f37166a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f37167b = new l1.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f37168c = new l1.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f37169d = new l1.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f37170e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static float b(float f10, float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f13, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f14) {
        return f14 < f12 ? f10 : f14 > f13 ? f11 : a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    public static int c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }
}
