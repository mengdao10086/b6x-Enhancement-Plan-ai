package a;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ya0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f3671a;

    public ya0(Context context) {
        f92.d(context, "context");
        this.f3671a = context;
    }

    public final ya0 c() {
        Context applicationContext = this.f3671a.getApplicationContext() != null ? this.f3671a.getApplicationContext() : this.f3671a;
        applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
        if (Build.VERSION.SDK_INT >= 24) {
            applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        }
        applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_ON"));
        applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.USER_PRESENT"));
        qc2.d(xd2.a(qe2.b()), null, null, new wa0(this, null), 3, null);
        return this;
    }

    public final boolean d() {
        Object systemService = this.f3671a.getSystemService("keyguard");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
        }
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        try {
            if (!keyguardManager.isKeyguardLocked() && !keyguardManager.inKeyguardRestrictedInputMode()) {
                z90.b(z90.f8048a, aa0.SCREEN_ON, null, 2, null);
                fa0.f867a.v(true);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            if (r11 != 0) goto L3
            return
        L3:
            android.content.BroadcastReceiver$PendingResult r10 = r9.goAsync()
            java.lang.String r11 = r11.getAction()
            if (r11 != 0) goto Le
            goto L7c
        Le:
            int r0 = r11.hashCode()
            r1 = 2
            r2 = 0
            switch(r0) {
                case -2128145023: goto L61;
                case -1454123155: goto L3a;
                case 823795052: goto L21;
                case 833559602: goto L18;
                default: goto L17;
            }
        L17:
            goto L7c
        L18:
            java.lang.String r0 = "android.intent.action.USER_UNLOCKED"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L7c
            goto L42
        L21:
            java.lang.String r0 = "android.intent.action.USER_PRESENT"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L7c
            long r3 = java.lang.System.currentTimeMillis()
            r9.f7962a = r3
            a.z90 r11 = a.z90.f8048a
            a.aa0 r0 = a.aa0.SCREEN_ON
            a.z90.b(r11, r0, r2, r1, r2)
            a.fa0 r11 = a.fa0.f867a
            r0 = 1
            goto L79
        L3a:
            java.lang.String r0 = "android.intent.action.SCREEN_ON"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L7c
        L42:
            long r0 = java.lang.System.currentTimeMillis()
            long r3 = java.lang.System.currentTimeMillis()
            r9.f7962a = r3
            a.od2 r11 = a.qe2.b()
            a.wd2 r3 = a.xd2.a(r11)
            r4 = 0
            r5 = 0
            a.xa0 r6 = new a.xa0
            r6.<init>(r9, r0, r2)
            r7 = 3
            r8 = 0
            a.oc2.d(r3, r4, r5, r6, r7, r8)
            goto L7c
        L61:
            java.lang.String r0 = "android.intent.action.SCREEN_OFF"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L7c
            long r3 = java.lang.System.currentTimeMillis()
            r9.f7962a = r3
            a.z90 r11 = a.z90.f8048a
            a.aa0 r0 = a.aa0.SCREEN_OFF
            a.z90.b(r11, r0, r2, r1, r2)
            a.fa0 r11 = a.fa0.f867a
            r0 = 0
        L79:
            r11.v(r0)
        L7c:
            r10.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ya0.onReceive(android.content.Context, android.content.Intent):void");
    }
}
