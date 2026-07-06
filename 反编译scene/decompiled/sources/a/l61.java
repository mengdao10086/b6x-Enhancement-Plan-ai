package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.utils.ElectricityUnit$autoDetect$1", f = "ElectricityUnit.kt", l = {68}, m = "invokeSuspend")
public final class l61 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f6679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ m61 f1756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ m92 f1757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1760a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l61(m61 m61Var, m92 m92Var, l92 l92Var, ArrayList arrayList, b62 b62Var) {
        super(2, b62Var);
        this.f1756a = m61Var;
        this.f1757a = m92Var;
        this.f6679a = l92Var;
        this.f1760a = arrayList;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        l61 l61Var = new l61(this.f1756a, this.f1757a, this.f6679a, this.f1760a, b62Var);
        l61Var.f1758a = (wd2) obj;
        return l61Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((l61) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
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
    public final java.lang.Object j(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.l61.j(java.lang.Object):java.lang.Object");
    }
}
