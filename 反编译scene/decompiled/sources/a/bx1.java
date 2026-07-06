package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.omarea.Scene;
import com.omarea.model.ActivatedStateModel;
import com.omarea.vtools.activities.ActivityStartSplash;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bx1 extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivatedStateModel f309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f310a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wv1 f5742a = new wv1(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f308a = a42.a(new vv1(this));
    public final z32 b = a42.a(new aw1(this));
    public final z32 c = a42.a(new ow1(this));

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xv1 f307a = new xv1(Scene.f4798a.c(), "pro_key_expire_date");

    public static /* synthetic */ String O1(bx1 bx1Var, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return bx1Var.N1(j, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        ((TextView) w1(t61.user_change_sn)).setOnClickListener(new cw1(this));
        ((LinearLayout) w1(t61.user_contact)).setOnClickListener(new dw1(this));
        ((TextView) w1(t61.user_go_pay)).setOnClickListener(new fw1(this));
        ((TextView) w1(t61.user_name)).setOnClickListener(new hw1(this));
        ((ImageView) w1(t61.user_avatar)).setOnClickListener(new jw1(this));
        ((TextView) w1(t61.user_sn)).setOnClickListener(kw1.f6649a);
        ((TextView) w1(t61.user_devices)).setOnClickListener(new lw1(this));
        ((TextView) w1(t61.user_upgrade)).setOnClickListener(new nw1(this));
        LinearLayout linearLayout = (LinearLayout) w1(t61.nav_gesture);
        f92.c(linearLayout, "nav_gesture");
        M1(linearLayout);
        LinearLayout linearLayout2 = (LinearLayout) w1(t61.nav_filter);
        f92.c(linearLayout2, "nav_filter");
        M1(linearLayout2);
        LinearLayout linearLayout3 = (LinearLayout) w1(t61.nav_share);
        f92.c(linearLayout3, "nav_share");
        M1(linearLayout3);
        LinearLayout linearLayout4 = (LinearLayout) w1(t61.nav_qq);
        f92.c(linearLayout4, "nav_qq");
        M1(linearLayout4);
        LinearLayout linearLayout5 = (LinearLayout) w1(t61.nav_insider_preview);
        f92.c(linearLayout5, "nav_insider_preview");
        M1(linearLayout5);
        Z1();
        X1();
    }

    public final void L1() {
        String strB0 = hz0.f1282a.B0();
        if (strB0 == null || strB0.length() == 0) {
            return;
        }
        u90.e(S1(), null, 1, null);
        qc2.d(xd2.a(qe2.b()), null, null, new ov1(this, strB0, null), 3, null);
    }

    public final void M1(View view) {
        view.setOnClickListener(this);
        if ((!f92.a(e50.f677a.y0(), "root")) && "root".equals(view.getTag())) {
            view.setEnabled(false);
        }
    }

    public final String N1(long j, String str) {
        String str2 = new SimpleDateFormat(str).format(new Date(j));
        f92.c(str2, "simpleDateFormat.format(Date(timestamp))");
        return str2;
    }

    public final void P1() {
        U1(new uv1(this));
    }

    public final nm1 Q1() {
        return (nm1) this.f308a.getValue();
    }

    public final om1 R1() {
        return (om1) this.b.getValue();
    }

    public final u90 S1() {
        return (u90) this.c.getValue();
    }

    public final void T1(String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
        try {
            s1(intent);
            m42 m42Var = m42.f6769a;
        } catch (Exception unused) {
            m42 m42Var2 = m42.f6769a;
        }
    }

    public final void U1(v72<m42> v72Var) {
        new no0().D(new bw1(this, v72Var));
    }

    public final void V1(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            s1(intent);
        } catch (Exception unused) {
        }
    }

    public final void W1() {
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        new jo1(clVarJ, this.f5742a, S1()).m();
    }

    public final void X1() {
        qc2.d(xd2.a(qe2.b()), null, null, new qw1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.String] */
    public final void Y1() {
        if (R()) {
            return;
        }
        String strJ = J(u61.user_unregistered);
        f92.c(strJ, "getString(R.string.user_unregistered)");
        String strB0 = hz0.f1282a.B0();
        TextView textView = (TextView) w1(t61.user_name);
        f92.c(textView, "user_name");
        if (!(strB0 == null || strB0.length() == 0)) {
            strJ = strB0;
        }
        textView.setText(strJ);
        n92 n92Var = new n92();
        n92Var.f6891a = J(u61.user_points) + "--";
        if (!(strB0 == null || strB0.length() == 0)) {
            qc2.d(xd2.a(qe2.b()), null, null, new tw1(this, strB0, n92Var, null), 3, null);
            return;
        }
        TextView textView2 = (TextView) w1(t61.user_points);
        if (textView2 != null) {
            textView2.setText((String) n92Var.f6891a);
        }
    }

    public final void Z1() {
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        Context applicationContext = contextP.getApplicationContext();
        f92.c(applicationContext, "context!!.applicationContext");
        ActivatedStateModel activatedStateModelD = new sn0(applicationContext).d();
        this.f309a = activatedStateModelD;
        TextView textView = (TextView) w1(t61.user_expire_date);
        f92.c(textView, "user_expire_date");
        textView.setText(activatedStateModelD.getText());
        if (activatedStateModelD.getActivated()) {
            ImageView imageView = (ImageView) w1(t61.user_logo);
            Context contextP2 = p();
            f92.b(contextP2);
            imageView.setImageDrawable(yb.d(contextP2, f92.a(activatedStateModelD.getType(), "perpetual") ? 2131231004 : 2131231009));
            TextView textView2 = (TextView) w1(t61.user_version);
            f92.c(textView2, "user_version");
            textView2.setText(activatedStateModelD.getTypeName());
            TextView textView3 = (TextView) w1(t61.user_upgrade);
            f92.c(textView3, "user_upgrade");
            textView3.setVisibility(f92.a(activatedStateModelD.getType(), "account") ? 0 : 8);
        } else {
            ImageView imageView2 = (ImageView) w1(t61.user_logo);
            Context contextP3 = p();
            f92.b(contextP3);
            imageView2.setImageDrawable(yb.d(contextP3, 2131231010));
            TextView textView4 = (TextView) w1(t61.user_version);
            f92.c(textView4, "user_version");
            textView4.setText(J(u61.user_free));
            if (f92.a(e50.f677a.y0(), "root")) {
                ActivityStartSplash.f8870a.b(false);
                cl clVarJ = j();
                if (clVarJ != null) {
                    clVarJ.finish();
                }
            }
        }
        String strA = new wm0().a();
        TextView textView5 = (TextView) w1(t61.user_sn);
        f92.c(textView5, "user_sn");
        textView5.setText("SN: " + strA);
        String strA2 = hz0.f1282a.a();
        if (!(strA2 == null || strA2.length() == 0) && strA2.length() >= 10) {
            TextView textView6 = (TextView) w1(t61.user_key_code);
            f92.c(textView6, "user_key_code");
            StringBuilder sb = new StringBuilder();
            sb.append("KEY: ");
            StringBuilder sb2 = new StringBuilder();
            if (strA2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strA2.substring(0, 4);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb2.append(strSubstring);
            sb2.append("***");
            int length = strA2.length() - 3;
            if (strA2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring2 = strA2.substring(length);
            f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring2);
            String string = sb2.toString();
            Locale locale = Locale.ENGLISH;
            f92.c(locale, "Locale.ENGLISH");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = string.toUpperCase(locale);
            f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            textView6.setText(sb.toString());
        }
        Y1();
    }

    public final void a2() {
        U1(new yw1(this));
    }

    public final void b2(String str) {
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        PackageManager packageManager = contextP.getPackageManager();
        if (str.equals("com.omarea.gesture")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setComponent(new ComponentName("com.omarea.gesture", "com.omarea.gesture.SettingsActivity"));
            s1(intent);
            return;
        }
        if (str.equals("com.omarea.filter")) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(268435456);
            intent2.setComponent(new ComponentName("com.omarea.filter", "com.omarea.filter.SettingsActivity"));
            s1(intent2);
            return;
        }
        try {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                s1(launchIntentForPackage);
                return;
            }
        } catch (Exception unused) {
        }
        V1("https://play.google.com/store/apps/details?id=" + str);
    }

    public final void c2() {
        String strB0 = hz0.f1282a.B0();
        if (strB0 == null || strB0.length() == 0) {
            return;
        }
        u90.e(S1(), null, 1, null);
        qc2.d(xd2.a(qe2.b()), null, null, new ax1(this, strB0, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        return layoutInflater.inflate(2131558558, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void j0() {
        S1().c();
        super.j0();
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        v1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view != null) {
            if ((!f92.a(e50.f677a.y0(), "root")) && "root".equals(view.getTag())) {
                Toast.makeText(view.getContext(), "没有获得ROOT权限，不能使用本功能", 0).show();
                return;
            }
            switch (view.getId()) {
                case 2131362707:
                    b2("com.omarea.filter");
                    return;
                case 2131362710:
                    b2("com.omarea.gesture");
                    return;
                case 2131362712:
                    string = "mqqapi://forward/url?src_type=web&style=default&plg_auth=1&version=1&url_prefix=aHR0cHM6Ly9wZC5xcS5jb20vcy8ybW80bnJicHo=";
                    break;
                case 2131362721:
                    T1("FNt6SyjNPzndLXNgAzGpmXEPI4T4haU1");
                    return;
                case 2131362724:
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", J(u61.share_link));
                    intent.setType("text/plain");
                    s1(intent);
                    return;
                case t61.pay_google /* 2131362766 */:
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://play.google.com/store/apps/details?id=");
                    Context context = view.getContext();
                    f92.c(context, "context");
                    sb.append(context.getPackageName());
                    string = sb.toString();
                    break;
                default:
                    return;
            }
            V1(string);
        }
    }

    public void v1() {
        HashMap map = this.f310a;
        if (map != null) {
            map.clear();
        }
    }

    public View w1(int i) {
        if (this.f310a == null) {
            this.f310a = new HashMap();
        }
        View view = (View) this.f310a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewM = M();
        if (viewM == null) {
            return null;
        }
        View viewFindViewById = viewM.findViewById(i);
        this.f310a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void z0() {
        super.z0();
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        clVarJ.setTitle(J(u61.app_name));
    }
}
