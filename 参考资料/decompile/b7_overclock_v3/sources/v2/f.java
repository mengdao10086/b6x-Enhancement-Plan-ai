package v2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.work.impl.WorkDatabase;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f52580b = "androidx.work.util.preferences";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52581c = "last_cancel_all_time_ms";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f52582d = "reschedule_needed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f52583a;

    public class a implements p.a<Long, Long> {
        public a() {
        }

        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long apply(Long value) {
            return Long.valueOf(value != null ? value.longValue() : 0L);
        }
    }

    public f(@n0 WorkDatabase workDatabase) {
        this.f52583a = workDatabase;
    }

    public static void d(@n0 Context context, @n0 c2.d sqLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f52580b, 0);
        if (sharedPreferences.contains(f52582d) || sharedPreferences.contains(f52581c)) {
            long j10 = sharedPreferences.getLong(f52581c, 0L);
            long j11 = sharedPreferences.getBoolean(f52582d, false) ? 1L : 0L;
            sqLiteDatabase.o();
            try {
                sqLiteDatabase.y0(androidx.work.impl.a.f8402v, new Object[]{f52581c, Long.valueOf(j10)});
                sqLiteDatabase.y0(androidx.work.impl.a.f8402v, new Object[]{f52582d, Long.valueOf(j11)});
                sharedPreferences.edit().clear().apply();
                sqLiteDatabase.v0();
            } finally {
                sqLiteDatabase.T0();
            }
        }
    }

    public long a() {
        Long lC = this.f52583a.R().c(f52581c);
        if (lC != null) {
            return lC.longValue();
        }
        return 0L;
    }

    @n0
    public LiveData<Long> b() {
        return Transformations.c(this.f52583a.R().a(f52581c), new a());
    }

    public boolean c() {
        Long lC = this.f52583a.R().c(f52582d);
        return lC != null && lC.longValue() == 1;
    }

    public void e(final long timeMillis) {
        this.f52583a.R().b(new u2.d(f52581c, timeMillis));
    }

    public void f(boolean needsReschedule) {
        this.f52583a.R().b(new u2.d(f52582d, needsReschedule));
    }
}
