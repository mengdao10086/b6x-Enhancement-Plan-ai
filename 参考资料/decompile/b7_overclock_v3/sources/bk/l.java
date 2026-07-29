package bk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
public class l {

    @t0({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f9494a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        @yt.l
        public static final Method f9495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hk.e
        @yt.l
        public static final Method f9496c;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
        static {
            /*
                bk.l$a r0 = new bk.l$a
                r0.<init>()
                bk.l.a.f9494a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.f0.o(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.f0.g(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.f0.o(r7, r8)
                java.lang.Object r7 = kotlin.collections.ArraysKt___ArraysKt.au(r7)
                boolean r7 = kotlin.jvm.internal.f0.g(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = 0
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                bk.l.a.f9495b = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.f0.g(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                bk.l.a.f9496c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bk.l.a.<clinit>():void");
        }
    }

    public void a(@yt.k Throwable cause, @yt.k Throwable exception) throws IllegalAccessException, InvocationTargetException {
        f0.p(cause, "cause");
        f0.p(exception, "exception");
        Method method = a.f9495b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @yt.k
    public Random b() {
        return new kotlin.random.b();
    }

    @yt.l
    public kotlin.text.h c(@yt.k MatchResult matchResult, @yt.k String name) {
        f0.p(matchResult, "matchResult");
        f0.p(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @yt.k
    public List<Throwable> d(@yt.k Throwable exception) {
        Object objInvoke;
        List<Throwable> listT;
        f0.p(exception, "exception");
        Method method = a.f9496c;
        return (method == null || (objInvoke = method.invoke(exception, new Object[0])) == null || (listT = kotlin.collections.m.t((Throwable[]) objInvoke)) == null) ? CollectionsKt__CollectionsKt.E() : listT;
    }
}
