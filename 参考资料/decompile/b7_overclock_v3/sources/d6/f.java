package d6;

import com.blankj.utilcode.util.f1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.community.R;
import hk.m;
import java.util.Calendar;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTimeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeUtils.kt\ncom/flydigi/community/util/TimeUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final f f26069a = new f();

    @m
    @k
    public static final String a(long j10) {
        long j11 = j10 * ((long) 1000);
        long jCurrentTimeMillis = System.currentTimeMillis() - j11;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j11);
        Calendar calendar2 = Calendar.getInstance();
        if (jCurrentTimeMillis < 60000) {
            String string = j1.a().getString(R.string.community_time_span_just_now);
            f0.o(string, "getApp().getString(R.str…unity_time_span_just_now)");
            return string;
        }
        if (jCurrentTimeMillis < 3600000) {
            String string2 = j1.a().getString(R.string.community_time_span_min_ago, new Object[]{Long.valueOf(jCurrentTimeMillis / ((long) 60000))});
            f0.o(string2, "getApp().getString(\n    …nts.MIN\n                )");
            return string2;
        }
        if (jCurrentTimeMillis < 86400000) {
            String string3 = j1.a().getString(R.string.community_time_span_hour_ago, new Object[]{Long.valueOf(jCurrentTimeMillis / ((long) w3.e.f53894d))});
            f0.o(string3, "getApp().getString(\n    …ts.HOUR\n                )");
            return string3;
        }
        if (n0.b(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar2.get(1)))) {
            String strQ0 = f1.Q0(j11, "MM-dd");
            f0.o(strQ0, "millis2String(mills, \"MM-dd\")");
            return strQ0;
        }
        String strQ02 = f1.Q0(j11, "yyyy-MM-dd");
        f0.o(strQ02, "millis2String(mills, \"yyyy-MM-dd\")");
        return strQ02;
    }
}
