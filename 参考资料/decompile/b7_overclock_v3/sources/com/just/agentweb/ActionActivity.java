package com.just.agentweb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import g.n0;
import g.p0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public final class ActionActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21731c = "KEY_ACTION";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21732d = "KEY_URI";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f21733e = "KEY_FROM_INTENTION";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21734f = "KEY_FILE_CHOOSER_INTENT";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f21735g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f21736h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f21737i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f21738j = "ActionActivity";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f21739k = 596;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Action f21740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Uri f21741b;

    public interface a {
        void a(int i10, int i11, Intent intent);
    }

    public interface b {
        void a(@n0 String[] strArr, @n0 int[] iArr, Bundle bundle);
    }

    public interface c {
        void a(boolean z10, Bundle bundle);
    }

    public static void g(a aVar) {
        f21737i = aVar;
    }

    public static void h(b bVar) {
        f21736h = bVar;
    }

    public static void i(Activity activity, Action action) {
        Intent intent = new Intent(activity, (Class<?>) ActionActivity.class);
        intent.putExtra(f21731c, action);
        activity.startActivity(intent);
    }

    public final void a() {
        f21737i = null;
        f21736h = null;
        f21735g = null;
    }

    public final void b(int i10, Intent intent) {
        a aVar = f21737i;
        if (aVar != null) {
            aVar.a(596, i10, intent);
            f21737i = null;
        }
        finish();
    }

    public final void c(Action action) {
        if (f21737i == null) {
            finish();
        }
        f();
    }

    public final void d(Action action) {
        ArrayList<String> arrayListG = action.g();
        if (com.just.agentweb.a.J(arrayListG)) {
            f21736h = null;
            f21735g = null;
            finish();
            return;
        }
        boolean zShouldShowRequestPermissionRationale = false;
        if (f21735g == null) {
            if (f21736h != null) {
                requestPermissions((String[]) arrayListG.toArray(new String[0]), 1);
            }
        } else {
            Iterator<String> it2 = arrayListG.iterator();
            while (it2.hasNext() && !(zShouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale(it2.next()))) {
            }
            f21735g.a(zShouldShowRequestPermissionRationale, new Bundle());
            f21735g = null;
            finish();
        }
    }

    public final void e() {
        try {
            if (f21737i == null) {
                finish();
            }
            File fileL = com.just.agentweb.a.l(this);
            if (fileL == null) {
                f21737i.a(596, 0, null);
                f21737i = null;
                finish();
            }
            Intent intentY = com.just.agentweb.a.y(this, fileL);
            this.f21741b = (Uri) intentY.getParcelableExtra("output");
            startActivityForResult(intentY, 596);
        } catch (Throwable th2) {
            c0.a(f21738j, "找不到系统相机");
            a aVar = f21737i;
            if (aVar != null) {
                aVar.a(596, 0, null);
            }
            f21737i = null;
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    public final void f() {
        try {
            if (f21737i == null) {
                finish();
                return;
            }
            Intent intent = (Intent) getIntent().getParcelableExtra(f21734f);
            if (intent == null) {
                a();
            } else {
                startActivityForResult(intent, 596);
            }
        } catch (Throwable th2) {
            c0.c(f21738j, "找不到文件选择器");
            b(-1, null);
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 596) {
            if (this.f21741b != null) {
                intent = new Intent().putExtra(f21732d, this.f21741b);
            }
            b(i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            c0.c(f21738j, "savedInstanceState:" + bundle);
            return;
        }
        Action action = (Action) getIntent().getParcelableExtra(f21731c);
        this.f21740a = action;
        if (action == null) {
            a();
            finish();
        } else if (action.b() == 1) {
            d(this.f21740a);
        } else if (this.f21740a.b() == 3) {
            e();
        } else {
            c(this.f21740a);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, @n0 String[] strArr, @n0 int[] iArr) {
        if (f21736h != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(f21733e, this.f21740a.e());
            f21736h.a(strArr, iArr, bundle);
        }
        f21736h = null;
        finish();
    }
}
