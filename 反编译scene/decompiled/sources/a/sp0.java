package a;

import a.p80;
import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.permissions.CheckRootStatus$forceGetRoot$2", f = "CheckRootStatus.kt", l = {}, m = "invokeSuspend")
public final class sp0 extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wp0 f2913a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f2914b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sp0(wp0 wp0Var, n92 n92Var, n92 n92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f2913a = wp0Var;
        this.f7420a = n92Var;
        this.f2914b = n92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        sp0 sp0Var = new sp0(this.f2913a, this.f7420a, this.f2914b, b62Var);
        sp0Var.f2912a = (wd2) obj;
        return sp0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
        return ((sp0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        String strS0 = e50.f677a.s0();
        String strF = a70.f(false);
        p80.a aVar = p80.f2403a;
        Context contextE = this.f2913a.e();
        String string = this.f2913a.e().getString(u61.error_root);
        f92.c(string, "context.getString(R.string.error_root)");
        String str = "Current Mode: " + ((String) this.f7420a.f6891a) + "\nSU CMD: " + strF + "\nCurrent User: " + ((String) this.f2914b.f6891a) + "\n\nLogs:\n" + strS0;
        String string2 = this.f2913a.e().getString(2131886519);
        f92.c(string2, "context.getString(R.string.btn_confirm)");
        q80 q80Var = new q80(string2, this.f2913a.b, false, 4, null);
        String string3 = this.f2913a.e().getString(u61.switch_root_cmd);
        f92.c(string3, "context.getString(R.string.switch_root_cmd)");
        p80.b bVarH = aVar.h(contextE, string, str, q80Var, new q80(string3, new rp0(this), false, 4, null));
        bVarH.i(false);
        return bVarH;
    }
}
