package t3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import l4.f;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public b() {
        throw new AssertionError();
    }

    public static int a(Context context, int i10) {
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }

    public static int b(Activity activity) {
        if (!f(activity)) {
            return 0;
        }
        Resources resources = activity.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", f.f39447b);
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        a.f("NavigationBar的高度:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int e(Context context) {
        int iA = a(context, 20);
        a.f("common statusBar height:" + iA);
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", f.f39447b);
        if (identifier > 0) {
            iA = context.getResources().getDimensionPixelSize(identifier);
            a.f("real statusBar height:" + iA);
        }
        a.f("finally statusBar height:" + iA);
        return iA;
    }

    public static boolean f(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }
}
