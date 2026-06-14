package com.omarea.vtools.activities;

import a.ah1;
import a.bc2;
import a.bh1;
import a.c60;
import a.e90;
import a.ec2;
import a.eh1;
import a.f92;
import a.fj0;
import a.fn0;
import a.g82;
import a.g91;
import a.g92;
import a.hz0;
import a.i52;
import a.jg1;
import a.k92;
import a.kj0;
import a.l90;
import a.m42;
import a.mg1;
import a.n92;
import a.ng1;
import a.og1;
import a.p80;
import a.q92;
import a.rg1;
import a.s21;
import a.se0;
import a.sg1;
import a.sl0;
import a.t61;
import a.u42;
import a.u61;
import a.u90;
import a.ug1;
import a.um0;
import a.v72;
import a.vg1;
import a.wg1;
import a.x60;
import a.xg1;
import a.y60;
import a.yg1;
import a.ym0;
import a.zg1;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.krscript.model.RunnableNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivitySwap extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f5511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f5514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedHashMap<String, String> f5517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5518a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8895a = 2048;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fn0 f5510a = new fn0(Scene.f4798a.c());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ym0 f5513a = new ym0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5515a = "addin/alive_benchmark.sh";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v72<m42> f5512a = new a();
    public v72<m42> b = new k();

    public static final class a extends g92 implements v72<m42> {
        public a() {
            super(0);
        }

        public final void a() {
            String str;
            int iR;
            boolean zS = ActivitySwap.this.f5510a.s();
            String strD = x60.f7856a.d("/proc/sys/vm/swappiness");
            String strD2 = x60.f7856a.d("/proc/sys/vm/watermark_scale_factor");
            String strD3 = x60.f7856a.d("/proc/meminfo");
            boolean zN = ActivitySwap.this.f5510a.n();
            String strL = ActivitySwap.this.f5510a.l();
            List<String> listK = ActivitySwap.this.f5510a.k();
            String strD4 = x60.f7856a.d("/proc/sys/vm/extra_free_kbytes");
            String strE = ActivitySwap.this.f5510a.e();
            String strE2 = ActivitySwap.this.E();
            int iO = ActivitySwap.this.f5510a.o();
            String str2 = (String) i52.K(ec2.d0(um0.f7612a.a("vtools.swap.loop"), new String[]{"/"}, false, 0, 6, null));
            if (str2 != null && !ec2.C(str2, "loop", false, 2, null)) {
                str2 = null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(ActivitySwap.this.C());
            k92 k92Var = new k92();
            k92Var.f6587a = 0.0f;
            k92 k92Var2 = new k92();
            k92Var2.f6587a = 0.0f;
            if (zS) {
                iR = ActivitySwap.this.f5510a.r();
                str = strD4;
            } else {
                str = strD4;
                iR = 0;
            }
            k92 k92Var3 = new k92();
            k92Var3.f6587a = 0.0f;
            int size = listK.size();
            int i = 1;
            while (i < size) {
                int i2 = size;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                List<String> list = listK;
                List listA0 = i52.a0(ec2.d0(listK.get(i), new String[]{" "}, false, 0, 6, null));
                boolean z = zN;
                String str3 = (String) listA0.get(0);
                String str4 = strL;
                linkedHashMap.put("path", str3);
                String str5 = strD3;
                linkedHashMap.put("type", listA0.get(1));
                String strO = ActivitySwap.this.O((String) listA0.get(2));
                linkedHashMap.put("size", strO);
                String str6 = strD2;
                String strO2 = ActivitySwap.this.O((String) listA0.get(3));
                linkedHashMap.put("used", strO2);
                linkedHashMap.put("priority", listA0.get(4));
                arrayList.add(linkedHashMap);
                String str7 = strD;
                if (bc2.x(str3, "/swapfile", false, 2, null) || str3.equals("/data/swapfile") || (str2 != null && ec2.C(str3, str2, false, 2, null))) {
                    k92Var.f6587a = Float.parseFloat(strO);
                    k92Var2.f6587a = Float.parseFloat(strO) - Float.parseFloat(strO2);
                } else if (bc2.x(str3, "/block/zram0", false, 2, null) || bc2.x(str3, "/dev/block/zram0", false, 2, null)) {
                    try {
                        k92Var3.f6587a = Float.parseFloat(strO) - Float.parseFloat(strO2);
                    } catch (Exception unused) {
                    }
                }
                i++;
                strD = str7;
                strD3 = str5;
                size = i2;
                zN = z;
                listK = list;
                strL = str4;
                strD2 = str6;
            }
            Scene.f4798a.i(new jg1(this, iO, k92Var, k92Var2, iR, k92Var3, strD, strD2, new s21(ActivitySwap.this, arrayList), strD3, strL, zN, zS, str, strE2, strE));
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ m42 i() {
            a();
            return m42.f6769a;
        }
    }

    public static final class a0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8897a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompoundButton f5519a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SeekBar f5520a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TextView f5521a;

        public a0(p80.b bVar, SeekBar seekBar, CompoundButton compoundButton, TextView textView) {
            this.f8897a = bVar;
            this.f5520a = seekBar;
            this.f5519a = compoundButton;
            this.f5521a = textView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8897a.c();
            SeekBar seekBar = this.f5520a;
            f92.c(seekBar, "zramSizeBar");
            int progress = seekBar.getProgress() * 128;
            CompoundButton compoundButton = this.f5519a;
            f92.c(compoundButton, "zramAutoStart");
            boolean zIsChecked = compoundButton.isChecked();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            TextView textView = this.f5521a;
            f92.c(textView, "compactAlgorithm");
            sb.append(textView.getText());
            String string = sb.toString();
            u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
            String string2 = ActivitySwap.this.getString(u61.zram_resizing);
            f92.c(string2, "getString(R.string.zram_resizing)");
            u90VarJ.d(string2);
            ActivitySwap.l(ActivitySwap.this).edit().putInt(hz0.f1282a.z0(), progress).putBoolean(hz0.f1282a.y0(), zIsChecked).putString(hz0.f1282a.p0(), string).apply();
            new Thread(new Thread(new eh1(this, string, progress))).start();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8898a = new b();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8899a = new c();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivitySwap.this.L();
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivitySwap.this.F();
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int iP = ActivitySwap.this.f5510a.p();
            if (iP <= 500 || x60.f7856a.h()) {
                ActivitySwap.this.N();
                return;
            }
            p80.a aVar = p80.f2403a;
            ActivitySwap activitySwap = ActivitySwap.this;
            String string = activitySwap.getString(u61.swap_reboot);
            f92.c(string, "getString(R.string.swap_reboot)");
            String string2 = ActivitySwap.this.getString(u61.swap_reboot_reason);
            f92.c(string2, "getString(R.string.swap_reboot_reason)");
            String str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(iP)}, 1));
            f92.c(str, "java.lang.String.format(this, *args)");
            aVar.i(activitySwap, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : new mg1(this), (16 & 16) != 0 ? null : null);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ ActivitySwap b;

        public g(ActivitySwap activitySwap) {
            this.b = activitySwap;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            boolean zIsChecked = ((CompoundButton) view).isChecked();
            ActivitySwap.l(ActivitySwap.this).edit().putBoolean(hz0.f1282a.q0(), zIsChecked).apply();
            if (!zIsChecked) {
                Toast.makeText(this.b, ActivitySwap.this.getString(u61.swap_lmk_restart), 0).show();
                return;
            }
            Object systemService = this.b.getSystemService("activity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            sl0 sl0Var = new sl0();
            sl0Var.a(memoryInfo.totalMem);
            TextView textView = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_lmk_current);
            f92.c(textView, "swap_lmk_current");
            textView.setText(sl0Var.b());
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivitySwap.this.K();
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivitySwap.this.T();
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivitySwap.this.P();
        }
    }

    public static final class k extends g92 implements v72<m42> {
        public k() {
            super(0);
        }

        public final void a() {
            Toast.makeText(ActivitySwap.this.getContext(), ActivitySwap.this.getString(u61.executed), 1).show();
            ActivitySwap.j(ActivitySwap.this).c();
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ m42 i() {
            a();
            return m42.f6769a;
        }
    }

    public static final class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8908a;

        public l(p80.b bVar) {
            this.f8908a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8908a.c();
        }
    }

    public static final class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fj0 f8909a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ p80.b f5523a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompoundButton f5524a;
        public final /* synthetic */ CompoundButton b;
        public final /* synthetic */ CompoundButton c;
        public final /* synthetic */ CompoundButton d;
        public final /* synthetic */ CompoundButton e;

        public m(p80.b bVar, fj0 fj0Var, CompoundButton compoundButton, CompoundButton compoundButton2, CompoundButton compoundButton3, CompoundButton compoundButton4, CompoundButton compoundButton5) {
            this.f5523a = bVar;
            this.f8909a = fj0Var;
            this.f5524a = compoundButton;
            this.b = compoundButton2;
            this.c = compoundButton3;
            this.d = compoundButton4;
            this.e = compoundButton5;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            this.f5523a.c();
            CompoundButton compoundButtonF = this.f8909a.f();
            if (f92.a(compoundButtonF, this.f5524a)) {
                i = 5;
            } else if (f92.a(compoundButtonF, this.b)) {
                i = 0;
            } else if (!f92.a(compoundButtonF, this.c)) {
                return;
            } else {
                i = -2;
            }
            SharedPreferences.Editor editorEdit = ActivitySwap.l(ActivitySwap.this).edit();
            String strW0 = hz0.f1282a.w0();
            CompoundButton compoundButton = this.d;
            f92.c(compoundButton, "mountLoop");
            SharedPreferences.Editor editorPutInt = editorEdit.putBoolean(strW0, compoundButton.isChecked()).putInt(hz0.f1282a.u0(), i);
            String strS0 = hz0.f1282a.s0();
            CompoundButton compoundButton2 = this.e;
            f92.c(compoundButton2, "autoStart");
            editorPutInt.putBoolean(strS0, compoundButton2.isChecked()).apply();
            u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
            String string = ActivitySwap.this.getString(u61.please_wait);
            f92.c(string, "getString(R.string.please_wait)");
            u90VarJ.d(string);
            new Thread(new og1(this)).start();
        }
    }

    public static final class n extends g92 implements g82<Integer, String> {
        public final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(int i) {
            super(1);
            this.b = i;
        }

        public final String a(int i) {
            return String.valueOf(i * this.b) + "MB";
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ String f(Integer num) {
            return a(num.intValue());
        }
    }

    public static final class o implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8910a;

        public o(p80.b bVar) {
            this.f8910a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8910a.c();
        }
    }

    public static final class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8911a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ p80.b f5526a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SeekBar f5527a;

        public p(p80.b bVar, SeekBar seekBar, int i) {
            this.f5526a = bVar;
            this.f5527a = seekBar;
            this.f8911a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f5526a.c();
            SeekBar seekBar = this.f5527a;
            f92.c(seekBar, "swapSize");
            int progress = seekBar.getProgress() * this.f8911a;
            if (progress < 1) {
                Scene.c cVar = Scene.f4798a;
                String string = ActivitySwap.this.getString(u61.swap_size_require);
                f92.c(string, "getString(R.string.swap_size_require)");
                Scene.c.p(cVar, string, 0, 2, null);
                return;
            }
            if (progress != ActivitySwap.this.f5510a.o()) {
                new Thread(new rg1(this, progress)).start();
            } else {
                ActivitySwap.l(ActivitySwap.this).edit().putInt(hz0.f1282a.v0(), progress).apply();
                ActivitySwap.this.J();
            }
        }
    }

    public static final class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8912a;

        public q(p80.b bVar) {
            this.f8912a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8912a.c();
        }
    }

    public static final class r implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8913a;

        public r(p80.b bVar) {
            this.f8913a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8913a.c();
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(ActivitySwap.this.getString(u61.config_swap_module_url)));
                ActivitySwap.this.getContext().startActivity(intent);
                ActivitySwap.this.finish();
            } catch (Exception unused) {
                Toast.makeText(ActivitySwap.this.getContext(), ActivitySwap.this.getString(u61.download_failed), 0).show();
            }
            ActivitySwap.this.finish();
        }
    }

    public static final class s extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8914a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long f5530a;

        public s(int i, long j) {
            this.f8914a = i;
            this.f5530a = j;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String string;
            int iP = ActivitySwap.this.f5510a.p();
            float fCurrentTimeMillis = ((this.f8914a - iP) / (System.currentTimeMillis() - this.f5530a)) * 1000;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ActivitySwap.this.getString(u61.swap_recycling_swapfile));
            q92 q92Var = q92.f7191a;
            String str = String.format(' ' + iP + '/' + this.f8914a + "MB (%.1fMB/s)\n", Arrays.copyOf(new Object[]{Float.valueOf(fCurrentTimeMillis)}, 1));
            f92.c(str, "java.lang.String.format(format, *args)");
            sb2.append(str);
            sb.append(sb2.toString());
            if (fCurrentTimeMillis > 0) {
                string = ActivitySwap.this.getString(u61.swap_recycling_estimate) + " " + ((int) (iP / fCurrentTimeMillis)) + "秒";
            } else {
                string = ActivitySwap.this.getString(u61.swap_recycling_waiting);
            }
            sb.append(string);
            Scene.f4798a.i(new sg1(this, sb));
        }
    }

    public static final class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8915a;

        public t(p80.b bVar) {
            this.f8915a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8915a.c();
        }
    }

    public static final class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8916a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompoundButton f5532a;

        public u(p80.b bVar, CompoundButton compoundButton) {
            this.f8916a = bVar;
            this.f5532a = compoundButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8916a.c();
            CompoundButton compoundButton = this.f5532a;
            f92.c(compoundButton, "deleteFile");
            boolean zIsChecked = compoundButton.isChecked();
            u90 u90VarJ = ActivitySwap.j(ActivitySwap.this);
            String string = ActivitySwap.this.getString(u61.swap_on_close);
            f92.c(string, "getString(R.string.swap_on_close)");
            u90VarJ.d(string);
            new Thread(new ug1(this, zIsChecked)).start();
        }
    }

    public static final class v implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8917a;

        public v(p80.b bVar) {
            this.f8917a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8917a.c();
        }
    }

    public static final class w implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8918a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SeekBar f5534a;
        public final /* synthetic */ SeekBar b;
        public final /* synthetic */ SeekBar c;

        public w(p80.b bVar, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3) {
            this.f8918a = bVar;
            this.f5534a = seekBar;
            this.b = seekBar2;
            this.c = seekBar3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8918a.c();
            SeekBar seekBar = this.f5534a;
            f92.c(seekBar, "swappinessSeekBar");
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = this.b;
            f92.c(seekBar2, "extraFreeSeekBar");
            int progress2 = seekBar2.getProgress();
            SeekBar seekBar3 = this.c;
            f92.c(seekBar3, "watermarkScaleSeekBar");
            int progress3 = seekBar3.getProgress();
            SharedPreferences.Editor editorPutInt = ActivitySwap.l(ActivitySwap.this).edit().putInt(hz0.f1282a.t0(), progress).putInt(hz0.f1282a.r0(), progress2);
            x60.f7856a.j("/proc/sys/vm/swappiness", String.valueOf(progress));
            x60.f7856a.j("/proc/sys/vm/extra_free_kbytes", String.valueOf(progress2));
            SeekBar seekBar4 = this.c;
            f92.c(seekBar4, "watermarkScaleSeekBar");
            if (seekBar4.isEnabled()) {
                x60.f7856a.j("/proc/sys/vm/watermark_scale_factor", String.valueOf(progress3));
                editorPutInt.putInt(hz0.f1282a.x0(), progress3);
            }
            editorPutInt.apply();
            Scene.f4798a.i(new yg1(this));
        }
    }

    public static final class x extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8919a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long f5536a;

        public x(int i, long j) {
            this.f8919a = i;
            this.f5536a = j;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String string;
            int iX = ActivitySwap.this.f5510a.x();
            float fCurrentTimeMillis = ((this.f8919a - iX) / (System.currentTimeMillis() - this.f5536a)) * 1000;
            StringBuilder sb = new StringBuilder();
            q92 q92Var = q92.f7191a;
            String str = String.format(ActivitySwap.this.getString(u61.swap_recycling_zram) + ' ' + iX + '/' + this.f8919a + "MB (%.1fMB/s)\n", Arrays.copyOf(new Object[]{Float.valueOf(fCurrentTimeMillis)}, 1));
            f92.c(str, "java.lang.String.format(format, *args)");
            sb.append(str);
            if (fCurrentTimeMillis > 0) {
                string = ActivitySwap.this.getString(u61.swap_recycling_estimate) + " " + ((int) (iX / fCurrentTimeMillis)) + "秒";
            } else {
                string = ActivitySwap.this.getString(u61.swap_recycling_waiting);
            }
            sb.append(string);
            Scene.f4798a.i(new zg1(this, sb));
        }
    }

    public static final class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8920a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String[] f5539a;

        public y(String[] strArr, n92 n92Var) {
            this.f5539a = strArr;
            this.f8920a = n92Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e90 e90Var = l90.f6685a;
            Context context = ActivitySwap.this.getContext();
            String[] strArr = this.f5539a;
            l90 l90VarB = e90Var.b(context, strArr, u42.t(strArr, (String) this.f8920a.f6891a), new ah1(this, view));
            l90VarB.l(u61.swap_zram_comp_options);
            l90VarB.o();
        }
    }

    public static final class z implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8921a;

        public z(p80.b bVar) {
            this.f8921a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8921a.c();
        }
    }

    public static final /* synthetic */ u90 j(ActivitySwap activitySwap) {
        u90 u90Var = activitySwap.f5511a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public static final /* synthetic */ SharedPreferences l(ActivitySwap activitySwap) {
        SharedPreferences sharedPreferences = activitySwap.f5514a;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        f92.m("swapConfig");
        throw null;
    }

    public final v72<m42> B() {
        return this.f5512a;
    }

    public final LinkedHashMap<String, String> C() {
        if (this.f5517a == null) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("path", getString(u61.path));
            linkedHashMap.put("type", getString(u61.type));
            linkedHashMap.put("size", getString(u61.size));
            linkedHashMap.put("used", getString(u61.used));
            linkedHashMap.put("priority", getString(u61.order));
            m42 m42Var = m42.f6769a;
            this.f5517a = linkedHashMap;
        }
        LinkedHashMap<String, String> linkedHashMap2 = this.f5517a;
        f92.b(linkedHashMap2);
        return linkedHashMap2;
    }

    public final String D() {
        String string;
        String str;
        String str2;
        String strD = x60.f7856a.d("/proc/vmstat");
        StringBuilder sb = new StringBuilder();
        try {
            for (String str3 : ec2.d0(strD, new String[]{"\n"}, false, 0, 6, null)) {
                if (bc2.x(str3, "pswpin", false, 2, null)) {
                    string = getString(u61.swap_read);
                    str = "getString(R.string.swap_read)";
                } else if (bc2.x(str3, "pswpout", false, 2, null)) {
                    string = getString(u61.swap_write);
                    str = "getString(R.string.swap_write)";
                }
                f92.c(string, str);
                String str4 = (String) ec2.d0(str3, new String[]{" "}, false, 0, 6, null).get(1);
                sb.append(string);
                long j2 = (Long.parseLong(str4) * ((long) 4)) / ((long) 1024);
                if (j2 > 10240) {
                    q92 q92Var = q92.f7191a;
                    String str5 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(j2 / 1024.0f)}, 1));
                    f92.c(str5, "java.lang.String.format(format, *args)");
                    sb.append(str5);
                    str2 = "GB\n";
                } else {
                    sb.append(j2);
                    str2 = "MB\n";
                }
                sb.append(str2);
            }
        } catch (Exception unused) {
        }
        String string2 = sb.toString();
        f92.c(string2, "text.toString()");
        if (string2 != null) {
            return ec2.r0(string2).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x03a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String E() {
        /*
            Method dump skipped, instruction units count: 973
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivitySwap.E():java.lang.String");
    }

    public final void F() {
        c60 c60Var = c60.f5764a;
        String str = this.f5515a;
        String strM = c60Var.m(str, str, this);
        if (strM == null) {
            strM = ym0.f7994a.a();
        }
        String str2 = "sh " + strM;
        RunnableNode runnableNode = new RunnableNode("");
        runnableNode.setTitle("KeepAlive Benchmark");
        runnableNode.setDesc(str2);
        se0 se0VarA = se0.f7388a.a(runnableNode, b.f8898a, c.f8899a, str2, null, false);
        se0VarA.z1(false);
        se0VarA.B1(getSupportFragmentManager(), "");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G() {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivitySwap.G():void");
    }

    public final void H() {
        I();
        Timer timer = new Timer("ActivitySwaps");
        timer.schedule(new ng1(this), 0L, 5000L);
        m42 m42Var = m42.f6769a;
        this.f5518a = timer;
    }

    public final void I() {
        Timer timer = this.f5518a;
        if (timer != null) {
            timer.cancel();
        }
        this.f5518a = null;
    }

    public final void J() {
        View viewInflate = getLayoutInflater().inflate(2131558542, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.swap_priority_high);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.swap_priority_middle);
        CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.swap_priority_low);
        CompoundButton compoundButton4 = (CompoundButton) viewInflate.findViewById(t61.swap_auto_start);
        CompoundButton compoundButton5 = (CompoundButton) viewInflate.findViewById(t61.swap_mount_loop);
        f92.c(compoundButton, "priorityHight");
        f92.c(compoundButton2, "priorityMiddle");
        f92.c(compoundButton3, "priorityLow");
        fj0 fj0Var = new fj0(compoundButton, compoundButton2, compoundButton3);
        SharedPreferences sharedPreferences = this.f5514a;
        if (sharedPreferences == null) {
            f92.m("swapConfig");
            throw null;
        }
        int i2 = sharedPreferences.getInt(hz0.f1282a.u0(), -2);
        if (i2 == 0) {
            compoundButton2.setChecked(true);
        } else if (i2 != 5) {
            compoundButton3.setChecked(true);
        } else {
            compoundButton.setChecked(true);
        }
        f92.c(compoundButton5, "mountLoop");
        SharedPreferences sharedPreferences2 = this.f5514a;
        if (sharedPreferences2 == null) {
            f92.m("swapConfig");
            throw null;
        }
        compoundButton5.setChecked(sharedPreferences2.getBoolean(hz0.f1282a.w0(), false));
        f92.c(compoundButton4, "autoStart");
        SharedPreferences sharedPreferences3 = this.f5514a;
        if (sharedPreferences3 == null) {
            f92.m("swapConfig");
            throw null;
        }
        compoundButton4.setChecked(sharedPreferences3.getBoolean(hz0.f1282a.s0(), false));
        viewInflate.findViewById(2131362069).setOnClickListener(new l(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new m(bVarT, fj0Var, compoundButton, compoundButton2, compoundButton3, compoundButton5, compoundButton4));
    }

    public final void K() {
        int iO;
        View viewInflate = getLayoutInflater().inflate(2131558543, (ViewGroup) null);
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(t61.swap_size);
        TextView textView = (TextView) viewInflate.findViewById(t61.swap_size_text);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        kj0 kj0Var = new kj0();
        f92.c(seekBar, "swapSize");
        f92.c(textView, "swapSizeText");
        kj0Var.a(seekBar, textView, new n(128));
        if (this.f5510a.n()) {
            iO = this.f5510a.o();
        } else {
            SharedPreferences sharedPreferences = this.f5514a;
            if (sharedPreferences == null) {
                f92.m("swapConfig");
                throw null;
            }
            iO = sharedPreferences.getInt(hz0.f1282a.v0(), 0);
        }
        seekBar.setProgress(iO / 128);
        textView.setText(String.valueOf(seekBar.getProgress() * 128) + "MB");
        viewInflate.findViewById(2131362069).setOnClickListener(new o(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new p(bVarT, seekBar, 128));
    }

    public final void L() {
        View viewInflate = getLayoutInflater().inflate(2131558545, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(2131362069).setOnClickListener(new q(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new r(bVarT));
    }

    public final Timer M() {
        Timer timer = new Timer("SwapOFF");
        timer.schedule(new s(this.f5510a.p(), System.currentTimeMillis()), 0L, 1000L);
        return timer;
    }

    public final void N() {
        View viewInflate = getLayoutInflater().inflate(2131558544, (ViewGroup) null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.swap_delete_file);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(2131362069).setOnClickListener(new t(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new u(bVarT, compoundButton));
    }

    public final String O(String str) {
        try {
            return String.valueOf(Long.parseLong(str) / ((long) 1024));
        } catch (Exception unused) {
            return str;
        }
    }

    public final void P() {
        int i2;
        int i3;
        SharedPreferences sharedPreferences;
        View viewInflate = getLayoutInflater().inflate(2131558546, (ViewGroup) null);
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(t61.seekbar_swap_swappiness);
        TextView textView = (TextView) viewInflate.findViewById(t61.txt_zramstus_swappiness);
        SeekBar seekBar2 = (SeekBar) viewInflate.findViewById(t61.seekbar_extra_free_kbytes);
        TextView textView2 = (TextView) viewInflate.findViewById(t61.text_extra_free_kbytes);
        SeekBar seekBar3 = (SeekBar) viewInflate.findViewById(t61.seekbar_watermark_scale_factor);
        TextView textView3 = (TextView) viewInflate.findViewById(t61.text_watermark_scale_factor);
        View viewFindViewById = viewInflate.findViewById(2131362380);
        if (viewFindViewById != null) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.extra_free_view);
            f92.c(linearLayout, "extra_free_view");
            viewFindViewById.setVisibility(linearLayout.getVisibility());
        }
        seekBar.setMax((x60.f7856a.h() || Integer.parseInt(x60.f7856a.d("/proc/sys/vm/swappiness")) > 100) ? 200 : 100);
        SharedPreferences sharedPreferences2 = this.f5514a;
        if (sharedPreferences2 == null) {
            f92.m("swapConfig");
            throw null;
        }
        seekBar.setProgress(sharedPreferences2.getInt(hz0.f1282a.t0(), 100));
        f92.c(textView, "swappinessText");
        f92.c(seekBar, "swappinessSeekBar");
        textView.setText(String.valueOf(seekBar.getProgress()));
        String strD = x60.f7856a.d("/proc/sys/vm/extra_free_kbytes");
        f92.c(seekBar2, "extraFreeSeekBar");
        try {
            i3 = Integer.parseInt(strD);
            sharedPreferences = this.f5514a;
        } catch (Exception unused) {
            SharedPreferences sharedPreferences3 = this.f5514a;
            if (sharedPreferences3 == null) {
                f92.m("swapConfig");
                throw null;
            }
            i2 = sharedPreferences3.getInt(hz0.f1282a.r0(), 29615);
        }
        if (sharedPreferences == null) {
            f92.m("swapConfig");
            throw null;
        }
        i2 = sharedPreferences.getInt(hz0.f1282a.r0(), i3);
        seekBar2.setProgress(i2);
        f92.c(textView2, "extraFreeText");
        textView2.setText(String.valueOf(seekBar2.getProgress()) + "(" + (seekBar2.getProgress() / 1024) + "MB)");
        f92.c(seekBar3, "watermarkScaleSeekBar");
        SharedPreferences sharedPreferences4 = this.f5514a;
        if (sharedPreferences4 == null) {
            f92.m("swapConfig");
            throw null;
        }
        seekBar3.setProgress(sharedPreferences4.getInt(hz0.f1282a.x0(), 100));
        f92.c(textView3, "watermarkScaleText");
        int progress = seekBar3.getProgress();
        textView3.setText(progress + '(' + (progress / 100.0f) + "%)");
        seekBar3.setEnabled(y60.f7952a.d("/proc/sys/vm/watermark_scale_factor"));
        kj0 kj0Var = new kj0();
        kj0Var.a(seekBar, textView, vg1.f7694a);
        kj0Var.a(seekBar2, textView2, wg1.f7787a);
        kj0Var.a(seekBar3, textView3, xg1.f7888a);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(2131362069).setOnClickListener(new v(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new w(bVarT, seekBar, seekBar2, seekBar3));
    }

    public final String Q(String str, String str2) {
        try {
            return String.valueOf(((Long.parseLong(str2) * ((long) 1000)) / Long.parseLong(str)) / 10.0d) + "%";
        } catch (Exception unused) {
            return str2 + '/' + str;
        }
    }

    public final String R(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            long j2 = 1024;
            sb.append(String.valueOf((Long.parseLong(str) / j2) / j2));
            sb.append("MB");
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public final Timer S() {
        Timer timer = new Timer("ZramOFF");
        timer.schedule(new x(this.f5510a.x(), System.currentTimeMillis()), 0L, 1000L);
        return timer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, java.lang.String] */
    public final void T() {
        View viewInflate = getLayoutInflater().inflate(2131558550, (ViewGroup) null);
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(t61.zram_size);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.zram_auto_start);
        TextView textView = (TextView) viewInflate.findViewById(2131363086);
        TextView textView2 = (TextView) viewInflate.findViewById(t61.zram_size_text);
        f92.c(compoundButton, "zramAutoStart");
        SharedPreferences sharedPreferences = this.f5514a;
        if (sharedPreferences == null) {
            f92.m("swapConfig");
            throw null;
        }
        compoundButton.setChecked(sharedPreferences.getBoolean(hz0.f1282a.y0(), false));
        String[] strArrF = this.f5510a.f();
        n92 n92Var = new n92();
        SharedPreferences sharedPreferences2 = this.f5514a;
        if (sharedPreferences2 == null) {
            f92.m("swapConfig");
            throw null;
        }
        ?? string = sharedPreferences2.getString(hz0.f1282a.p0(), this.f5510a.e());
        n92Var.f6891a = string;
        f92.b(string);
        if (!u42.k(strArrF, string)) {
            n92Var.f6891a = this.f5510a.e();
            SharedPreferences sharedPreferences3 = this.f5514a;
            if (sharedPreferences3 == null) {
                f92.m("swapConfig");
                throw null;
            }
            sharedPreferences3.edit().putString(hz0.f1282a.p0(), (String) n92Var.f6891a).apply();
        }
        f92.c(textView, "compactAlgorithm");
        textView.setText((String) n92Var.f6891a);
        textView.setOnClickListener(new y(strArrF, n92Var));
        kj0 kj0Var = new kj0();
        f92.c(seekBar, "zramSizeBar");
        f92.c(textView2, "zramSizeText");
        kj0Var.a(seekBar, textView2, bh1.f5706a);
        int iCeil = (int) (Math.ceil(((double) this.f8895a) / 2048.0d) * ((double) 2048));
        seekBar.setMax(iCeil / 128);
        SharedPreferences sharedPreferences4 = this.f5514a;
        if (sharedPreferences4 == null) {
            f92.m("swapConfig");
            throw null;
        }
        int i2 = sharedPreferences4.getInt(hz0.f1282a.z0(), 0);
        if (i2 <= iCeil) {
            iCeil = i2;
        }
        seekBar.setProgress(iCeil / 128);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(2131362069).setOnClickListener(new z(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new a0(bVarT, seekBar, compoundButton, textView));
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5516a == null) {
            this.f5516a = new HashMap();
        }
        View view = (View) this.f5516a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5516a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558466);
        setBackArrow();
        SharedPreferences sharedPreferences = getSharedPreferences(hz0.f1282a.o0(), 0);
        f92.c(sharedPreferences, "getSharedPreferences(Spf…PF, Context.MODE_PRIVATE)");
        this.f5514a = sharedPreferences;
        Object systemService = getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        ((ActivityManager) systemService).getMemoryInfo(new ActivityManager.MemoryInfo());
        this.f8895a = (int) ((r0.totalMem / ((long) 1024)) / 1024.0f);
        G();
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        u90 u90Var = this.f5511a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90Var.c();
        super.onDestroy();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        I();
        ym0 ym0Var = this.f5513a;
        SharedPreferences sharedPreferences = this.f5514a;
        if (sharedPreferences == null) {
            f92.m("swapConfig");
            throw null;
        }
        ym0Var.f(sharedPreferences);
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_swap));
        ym0 ym0Var = this.f5513a;
        SharedPreferences sharedPreferences = this.f5514a;
        if (sharedPreferences == null) {
            f92.m("swapConfig");
            throw null;
        }
        ym0Var.e(sharedPreferences);
        H();
    }
}
