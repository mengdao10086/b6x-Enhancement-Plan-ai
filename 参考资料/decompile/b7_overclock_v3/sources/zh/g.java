package zh;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    public static int a(Context context, int i10) {
        int iRound = Math.round(context.getResources().getDisplayMetrics().widthPixels / i10);
        if (iRound == 0) {
            return 1;
        }
        return iRound;
    }
}
