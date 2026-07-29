package p3;

import android.app.Activity;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import r3.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f46317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f46318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.fragment.app.Fragment f46319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f46320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f46321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f46322f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r3.b f46324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f46325i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46323g = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<com.app.hubert.guide.model.a> f46326j = new ArrayList();

    public a(Activity activity) {
        this.f46317a = activity;
    }

    public a a(com.app.hubert.guide.model.a aVar) {
        this.f46326j.add(aVar);
        return this;
    }

    public a b(boolean z10) {
        this.f46321e = z10;
        return this;
    }

    public a c(View view) {
        this.f46322f = view;
        return this;
    }

    public b d() {
        e();
        return new b(this);
    }

    public final void e() {
        if (TextUtils.isEmpty(this.f46320d)) {
            throw new IllegalArgumentException("the param 'label' is missing, please call setLabel()");
        }
        if (this.f46317a == null) {
            if (this.f46318b != null || this.f46319c != null) {
                throw new IllegalStateException("activity is null, please make sure that fragment is showing when call NewbieGuide");
            }
        }
    }

    public a f(String str) {
        this.f46320d = str;
        return this;
    }

    public a g(r3.b bVar) {
        this.f46324h = bVar;
        return this;
    }

    public a h(e eVar) {
        this.f46325i = eVar;
        return this;
    }

    public a i(int i10) {
        this.f46323g = i10;
        return this;
    }

    public b j() {
        e();
        b bVar = new b(this);
        bVar.p();
        return bVar;
    }

    public a(Fragment fragment) {
        this.f46318b = fragment;
        this.f46317a = fragment.getActivity();
    }

    public a(androidx.fragment.app.Fragment fragment) {
        this.f46319c = fragment;
        this.f46317a = fragment.w1();
    }
}
