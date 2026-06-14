package com.omarea.vtools.activities;

import a.b62;
import a.bc2;
import a.d72;
import a.e50;
import a.ec2;
import a.f92;
import a.fa0;
import a.fg2;
import a.g82;
import a.g91;
import a.g92;
import a.h42;
import a.hf2;
import a.hl0;
import a.i52;
import a.k82;
import a.m42;
import a.nl1;
import a.o91;
import a.oc2;
import a.p91;
import a.qc2;
import a.qe2;
import a.qx0;
import a.r62;
import a.sk1;
import a.t61;
import a.u61;
import a.vj0;
import a.wd2;
import a.x62;
import a.xd2;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.model.ChargeStatSession;
import com.omarea.ui.BatteryRealtimeStatus;
import com.omarea.ui.charge.ChargeCurveView;
import com.omarea.ui.charge.ChargeTempView;
import com.omarea.ui.charge.ChargeTimeView;
import java.util.HashMap;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityChargeStat extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hl0 f5198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx0 f5199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f5200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5202a;
    public int b;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new nl1().d(ActivityChargeStat.this);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeStat.this.startActivity(new Intent(ActivityChargeStat.this.getContext(), (Class<?>) ActivityPowerStat.class));
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityChargeStat$onCreate$3", f = "ActivityChargeStat.kt", l = {59}, m = "invokeSuspend")
    public static final class c extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8602a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5204a;
        public int b;

        public c(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            c cVar = ActivityChargeStat.this.new c(b62Var);
            cVar.f8602a = (wd2) obj;
            return cVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((c) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8602a;
                if (f92.a(e50.f677a.y0(), "root") && (ActivityChargeStat.this.f5198a.o() || ActivityChargeStat.this.f5198a.m() || ActivityChargeStat.this.f5198a.f())) {
                    fg2 fg2VarC = qe2.c();
                    o91 o91Var = new o91(this, null);
                    this.f5204a = wd2Var;
                    this.b = 1;
                    if (oc2.g(fg2VarC, o91Var, this) == objC) {
                        return objC;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean zK = ((ChargeCurveView) ActivityChargeStat.this._$_findCachedViewById(t61.view_speed)).k();
            f92.c(view, "it");
            view.setAlpha(zK ? 1.0f : 0.3f);
            TextView textView = (TextView) ActivityChargeStat.this._$_findCachedViewById(t61.power_mode_title);
            f92.c(textView, "power_mode_title");
            textView.setText(ActivityChargeStat.this.getString(zK ? u61.charge_power : u61.charge_current));
            ((ChargeCurveView) ActivityChargeStat.this._$_findCachedViewById(t61.view_speed)).l(ActivityChargeStat.this.b);
        }
    }

    public static final class e extends g92 implements g82<ChargeStatSession, m42> {
        public e() {
            super(1);
        }

        public final void a(ChargeStatSession chargeStatSession) {
            f92.d(chargeStatSession, "it");
            ActivityChargeStat.this.b = chargeStatSession.session;
            ActivityChargeStat.this.o();
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(ChargeStatSession chargeStatSession) {
            a(chargeStatSession);
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityChargeStat$updateUI$1", f = "ActivityChargeStat.kt", l = {174}, m = "invokeSuspend")
    public static final class f extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8605a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5206a;
        public int b;

        public f(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            f fVar = ActivityChargeStat.this.new f(b62Var);
            fVar.f8605a = (wd2) obj;
            return fVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((f) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8605a;
                BatteryRealtimeStatus batteryRealtimeStatus = (BatteryRealtimeStatus) ActivityChargeStat.this._$_findCachedViewById(t61.view_realtime_values);
                this.f5206a = wd2Var;
                this.b = 1;
                if (batteryRealtimeStatus.e(this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5207a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ boolean f5208b;

        public g(String str, boolean z, String str2) {
            this.f5207a = str;
            this.f5208b = z;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityChargeStat.this.setTitle(this.f5207a);
            BatteryRealtimeStatus batteryRealtimeStatus = (BatteryRealtimeStatus) ActivityChargeStat.this._$_findCachedViewById(t61.view_realtime_values);
            f92.c(batteryRealtimeStatus, "view_realtime_values");
            batteryRealtimeStatus.setVisibility(this.f5208b ? 0 : 8);
            ((ChargeCurveView) ActivityChargeStat.this._$_findCachedViewById(t61.view_speed)).l(ActivityChargeStat.this.b);
            ((ChargeTimeView) ActivityChargeStat.this._$_findCachedViewById(t61.view_time)).c(ActivityChargeStat.this.b);
            ((ChargeTempView) ActivityChargeStat.this._$_findCachedViewById(t61.view_temperature)).d(ActivityChargeStat.this.b);
            TextView textView = (TextView) ActivityChargeStat.this._$_findCachedViewById(t61.charge_sum);
            f92.c(textView, "charge_sum");
            textView.setText(this.b);
        }
    }

    public ActivityChargeStat() {
        qx0 qx0VarD = qx0.d();
        this.f5199a = qx0VarD;
        f92.c(qx0VarD, "storage");
        int iF = qx0VarD.f();
        this.f8599a = iF;
        this.b = iF;
        this.f5198a = new hl0();
        this.f5200a = new vj0();
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5201a == null) {
            this.f5201a = new HashMap();
        }
        View view = (View) this.f5201a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5201a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final String n() {
        double d2 = (fa0.f867a.p() > ((double) 5) ? 1 : (fa0.f867a.p() == ((double) 5) ? 0 : -1)) > 0 ? 7.74d : 3.87d;
        ChargeStatSession chargeStatSessionG = this.f5199a.g(this.b);
        int i = this.f5199a.i(d2, this.b);
        StringBuilder sb = new StringBuilder();
        sb.append(i >= 0 ? "+" : "");
        sb.append((i / 100) / 10.0f);
        sb.append("Wh");
        String string = sb.toString();
        if (chargeStatSessionG == null) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(chargeStatSessionG.capacityRatio < 0 ? "" : "+");
        sb2.append(chargeStatSessionG.capacityRatio);
        sb2.append("%");
        String string2 = sb2.toString();
        String strA = this.f5200a.a(chargeStatSessionG.beginTime);
        String str = ((String) i52.A(ec2.d0(strA, new String[]{" "}, false, 0, 6, null))) + " ";
        String strA2 = this.f5200a.a(chargeStatSessionG.endTime);
        if (ec2.C(strA2, str, false, 2, null)) {
            String strT = bc2.t(strA2, str, "", false, 4, null);
            strA = bc2.t(strA, str, str + ' ', false, 4, null);
            strA2 = strT;
        }
        return strA + " ~ " + strA2 + "\u3000\u3000" + this.f5200a.c((chargeStatSessionG.endTime - chargeStatSessionG.beginTime) / 60000.0d) + "\u3000\u3000" + string2 + "\u3000" + string;
    }

    public final void o() {
        String string;
        String strA;
        boolean z = this.f8599a == this.b;
        if (z) {
            string = getString(u61.menu_charge);
        } else {
            ChargeStatSession chargeStatSessionG = this.f5199a.g(this.b);
            if (chargeStatSessionG == null || (strA = this.f5200a.a(chargeStatSessionG.beginTime)) == null) {
                string = getString(u61.menu_charge);
                f92.c(string, "getString(R.string.menu_charge)");
            } else {
                string = strA;
            }
        }
        f92.c(string, "if (realtime) {\n        …ng.menu_charge)\n        }");
        if (z) {
            qc2.d(xd2.a(qe2.b()), null, null, new f(null), 3, null);
        }
        Scene.f4798a.i(new g(string, z, n()));
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558443);
        setBackArrow();
        ((TextView) _$_findCachedViewById(t61.electricity_adj_unit)).setOnClickListener(new a());
        ((TextView) _$_findCachedViewById(t61.more_battery_stats)).setOnClickListener(new b());
        qc2.d(hf2.f6309a, qe2.b(), null, new c(null), 2, null);
        ((ImageView) _$_findCachedViewById(t61.power_mode)).setOnClickListener(new d());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623942, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361908) {
            this.f5199a.n(this.b);
            Toast.makeText(getContext(), getString(u61.power_cleared), 0).show();
            qx0 qx0Var = this.f5199a;
            f92.c(qx0Var, "storage");
            this.b = qx0Var.f();
            o();
        } else if (itemId == 2131361913) {
            new sk1(this, getThemeMode(), this.b, new e()).B1(getSupportFragmentManager(), "BatteryRecords");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        Timer timer = this.f5202a;
        if (timer != null) {
            timer.cancel();
        }
        this.f5202a = null;
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_charge));
        Timer timer = new Timer("ActivityChargeTimer");
        timer.schedule(new p91(this), 40L, 2000L);
        m42 m42Var = m42.f6769a;
        this.f5202a = timer;
    }
}
