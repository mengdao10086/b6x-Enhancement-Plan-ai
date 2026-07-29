package com.blankj.utilcode.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12018a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f12019b = new ConcurrentHashMap(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f12020c = 1000;

    public w() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(long j10) {
        Map<String, Long> map = f12019b;
        if (map.size() < 64) {
            return;
        }
        Iterator<Map.Entry<String, Long>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            if (j10 >= it2.next().getValue().longValue()) {
                it2.remove();
            }
        }
    }

    public static boolean b(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return c(view, 1000L);
    }

    public static boolean c(@g.n0 View view, long j10) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return d(String.valueOf(view.hashCode()), j10);
    }

    public static boolean d(@g.n0 String str, long j10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a(jElapsedRealtime);
        Map<String, Long> map = f12019b;
        Long l10 = map.get(str);
        if (l10 != null && jElapsedRealtime < l10.longValue()) {
            return false;
        }
        map.put(str, Long.valueOf(jElapsedRealtime + j10));
        return true;
    }
}
