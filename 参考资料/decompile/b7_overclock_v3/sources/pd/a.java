package pd;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static int a(@n0 Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f10, f11, f12, f13, i10) : canvas.saveLayerAlpha(f10, f11, f12, f13, i10, 31);
    }

    public static int b(@n0 Canvas canvas, @p0 RectF rectF, int i10) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(rectF, i10) : canvas.saveLayerAlpha(rectF, i10, 31);
    }
}
