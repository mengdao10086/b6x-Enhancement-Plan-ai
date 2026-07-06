package a;

import com.omarea.Scene;
import com.omarea.model.LoginResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$unbindDevice$1$1", f = "FragmentUser.kt", l = {}, m = "invokeSuspend")
public final class zw1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax1 f8103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f3891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3892a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw1(ax1 ax1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f8103a = ax1Var;
        this.f3891a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        zw1 zw1Var = new zw1(this.f8103a, this.f3891a, b62Var);
        zw1Var.f3892a = (wd2) obj;
        return zw1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((zw1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        Scene.c cVar;
        String strJ;
        String str;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f8103a.f5651a.S1().c();
        T t = this.f3891a.f6891a;
        if (((LoginResponse) t) == null) {
            cVar = Scene.f4798a;
            strJ = this.f8103a.f5651a.J(u61.user_not_response);
            str = "getString(R.string.user_not_response)";
        } else {
            if (!((LoginResponse) t).getPass()) {
                cVar = Scene.f4798a;
                strJ = this.f8103a.f5651a.J(u61.user_unbind_failure) + " " + ((LoginResponse) this.f3891a.f6891a).getError();
                Scene.c.p(cVar, strJ, 0, 2, null);
                return m42.f6769a;
            }
            hz0.f1282a.M0(null);
            if (!this.f8103a.f5651a.R()) {
                this.f8103a.f5651a.Y1();
                return m42.f6769a;
            }
            cVar = Scene.f4798a;
            strJ = this.f8103a.f5651a.J(u61.user_log_out_ok);
            str = "getString(R.string.user_log_out_ok)";
        }
        f92.c(strJ, str);
        Scene.c.p(cVar, strJ, 0, 2, null);
        return m42.f6769a;
    }
}
