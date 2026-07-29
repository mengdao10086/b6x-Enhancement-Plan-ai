package kotlin.random;

import bk.f;
import bk.m;
import kotlin.jvm.internal.f0;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    @v0(version = "1.3")
    @k
    public static final java.util.Random a(@k Random random) {
        java.util.Random randomV;
        f0.p(random, "<this>");
        a aVar = random instanceof a ? (a) random : null;
        return (aVar == null || (randomV = aVar.v()) == null) ? new KotlinRandom(random) : randomV;
    }

    @v0(version = "1.3")
    @k
    public static final Random b(@k java.util.Random random) {
        Random randomA;
        f0.p(random, "<this>");
        KotlinRandom kotlinRandom = random instanceof KotlinRandom ? (KotlinRandom) random : null;
        return (kotlinRandom == null || (randomA = kotlinRandom.a()) == null) ? new PlatformRandom(random) : randomA;
    }

    @f
    public static final Random c() {
        return m.f9497a.b();
    }

    public static final double d(int i10, int i11) {
        return ((((long) i10) << 27) + ((long) i11)) / 9.007199254740992E15d;
    }
}
