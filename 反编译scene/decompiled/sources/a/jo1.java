package a;

import a.p80;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ol1 f6531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u90 f1571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f1572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1574a;
    public final String b;

    public jo1(Activity activity, ol1 ol1Var, u90 u90Var) {
        f92.d(activity, "context");
        f92.d(ol1Var, "exchangeHandler");
        f92.d(u90Var, "progressBarDialog");
        this.f1572a = activity;
        this.f6531a = ol1Var;
        this.f1571a = u90Var;
        this.f1574a = true;
        this.f1573a = "https://www.paypal.me/duduski";
        this.b = "https://vtools.oss-cn-beijing.aliyuncs.com/";
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.String r13, java.lang.Runnable r14) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.jo1.i(java.lang.String, java.lang.Runnable):void");
    }

    public final void j() {
        qc2.d(xd2.a(qe2.b()), null, null, new xn1(this, null), 3, null);
    }

    public final boolean k() {
        if (new wm0().a().length() > 0) {
            return true;
        }
        p80.a aVar = p80.f2403a;
        Activity activity = this.f1572a;
        String string = activity.getString(u61.user_sn_null);
        f92.c(string, "context.getString(R.string.user_sn_null)");
        String string2 = this.f1572a.getString(u61.user_sn_root);
        f92.c(string2, "context.getString(R.string.user_sn_root)");
        p80.a.b(aVar, activity, string, string2, null, 8, null);
        return false;
    }

    public final void l(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            this.f1572a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.view.View] */
    public final void m() {
        n92 n92Var = new n92();
        ?? Inflate = LayoutInflater.from(this.f1572a).inflate(2131558528, (ViewGroup) null);
        n92Var.f6891a = Inflate;
        Inflate.findViewById(t61.pay_alipay).setOnClickListener(new zn1(this));
        ((View) n92Var.f6891a).findViewById(t61.pay_wxpay).setOnClickListener(new do1(this));
        ((View) n92Var.f6891a).findViewById(t61.pay_paypal).setOnClickListener(new fo1(this));
        ((View) n92Var.f6891a).findViewById(t61.pay_google).setOnClickListener(new go1(this));
        qc2.d(xd2.a(qe2.b()), null, null, new io1(this, n92Var, null), 3, null);
    }
}
