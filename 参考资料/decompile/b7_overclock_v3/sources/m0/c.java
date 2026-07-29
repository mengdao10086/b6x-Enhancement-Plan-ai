package m0;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import g.n0;
import g.p0;
import g.v0;
import m0.d;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    @v0(29)
    public static class a {
        @g.u
        public static ColorFilter a(int i10, Object obj) {
            return new BlendModeColorFilter(i10, (BlendMode) obj);
        }
    }

    @p0
    public static ColorFilter a(int i10, @n0 BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = d.b.a(blendModeCompat);
            if (objA != null) {
                return a.a(i10, objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = d.a(blendModeCompat);
        if (modeA != null) {
            return new PorterDuffColorFilter(i10, modeA);
        }
        return null;
    }
}
