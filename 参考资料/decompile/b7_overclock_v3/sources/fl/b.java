package fl;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static int a(Context context, double d10) {
        return (int) ((d10 * ((double) context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
