package rx_activity_result2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* JADX INFO: loaded from: classes6.dex */
public class HolderActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static d f49210f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f49211g = -909;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f49212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnResult f49213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Intent f49216e;

    public class a implements dj.a {
        public a() {
        }

        @Override // dj.a
        public void run() throws Exception {
            HolderActivity.this.finish();
        }
    }

    public static void a(d dVar) {
        f49210f = dVar;
    }

    public final void b(e eVar) {
        try {
            startIntentSenderForResult(eVar.j(), 0, eVar.g(), eVar.h(), eVar.i(), eVar.f());
        } catch (IntentSender.SendIntentException e10) {
            e10.printStackTrace();
            this.f49213b.j(f49211g, 0, null);
        }
    }

    public final void c(e eVar) {
        try {
            startIntentSenderForResult(eVar.j(), 0, eVar.g(), eVar.h(), eVar.i(), eVar.f(), eVar.k());
        } catch (IntentSender.SendIntentException e10) {
            e10.printStackTrace();
            this.f49213b.j(f49211g, 0, null);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f49214c = i11;
        this.f49215d = i10;
        this.f49216e = intent;
        c cVar = this.f49212a;
        if (cVar != null) {
            cVar.j(i10, i11, intent).R1(new a()).D5();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d dVar = f49210f;
        if (dVar == null) {
            finish();
            return;
        }
        this.f49212a = dVar.b();
        this.f49213b = f49210f.c();
        if (bundle != null) {
            return;
        }
        d dVar2 = f49210f;
        if (dVar2 instanceof e) {
            e eVar = (e) dVar2;
            if (eVar.k() == null) {
                b(eVar);
                return;
            } else {
                c(eVar);
                return;
            }
        }
        try {
            startActivityForResult(dVar2.a(), 0);
        } catch (ActivityNotFoundException e10) {
            OnResult onResult = this.f49213b;
            if (onResult != null) {
                onResult.e(e10);
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OnResult onResult = this.f49213b;
        if (onResult != null) {
            onResult.j(this.f49215d, this.f49214c, this.f49216e);
        }
    }
}
