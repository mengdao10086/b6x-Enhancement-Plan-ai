package a;

import com.omarea.Scene;
import com.omarea.model.LoginResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogLogin$login$1", f = "DialogLogin.kt", l = {132, 145, 145, 145}, m = "invokeSuspend")
public final class tm1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zm1 f3042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3044a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3045b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f3046b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tm1(zm1 zm1Var, String str, String str2, b62 b62Var) {
        super(2, b62Var);
        this.f3042a = zm1Var;
        this.f3044a = str;
        this.f3046b = str2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tm1 tm1Var = new tm1(this.f3042a, this.f3044a, this.f3046b, b62Var);
        tm1Var.f7514a = (wd2) obj;
        return tm1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tm1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Object] */
    @Override // a.s62
    public final Object j(Object obj) throws Throwable {
        wd2 wd2Var;
        Scene.c cVar;
        String string;
        Object objC = r62.c();
        ?? r1 = this.b;
        boolean z = true;
        try {
            try {
            } catch (Exception unused) {
                Scene.c cVar2 = Scene.f4798a;
                String string2 = this.f3042a.f3870a.getString(u61.user_not_response);
                f92.c(string2, "context.getString(R.string.user_not_response)");
                Scene.c.p(cVar2, string2, 0, 2, null);
                fg2 fg2VarC = qe2.c();
                sm1 sm1Var = new sm1(this, null);
                this.f3043a = r1;
                this.b = 3;
                if (oc2.g(fg2VarC, sm1Var, this) == objC) {
                    return objC;
                }
            }
            if (r1 == 0) {
                h42.b(obj);
                wd2Var = this.f7514a;
                LoginResponse loginResponseK = new mp0(this.f3042a.f3870a).K(this.f3044a, this.f3046b);
                if (loginResponseK == null) {
                    cVar = Scene.f4798a;
                    string = this.f3042a.f3870a.getString(u61.user_not_response);
                    f92.c(string, "context.getString(R.string.user_not_response)");
                } else if (loginResponseK.getPass()) {
                    Scene.c cVar3 = Scene.f4798a;
                    String string3 = this.f3042a.f3870a.getString(u61.user_login_ok);
                    f92.c(string3, "context.getString(R.string.user_login_ok)");
                    Scene.c.p(cVar3, string3, 0, 2, null);
                    this.f3042a.g();
                    om1 om1Var = this.f3042a.f8082a;
                    String str = this.f3044a;
                    boolean activated = loginResponseK.getActivated();
                    this.f3043a = wd2Var;
                    this.f3045b = loginResponseK;
                    this.b = 1;
                    if (om1Var.a(str, activated, this) == objC) {
                        return objC;
                    }
                } else {
                    if (loginResponseK.getError().length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        Scene.c.p(Scene.f4798a, loginResponseK.getError(), 0, 2, null);
                    } else {
                        cVar = Scene.f4798a;
                        string = this.f3042a.f3870a.getString(u61.user_login_failure);
                        f92.c(string, "context.getString(R.string.user_login_failure)");
                    }
                }
                Scene.c.p(cVar, string, 0, 2, null);
            } else {
                if (r1 != 1) {
                    if (r1 == 2 || r1 == 3) {
                        h42.b(obj);
                        return m42.f6769a;
                    }
                    if (r1 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.f3045b;
                    h42.b(obj);
                    throw th;
                }
                wd2Var = (wd2) this.f3043a;
                h42.b(obj);
            }
            fg2 fg2VarC2 = qe2.c();
            sm1 sm1Var2 = new sm1(this, null);
            this.f3043a = wd2Var;
            this.b = 2;
            if (oc2.g(fg2VarC2, sm1Var2, this) == objC) {
                return objC;
            }
            return m42.f6769a;
        } catch (Throwable th2) {
            fg2 fg2VarC3 = qe2.c();
            sm1 sm1Var3 = new sm1(this, null);
            this.f3043a = r1;
            this.f3045b = th2;
            this.b = 4;
            if (oc2.g(fg2VarC3, sm1Var3, this) == objC) {
                return objC;
            }
            throw th2;
        }
    }
}
