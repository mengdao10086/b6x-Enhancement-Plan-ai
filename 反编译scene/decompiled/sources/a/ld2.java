package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ld2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6696a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = a.mi2.d(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            a.ld2.f6696a = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
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
        throw new UnsupportedOperationException("Method not decompiled: a.ld2.<clinit>():void");
    }

    public static final od2 a() {
        return f6696a ? dj2.f5909a : ed2.f722a;
    }

    public static final String b(l62 l62Var) {
        td2 td2Var;
        if (!be2.c() || (td2Var = (td2) l62Var.get(td2.f7491a)) == null) {
            return null;
        }
        vd2 vd2Var = (vd2) l62Var.get(vd2.f7684a);
        if (vd2Var != null) {
            vd2Var.l();
            throw null;
        }
        return "coroutine#" + td2Var.l();
    }

    public static final l62 c(wd2 wd2Var, l62 l62Var) {
        l62 l62VarPlus = wd2Var.f().plus(l62Var);
        l62 l62VarPlus2 = be2.c() ? l62VarPlus.plus(new td2(be2.b().incrementAndGet())) : l62VarPlus;
        return (l62VarPlus == qe2.a() || l62VarPlus.get(e62.f5972a) != null) ? l62VarPlus2 : l62VarPlus2.plus(qe2.a());
    }
}
