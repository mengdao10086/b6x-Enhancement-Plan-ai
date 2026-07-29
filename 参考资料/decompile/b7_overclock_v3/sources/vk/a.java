package vk;

import bk.f;
import hk.h;
import java.time.Duration;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.time.DurationUnit;
import kotlin.v0;
import uk.e;
import uk.g;
import uk.k;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "DurationConversionsJDK8Kt")
@t0({"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,33:1\n720#2,2:34\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n33#1:34,2\n*E\n"})
public final class a {
    @c2(markerClass = {k.class})
    @f
    @v0(version = "1.6")
    public static final Duration a(long j10) {
        Duration durationOfSeconds = Duration.ofSeconds(e.P(j10), e.T(j10));
        f0.o(durationOfSeconds, "toJavaDuration-LRDsOJo");
        return durationOfSeconds;
    }

    @c2(markerClass = {k.class})
    @f
    @v0(version = "1.6")
    public static final long b(Duration duration) {
        f0.p(duration, "<this>");
        return e.h0(g.n0(duration.getSeconds(), DurationUnit.SECONDS), g.m0(duration.getNano(), DurationUnit.NANOSECONDS));
    }
}
