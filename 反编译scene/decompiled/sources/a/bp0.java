package a;

import android.util.Log;
import com.omarea.model.AccountPointsResponse;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bp0<V> implements Callable<AccountPointsResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mp0 f5722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f292a;
    public final /* synthetic */ String b;

    public bp0(mp0 mp0Var, String str, String str2) {
        this.f5722a = mp0Var;
        this.f292a = str;
        this.b = str2;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AccountPointsResponse call() {
        String strL;
        try {
            mp0 mp0Var = this.f5722a;
            String str = no0.f6937a.a() + "/account-integral";
            g30 g30Var = new g30();
            Locale localeH = this.f5722a.H();
            if (localeH != null) {
                g30Var.x("locale", localeH.getLanguage());
            }
            g30Var.x("uid", this.f292a);
            g30Var.x("password", this.f5722a.L(this.b));
            m42 m42Var = m42.f6769a;
            strL = mp0Var.l(str, g30Var);
        } catch (Exception unused) {
            Log.e("Scene", "Cloud Request(exchangeCode), Fail!");
        }
        if (strL == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ec2.r0(strL).toString();
        if (string.length() > 0) {
            try {
                Object objQ = new vn0().q(string, new AccountPointsResponse().getClass());
                ((AccountPointsResponse) objQ).setDetail(string);
                return (AccountPointsResponse) objQ;
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }
}
