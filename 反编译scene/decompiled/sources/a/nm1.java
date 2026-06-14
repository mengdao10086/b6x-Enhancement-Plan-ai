package a;

import a.p80;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.ExchangeResponse;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ol1 f6932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f2114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f2115a;

    public nm1(Activity activity, ol1 ol1Var, u90 u90Var) {
        f92.d(activity, "activity");
        f92.d(ol1Var, "exchangeHandler");
        f92.d(u90Var, "progressBarDialog");
        this.f2115a = activity;
        this.f6932a = ol1Var;
        this.f2114a = u90Var;
    }

    public static /* synthetic */ void l(nm1 nm1Var, p80.b bVar, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        nm1Var.k(bVar, str, z);
    }

    public final boolean j() {
        if (new wm0().a().length() > 0) {
            return true;
        }
        p80.a aVar = p80.f2403a;
        Activity activity = this.f2115a;
        String string = activity.getString(u61.user_sn_null);
        f92.c(string, "activity.getString(R.string.user_sn_null)");
        String string2 = this.f2115a.getString(u61.user_sn_root2);
        f92.c(string2, "activity.getString(R.string.user_sn_root2)");
        p80.a.b(aVar, activity, string, string2, null, 8, null);
        return false;
    }

    public final void k(p80.b bVar, String str, boolean z) {
        qc2.d(xd2.a(qe2.b()), null, null, new ql1(this, str, z, bVar, null), 3, null);
    }

    public final String m(ExchangeResponse exchangeResponse) {
        if (exchangeResponse.getNumber() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String string = this.f2115a.getString(u61.user_exchange_exhaust_desc);
        f92.c(string, "activity.getString(R.str…er_exchange_exhaust_desc)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(exchangeResponse.getNumber()), Integer.valueOf(exchangeResponse.getUsed())}, 2));
        f92.c(str, "java.lang.String.format(this, *args)");
        sb.append(str);
        sb.append('\n');
        sb.append(exchangeResponse.getDevices());
        return sb.toString();
    }

    public final void n(p80.b bVar, String str, ExchangeResponse exchangeResponse) throws InterruptedException {
        String string;
        if (exchangeResponse.getExchanged()) {
            String codeStr = exchangeResponse.getCodeStr();
            if (!(codeStr.length() > 0)) {
                s(true);
                bVar.c();
                p80.a aVar = p80.f2403a;
                Activity activity = this.f2115a;
                String string2 = activity.getString(u61.user_exchange_ok);
                f92.c(string2, "activity.getString(R.string.user_exchange_ok)");
                aVar.z(activity, string2, new ul1(this));
                return;
            }
            String strQ = e50.f677a.Q(codeStr);
            if (ec2.C(strQ, "success", false, 2, null)) {
                hz0.f1282a.D0(codeStr);
                qc2.d(xd2.a(qe2.b()), null, null, new rl1(this, null), 3, null);
                bVar.c();
                p80.a aVar2 = p80.f2403a;
                Activity activity2 = this.f2115a;
                String string3 = activity2.getString(u61.user_exchange_ok);
                f92.c(string3, "activity.getString(R.string.user_exchange_ok)");
                aVar2.y(activity2, string3, m(exchangeResponse), new sl1(this));
                return;
            }
            p80.a aVar3 = p80.f2403a;
            Activity activity3 = this.f2115a;
            String string4 = activity3.getString(2131886660);
            f92.c(string4, "activity.getString(R.string.execute_fail)");
            aVar3.M(activity3, (16 & 2) != 0 ? "" : string4, (16 & 4) != 0 ? "" : this.f2115a.getString(u61.user_exchange_ok_error) + "\n\nResponse:\n" + exchangeResponse.getDetail() + "\n\n" + strQ, (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? null : tl1.f7512a);
            return;
        }
        if (exchangeResponse.getActivated()) {
            String codeStr2 = exchangeResponse.getCodeStr();
            String strQ2 = e50.f677a.Q(codeStr2);
            if (ec2.C(strQ2, "success", false, 2, null)) {
                hz0.f1282a.D0(codeStr2);
                qc2.d(xd2.a(qe2.b()), null, null, new vl1(this, null), 3, null);
                bVar.c();
                p80.a aVar4 = p80.f2403a;
                Activity activity4 = this.f2115a;
                String string5 = activity4.getString(u61.user_exchange_ok);
                f92.c(string5, "activity.getString(R.string.user_exchange_ok)");
                String string6 = this.f2115a.getString(u61.user_exchange_ok_old);
                f92.c(string6, "activity.getString(R.string.user_exchange_ok_old)");
                aVar4.y(activity4, string5, string6, new wl1(this));
                return;
            }
            p80.a aVar5 = p80.f2403a;
            Activity activity5 = this.f2115a;
            String string7 = activity5.getString(u61.user_exchange_fail);
            f92.c(string7, "activity.getString(R.string.user_exchange_fail)");
            aVar5.a(activity5, string7, this.f2115a.getString(u61.user_exchange_ok_old_error) + "\n\nResponse:\n" + exchangeResponse.getDetail() + "\n\n" + strQ2, xl1.f7902a);
            return;
        }
        if (!exchangeResponse.getFound()) {
            if (!exchangeResponse.getFound()) {
                p80.a aVar6 = p80.f2403a;
                Activity activity6 = this.f2115a;
                String string8 = activity6.getString(u61.user_exchange_fail);
                f92.c(string8, "activity.getString(R.string.user_exchange_fail)");
                String string9 = this.f2115a.getString(u61.user_exchange_invalid_desc);
                f92.c(string9, "activity.getString(R.str…er_exchange_invalid_desc)");
                p80.a.b(aVar6, activity6, string8, string9, null, 8, null);
                return;
            }
            p80.a aVar7 = p80.f2403a;
            Activity activity7 = this.f2115a;
            if (exchangeResponse.getError().length() > 0) {
                string = exchangeResponse.getError();
            } else {
                string = this.f2115a.getString(u61.user_exchange_fail);
                f92.c(string, "activity.getString(R.string.user_exchange_fail)");
            }
            p80.a.b(aVar7, activity7, string, this.f2115a.getString(u61.user_exchange_unknown_error2) + "\n\n" + exchangeResponse.getDetail(), null, 8, null);
            return;
        }
        if (exchangeResponse.getNumber() > exchangeResponse.getUsed()) {
            p80.a aVar8 = p80.f2403a;
            Activity activity8 = this.f2115a;
            String string10 = activity8.getString(u61.user_exchange_valid);
            f92.c(string10, "activity.getString(R.string.user_exchange_valid)");
            String strM = m(exchangeResponse);
            String string11 = this.f2115a.getString(u61.user_exchange_now);
            f92.c(string11, "activity.getString(R.string.user_exchange_now)");
            q80 q80Var = new q80(string11, new yl1(this, bVar, str), false, 4, null);
            String string12 = this.f2115a.getString(2131886518);
            f92.c(string12, "activity.getString(R.string.btn_cancel)");
            aVar8.h(activity8, string10, strM, q80Var, new q80(string12, null, false, 6, null)).i(false);
            return;
        }
        if (exchangeResponse.getError().length() > 0) {
            if (exchangeResponse.getDevices().length() == 0) {
                p80.a aVar9 = p80.f2403a;
                Activity activity9 = this.f2115a;
                String string13 = activity9.getString(u61.user_exchange_fail);
                f92.c(string13, "activity.getString(R.string.user_exchange_fail)");
                p80.a.b(aVar9, activity9, string13, exchangeResponse.getError(), null, 8, null);
                return;
            }
        }
        p80.a aVar10 = p80.f2403a;
        Activity activity10 = this.f2115a;
        String string14 = activity10.getString(u61.user_exchange_exhaust);
        f92.c(string14, "activity.getString(R.string.user_exchange_exhaust)");
        p80.a.b(aVar10, activity10, string14, this.f2115a.getString(u61.user_exchange_exhaust_desc2) + m(exchangeResponse), null, 8, null);
    }

    public final boolean o(String str) {
        return new nb2("20[0-9]{26}").f(str) || new nb2("10[0-9]{30}").f(str) || new nb2("[0-9A-Z]{17}").f(str);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, a.p80$b] */
    public final void p() {
        View viewInflate = LayoutInflater.from(this.f2115a).inflate(2131558526, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(2131362341);
        TextView textView = (TextView) viewInflate.findViewById(t61.account);
        View viewFindViewById = viewInflate.findViewById(t61.login);
        View viewFindViewById2 = viewInflate.findViewById(t61.payment);
        String strH = Scene.f4798a.h("order_id", "");
        if (!(strH == null || strH.length() == 0)) {
            editText.setText(strH);
        }
        f92.c(textView, "accountView");
        textView.setText("• " + hz0.f1282a.B0());
        n92 n92Var = new n92();
        n92Var.f6891a = null;
        p80.a aVar = p80.f2403a;
        Activity activity = this.f2115a;
        String string = activity.getString(u61.user_verify);
        f92.c(string, "activity.getString(R.string.user_verify)");
        ?? J = p80.a.j(aVar, activity, viewInflate, new q80(string, new bm1(this, editText, n92Var), false), null, 8, null);
        n92Var.f6891a = J;
        J.i(false);
        viewFindViewById.setOnClickListener(new dm1(this, n92Var));
        viewFindViewById2.setOnClickListener(new fm1(this, n92Var));
    }

    public final void q(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            this.f2115a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final void r(boolean z) {
        Scene.f4798a.i(new gm1(this, z));
    }

    public final void s(boolean z) {
        if (j()) {
            r(true);
            qc2.d(xd2.a(qe2.b()), null, null, new km1(this, hz0.f1282a.a(), z, null), 3, null);
        }
    }

    public final void t() {
        new zm1(this.f2115a, this.f2114a, new mm1(this)).j();
    }
}
