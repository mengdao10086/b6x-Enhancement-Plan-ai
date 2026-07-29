package cd;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class e {
    public static Notification a(Context context, @g.v int i10, String str, @p0 PendingIntent pendingIntent, @p0 String str2) {
        return new com.google.android.exoplayer2.ui.d(context, str).a(context, i10, pendingIntent, str2);
    }

    public static Notification b(Context context, @g.v int i10, String str, @p0 PendingIntent pendingIntent, @p0 String str2) {
        return new com.google.android.exoplayer2.ui.d(context, str).b(context, i10, pendingIntent, str2);
    }

    public static Notification c(Context context, @g.v int i10, String str, @p0 PendingIntent pendingIntent, @p0 String str2, List<cc.c> list) {
        return new com.google.android.exoplayer2.ui.d(context, str).e(context, i10, pendingIntent, str2, list);
    }
}
