package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f38937a = "kotlinx.coroutines.debug";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f38938b = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final String f38939c = "auto";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final String f38940d = "on";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final String f38941e = "off";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f38942f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f38943g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f38944h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final AtomicLong f38945i;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (r0.equals(kotlinx.coroutines.q0.f38940d) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.r0.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L63
            int r3 = r0.hashCode()
            if (r3 == 0) goto L39
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L30
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L27
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L43
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
            goto L63
        L27:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
            goto L63
        L30:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
            goto L41
        L39:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
        L41:
            r0 = 1
            goto L64
        L43:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.append(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L63:
            r0 = 0
        L64:
            kotlinx.coroutines.q0.f38943g = r0
            if (r0 == 0) goto L71
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.r0.f(r0, r1)
            if (r0 == 0) goto L71
            goto L72
        L71:
            r1 = 0
        L72:
            kotlinx.coroutines.q0.f38944h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.q0.f38945i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.q0.<clinit>():void");
    }

    @bk.f
    public static final void a(ik.a<Boolean> aVar) {
    }

    public static final boolean b() {
        return f38942f;
    }

    @yt.k
    public static final AtomicLong c() {
        return f38945i;
    }

    public static final boolean d() {
        return f38943g;
    }

    public static final boolean e() {
        return f38944h;
    }

    public static final void f() {
        f38945i.set(0L);
    }
}
