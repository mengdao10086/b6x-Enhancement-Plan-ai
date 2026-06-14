package com.omarea.vtools.services;

import a.b62;
import a.b92;
import a.d72;
import a.e50;
import a.ec2;
import a.f92;
import a.g82;
import a.g92;
import a.h42;
import a.i52;
import a.jm0;
import a.k82;
import a.kl0;
import a.m42;
import a.nb;
import a.pc2;
import a.r62;
import a.s60;
import a.t62;
import a.u42;
import a.u61;
import a.um0;
import a.vl0;
import a.wd2;
import a.x60;
import a.x62;
import a.xl0;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PowerManager;
import com.omarea.Scene;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class CompileService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8925a = new a(null);
    public static boolean d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NotificationManager f5548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PowerManager.WakeLock f5549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PowerManager f5550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f5552a;
    public boolean b;
    public boolean c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public final boolean a() {
            return CompileService.d;
        }
    }

    @x62(c = "com.omarea.vtools.services.CompileService$onHandleIntent$1", f = "CompileService.kt", l = {123}, m = "invokeSuspend")
    public static final class b extends d72 implements g82<b62<? super String>, Object> {
        public int b;

        public b(b62 b62Var) {
            super(1, b62Var);
        }

        @Override // a.g82
        public final Object f(b62<? super String> b62Var) {
            return ((b) n(b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                e50 e50Var = e50.f677a;
                this.b = 1;
                obj = e50.T(e50Var, null, this, 1, null);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return obj;
        }

        public final b62<m42> n(b62<?> b62Var) {
            f92.d(b62Var, "completion");
            return new b(b62Var);
        }
    }

    public static final class c extends g92 implements g82<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PackageManager f8926a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PackageManager packageManager) {
            super(1);
            this.f8926a = packageManager;
        }

        @Override // a.g82
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence f(String str) {
            f92.d(str, "it");
            try {
                CharSequence charSequenceLoadLabel = this.f8926a.getApplicationInfo(str, 0).loadLabel(this.f8926a);
                f92.c(charSequenceLoadLabel, "pm.getApplicationInfo(it, 0).loadLabel(pm)");
                return charSequenceLoadLabel;
            } catch (Exception unused) {
                return str;
            }
        }
    }

    @x62(c = "com.omarea.vtools.services.CompileService$onHandleIntent$largeMem$1", f = "CompileService.kt", l = {166}, m = "invokeSuspend")
    public static final class d extends d72 implements k82<wd2, b62<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8927a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5553a;
        public int b;

        public d(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d dVar = new d(b62Var);
            dVar.f8927a = (wd2) obj;
            return dVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super Boolean> b62Var) {
            return ((d) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8927a;
                xl0 xl0Var = new xl0();
                this.f5553a = wd2Var;
                this.b = 1;
                obj = xl0Var.b(this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return t62.a(((vl0) obj).b() > 16384);
        }
    }

    public CompileService() {
        super("vtools-compile");
        this.f5551a = "speed";
        this.f5552a = new String[]{"com.ss.android.ugc.aweme"};
    }

    public static /* synthetic */ void e(CompileService compileService, String str, String str2, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = true;
        }
        compileService.d(str, str2, i, i2, z);
    }

    public final ArrayList<String> b() {
        PackageManager packageManager = getPackageManager();
        f92.c(packageManager, "packageManager");
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        f92.c(installedApplications, "packageManager.getInstalledApplications(0)");
        ArrayList<String> arrayList = new ArrayList<>();
        int size = installedApplications.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(installedApplications.get(i).packageName);
        }
        arrayList.remove(getPackageName());
        arrayList.remove("com.google.android.gms");
        return arrayList;
    }

    public final void c() {
        NotificationManager notificationManager;
        if (!this.b) {
            String string = getString(u61.dex2oat_completed);
            f92.c(string, "getString(R.string.dex2oat_completed)");
            d("complete!", string, 100, 100, true);
            x60.f7856a.j("/dev/cpuctl/dex2oat/cpu.uclamp.min", "0");
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager = this.f5548a;
            if (notificationManager == null) {
                f92.m("nm");
                throw null;
            }
        } else {
            notificationManager = this.f5548a;
            if (notificationManager == null) {
                f92.m("nm");
                throw null;
            }
        }
        notificationManager.cancel(990);
    }

    public final void d(String str, String str2, int i, int i2, boolean z) {
        nb nbVar;
        if (Build.VERSION.SDK_INT >= 26) {
            if (!this.c) {
                NotificationManager notificationManager = this.f5548a;
                if (notificationManager == null) {
                    f92.m("nm");
                    throw null;
                }
                notificationManager.createNotificationChannel(new NotificationChannel("vtool-compile", "后台编译", 2));
                this.c = true;
            }
            nbVar = new nb(this, "vtool-compile");
        } else {
            nbVar = new nb(this);
        }
        NotificationManager notificationManager2 = this.f5548a;
        if (notificationManager2 == null) {
            f92.m("nm");
            throw null;
        }
        nbVar.n(2131231119);
        nbVar.g(str);
        nbVar.f(str2);
        nbVar.d(z);
        nbVar.k(i, i2, false);
        notificationManager2.notify(990, nbVar.a());
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        c();
        PowerManager.WakeLock wakeLock = this.f5549a;
        if (wakeLock == null) {
            f92.m("mWakeLock");
            throw null;
        }
        wakeLock.release();
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        char c2;
        String str5;
        Object systemService = getSystemService("power");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        PowerManager powerManager = (PowerManager) systemService;
        this.f5550a = powerManager;
        if (powerManager == null) {
            f92.m("mPowerManager");
            throw null;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "scene:CompileService");
        f92.c(wakeLockNewWakeLock, "mPowerManager.newWakeLoc…, \"scene:CompileService\")");
        this.f5549a = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock == null) {
            f92.m("mWakeLock");
            throw null;
        }
        wakeLockNewWakeLock.acquire(3600000L);
        Object systemService2 = getSystemService("notification");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        this.f5548a = (NotificationManager) systemService2;
        if (d) {
            this.b = true;
            c();
            return;
        }
        if (intent != null) {
            String action = intent.getAction();
            if (f92.a(action, getString(u61.scene_speed_compile))) {
                str5 = "speed";
            } else if (f92.a(action, getString(u61.scene_speed_profile_compile))) {
                this.f5551a = "speed-profile";
            } else if (f92.a(action, getString(u61.scene_everything_compile))) {
                str5 = "everything";
            } else if (f92.a(action, getString(u61.scene_reset_compile))) {
                this.f5551a = "reset";
            } else if (f92.a(action, getString(u61.scene_dex2at_compact))) {
                d = false;
                this.b = true;
                Scene.f4798a.a(new b(null));
                return;
            }
            this.f5551a = str5;
        }
        d = true;
        ArrayList arrayList = new ArrayList();
        kl0 kl0Var = new kl0();
        try {
            ArrayList<String[]> arrayListF = kl0Var.f();
            boolean z = u42.k(new String[]{"mt6989", "mt6991", "mt6993", "mt6899", "sun", "canoe", "tuna"}, jm0.f6525a.a()) || kl0Var.l(0) > 2400000;
            List<String[]> listSubList = arrayListF.subList(0, arrayListF.size());
            f92.c(listSubList, "clusters.subList(0, clusters.size)");
            i = 0;
            int i2 = 0;
            for (String[] strArr : listSubList) {
                try {
                    if (i2 > 0 || z) {
                        for (String str6 : strArr) {
                            i++;
                            arrayList.add(str6);
                        }
                    }
                    i2++;
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            i = 0;
        }
        if (i == 2 || i == 0) {
            arrayList.clear();
            int iH = kl0Var.h();
            i = 0;
            for (int i3 = (i == 2 && kl0Var.h() == 8) ? 2 : 0; i3 < iH; i3++) {
                arrayList.add(String.valueOf(i3));
                i++;
            }
        }
        if (((Boolean) pc2.b(null, new d(null), 1, null)).booleanValue()) {
            s60.f7366a.a("resetprop dalvik.vm.dex2oat-swap false");
            s60.f7366a.a("setprop dalvik.vm.dex2oat-swap false");
        }
        x60.f7856a.j("/dev/cpuctl/dex2oat/cpu.uclamp.min", "100");
        char c3 = ' ';
        if (i > 2 && (ec2.N(um0.f7612a.a("dalvik.vm.dex2oat-cpu-set"), "7", 0, false, 6, null) < 0 || ec2.N(um0.f7612a.a("dalvik.vm.background-dex2oat-cpu-set"), "7", 0, false, 6, null) < 0)) {
            StringBuilder sb = new StringBuilder();
            String[] strArr2 = {"dalvik.vm.bg-dex2oat-threads", "dalvik.vm.dex2oat-threads", "persist.dalvik.vm.dex2oat-threads", "dalvik.vm.image-dex2oat-threads", "ro.sys.fw.dex2oat_thread_count", "dalvik.vm.background-dex2oat-threads", "dalvik.vm.boot-dex2oat-threads"};
            int i4 = 0;
            for (int i5 = 7; i4 < i5; i5 = 7) {
                String str7 = strArr2[i4];
                sb.append("resetprop " + str7 + ' ' + i + '\n');
                sb.append("setprop " + str7 + ' ' + i + '\n');
                i4++;
            }
            String strH = i52.H(arrayList, ",", null, null, 0, null, null, 62, null);
            String[] strArr3 = {"dalvik.vm.default-dex2oat-cpu-set", "dalvik.vm.background-dex2oat-cpu-set", "dalvik.vm.boot-dex2oat-cpu-set", "dalvik.vm.image-dex2oat-cpu-set", "dalvik.vm.dex2oat-cpu-set"};
            for (int i6 = 0; i6 < 5; i6++) {
                String str8 = strArr3[i6];
                sb.append("resetprop " + str8 + ' ' + strH + '\n');
                sb.append("setprop " + str8 + ' ' + strH + '\n');
            }
            sb.append("");
            s60 s60Var = s60.f7366a;
            String string = sb.toString();
            f92.c(string, "cmdBuilder.toString()");
            s60Var.a(string);
        }
        ArrayList<String> arrayListB = b();
        int size = arrayListB.size();
        String str9 = Build.VERSION.SDK_INT > 34 ? "-p PRIORITY_INTERACTIVE_FAST" : "";
        c cVar = new c(getPackageManager());
        boolean zA = f92.a(this.f5551a, "reset");
        char c4 = '/';
        char c5 = '[';
        String str10 = "]";
        String str11 = "[";
        int i7 = u61.dex2oat_compiling;
        String str12 = "packageName";
        if (zA) {
            String packageName = getPackageName();
            int i8 = 0;
            for (String str13 : arrayListB) {
                if (!f92.a(str13, packageName)) {
                    f92.c(str13, str12);
                    CharSequence charSequenceF = cVar.f(str13);
                    String str14 = getString(i7) + str11 + this.f5551a + str10;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(c5);
                    sb2.append(i8);
                    sb2.append(c4);
                    sb2.append(size);
                    sb2.append(']');
                    sb2.append(charSequenceF);
                    String string2 = sb2.toString();
                    int i9 = i8;
                    str2 = str11;
                    str3 = str10;
                    str = str12;
                    str4 = packageName;
                    c2 = ' ';
                    e(this, str14, string2, size, i9, false, 16, null);
                    s60.f7366a.a("cmd package compile -f -m verify " + str9 + ' ' + str13 + " ||cmd package compile -f -m extra " + str9 + ' ' + str13 + " ||cmd package compile -f -m speed-profile " + str9 + ' ' + str13);
                    i8 = i9 + 1;
                } else {
                    str = str12;
                    str2 = str11;
                    str3 = str10;
                    str4 = packageName;
                    c2 = c3;
                }
                c3 = c2;
                str10 = str3;
                str12 = str;
                str11 = str2;
                i7 = u61.dex2oat_compiling;
                c4 = '/';
                c5 = '[';
                packageName = str4;
            }
        } else {
            String str15 = "[";
            int i10 = 0;
            for (String str16 : arrayListB) {
                String[] strArr4 = this.f5552a;
                f92.c(str16, "packageName");
                String str17 = u42.k(strArr4, str16) ? "speed-profile" : this.f5551a;
                CharSequence charSequenceF2 = cVar.f(str16);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(getString(u61.dex2oat_compiling));
                String str18 = str15;
                sb3.append(str18);
                sb3.append(str17);
                sb3.append("]");
                String string3 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append('[');
                sb4.append(i10);
                sb4.append('/');
                sb4.append(size);
                sb4.append(']');
                sb4.append(charSequenceF2);
                e(this, string3, sb4.toString(), size, i10, false, 16, null);
                s60.f7366a.a("cmd package compile -m " + str17 + ' ' + str9 + ' ' + str16);
                i10++;
                str15 = str18;
            }
            s60.f7366a.a("cmd package compile -m " + this.f5551a + ' ' + str9 + ' ' + getPackageName());
        }
        c();
        d = false;
    }
}
