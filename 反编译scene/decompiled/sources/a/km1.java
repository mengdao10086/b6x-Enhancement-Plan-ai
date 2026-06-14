package a;

import android.content.Context;
import com.omarea.Scene;
import com.omarea.model.ActivationCodeResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogExchange$sync$1", f = "DialogExchange.kt", l = {68}, m = "invokeSuspend")
public final class km1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nm1 f6621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1663a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1664b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f1665b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public km1(nm1 nm1Var, String str, boolean z, b62 b62Var) {
        super(2, b62Var);
        this.f6621a = nm1Var;
        this.f1663a = str;
        this.f1665b = z;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        km1 km1Var = new km1(this.f6621a, this.f1663a, this.f1665b, b62Var);
        km1Var.f1661a = (wd2) obj;
        return km1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((km1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        ActivationCodeResponse activationCodeResponseE;
        String str;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1661a;
            Context applicationContext = this.f6621a.f2115a.getApplicationContext();
            f92.c(applicationContext, "activity.applicationContext");
            activationCodeResponseE = new mp0(applicationContext).E();
            this.f6621a.r(false);
            if (activationCodeResponseE != null) {
                this.f6621a.r(false);
                if (activationCodeResponseE.getPass()) {
                    String codeStr = activationCodeResponseE.getCodeStr();
                    hz0.f1282a.D0(codeStr);
                    hz0.f1282a.E0(activationCodeResponseE.getType());
                    hz0 hz0Var = hz0.f1282a;
                    String account = activationCodeResponseE.getAccount();
                    if (account.length() == 0) {
                        account = null;
                    }
                    hz0Var.M0(account);
                    if ((!f92.a(codeStr, this.f1663a)) && ec2.C(e50.f677a.Q(codeStr), "success", false, 2, null)) {
                        sn0 sn0Var = new sn0(this.f6621a.f2115a);
                        this.f1662a = wd2Var;
                        this.f1664b = activationCodeResponseE;
                        this.c = codeStr;
                        this.b = 1;
                        if (sn0.b(sn0Var, null, this, 1, null) == objC) {
                            return objC;
                        }
                        str = codeStr;
                    } else if (!this.f1665b) {
                        Scene.f4798a.i(new jm1(this));
                    }
                }
            } else {
                Scene.c cVar = Scene.f4798a;
                String string = cVar.c().getString(u61.license_no_response);
                f92.c(string, "Scene.context.getString(…ring.license_no_response)");
                Scene.c.p(cVar, string, 0, 2, null);
            }
            return m42.f6769a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) this.c;
        activationCodeResponseE = (ActivationCodeResponse) this.f1664b;
        h42.b(obj);
        if (!this.f1665b) {
            Scene.f4798a.i(new hm1(this));
        }
        Scene.f4798a.i(new im1(this, str, activationCodeResponseE));
        return m42.f6769a;
    }
}
