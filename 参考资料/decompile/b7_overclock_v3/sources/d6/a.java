package d6;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f26066a = Resources.getSystem().getDisplayMetrics().density;

    public static int b(float f10) {
        return (int) ((f10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int d(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", l4.f.f39447b);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int e(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static float g(float f10) {
        return f10 / Resources.getSystem().getDisplayMetrics().density;
    }

    public int a(float f10) {
        return (int) ((f10 * this.f26066a) + 0.5f);
    }

    public float f(float f10) {
        return f10 / this.f26066a;
    }
}
