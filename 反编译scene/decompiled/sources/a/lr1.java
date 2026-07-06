package a;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lr1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rr1 f6734a;

    public lr1(rr1 rr1Var) {
        this.f6734a = rr1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ListView listView = (ListView) this.f6734a.w1(t61.app_list);
        f92.c(listView, "app_list");
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppList");
        }
        p01 p01Var = (p01) adapter;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        p01Var.i(((CompoundButton) view).isChecked());
        p01Var.notifyDataSetChanged();
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.f6734a.w1(t61.fab_apps);
        f92.c(floatingActionButton, "fab_apps");
        floatingActionButton.setVisibility(p01Var.g() ? 0 : 8);
    }
}
