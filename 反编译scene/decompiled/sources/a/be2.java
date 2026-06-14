package a;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class be2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f5700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f268a = td2.class.desiredAssertionStatus();
    public static final boolean b;
    public static final boolean c;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0.equals("auto") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r0.equals("on") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r0.equals("") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.Class<a.td2> r0 = a.td2.class
            boolean r0 = r0.desiredAssertionStatus()
            a.be2.f268a = r0
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = a.mi2.d(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L13
            goto L2f
        L13:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L45
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L3c
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L32
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L67
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L67
        L2f:
            boolean r0 = a.be2.f268a
            goto L4e
        L32:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L67
            r0 = r1
            goto L4e
        L3c:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L67
            goto L4d
        L45:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L67
        L4d:
            r0 = r2
        L4e:
            a.be2.b = r0
            if (r0 == 0) goto L5b
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = a.mi2.e(r0, r2)
            if (r0 == 0) goto L5b
            r1 = r2
        L5b:
            a.be2.c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            a.be2.f5700a = r0
            return
        L67:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.be2.<clinit>():void");
    }

    public static final boolean a() {
        return f268a;
    }

    public static final AtomicLong b() {
        return f5700a;
    }

    public static final boolean c() {
        return b;
    }

    public static final boolean d() {
        return c;
    }
}
