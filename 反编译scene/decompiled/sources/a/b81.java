package a;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityAppConfig2;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b81 implements vj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AdapterView f240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AppInfo f241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppConfig2.d f242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f243a;

    public b81(ActivityAppConfig2.d dVar, String str, AppInfo appInfo, AdapterView adapterView, int i, View view) {
        this.f242a = dVar;
        this.f243a = str;
        this.f241a = appInfo;
        this.f240a = adapterView;
        this.f5682a = i;
        this.f239a = view;
    }

    @Override // a.vj1
    public void a(String str) {
        SharedPreferences.Editor editorEdit = ActivityAppConfig2.this.A().edit();
        (str == null || str.length() == 0 ? editorEdit.remove(this.f243a) : editorEdit.putString(this.f243a, str)).apply();
        ActivityAppConfig2.this.E(this.f241a);
        AdapterView adapterView = this.f240a;
        f92.c(adapterView, "parent");
        Adapter adapter = adapterView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterSceneMode");
        }
        int i = this.f5682a;
        View view = this.f239a;
        f92.c(view, "view");
        ((p21) adapter).g(i, view);
        ActivityAppConfig2.this.D(this.f243a, "" + str);
    }
}
