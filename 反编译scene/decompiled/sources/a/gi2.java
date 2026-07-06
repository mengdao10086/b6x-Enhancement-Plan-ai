package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gi2 extends fg2 implements je2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Throwable f1018a;

    public gi2(Throwable th, String str) {
        this.f1018a = th;
        this.f6210a = str;
    }

    @Override // a.je2
    public re2 e(long j, Runnable runnable) {
        w();
        throw null;
    }

    @Override // a.je2
    public /* bridge */ /* synthetic */ void g(long j, tc2 tc2Var) {
        y(j, tc2Var);
        throw null;
    }

    @Override // a.od2
    public /* bridge */ /* synthetic */ void l(l62 l62Var, Runnable runnable) {
        v(l62Var, runnable);
        throw null;
    }

    @Override // a.od2
    public boolean o(l62 l62Var) {
        w();
        throw null;
    }

    @Override // a.fg2
    public fg2 p() {
        return this;
    }

    @Override // a.od2
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f1018a != null) {
            str = ", cause=" + this.f1018a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    public Void v(l62 l62Var, Runnable runnable) {
        w();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Void w() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f1018a
            if (r0 == 0) goto L37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f6210a
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f1018a
            r1.<init>(r0, r2)
            throw r1
        L37:
            a.fi2.c()
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.gi2.w():java.lang.Void");
    }

    public Void y(long j, tc2<? super m42> tc2Var) {
        w();
        throw null;
    }
}
