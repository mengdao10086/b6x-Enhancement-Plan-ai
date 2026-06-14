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
public final class er1 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fr1 f6034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WeakReference f785a;

    public er1(fr1 fr1Var, WeakReference weakReference) {
        this.f6034a = fr1Var;
        this.f785a = weakReference;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (f92.a(e50.f677a.y0(), "basic")) {
            ListView listView = (ListView) this.f6034a.f6133a.w1(t61.app_list);
            f92.c(listView, "app_list");
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppList");
            }
            AppInfo item = ((p01) adapter).getItem(i);
            cl clVarJ = this.f6034a.f6133a.j();
            f92.b(clVarJ);
            f92.c(clVarJ, "activity!!");
            new iq1(clVarJ, item, gr1.z1(this.f6034a.f6133a)).c0();
            return;
        }
        View viewFindViewById = view.findViewById(t61.select_state);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        }
        ((CheckBox) viewFindViewById).setChecked(!r1.isChecked());
        if (this.f785a.get() != null) {
            CheckBox checkBox = (CheckBox) this.f6034a.f6133a.w1(t61.select_state_all);
            f92.c(checkBox, "select_state_all");
            Object obj = this.f785a.get();
            f92.b(obj);
            checkBox.setChecked(((p01) obj).c());
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.f6034a.f6133a.w1(t61.fab_apps);
        f92.c(floatingActionButton, "fab_apps");
        p01 p01Var = (p01) this.f785a.get();
        floatingActionButton.setVisibility((p01Var == null || !p01Var.g()) ? 8 : 0);
    }
}
