package a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.omarea.model.AppInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rq1 implements AdapterView.OnItemLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wq1 f7324a;

    public rq1(wq1 wq1Var) {
        this.f7324a = wq1Var;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListView listView = (ListView) this.f7324a.w1(t61.app_list);
        f92.c(listView, "app_list");
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppList");
        }
        AppInfo item = ((p01) adapter).getItem(i);
        cl clVarJ = this.f7324a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        new iq1(clVarJ, item, wq1.z1(this.f7324a)).c0();
        return true;
    }
}
