package ab;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final BroadcastReceiver f436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final b f437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public e f438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f439g;

    public final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f441b;

        public b(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f440a = contentResolver;
            this.f441b = uri;
        }

        public void a() {
            this.f440a.registerContentObserver(this.f441b, false, this);
        }

        public void b() {
            this.f440a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            f fVar = f.this;
            fVar.c(e.b(fVar.f433a));
        }
    }

    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            f.this.c(e.c(context, intent));
        }
    }

    public interface d {
        void a(e eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.f433a = applicationContext;
        this.f434b = (d) hd.a.g(dVar);
        Handler handlerB = u0.B();
        this.f435c = handlerB;
        this.f436d = u0.f31154a >= 21 ? new c() : null;
        Uri uriD = e.d();
        this.f437e = uriD != null ? new b(handlerB, applicationContext.getContentResolver(), uriD) : null;
    }

    public final void c(e eVar) {
        if (!this.f439g || eVar.equals(this.f438f)) {
            return;
        }
        this.f438f = eVar;
        this.f434b.a(eVar);
    }

    public e d() {
        if (this.f439g) {
            return (e) hd.a.g(this.f438f);
        }
        this.f439g = true;
        b bVar = this.f437e;
        if (bVar != null) {
            bVar.a();
        }
        Intent intentRegisterReceiver = null;
        if (this.f436d != null) {
            intentRegisterReceiver = this.f433a.registerReceiver(this.f436d, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.f435c);
        }
        e eVarC = e.c(this.f433a, intentRegisterReceiver);
        this.f438f = eVarC;
        return eVarC;
    }

    public void e() {
        if (this.f439g) {
            this.f438f = null;
            BroadcastReceiver broadcastReceiver = this.f436d;
            if (broadcastReceiver != null) {
                this.f433a.unregisterReceiver(broadcastReceiver);
            }
            b bVar = this.f437e;
            if (bVar != null) {
                bVar.b();
            }
            this.f439g = false;
        }
    }
}
