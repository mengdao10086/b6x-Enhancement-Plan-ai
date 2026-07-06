package a;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fr1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gr1 f6133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ListView f940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f941a;

    public fr1(gr1 gr1Var, List list, ListView listView) {
        this.f6133a = gr1Var;
        this.f941a = list;
        this.f940a = listView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Context contextP = this.f6133a.p();
            f92.b(contextP);
            f92.c(contextP, "context!!");
            p01 p01Var = new p01(contextP, new ArrayList(this.f941a), this.f6133a.G1(), f92.a(e50.f677a.y0(), "basic"));
            WeakReference weakReference = new WeakReference(p01Var);
            this.f940a.setAdapter((ListAdapter) p01Var);
            this.f940a.setOnItemClickListener(new er1(this, weakReference));
            CheckBox checkBox = (CheckBox) this.f6133a.w1(t61.select_state_all);
            f92.c(checkBox, "select_state_all");
            checkBox.setChecked(false);
            FloatingActionButton floatingActionButton = (FloatingActionButton) this.f6133a.w1(t61.fab_apps);
            f92.c(floatingActionButton, "fab_apps");
            floatingActionButton.setVisibility(8);
        } catch (Exception unused) {
        }
    }
}
