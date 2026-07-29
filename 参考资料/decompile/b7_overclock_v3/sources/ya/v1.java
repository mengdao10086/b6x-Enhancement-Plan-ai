package ya;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f57197i = "StreamVolumeManager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f57198j = "android.media.VOLUME_CHANGED_ACTION";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f57199k = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f57200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f57201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f57202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioManager f57203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.p0
    public c f57204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f57205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f57207h;

    public interface b {
        void H(int i10, boolean z10);

        void q(int i10);
    }

    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = v1.this.f57201b;
            final v1 v1Var = v1.this;
            handler.post(new Runnable() { // from class: ya.w1
                @Override // java.lang.Runnable
                public final void run() {
                    v1.b(v1Var);
                }
            });
        }
    }

    public v1(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f57200a = applicationContext;
        this.f57201b = handler;
        this.f57202c = bVar;
        AudioManager audioManager = (AudioManager) hd.a.k((AudioManager) applicationContext.getSystemService("audio"));
        this.f57203d = audioManager;
        this.f57205f = 3;
        this.f57206g = h(audioManager, 3);
        this.f57207h = f(audioManager, this.f57205f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter(f57198j));
            this.f57204e = cVar;
        } catch (RuntimeException e10) {
            hd.t.o(f57197i, "Error registering stream volume receiver", e10);
        }
    }

    public static /* synthetic */ void b(v1 v1Var) {
        v1Var.o();
    }

    public static boolean f(AudioManager audioManager, int i10) {
        return hd.u0.f31154a >= 23 ? audioManager.isStreamMute(i10) : h(audioManager, i10) == 0;
    }

    public static int h(AudioManager audioManager, int i10) {
        try {
            return audioManager.getStreamVolume(i10);
        } catch (RuntimeException e10) {
            hd.t.o(f57197i, "Could not retrieve stream volume for stream type " + i10, e10);
            return audioManager.getStreamMaxVolume(i10);
        }
    }

    public void c() {
        if (this.f57206g <= e()) {
            return;
        }
        this.f57203d.adjustStreamVolume(this.f57205f, -1, 1);
        o();
    }

    public int d() {
        return this.f57203d.getStreamMaxVolume(this.f57205f);
    }

    public int e() {
        if (hd.u0.f31154a >= 28) {
            return this.f57203d.getStreamMinVolume(this.f57205f);
        }
        return 0;
    }

    public int g() {
        return this.f57206g;
    }

    public void i() {
        if (this.f57206g >= d()) {
            return;
        }
        this.f57203d.adjustStreamVolume(this.f57205f, 1, 1);
        o();
    }

    public boolean j() {
        return this.f57207h;
    }

    public void k() {
        c cVar = this.f57204e;
        if (cVar != null) {
            try {
                this.f57200a.unregisterReceiver(cVar);
            } catch (RuntimeException e10) {
                hd.t.o(f57197i, "Error unregistering stream volume receiver", e10);
            }
            this.f57204e = null;
        }
    }

    public void l(boolean z10) {
        if (hd.u0.f31154a >= 23) {
            this.f57203d.adjustStreamVolume(this.f57205f, z10 ? -100 : 100, 1);
        } else {
            this.f57203d.setStreamMute(this.f57205f, z10);
        }
        o();
    }

    public void m(int i10) {
        if (this.f57205f == i10) {
            return;
        }
        this.f57205f = i10;
        o();
        this.f57202c.q(i10);
    }

    public void n(int i10) {
        if (i10 < e() || i10 > d()) {
            return;
        }
        this.f57203d.setStreamVolume(this.f57205f, i10, 1);
        o();
    }

    public final void o() {
        int iH = h(this.f57203d, this.f57205f);
        boolean zF = f(this.f57203d, this.f57205f);
        if (this.f57206g == iH && this.f57207h == zF) {
            return;
        }
        this.f57206g = iH;
        this.f57207h = zF;
        this.f57202c.H(iH, zF);
    }
}
