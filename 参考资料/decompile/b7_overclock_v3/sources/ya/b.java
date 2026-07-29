package ya;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f56571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f56572c;

    public final class a extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0668b f56573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f56574b;

        public a(Handler handler, InterfaceC0668b interfaceC0668b) {
            this.f56574b = handler;
            this.f56573a = interfaceC0668b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f56574b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f56572c) {
                this.f56573a.u();
            }
        }
    }

    /* JADX INFO: renamed from: ya.b$b, reason: collision with other inner class name */
    public interface InterfaceC0668b {
        void u();
    }

    public b(Context context, Handler handler, InterfaceC0668b interfaceC0668b) {
        this.f56570a = context.getApplicationContext();
        this.f56571b = new a(handler, interfaceC0668b);
    }

    public void b(boolean z10) {
        if (z10 && !this.f56572c) {
            this.f56570a.registerReceiver(this.f56571b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f56572c = true;
        } else {
            if (z10 || !this.f56572c) {
                return;
            }
            this.f56570a.unregisterReceiver(this.f56571b);
            this.f56572c = false;
        }
    }
}
