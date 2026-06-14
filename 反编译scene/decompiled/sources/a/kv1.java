package a;

import a.p80;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.omarea.Scene;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.vtools.activities.ActivityCpuControl;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kv1 extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f1691a;
    public String d = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wu0 f1689a = new wu0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f1690a = Scene.f4798a.c().getSharedPreferences(hz0.f1282a.l0(), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bv0 f6646a = new bv0();

    public static /* synthetic */ void Q1(kv1 kv1Var, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "normal";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        kv1Var.P1(str, z);
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        TextView textView;
        View.OnClickListener dv1Var;
        f92.d(view, "view");
        super.D0(view, bundle);
        ((Switch) w1(t61.dynamic_control)).setOnClickListener(new pu1(this));
        ((Switch) w1(t61.dynamic_control)).setOnCheckedChangeListener(new su1(this));
        ((Switch) w1(t61.pedestal_mode)).setOnClickListener(new tu1(this));
        Spinner spinner = (Spinner) w1(t61.first_mode);
        int iT = u42.t(new String[]{wu0.f3480a.p(), wu0.f3480a.c(), wu0.f3480a.o(), wu0.f3480a.i()}, this.f1690a.getString("*", wu0.f3480a.c()));
        if (iT > -1) {
            spinner.setSelection(iT);
        }
        spinner.setOnItemSelectedListener(new ft1(uu1.f7633a));
        ev1 ev1Var = new ev1(this);
        ((ImageButton) w1(t61.config_author_icon)).setOnClickListener(ev1Var);
        ((TextView) w1(t61.config_author)).setOnClickListener(ev1Var);
        ((BlurViewLinearLayout) w1(t61.nav_app_scene)).setOnClickListener(new wu1(this));
        w1(t61.nav_scene_service_not_active).setOnClickListener(new xu1(this));
        ((BlurViewLinearLayout) w1(t61.nav_skip_ad)).setOnClickListener(new yu1(this));
        if (f92.a(e50.f677a.y0(), "root")) {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) w1(t61.nav_more);
            f92.c(blurViewLinearLayout, "nav_more");
            blurViewLinearLayout.setVisibility(0);
            if (!this.f1689a.s() && this.f1689a.p() == null) {
                P1("normal", true);
            }
            String str = Build.MANUFACTURER;
            f92.c(str, "Build.MANUFACTURER");
            Locale locale = Locale.getDefault();
            f92.c(locale, "Locale.getDefault()");
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase(locale);
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (f92.a(lowerCase, "xiaomi")) {
                textView = (TextView) w1(t61.nav_thermal);
                dv1Var = new cv1(this);
            } else if ((f92.a(lowerCase, "oppo") || f92.a(lowerCase, "realme") || f92.a(lowerCase, "oneplus")) && e60.f698a.n()) {
                textView = (TextView) w1(t61.nav_thermal);
                dv1Var = new dv1(this);
            } else {
                if (f92.a(lowerCase, "meizu") && e60.f698a.n()) {
                    textView = (TextView) w1(t61.nav_thermal);
                    dv1Var = new hu1(this);
                }
                TextView textView2 = (TextView) w1(t61.nav_thermal);
                f92.c(textView2, "nav_thermal");
                textView2.setVisibility(8);
            }
            textView.setOnClickListener(dv1Var);
        } else {
            TextView textView22 = (TextView) w1(t61.nav_thermal);
            f92.c(textView22, "nav_thermal");
            textView22.setVisibility(8);
        }
        ((TextView) w1(t61.nav_freeze)).setOnClickListener(new iu1(this));
        ((Switch) w1(t61.extreme_performance_on)).setOnClickListener(ju1.f6547a);
        qc2.d(xd2.a(qe2.c()), null, null, new gu1(null, this), 3, null);
        ((TextView) w1(t61.custom_powersave)).setOnClickListener(new ku1(this));
        ((TextView) w1(t61.custom_balance)).setOnClickListener(new lu1(this));
        ((TextView) w1(t61.custom_performance)).setOnClickListener(new mu1(this));
        ((TextView) w1(t61.custom_fast)).setOnClickListener(new nu1(this));
        ((ImageButton) w1(t61.custom_features)).setOnClickListener(new ou1(this));
    }

    public final void L1(Runnable runnable) {
        if (!bv0.f5735a.a()) {
            runnable.run();
            return;
        }
        p80.a aVar = p80.f2403a;
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        String strJ = J(u61.make_choice);
        f92.c(strJ, "getString(R.string.make_choice)");
        String strJ2 = J(u61.schedule_remove_outside);
        f92.c(strJ2, "getString(R.string.schedule_remove_outside)");
        aVar.M(clVarJ, (16 & 2) != 0 ? "" : strJ, (16 & 4) != 0 ? "" : strJ2, (16 & 8) != 0 ? null : new gt1(this, runnable), (16 & 16) != 0 ? null : null);
    }

    public final void M1() {
        View viewInflate = w().inflate(2131558537, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, clVarJ, viewInflate, false, 4, null);
        String strA = jm0.f6525a.a();
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strA.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        View viewFindViewById = viewInflate.findViewById(t61.source_official_hp);
        View viewFindViewById2 = viewInflate.findViewById(t61.source_official_lp);
        View viewFindViewById3 = viewInflate.findViewById(t61.source_official_ep);
        View viewFindViewById4 = viewInflate.findViewById(t61.source_fas_rs);
        View viewFindViewById5 = viewInflate.findViewById(t61.help);
        viewFindViewById.setOnClickListener(new qt1(this, bVarT));
        if (Build.VERSION.SDK_INT <= 30 || !y42.c("mt6893", "mt6895", "mt6897", "mt6983", "mt6985", "mt6989", "lahaina", "waipio", "cape", "ukee", "kalama", "pineapple", "cliffs", "sun", "canoe").contains(lowerCase)) {
            viewFindViewById2.setVisibility(8);
        } else {
            viewFindViewById2.setOnClickListener(new it1(this, lowerCase, bVarT));
            qc2.d(xd2.a(qe2.b()), null, null, new tt1(viewFindViewById2, null), 3, null);
        }
        if (Build.VERSION.SDK_INT <= 30 || !y42.c("mt6895", "mt6897", "mt6899", "mt6983", "mt6985", "mt6989", "mt6991", "mt8799", "cape", "ukee", "kalama", "pineapple", "cliffs", "sun", "canoe").contains(lowerCase)) {
            viewFindViewById3.setVisibility(8);
        } else {
            viewFindViewById3.setOnClickListener(new kt1(this, lowerCase, bVarT));
        }
        if (Build.VERSION.SDK_INT > 30) {
            viewFindViewById4.setOnClickListener(new lt1(this));
        } else {
            viewFindViewById4.setVisibility(8);
        }
        viewInflate.findViewById(t61.source_download).setOnClickListener(new ut1(this, bVarT));
        viewInflate.findViewById(t61.source_download3).setOnClickListener(new vt1(this, bVarT));
        View viewFindViewById6 = viewInflate.findViewById(t61.source_custom);
        viewFindViewById6.setOnClickListener(new ot1(viewFindViewById6, this, bVarT));
        viewFindViewById5.setOnClickListener(new wt1(this));
    }

    public final void N1() {
        qc2.d(xd2.a(qe2.c()), null, null, new xt1(this, null), 3, null);
        z90.b(z90.f8048a, aa0.SCENE_CONFIG, null, 2, null);
    }

    public final void O1() {
        p80.a aVar = p80.f2403a;
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        String strJ = J(u61.tip);
        f92.c(strJ, "getString(R.string.tip)");
        String strJ2 = J(u61.schedule_fas_rs_summary);
        f92.c(strJ2, "getString(R.string.schedule_fas_rs_summary)");
        aVar.a(clVarJ, strJ, strJ2, new yt1(this));
    }

    public final void P1(String str, boolean z) {
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "this.context!!");
        Context applicationContext = contextP.getApplicationContext();
        f92.c(applicationContext, "this.context!!.applicationContext");
        qc2.d(xd2.a(qe2.b()), null, null, new du1(this, new ho0(applicationContext), str, z, !f92.a(Scene.f4798a.h(hz0.f1282a.x(), "normal"), str), null), 3, null);
    }

    public final void R1() {
        p80.a aVar = p80.f2403a;
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        String strJ = J(u61.tip);
        f92.c(strJ, "getString(R.string.tip)");
        String strJ2 = J(u61.schedule_uperf_summary);
        f92.c(strJ2, "getString(R.string.schedule_uperf_summary)");
        aVar.a(clVarJ, strJ, strJ2, new eu1(this));
    }

    public final void S1() {
        p80.a aVar = p80.f2403a;
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        String strJ = J(u61.tip);
        f92.c(strJ, "getString(R.string.tip)");
        String strJ2 = J(u61.schedule_uperf_gt_summary);
        f92.c(strJ2, "getString(R.string.schedule_uperf_gt_summary)");
        aVar.a(clVarJ, strJ, strJ2, new fu1(this));
    }

    public final boolean T1() {
        ar0 ar0VarP = this.f1689a.p();
        if (ar0VarP == null) {
            return false;
        }
        String strH = ar0VarP.h();
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strH == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strH.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return bc2.x(lowerCase, "uperf", false, 2, null) && ((ar0VarP.p() > 3L ? 1 : (ar0VarP.p() == 3L ? 0 : -1)) == 0 || ec2.C(lowerCase, "v3", false, 2, null));
    }

    public final void U1(String str) {
        Intent intent = new Intent(p(), (Class<?>) ActivityCpuControl.class);
        intent.putExtra("cpuModeName", str);
        s1(intent);
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
        if (!f92.a(wu0.f3480a.e(), "SOURCE_SCENE_ONLINE")) {
            bv0.j(new bv0(), false, 1, null);
            return;
        }
        String strA = jm0.f6525a.a();
        if (this.f1689a.s()) {
            if (!(strA.length() > 0) || !(!f92.a(Scene.f4798a.h("machine", strA), strA))) {
                Context contextP = p();
                f92.b(contextP);
                f92.c(contextP, "context!!");
                Context applicationContext = contextP.getApplicationContext();
                f92.c(applicationContext, "context!!.applicationContext");
                qc2.d(xd2.a(qe2.b()), null, null, new fv1(this, new ho0(applicationContext), null), 3, null);
                return;
            }
        }
        bv0 bv0Var = new bv0();
        bv0Var.e();
        bv0Var.d();
        Scene.f4798a.g().edit().remove(hz0.f1282a.y()).remove(hz0.f1282a.c0()).remove(hz0.f1282a.x()).putString("machine", strA).apply();
        P1("normal", true);
        try {
            e42 e42Var = g42.f6169a;
            a2();
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
    }

    public final void X1() {
        zg0 zg0Var = new zg0();
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        zg0Var.c(clVarJ, new gv1(this));
    }

    public final /* synthetic */ Object Y1(b62<? super m42> b62Var) {
        Object objS0 = e50.f677a.S0("", "", "stop", (112 & 8) != 0 ? "dynamic" : "manual", (112 & 16) != 0 ? "" : null, (112 & 32) != 0 ? false : false, (112 & 64) != 0 ? false : false, b62Var);
        return objS0 == r62.c() ? objS0 : m42.f6769a;
    }

    public final void Z1() {
        String str = this.d;
        int iHashCode = str.hashCode();
        if (iHashCode != -610722744) {
            if (iHashCode != -273856726) {
                if (iHashCode == 1873639777 && str.equals("SOURCE_OUTSIDE")) {
                    ar0 ar0VarP = this.f1689a.p();
                    if (ar0VarP != null) {
                        TextView textView = (TextView) w1(t61.custom_state);
                        f92.c(textView, "custom_state");
                        textView.setVisibility(0);
                        TextView textView2 = (TextView) w1(t61.custom_state);
                        f92.c(textView2, "custom_state");
                        textView2.setText("🌏 Version: " + ar0VarP.o() + " " + ar0VarP.p());
                    } else {
                        TextView textView3 = (TextView) w1(t61.custom_state);
                        f92.c(textView3, "custom_state");
                        textView3.setVisibility(8);
                    }
                    ImageButton imageButton = (ImageButton) w1(t61.custom_features);
                    f92.c(imageButton, "custom_features");
                    imageButton.setVisibility(0);
                }
            } else if (str.equals("SOURCE_SCENE_ONLINE")) {
                TextView textView4 = (TextView) w1(t61.custom_state);
                f92.c(textView4, "custom_state");
                textView4.setVisibility(0);
                ImageButton imageButton2 = (ImageButton) w1(t61.custom_features);
                f92.c(imageButton2, "custom_features");
                imageButton2.setVisibility(0);
                ar0 ar0VarP2 = this.f1689a.p();
                if (ar0VarP2 != null) {
                    TextView textView5 = (TextView) w1(t61.custom_state);
                    f92.c(textView5, "custom_state");
                    textView5.setText("🌍 Version: " + ar0VarP2.o() + " " + ar0VarP2.p());
                } else {
                    TextView textView6 = (TextView) w1(t61.custom_state);
                    f92.c(textView6, "custom_state");
                    textView6.setText("🌍 Version: " + Scene.f4798a.g().getLong(hz0.f1282a.y(), 0L));
                }
            }
            LinearLayout linearLayout = (LinearLayout) w1(t61.custom_modes);
            f92.c(linearLayout, "custom_modes");
            linearLayout.setVisibility(8);
        }
        if (str.equals("SOURCE_SCENE_CUSTOM")) {
            ImageButton imageButton3 = (ImageButton) w1(t61.custom_features);
            f92.c(imageButton3, "custom_features");
            imageButton3.setVisibility(0);
            TextView textView7 = (TextView) w1(t61.custom_state);
            f92.c(textView7, "custom_state");
            textView7.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) w1(t61.custom_modes);
            f92.c(linearLayout2, "custom_modes");
            linearLayout2.setVisibility(0);
            return;
        }
        TextView textView8 = (TextView) w1(t61.custom_state);
        f92.c(textView8, "custom_state");
        textView8.setVisibility(8);
        ImageButton imageButton4 = (ImageButton) w1(t61.custom_features);
        f92.c(imageButton4, "custom_features");
        imageButton4.setVisibility(8);
        LinearLayout linearLayout3 = (LinearLayout) w1(t61.custom_modes);
        f92.c(linearLayout3, "custom_modes");
        linearLayout3.setVisibility(8);
    }

    public final void a2() {
        if (R() || !Q()) {
            return;
        }
        if (!bv0.f5735a.a()) {
            this.f6646a.f();
        }
        this.d = wu0.f3480a.e();
        Z1();
        TextView textView = (TextView) w1(t61.config_author);
        f92.c(textView, "config_author");
        textView.setText(wu0.f3480a.f());
        zg0 zg0Var = new zg0();
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        boolean zA = zg0Var.a(contextP);
        boolean zB0 = hz0.f1282a.b0();
        Switch r2 = (Switch) w1(t61.dynamic_control);
        f92.c(r2, "dynamic_control");
        r2.setChecked(zB0 && (zA || hz0.f1282a.B()));
        View viewW1 = w1(t61.nav_scene_service_not_active);
        f92.c(viewW1, "nav_scene_service_not_active");
        int i = 8;
        viewW1.setVisibility(zA ? 8 : 0);
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) w1(t61.nav_skip_ad);
        f92.c(blurViewLinearLayout, "nav_skip_ad");
        blurViewLinearLayout.setVisibility(zA ? 0 : 8);
        qc2.d(xd2.a(qe2.b()), null, null, new iv1(this, zB0, null), 3, null);
        boolean zR = this.f1689a.r();
        if (!zR && hz0.f1282a.a0()) {
            hz0.f1282a.J0(false);
        }
        LinearLayout linearLayout = (LinearLayout) w1(t61.pedestal_mode_view);
        f92.c(linearLayout, "pedestal_mode_view");
        if (zR) {
            i = 0;
        } else {
            hz0.f1282a.J0(false);
        }
        linearLayout.setVisibility(i);
        ((Switch) w1(t61.pedestal_mode)).setOnCheckedChangeListener(new jv1(this));
        Switch r1 = (Switch) w1(t61.pedestal_mode);
        f92.c(r1, "pedestal_mode");
        r1.setChecked(zR && hz0.f1282a.a0());
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        return layoutInflater.inflate(2131558557, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        v1();
    }

    public void v1() {
        HashMap map = this.f1691a;
        if (map != null) {
            map.clear();
        }
    }

    public View w1(int i) {
        if (this.f1691a == null) {
            this.f1691a = new HashMap();
        }
        View view = (View) this.f1691a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewM = M();
        if (viewM == null) {
            return null;
        }
        View viewFindViewById = viewM.findViewById(i);
        this.f1691a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void z0() {
        super.z0();
        String str = this.d;
        try {
            e42 e42Var = g42.f6169a;
            a2();
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
        Switch r1 = (Switch) w1(t61.dynamic_control);
        f92.c(r1, "dynamic_control");
        if (r1.isChecked()) {
            if ((str.length() > 0) && (!f92.a(str, this.d))) {
                z90.b(z90.f8048a, aa0.SCENE_CONFIG, null, 2, null);
            }
        }
        W1();
    }
}
