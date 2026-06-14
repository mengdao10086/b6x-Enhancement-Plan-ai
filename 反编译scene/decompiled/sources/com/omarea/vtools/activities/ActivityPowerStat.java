package com.omarea.vtools.activities;

import a.b62;
import a.d72;
import a.e50;
import a.f92;
import a.fa0;
import a.g82;
import a.g91;
import a.g92;
import a.h42;
import a.hf2;
import a.hl0;
import a.k82;
import a.kk1;
import a.m42;
import a.nl1;
import a.qc2;
import a.qe2;
import a.r62;
import a.ru0;
import a.t51;
import a.t61;
import a.u61;
import a.ve1;
import a.vj0;
import a.wd2;
import a.x62;
import a.xd2;
import a.xe1;
import a.ye1;
import a.zg0;
import a.zy0;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.Scene;
import com.omarea.model.PowerStatAVG;
import com.omarea.model.PowerStatSession;
import com.omarea.ui.power.PowerStatView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityPowerStat extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hl0 f5446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f5447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zy0 f5448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5449a;
    public int b;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new nl1().d(ActivityPowerStat.this);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityPowerStat.this.startActivity(new Intent(ActivityPowerStat.this.getContext(), (Class<?>) ActivityChargeStat.class));
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerStat$onCreate$3", f = "ActivityPowerStat.kt", l = {}, m = "invokeSuspend")
    public static final class c extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8846a;
        public int b;

        public c(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            c cVar = ActivityPowerStat.this.new c(b62Var);
            cVar.f8846a = (wd2) obj;
            return cVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((c) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            if (f92.a(e50.f677a.y0(), "root") && (ActivityPowerStat.this.f5446a.o() || ActivityPowerStat.this.f5446a.m() || ActivityPowerStat.this.f5446a.f())) {
                TextView textView = (TextView) ActivityPowerStat.this._$_findCachedViewById(t61.charge_controller);
                f92.c(textView, "charge_controller");
                textView.setVisibility(0);
                ((TextView) ActivityPowerStat.this._$_findCachedViewById(t61.charge_controller)).setOnClickListener(new ve1(this));
            }
            return m42.f6769a;
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ((PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time)).setLadder(!((PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time)).getLadder());
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ((PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time)).setShowIcons(!((PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time)).getShowIcons());
            ((PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time)).g();
            Scene.f4798a.k("power_show_icons", ((PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time)).getShowIcons());
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean z = !Scene.f4798a.b("pu_sort_with_sum", true);
            Scene.f4798a.k("pu_sort_with_sum", z);
            f92.c(view, "it");
            view.setAlpha(z ? 1.0f : 0.3f);
            RecyclerView recyclerView = (RecyclerView) ActivityPowerStat.this._$_findCachedViewById(t61.battery_stats);
            f92.c(recyclerView, "battery_stats");
            RecyclerView.g adapter = recyclerView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.power.AdapterBatteryStats");
            }
            ((t51) adapter).A(z);
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean z = !Scene.f4798a.b("pu_watt_mode", true);
            Scene.f4798a.k("pu_watt_mode", z);
            f92.c(view, "it");
            view.setAlpha(z ? 1.0f : 0.3f);
            ActivityPowerStat.this.p();
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityPowerStat.this.o();
        }
    }

    public static final class i extends g92 implements g82<PowerStatSession, m42> {
        public i() {
            super(1);
        }

        public final void a(PowerStatSession powerStatSession) {
            f92.d(powerStatSession, "it");
            ActivityPowerStat.this.b = powerStatSession.session;
            ActivityPowerStat.this.p();
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(PowerStatSession powerStatSession) {
            a(powerStatSession);
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerStat$updateUI$1", f = "ActivityPowerStat.kt", l = {}, m = "invokeSuspend")
    public static final class j extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ru0 f8853a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5451a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5453a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ArrayList arrayList, ru0 ru0Var, b62 b62Var) {
            super(2, b62Var);
            this.f5453a = arrayList;
            this.f8853a = ru0Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            j jVar = ActivityPowerStat.this.new j(this.f5453a, this.f8853a, b62Var);
            jVar.f5451a = (wd2) obj;
            return jVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((j) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            ArrayList<PowerStatAVG> arrayList = this.f5453a;
            f92.c(arrayList, "data");
            for (PowerStatAVG powerStatAVG : arrayList) {
                ru0 ru0Var = this.f8853a;
                String str = powerStatAVG.packageName;
                f92.c(str, "it.packageName");
                ru0Var.j(str);
            }
            Scene.f4798a.i(new ye1(this));
            return m42.f6769a;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f8854a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ float f5454a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ int f5455a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long f5456a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5458a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5459a;
        public final /* synthetic */ double b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ String f5460b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ boolean f5461b;
        public final /* synthetic */ double c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final /* synthetic */ boolean f5462c;

        public k(String str, boolean z, boolean z2, ArrayList arrayList, long j, String str2, double d, float f, int i, double d2, double d3) {
            this.f5458a = str;
            this.f5461b = z;
            this.f5462c = z2;
            this.f5459a = arrayList;
            this.f5456a = j;
            this.f5460b = str2;
            this.f8854a = d;
            this.f5454a = f;
            this.f5455a = i;
            this.b = d2;
            this.c = d3;
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x0283  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 853
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityPowerStat.k.run():void");
        }
    }

    public ActivityPowerStat() {
        zy0 zy0VarE = zy0.e();
        this.f5448a = zy0VarE;
        f92.c(zy0VarE, "storage");
        int iH = zy0VarE.h();
        this.f8843a = iH;
        this.b = iH;
        this.f5446a = new hl0();
        this.f5447a = new vj0();
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5449a == null) {
            this.f5449a = new HashMap();
        }
        View view = (View) this.f5449a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5449a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    public final void o() {
        qc2.d(xd2.a(qe2.b()), null, null, new xe1(new zg0(), null, this), 3, null);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558462);
        setBackArrow();
        ((TextView) _$_findCachedViewById(t61.electricity_adj_unit)).setOnClickListener(new a());
        ((TextView) _$_findCachedViewById(t61.more_charge)).setOnClickListener(new b());
        qc2.d(hf2.f6309a, qe2.c(), null, new c(null), 2, null);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.battery_stats);
        f92.c(recyclerView, "battery_stats");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.H2(1);
        linearLayoutManager.J2(false);
        m42 m42Var = m42.f6769a;
        recyclerView.setLayoutManager(linearLayoutManager);
        ((TextView) _$_findCachedViewById(t61.view_time_title)).setOnClickListener(new d());
        ((PowerStatView) _$_findCachedViewById(t61.view_time)).setOnClickListener(new e());
        ((PowerStatView) _$_findCachedViewById(t61.view_time)).setShowIcons(Scene.f4798a.b("power_show_icons", true));
        ImageView imageView = (ImageView) _$_findCachedViewById(t61.sort_by_time);
        f92.c(imageView, "sort_by_time");
        imageView.setAlpha(Scene.f4798a.b("pu_sort_with_sum", true) ? 1.0f : 0.3f);
        ((ImageView) _$_findCachedViewById(t61.sort_by_time)).setOnClickListener(new f());
        ImageView imageView2 = (ImageView) _$_findCachedViewById(t61.watt_mode);
        f92.c(imageView2, "watt_mode");
        imageView2.setAlpha(Scene.f4798a.b("pu_watt_mode", true) ? 1.0f : 0.3f);
        ((ImageView) _$_findCachedViewById(t61.watt_mode)).setOnClickListener(new g());
        _$_findCachedViewById(t61.nav_scene_service_not_active).setOnClickListener(new h());
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
            this.f5448a.o(this.b);
            Toast.makeText(getContext(), getString(u61.power_cleared), 0).show();
            p();
            ((PowerStatView) _$_findCachedViewById(t61.view_time)).g();
        } else if (itemId == 2131361913) {
            new kk1(this, getThemeMode(), this.b, new i()).B1(getSupportFragmentManager(), "BatteryRecords");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_power_utilization));
        p();
    }

    public final void p() {
        String string;
        int iA = fa0.f867a.a();
        double dO = fa0.f867a.o();
        float fL = this.f5446a.l(iA);
        double dP = fa0.f867a.p();
        ArrayList<PowerStatAVG> arrayListB = this.f5448a.b(this.b);
        qc2.d(xd2.a(qe2.b()), null, null, new j(arrayListB, new ru0(this, true, 0, 4, null), null), 3, null);
        String strC = this.f5447a.c(((double) (this.f5448a.i(this.b) * ((int) 3))) / 60.0d);
        double dAbs = Math.abs(this.f5448a.c(this.b));
        ((PowerStatView) _$_findCachedViewById(t61.view_time)).setSessionId(this.b);
        boolean zA = new zg0().a(getContext());
        boolean z = this.f8843a == this.b;
        if (z) {
            string = getString(u61.menu_power_utilization);
        } else {
            PowerStatSession powerStatSessionJ = this.f5448a.j(this.b);
            if (powerStatSessionJ == null || (string = this.f5447a.a(powerStatSessionJ.beginTime)) == null) {
                string = getString(u61.menu_charge);
                f92.c(string, "getString(R.string.menu_charge)");
            }
        }
        String str = string;
        f92.c(str, "if (realtime) {\n        …ng.menu_charge)\n        }");
        Scene.f4798a.i(new k(str, zA, z, arrayListB, 3L, strC, dAbs, fL, iA, dP, dO));
    }
}
