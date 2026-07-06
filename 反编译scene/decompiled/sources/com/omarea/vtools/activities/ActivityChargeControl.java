package com.omarea.vtools.activities;

import a.aa0;
import a.b62;
import a.bc2;
import a.d72;
import a.ec2;
import a.f92;
import a.g91;
import a.h42;
import a.hf2;
import a.hl0;
import a.hz0;
import a.j91;
import a.k82;
import a.k91;
import a.l91;
import a.ln1;
import a.m42;
import a.m91;
import a.n92;
import a.pn1;
import a.q92;
import a.qc2;
import a.qe2;
import a.qi0;
import a.r62;
import a.rh0;
import a.t61;
import a.u61;
import a.wd2;
import a.x62;
import a.xd2;
import a.z90;
import a.zj0;
import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.ui.BlurViewLinearLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityChargeControl extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hl0 f8575a = new hl0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f5189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5191a;
    public boolean b;
    public boolean c;
    public boolean d;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SharedPreferences f8576a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f5192a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5193a;

        public a(Runnable runnable, SharedPreferences sharedPreferences, TextView textView) {
            f92.d(runnable, "next");
            f92.d(sharedPreferences, "spf");
            f92.d(textView, "settings_qc_limit_desc");
            this.f5193a = runnable;
            this.f8576a = sharedPreferences;
            this.f5192a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f5192a.setText("" + (i * 100) + "mA");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            f92.b(seekBar);
            int progress = seekBar.getProgress() * 100;
            if (this.f8576a.getInt(hz0.f1282a.r(), hz0.f1282a.s()) == progress) {
                return;
            }
            this.f8576a.edit().putInt(hz0.f1282a.r(), progress).apply();
            this.f5193a.run();
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SharedPreferences f8577a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f5194a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5195a;

        public b(Runnable runnable, SharedPreferences sharedPreferences, TextView textView) {
            f92.d(runnable, "next");
            f92.d(sharedPreferences, "spf");
            f92.d(textView, "battery_bp_level_desc");
            this.f5195a = runnable;
            this.f8577a = sharedPreferences;
            this.f5194a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView textView = this.f5194a;
            q92 q92Var = q92.f7191a;
            String string = textView.getContext().getString(u61.battery_bp_status);
            f92.c(string, "battery_bp_level_desc.co…string.battery_bp_status)");
            String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i + 30), Integer.valueOf(i + 10)}, 2));
            f92.c(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            f92.b(seekBar);
            int progress = seekBar.getProgress() + 30;
            if (this.f8577a.getInt(hz0.f1282a.h(), Integer.MIN_VALUE) == progress) {
                return;
            }
            this.f8577a.edit().putInt(hz0.f1282a.h(), progress).apply();
            this.f5195a.run();
        }
    }

    public static final class c implements ln1 {
        public int c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8578a = 1000;
        public int b = 20000;

        public c() {
            this.c = ActivityChargeControl.this.f8575a.j();
        }

        @Override // a.ln1
        public int a() {
            return this.f8578a;
        }

        @Override // a.ln1
        public void b(int i) {
            ActivityChargeControl.this.f8575a.y(i);
            ActivityChargeControl.this.v();
        }

        @Override // a.ln1
        public int c() {
            return this.b;
        }

        @Override // a.ln1
        public int d() {
            return this.c;
        }
    }

    public static final class d implements ln1 {
        public int c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8579a = -1;
        public int b = 100;

        public d() {
            this.c = ActivityChargeControl.this.f8575a.i();
        }

        @Override // a.ln1
        public int a() {
            return this.f8579a;
        }

        @Override // a.ln1
        public void b(int i) {
            ActivityChargeControl.this.f8575a.x(i);
            ActivityChargeControl.this.v();
        }

        @Override // a.ln1
        public int c() {
            return this.b;
        }

        @Override // a.ln1
        public int d() {
            return this.c;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityChargeControl$notifyConfigChanged$1", f = "ActivityChargeControl.kt", l = {}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8580a;
        public int b;

        public e(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = new e(b62Var);
            eVar.f8580a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            z90.b(z90.f8048a, aa0.CHARGE_CONFIG_CHANGED, null, 2, null);
            return m42.f6769a;
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeControl.this.f8575a.s();
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeControl.this.f8575a.w();
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = ActivityChargeControl.o(ActivityChargeControl.this).getInt(hz0.f1282a.t(), hz0.f1282a.u());
            new TimePickerDialog(ActivityChargeControl.this.getContext(), new k91(this), i / 60, i % 60, true).show();
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = ActivityChargeControl.o(ActivityChargeControl.this).getInt(hz0.f1282a.v(), hz0.f1282a.w());
            new TimePickerDialog(ActivityChargeControl.this.getContext(), new l91(this), i / 60, i % 60, true).show();
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            CompoundButton compoundButton = (CompoundButton) view;
            boolean zIsChecked = compoundButton.isChecked();
            if (!zIsChecked || ActivityChargeControl.o(ActivityChargeControl.this).getBoolean(hz0.f1282a.q(), false)) {
                ActivityChargeControl.o(ActivityChargeControl.this).edit().putBoolean(hz0.f1282a.p(), zIsChecked).apply();
                ActivityChargeControl.this.u();
                return;
            }
            Toast.makeText(ActivityChargeControl.this.getContext(), ActivityChargeControl.this.getString(u61.battery_require) + " " + ActivityChargeControl.this.getString(u61.battery_qc_charger), 1).show();
            compoundButton.setChecked(false);
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Scene.c cVar;
            int i;
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            boolean zIsChecked = ((CompoundButton) view).isChecked();
            ActivityChargeControl.o(ActivityChargeControl.this).edit().putBoolean(hz0.f1282a.q(), zIsChecked).apply();
            if (zIsChecked) {
                ActivityChargeControl.this.u();
                cVar = Scene.f4798a;
                i = u61.battery_auto_boot_desc;
            } else {
                cVar = Scene.f4798a;
                i = u61.battery_qc_rehoot_desc;
            }
            cVar.n(i, 1);
        }
    }

    public static final class l implements CompoundButton.OnCheckedChangeListener {
        public l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LinearLayout linearLayout = (LinearLayout) ActivityChargeControl.this._$_findCachedViewById(t61.battery_charge_speed_ext);
            f92.c(linearLayout, "battery_charge_speed_ext");
            linearLayout.setVisibility(z ? 0 : 8);
            if (z) {
                return;
            }
            Switch r3 = (Switch) ActivityChargeControl.this._$_findCachedViewById(t61.battery_night_mode);
            f92.c(r3, "battery_night_mode");
            r3.setChecked(false);
            ActivityChargeControl.o(ActivityChargeControl.this).edit().putBoolean(hz0.f1282a.p(), false).apply();
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SharedPreferences.Editor editorEdit = ActivityChargeControl.o(ActivityChargeControl.this).edit();
            String strG = hz0.f1282a.g();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            CompoundButton compoundButton = (CompoundButton) view;
            editorEdit.putBoolean(strG, compoundButton.isChecked()).apply();
            if (!compoundButton.isChecked()) {
                ActivityChargeControl.this.f8575a.w();
            } else {
                ActivityChargeControl.this.u();
                Scene.f4798a.n(u61.battery_auto_boot_desc, 1);
            }
        }
    }

    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SharedPreferences.Editor editorEdit = ActivityChargeControl.o(ActivityChargeControl.this).edit();
            String strJ = hz0.f1282a.j();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            CompoundButton compoundButton = (CompoundButton) view;
            editorEdit.putBoolean(strJ, compoundButton.isChecked()).apply();
            if (!compoundButton.isChecked()) {
                ActivityChargeControl.this.f8575a.w();
            } else {
                ActivityChargeControl.this.u();
                Scene.f4798a.n(u61.battery_auto_boot_desc, 1);
            }
        }
    }

    public static final class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityChargeControl.this.u();
        }
    }

    public static final class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = ActivityChargeControl.o(ActivityChargeControl.this).getInt(hz0.f1282a.r(), hz0.f1282a.s());
            if (ActivityChargeControl.o(ActivityChargeControl.this).getBoolean(hz0.f1282a.q(), false)) {
                hl0.A(ActivityChargeControl.this.f8575a, i, false, 2, null);
            }
            ActivityChargeControl.this.u();
        }
    }

    public static final class q implements rh0<String> {
        public q() {
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            return "" + ActivityChargeControl.o(ActivityChargeControl.this).getInt(hz0.f1282a.r(), hz0.f1282a.s()) + "mA";
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            f92.d(str, "value");
            String string = ec2.r0(str).toString();
            Locale locale = Locale.ENGLISH;
            f92.c(locale, "Locale.ENGLISH");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = string.toLowerCase(locale);
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strT = bc2.t(lowerCase, "ma", "", false, 4, null);
            try {
                int i = Integer.parseInt(strT);
                ActivityChargeControl.o(ActivityChargeControl.this).edit().putInt(hz0.f1282a.r(), Integer.parseInt(strT)).apply();
                if (ActivityChargeControl.o(ActivityChargeControl.this).getBoolean(hz0.f1282a.q(), false)) {
                    qc2.d(xd2.a(qe2.b()), null, null, new m91(this, i, null), 3, null);
                }
                SeekBar seekBar = (SeekBar) ActivityChargeControl.this._$_findCachedViewById(t61.settings_qc_limit);
                f92.c(seekBar, "settings_qc_limit");
                seekBar.setProgress(i / 100);
                ActivityChargeControl.this.u();
            } catch (Exception unused) {
            }
        }
    }

    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            ActivityChargeControl.this.f8575a.B(((CompoundButton) view).isChecked());
        }
    }

    public static final class s implements View.OnClickListener {
        public s() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            hl0 hl0Var = ActivityChargeControl.this.f8575a;
            if (view == 0) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Checkable");
            }
            hl0Var.C(((Checkable) view).isChecked());
        }
    }

    public static final class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeControl.this.s();
        }
    }

    public static final class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeControl activityChargeControl = ActivityChargeControl.this;
            Toast.makeText(activityChargeControl, activityChargeControl.getString(u61.device_unsupport), 0).show();
        }
    }

    public static final class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeControl.this.r();
        }
    }

    public static final class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityChargeControl activityChargeControl = ActivityChargeControl.this;
            Toast.makeText(activityChargeControl, activityChargeControl.getString(u61.device_unsupport), 0).show();
        }
    }

    public static final /* synthetic */ SharedPreferences o(ActivityChargeControl activityChargeControl) {
        SharedPreferences sharedPreferences = activityChargeControl.f5189a;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        f92.m("spf");
        throw null;
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5190a == null) {
            this.f5190a = new HashMap();
        }
        View view = (View) this.f5190a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5190a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558442);
        setBackArrow();
        onViewCreated();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
        Timer timer = this.f5191a;
        if (timer != null) {
            f92.b(timer);
            timer.cancel();
            this.f5191a = null;
        }
    }

    @Override // a.g91, a.cl, android.app.Activity
    @SuppressLint({"ApplySharedPref", "SetTextI18n"})
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_charge_control));
        Switch r0 = (Switch) _$_findCachedViewById(t61.settings_qc);
        f92.c(r0, "settings_qc");
        SharedPreferences sharedPreferences = this.f5189a;
        if (sharedPreferences == null) {
            f92.m("spf");
            throw null;
        }
        r0.setChecked(sharedPreferences.getBoolean(hz0.f1282a.q(), false));
        Switch r02 = (Switch) _$_findCachedViewById(t61.settings_bp);
        f92.c(r02, "settings_bp");
        SharedPreferences sharedPreferences2 = this.f5189a;
        if (sharedPreferences2 == null) {
            f92.m("spf");
            throw null;
        }
        r02.setChecked(sharedPreferences2.getBoolean(hz0.f1282a.g(), false));
        Switch r03 = (Switch) _$_findCachedViewById(t61.settings_cdp_disable);
        f92.c(r03, "settings_cdp_disable");
        SharedPreferences sharedPreferences3 = this.f5189a;
        if (sharedPreferences3 == null) {
            f92.m("spf");
            throw null;
        }
        r03.setChecked(sharedPreferences3.getBoolean(hz0.f1282a.j(), false));
        SharedPreferences sharedPreferences4 = this.f5189a;
        if (sharedPreferences4 == null) {
            f92.m("spf");
            throw null;
        }
        int i2 = sharedPreferences4.getInt(hz0.f1282a.h(), hz0.f1282a.i());
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(t61.settings_bp_level);
        f92.c(seekBar, "settings_bp_level");
        seekBar.setProgress(i2 - 30);
        TextView textView = (TextView) _$_findCachedViewById(t61.battery_bp_level_desc);
        f92.c(textView, "battery_bp_level_desc");
        q92 q92Var = q92.f7191a;
        TextView textView2 = (TextView) _$_findCachedViewById(t61.battery_bp_level_desc);
        f92.c(textView2, "battery_bp_level_desc");
        String string = textView2.getContext().getString(u61.battery_bp_status);
        f92.c(string, "battery_bp_level_desc.co…string.battery_bp_status)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i2 - 20)}, 2));
        f92.c(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(t61.settings_qc_limit);
        f92.c(seekBar2, "settings_qc_limit");
        SharedPreferences sharedPreferences5 = this.f5189a;
        if (sharedPreferences5 == null) {
            f92.m("spf");
            throw null;
        }
        seekBar2.setProgress(sharedPreferences5.getInt(hz0.f1282a.r(), hz0.f1282a.s()) / 100);
        EditText editText = (EditText) _$_findCachedViewById(t61.settings_qc_limit_desc);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        SharedPreferences sharedPreferences6 = this.f5189a;
        if (sharedPreferences6 == null) {
            f92.m("spf");
            throw null;
        }
        sb.append(sharedPreferences6.getInt(hz0.f1282a.r(), hz0.f1282a.s()));
        sb.append("mA");
        editText.setText(sb.toString());
        String str2 = String.valueOf(new zj0().a(this)) + "mAh   ";
        n92 n92Var = new n92();
        n92Var.f6891a = "";
        n92 n92Var2 = new n92();
        n92 n92Var3 = new n92();
        Timer timer = new Timer("ActivityChargeController");
        timer.schedule(new j91(this, n92Var, n92Var2, n92Var3), 0L, 3000L);
        m42 m42Var = m42.f6769a;
        this.f5191a = timer;
        v();
    }

    public final void onViewCreated() {
        SharedPreferences sharedPreferences = getSharedPreferences(hz0.f1282a.f(), 0);
        f92.c(sharedPreferences, "getSharedPreferences(Spf…PF, Context.MODE_PRIVATE)");
        this.f5189a = sharedPreferences;
        this.b = this.f8575a.o();
        this.c = this.f8575a.v();
        boolean z = !this.b && this.f8575a.m();
        this.d = z;
        if (z) {
            TextView textView = (TextView) _$_findCachedViewById(t61.settings_qc_limit_current);
            f92.c(textView, "settings_qc_limit_current");
            textView.setVisibility(8);
        }
        ((Switch) _$_findCachedViewById(t61.settings_qc)).setOnClickListener(new k());
        ((Switch) _$_findCachedViewById(t61.settings_qc)).setOnCheckedChangeListener(new l());
        ((Switch) _$_findCachedViewById(t61.settings_bp)).setOnClickListener(new m());
        ((Switch) _$_findCachedViewById(t61.settings_cdp_disable)).setOnClickListener(new n());
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(t61.settings_bp_level);
        o oVar = new o();
        SharedPreferences sharedPreferences2 = this.f5189a;
        if (sharedPreferences2 == null) {
            f92.m("spf");
            throw null;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(t61.battery_bp_level_desc);
        f92.c(textView2, "battery_bp_level_desc");
        seekBar.setOnSeekBarChangeListener(new b(oVar, sharedPreferences2, textView2));
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(t61.settings_qc_limit);
        p pVar = new p();
        SharedPreferences sharedPreferences3 = this.f5189a;
        if (sharedPreferences3 == null) {
            f92.m("spf");
            throw null;
        }
        EditText editText = (EditText) _$_findCachedViewById(t61.settings_qc_limit_desc);
        f92.c(editText, "settings_qc_limit_desc");
        seekBar2.setOnSeekBarChangeListener(new a(pVar, sharedPreferences3, editText));
        qi0 qi0Var = new qi0(null, 1, null);
        EditText editText2 = (EditText) _$_findCachedViewById(t61.settings_qc_limit_desc);
        f92.c(editText2, "settings_qc_limit_desc");
        qi0Var.f(editText2, new q());
        double dA = new zj0().a(this);
        SeekBar seekBar3 = (SeekBar) _$_findCachedViewById(t61.settings_qc_limit);
        f92.c(seekBar3, "settings_qc_limit");
        seekBar3.setMax(dA > ((double) 4000) ? 220 : dA > ((double) 3900) ? 100 : dA >= ((double) 3000) ? 60 : 45);
        if (!this.b && !this.d) {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.settings_qc_panel);
            f92.c(blurViewLinearLayout, "settings_qc_panel");
            blurViewLinearLayout.setVisibility(8);
            SharedPreferences sharedPreferences4 = this.f5189a;
            if (sharedPreferences4 == null) {
                f92.m("spf");
                throw null;
            }
            sharedPreferences4.edit().putBoolean(hz0.f1282a.q(), false).putBoolean(hz0.f1282a.p(), false).apply();
        }
        if (this.f8575a.f()) {
            BlurViewLinearLayout blurViewLinearLayout2 = (BlurViewLinearLayout) _$_findCachedViewById(t61.bp_cardview);
            f92.c(blurViewLinearLayout2, "bp_cardview");
            blurViewLinearLayout2.setVisibility(0);
        } else {
            Switch r0 = (Switch) _$_findCachedViewById(t61.settings_bp);
            f92.c(r0, "settings_bp");
            r0.setEnabled(false);
            SharedPreferences sharedPreferences5 = this.f5189a;
            if (sharedPreferences5 == null) {
                f92.m("spf");
                throw null;
            }
            sharedPreferences5.edit().putBoolean(hz0.f1282a.g(), false).apply();
            BlurViewLinearLayout blurViewLinearLayout3 = (BlurViewLinearLayout) _$_findCachedViewById(t61.bp_cardview);
            f92.c(blurViewLinearLayout3, "bp_cardview");
            blurViewLinearLayout3.setVisibility(8);
        }
        if (this.c) {
            BlurViewLinearLayout blurViewLinearLayout4 = (BlurViewLinearLayout) _$_findCachedViewById(t61.settings_pd_support);
            f92.c(blurViewLinearLayout4, "settings_pd_support");
            blurViewLinearLayout4.setVisibility(0);
            ((Switch) _$_findCachedViewById(t61.settings_pd)).setOnClickListener(new r());
            Switch r02 = (Switch) _$_findCachedViewById(t61.settings_pd);
            f92.c(r02, "settings_pd");
            r02.setChecked(this.f8575a.u());
            TextView textView3 = (TextView) _$_findCachedViewById(t61.settings_pd_state);
            f92.c(textView3, "settings_pd_state");
            textView3.setText(getString(this.f8575a.t() ? u61.battery_pd_active_1 : u61.battery_pd_active_0));
        } else {
            BlurViewLinearLayout blurViewLinearLayout5 = (BlurViewLinearLayout) _$_findCachedViewById(t61.settings_pd_support);
            f92.c(blurViewLinearLayout5, "settings_pd_support");
            blurViewLinearLayout5.setVisibility(8);
        }
        if (this.f8575a.D()) {
            BlurViewLinearLayout blurViewLinearLayout6 = (BlurViewLinearLayout) _$_findCachedViewById(t61.settings_step_charge);
            f92.c(blurViewLinearLayout6, "settings_step_charge");
            blurViewLinearLayout6.setVisibility(0);
            ((Switch) _$_findCachedViewById(t61.settings_step_charge_enabled)).setOnClickListener(new s());
            Switch r03 = (Switch) _$_findCachedViewById(t61.settings_step_charge_enabled);
            f92.c(r03, "settings_step_charge_enabled");
            r03.setChecked(this.f8575a.q());
        } else {
            BlurViewLinearLayout blurViewLinearLayout7 = (BlurViewLinearLayout) _$_findCachedViewById(t61.settings_step_charge);
            f92.c(blurViewLinearLayout7, "settings_step_charge");
            blurViewLinearLayout7.setVisibility(8);
        }
        ((Button) _$_findCachedViewById(t61.bp_disable_charge)).setOnClickListener(new f());
        ((Button) _$_findCachedViewById(t61.bp_enable_charge)).setOnClickListener(new g());
        TextView textView4 = (TextView) _$_findCachedViewById(t61.battery_get_up);
        f92.c(textView4, "battery_get_up");
        SharedPreferences sharedPreferences6 = this.f5189a;
        if (sharedPreferences6 == null) {
            f92.m("spf");
            throw null;
        }
        textView4.setText(t(sharedPreferences6.getInt(hz0.f1282a.t(), hz0.f1282a.u())));
        ((TextView) _$_findCachedViewById(t61.battery_get_up)).setOnClickListener(new h());
        TextView textView5 = (TextView) _$_findCachedViewById(t61.battery_sleep);
        SharedPreferences sharedPreferences7 = this.f5189a;
        if (sharedPreferences7 == null) {
            f92.m("spf");
            throw null;
        }
        textView5.setText(t(sharedPreferences7.getInt(hz0.f1282a.v(), hz0.f1282a.w())));
        ((TextView) _$_findCachedViewById(t61.battery_sleep)).setOnClickListener(new i());
        Switch r04 = (Switch) _$_findCachedViewById(t61.battery_night_mode);
        f92.c(r04, "battery_night_mode");
        SharedPreferences sharedPreferences8 = this.f5189a;
        if (sharedPreferences8 == null) {
            f92.m("spf");
            throw null;
        }
        r04.setChecked(sharedPreferences8.getBoolean(hz0.f1282a.p(), false));
        ((Switch) _$_findCachedViewById(t61.battery_night_mode)).setOnClickListener(new j());
    }

    public final void r() {
        new pn1(this).a(new c());
    }

    public final void s() {
        new pn1(this).a(new d());
    }

    public final String t(int i2) {
        q92 q92Var = q92.f7191a;
        String string = getString(u61.battery_night_mode_time);
        f92.c(string, "getString(R.string.battery_night_mode_time)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)}, 2));
        f92.c(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final void u() {
        qc2.d(hf2.f6309a, qe2.b(), null, new e(null), 2, null).n();
    }

    public final void v() {
        View.OnClickListener uVar;
        View.OnClickListener wVar;
        BlurViewLinearLayout blurViewLinearLayout;
        int i2;
        int i3 = this.f8575a.i();
        int iJ = this.f8575a.j();
        TextView textView = (TextView) _$_findCachedViewById(t61.battery_forgery_ratio);
        if (i3 > 0) {
            f92.c(textView, "battery_forgery_ratio");
            StringBuilder sb = new StringBuilder();
            sb.append(i3);
            sb.append('%');
            textView.setText(sb.toString());
            textView = (TextView) _$_findCachedViewById(t61.battery_forgery_ratio);
            uVar = new t();
        } else {
            uVar = new u();
        }
        textView.setOnClickListener(uVar);
        TextView textView2 = (TextView) _$_findCachedViewById(t61.battery_forgery_full_now);
        if (iJ > 0) {
            f92.c(textView2, "battery_forgery_full_now");
            textView2.setText(String.valueOf(iJ) + "mAh");
            textView2 = (TextView) _$_findCachedViewById(t61.battery_forgery_full_now);
            wVar = new v();
        } else {
            wVar = new w();
        }
        textView2.setOnClickListener(wVar);
        if (i3 >= 1 || iJ >= 1) {
            blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.battery_forgery);
            f92.c(blurViewLinearLayout, "battery_forgery");
            i2 = 0;
        } else {
            blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.battery_forgery);
            f92.c(blurViewLinearLayout, "battery_forgery");
            i2 = 8;
        }
        blurViewLinearLayout.setVisibility(i2);
    }
}
