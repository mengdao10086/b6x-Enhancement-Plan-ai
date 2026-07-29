package dk;

import hk.e;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.random.Random;
import kotlin.text.h;
import qk.m;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public class a extends ck.a {

    /* JADX INFO: renamed from: dk.a$a, reason: collision with other inner class name */
    @t0({"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    public static final class C0297a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final C0297a f26276a = new C0297a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @e
        @l
        public static final Integer f26277b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null) {
                if (num2.intValue() > 0) {
                    num = num2;
                }
            }
            f26277b = num;
        }
    }

    private final boolean e(int i10) {
        Integer num = C0297a.f26277b;
        return num == null || num.intValue() >= i10;
    }

    @Override // bk.l
    @k
    public Random b() {
        return e(34) ? new pk.a() : super.b();
    }

    @Override // bk.l
    @l
    public h c(@k MatchResult matchResult, @k String name) {
        f0.p(matchResult, "matchResult");
        f0.p(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        m mVar = new m(matcher.start(name), matcher.end(name) - 1);
        if (mVar.a().intValue() < 0) {
            return null;
        }
        String strGroup = matcher.group(name);
        f0.o(strGroup, "matcher.group(name)");
        return new h(strGroup, mVar);
    }
}
