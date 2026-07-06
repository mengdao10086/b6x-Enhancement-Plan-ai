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
public final class vq1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wq1 f7717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ListView f3297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f3298a;

    public vq1(wq1 wq1Var, List list, ListView listView) {
        this.f7717a = wq1Var;
        this.f3298a = list;
        this.f3297a = listView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Context contextP = this.f7717a.p();
            f92.b(contextP);
            f92.c(contextP, "context!!");
            p01 p01Var = new p01(contextP, new ArrayList(this.f3298a), this.f7717a.G1(), f92.a(e50.f677a.y0(), "basic"));
            WeakReference weakReference = new WeakReference(p01Var);
            this.f3297a.setAdapter((ListAdapter) p01Var);
            this.f3297a.setOnItemClickListener(new uq1(this, weakReference));
            CheckBox checkBox = (CheckBox) this.f7717a.w1(t61.select_state_all);
            f92.c(checkBox, "select_state_all");
            checkBox.setChecked(false);
            FloatingActionButton floatingActionButton = (FloatingActionButton) this.f7717a.w1(t61.fab_apps);
            f92.c(floatingActionButton, "fab_apps");
            floatingActionButton.setVisibility(8);
        } catch (Exception unused) {
        }
    }
}
