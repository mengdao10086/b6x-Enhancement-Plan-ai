package a;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class qw {
    static {
        new AtomicReference();
    }

    public static TimeZone a() {
        return TimeZone.getTimeZone("UTC");
    }

    public static Calendar b() {
        return c(null);
    }

    public static Calendar c(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(a());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
