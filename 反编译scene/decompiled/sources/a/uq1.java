package a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.omarea.model.AppInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uq1 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vq1 f7623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WeakReference f3206a;

    public uq1(vq1 vq1Var, WeakReference weakReference) {
        this.f7623a = vq1Var;
        this.f3206a = weakReference;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (f92.a(e50.f677a.y0(), "basic")) {
            ListView listView = (ListView) this.f7623a.f7717a.w1(t61.app_list);
            f92.c(listView, "app_list");
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppList");
            }
            AppInfo item = ((p01) adapter).getItem(i);
            cl clVarJ = this.f7623a.f7717a.j();
            f92.b(clVarJ);
            f92.c(clVarJ, "activity!!");
            new iq1(clVarJ, item, wq1.z1(this.f7623a.f7717a)).c0();
            return;
        }
        CheckBox checkBox = (CheckBox) view.findViewById(t61.select_state);
        f92.c(checkBox, "checkBox");
        checkBox.setChecked(!checkBox.isChecked());
        if (this.f3206a.get() != null) {
            CheckBox checkBox2 = (CheckBox) this.f7623a.f7717a.w1(t61.select_state_all);
            f92.c(checkBox2, "select_state_all");
            Object obj = this.f3206a.get();
            f92.b(obj);
            checkBox2.setChecked(((p01) obj).c());
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.f7623a.f7717a.w1(t61.fab_apps);
        f92.c(floatingActionButton, "fab_apps");
        p01 p01Var = (p01) this.f3206a.get();
        floatingActionButton.setVisibility((p01Var == null || !p01Var.g()) ? 8 : 0);
    }
}
