package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.i;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public static final String f6416a = "androidx.profileinstaller.action.INSTALL_PROFILE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public static final String f6417b = "androidx.profileinstaller.action.SAVE_PROFILE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public static final String f6418c = "androidx.profileinstaller.action.SKIP_FILE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public static final String f6419d = "androidx.profileinstaller.action.BENCHMARK_OPERATION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public static final String f6420e = "EXTRA_SKIP_FILE_OPERATION";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public static final String f6421f = "WRITE_SKIP_FILE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public static final String f6422g = "DELETE_SKIP_FILE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public static final String f6423h = "EXTRA_BENCHMARK_OPERATION";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public static final String f6424i = "DROP_SHADER_CACHE";

    public class a implements i.d {
        public a() {
        }

        @Override // androidx.profileinstaller.i.d
        public void a(int i10, @p0 Object obj) {
            i.f6468h.a(i10, obj);
        }

        @Override // androidx.profileinstaller.i.d
        public void b(int i10, @p0 Object obj) {
            i.f6468h.b(i10, obj);
            ProfileInstallReceiver.this.setResultCode(i10);
        }
    }

    public static void a(@n0 i.d dVar) {
        if (Build.VERSION.SDK_INT < 24) {
            dVar.b(13, null);
        } else {
            Process.sendSignal(Process.myPid(), 10);
            dVar.b(12, null);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@n0 Context context, @p0 Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (f6416a.equals(action)) {
            i.n(context, f.f6454a, new a(), true);
            return;
        }
        if (f6418c.equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString(f6420e);
                if (f6421f.equals(string)) {
                    i.o(context, f.f6454a, new a());
                    return;
                } else {
                    if (f6422g.equals(string)) {
                        i.d(context, f.f6454a, new a());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (f6417b.equals(action)) {
            a(new a());
            return;
        }
        if (!f6419d.equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString(f6423h);
        a aVar = new a();
        if (f6424i.equals(string2)) {
            androidx.profileinstaller.a.b(context, aVar);
        } else {
            aVar.b(16, null);
        }
    }
}
