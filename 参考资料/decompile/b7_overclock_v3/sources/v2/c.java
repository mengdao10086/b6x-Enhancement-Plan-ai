package v2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.work.impl.WorkDatabase;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f52567b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52568c = "androidx.work.util.id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f52569d = "next_job_scheduler_id";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f52570e = "next_alarm_manager_id";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f52571a;

    public c(@n0 WorkDatabase workDatabase) {
        this.f52571a = workDatabase;
    }

    public static void a(@n0 Context context, @n0 c2.d sqLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f52568c, 0);
        if (sharedPreferences.contains(f52569d) || sharedPreferences.contains(f52569d)) {
            int i10 = sharedPreferences.getInt(f52569d, 0);
            int i11 = sharedPreferences.getInt(f52570e, 0);
            sqLiteDatabase.o();
            try {
                sqLiteDatabase.y0(androidx.work.impl.a.f8402v, new Object[]{f52569d, Integer.valueOf(i10)});
                sqLiteDatabase.y0(androidx.work.impl.a.f8402v, new Object[]{f52570e, Integer.valueOf(i11)});
                sharedPreferences.edit().clear().apply();
                sqLiteDatabase.v0();
            } finally {
                sqLiteDatabase.T0();
            }
        }
    }

    public int b() {
        int iC;
        synchronized (c.class) {
            iC = c(f52570e);
        }
        return iC;
    }

    public final int c(String key) {
        this.f52571a.e();
        try {
            Long lC = this.f52571a.R().c(key);
            int i10 = 0;
            int iIntValue = lC != null ? lC.intValue() : 0;
            if (iIntValue != Integer.MAX_VALUE) {
                i10 = iIntValue + 1;
            }
            e(key, i10);
            this.f52571a.K();
            return iIntValue;
        } finally {
            this.f52571a.k();
        }
    }

    public int d(int minInclusive, int maxInclusive) {
        synchronized (c.class) {
            int iC = c(f52569d);
            if (iC < minInclusive || iC > maxInclusive) {
                e(f52569d, minInclusive + 1);
            } else {
                minInclusive = iC;
            }
        }
        return minInclusive;
    }

    public final void e(String key, int value) {
        this.f52571a.R().b(new u2.d(key, value));
    }
}
