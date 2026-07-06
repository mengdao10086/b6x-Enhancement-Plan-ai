package a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.omarea.common.ui.OverScrollListView;
import com.omarea.vtools.activities.ActivityAppRetrieve;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n81 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o81 f6888a;

    public n81(o81 o81Var) {
        this.f6888a = o81Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p01 p01Var;
        p01 p01Var2;
        if (i != 0) {
            View viewFindViewById = view.findViewById(t61.select_state);
            if (viewFindViewById == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
            }
            ((CheckBox) viewFindViewById).setChecked(!r1.isChecked());
            CheckBox checkBox = (CheckBox) ((OverScrollListView) ActivityAppRetrieve.this._$_findCachedViewById(t61.hidden_app)).findViewById(2131362851);
            f92.c(checkBox, "all");
            WeakReference weakReference = ActivityAppRetrieve.this.f5151a;
            checkBox.setChecked((weakReference == null || (p01Var = (p01) weakReference.get()) == null || !p01Var.c()) ? false : true);
            return;
        }
        View viewFindViewById2 = adapterView.findViewById(2131362851);
        f92.c(viewFindViewById2, "parentView.findViewById(R.id.select_state_all)");
        CheckBox checkBox2 = (CheckBox) viewFindViewById2;
        checkBox2.setChecked(!checkBox2.isChecked());
        WeakReference weakReference2 = ActivityAppRetrieve.this.f5151a;
        if (weakReference2 == null || (p01Var2 = (p01) weakReference2.get()) == null) {
            return;
        }
        p01Var2.i(checkBox2.isChecked());
        p01Var2.notifyDataSetChanged();
    }
}
