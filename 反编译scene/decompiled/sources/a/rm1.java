package a;

import android.app.AlertDialog;
import android.content.Context;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rm1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zm1 f2759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertDialog f2760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2762a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2763b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm1(AlertDialog alertDialog, n92 n92Var, b62 b62Var, zm1 zm1Var, String str) {
        super(2, b62Var);
        this.f2760a = alertDialog;
        this.f7316a = n92Var;
        this.f2759a = zm1Var;
        this.f2762a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        rm1 rm1Var = new rm1(this.f2760a, this.f7316a, b62Var, this.f2759a, this.f2762a);
        rm1Var.f2758a = (wd2) obj;
        return rm1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((rm1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Boolean] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        Object obj2 = this.b;
        try {
        } catch (Exception e) {
            fg2 fg2VarC = qe2.c();
            qm1 qm1Var = new qm1(this, null);
            this.f2761a = obj2;
            this.f2763b = e;
            this.b = 2;
            if (oc2.g(fg2VarC, qm1Var, this) == objC) {
                return objC;
            }
        }
        if (obj2 == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2758a;
            n92 n92Var = new n92();
            Context context = this.f2760a.getContext();
            f92.c(context, "context");
            n92Var.f6891a = new mp0(context).D(this.f2762a).get(5L, TimeUnit.SECONDS);
            fg2 fg2VarC2 = qe2.c();
            pm1 pm1Var = new pm1(this, n92Var, null);
            this.f2761a = wd2Var;
            this.f2763b = n92Var;
            this.b = 1;
            obj2 = wd2Var;
            if (oc2.g(fg2VarC2, pm1Var, this) == objC) {
                return objC;
            }
        } else {
            if (obj2 != 1) {
                if (obj2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2 wd2Var2 = (wd2) this.f2761a;
            h42.b(obj);
            obj2 = wd2Var2;
        }
        return m42.f6769a;
    }
}
