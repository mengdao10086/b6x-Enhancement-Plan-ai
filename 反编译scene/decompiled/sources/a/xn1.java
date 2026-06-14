package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogPaymentMethods$check$1", f = "DialogPaymentMethods.kt", l = {}, m = "invokeSuspend")
public final class xn1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f7907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3603a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xn1(jo1 jo1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7907a = jo1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xn1 xn1Var = new xn1(this.f7907a, b62Var);
        xn1Var.f3603a = (wd2) obj;
        return xn1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xn1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        URLConnection uRLConnectionOpenConnection;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            uRLConnectionOpenConnection = new URL(this.f7907a.b + "vi/lastversion.json").openConnection();
        } catch (Exception unused) {
            this.f7907a.f1574a = true;
        }
        if (uRLConnectionOpenConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        String strE = t72.e(new BufferedReader(new InputStreamReader(((HttpURLConnection) uRLConnectionOpenConnection).getInputStream())));
        this.f7907a.f1574a = ec2.C(strE, "NoSuchKey", false, 2, null) || ec2.C(strE, "AccessDenied", false, 2, null);
        return m42.f6769a;
    }
}
