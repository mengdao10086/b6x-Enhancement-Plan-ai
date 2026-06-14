package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.krscript.ui.DialogLogFragment$MyShellHandler$onStart$1", f = "DialogLogFragment.kt", l = {247}, m = "invokeSuspend")
public final class le0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ne0 f6697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1789a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public le0(ne0 ne0Var, b62 b62Var) {
        super(2, b62Var);
        this.f6697a = ne0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        le0 le0Var = new le0(this.f6697a, b62Var);
        le0Var.f1788a = (wd2) obj;
        return le0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((le0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:22:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r5.b
            r2 = 1
            if (r1 == 0) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r1 = r5.f1789a
            a.wd2 r1 = (a.wd2) r1
            a.h42.b(r6)
            r6 = r5
            goto L4d
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            a.h42.b(r6)
            a.wd2 r6 = r5.f1788a
            r1 = r6
            r6 = r5
        L23:
            a.ne0 r3 = r6.f6697a
            boolean r3 = a.ne0.d(r3)
            if (r3 != 0) goto L40
            a.ne0 r3 = r6.f6697a
            java.lang.StringBuffer r3 = a.ne0.b(r3)
            int r3 = r3.length()
            if (r3 <= 0) goto L39
            r3 = r2
            goto L3a
        L39:
            r3 = 0
        L3a:
            if (r3 == 0) goto L3d
            goto L40
        L3d:
            a.m42 r6 = a.m42.f6769a
            return r6
        L40:
            r3 = 16
            r6.f1789a = r1
            r6.b = r2
            java.lang.Object r3 = a.ke2.a(r3, r6)
            if (r3 != r0) goto L4d
            return r0
        L4d:
            a.ne0 r3 = r6.f6697a
            a.ne0.a(r3)
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: a.le0.j(java.lang.Object):java.lang.Object");
    }
}
