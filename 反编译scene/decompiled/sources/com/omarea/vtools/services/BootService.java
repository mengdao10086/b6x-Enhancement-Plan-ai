package com.omarea.vtools.services;

import a.aa0;
import a.bc2;
import a.e50;
import a.ec2;
import a.f92;
import a.fn0;
import a.hz0;
import a.nb;
import a.s60;
import a.u61;
import a.x60;
import a.y60;
import a.z90;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.PowerManager;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BootService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f8924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f5545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PowerManager.WakeLock f5546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PowerManager f5547a;
    public boolean b;
    public boolean c;

    public BootService() {
        super("vtools-boot");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.services.BootService.a():void");
    }

    public final void b() {
        NotificationManager notificationManager;
        if (this.b) {
            String string = getString(u61.boot_success);
            f92.c(string, "getString(R.string.boot_success)");
            f(string);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager = this.f8924a;
            if (notificationManager == null) {
                f92.m("nm");
                throw null;
            }
        } else {
            notificationManager = this.f8924a;
            if (notificationManager == null) {
                f92.m("nm");
                throw null;
            }
        }
        notificationManager.cancel(900);
    }

    public final void c(Context context) {
        String string = getString(u61.boot_swapon);
        f92.c(string, "getString(R.string.boot_swapon)");
        f(string);
        SharedPreferences sharedPreferences = this.f5545a;
        if (sharedPreferences == null) {
            f92.m("swapConfig");
            throw null;
        }
        int i = sharedPreferences.getInt(hz0.f1282a.u0(), -2);
        SharedPreferences sharedPreferences2 = this.f5545a;
        if (sharedPreferences2 == null) {
            f92.m("swapConfig");
            throw null;
        }
        new fn0(context).F(i, sharedPreferences2.getBoolean(hz0.f1282a.w0(), false));
    }

    public final String d() {
        Object obj;
        Iterator it = ec2.d0(x60.f7856a.d("/sys/block/zram0/comp_algorithm"), new String[]{" "}, false, 0, 6, null).iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            boolean z = false;
            if (bc2.x(str, "[", false, 2, null) && bc2.o(str, "]", false, 2, null)) {
                z = true;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        String str2 = (String) obj;
        if (str2 == null) {
            return "";
        }
        String strT = bc2.t(bc2.t(str2, "[", "", false, 4, null), "]", "", false, 4, null);
        if (strT != null) {
            return ec2.r0(strT).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final void e(int i, String str, boolean z) {
        String str2;
        s60.f7366a.a("if [[ ! -e /dev/block/zram0 ]] && [[ -e /sys/class/zram-control ]]; then\n  cat /sys/class/zram-control/hot_add\nfi");
        String strI = y60.f7952a.i("/sys/block/zram0/disksize");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        long j = ((long) (i * 1024)) * 1024;
        sb.append(j);
        if (!(!f92.a(strI, sb.toString()))) {
            if (!(str.length() > 0) || !(!f92.a(str, d()))) {
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("swappiness_bak=`cat /proc/sys/vm/swappiness`\n");
        if (!z) {
            sb2.append("echo 0 > /proc/sys/vm/swappiness\n");
        }
        sb2.append("echo 4 > /sys/block/zram0/max_comp_streams\n");
        sb2.append("sync\n");
        sb2.append("if [[ -f /sys/block/zram0/backing_dev ]]; then\n");
        sb2.append("  backing_dev=$(cat /sys/block/zram0/backing_dev)\n");
        sb2.append("fi\n");
        sb2.append("echo 3 > /proc/sys/vm/drop_caches\n");
        sb2.append("umount /dev/block/zram0 2>/dev/null\n");
        sb2.append("swapoff /dev/block/zram0 >/dev/null 2>&1\n");
        sb2.append("echo 1 > /sys/block/zram0/reset\n");
        sb2.append("if [[ -f /sys/block/zram0/backing_dev ]]; then\n");
        sb2.append("  echo \"$backing_dev\" > /sys/block/zram0/backing_dev\n");
        sb2.append("fi\n");
        if (str.length() > 0) {
            sb2.append("echo \"" + str + "\" > /sys/block/zram0/comp_algorithm\n");
        }
        if (i > 2047) {
            str2 = "echo " + i + "M > /sys/block/zram0/disksize\n";
        } else {
            str2 = "echo " + j + " > /sys/block/zram0/disksize\n";
        }
        sb2.append(str2);
        sb2.append("echo 4 > /sys/block/zram0/max_comp_streams\n");
        sb2.append("mkswap /dev/block/zram0 >/dev/null 2>&1\n");
        sb2.append("swapon -p 0 /dev/block/zram0 >/dev/null 2>&1\n");
        sb2.append("echo $swappiness_bak > /proc/sys/vm/swappiness");
        s60 s60Var = s60.f7366a;
        String string = sb2.toString();
        f92.c(string, "sb.toString()");
        s60Var.a(string);
    }

    public final void f(String str) {
        nb nbVar;
        if (Build.VERSION.SDK_INT >= 26) {
            if (!this.c) {
                NotificationManager notificationManager = this.f8924a;
                if (notificationManager == null) {
                    f92.m("nm");
                    throw null;
                }
                notificationManager.createNotificationChannel(new NotificationChannel("vtool-boot", getString(u61.notice_channel_boot), 2));
                this.c = true;
            }
            nbVar = new nb(this, "vtool-boot");
        } else {
            nbVar = new nb(this);
        }
        NotificationManager notificationManager2 = this.f8924a;
        if (notificationManager2 == null) {
            f92.m("nm");
            throw null;
        }
        nbVar.n(2131230938);
        nbVar.g(getString(u61.notice_channel_boot));
        nbVar.f(str);
        notificationManager2.notify(900, nbVar.a());
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        b();
        PowerManager.WakeLock wakeLock = this.f5546a;
        if (wakeLock == null) {
            f92.m("mWakeLock");
            throw null;
        }
        wakeLock.release();
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) throws InterruptedException {
        Object systemService = getSystemService("power");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        PowerManager powerManager = (PowerManager) systemService;
        this.f5547a = powerManager;
        if (powerManager == null) {
            f92.m("mPowerManager");
            throw null;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "scene:BootService");
        f92.c(wakeLockNewWakeLock, "mPowerManager.newWakeLoc…OCK, \"scene:BootService\")");
        this.f5546a = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock == null) {
            f92.m("mWakeLock");
            throw null;
        }
        wakeLockNewWakeLock.acquire(600000L);
        Object systemService2 = getSystemService("notification");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        this.f8924a = (NotificationManager) systemService2;
        SharedPreferences sharedPreferences = getSharedPreferences(hz0.f1282a.o0(), 0);
        f92.c(sharedPreferences, "this.getSharedPreference…PF, Context.MODE_PRIVATE)");
        this.f5545a = sharedPreferences;
        for (int i = 0; i < 10 && (!f92.a(e50.f677a.y0(), "root")); i++) {
            Thread.sleep(3000L);
        }
        if (!f92.a(e50.f677a.y0(), "root")) {
            return;
        }
        if (e50.f677a.r0()) {
            z90.b(z90.f8048a, aa0.BOOT_COMPLETED, null, 2, null);
            a();
        } else {
            String string = getString(u61.boot_fail);
            f92.c(string, "getString(R.string.boot_fail)");
            f(string);
        }
    }
}
