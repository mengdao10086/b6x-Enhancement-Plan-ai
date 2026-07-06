package a;

import a.p80;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.ui.BlurViewRecyclerView;
import com.omarea.vtools.activities.ActivityCommandList;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r91 implements v01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCommandList f7284a;

    public r91(ActivityCommandList activityCommandList) {
        this.f7284a = activityCommandList;
    }

    @Override // a.v01
    public void a(View view, int i) {
        f92.d(view, "view");
        BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) this.f7284a._$_findCachedViewById(t61.list_commands);
        f92.c(blurViewRecyclerView, "list_commands");
        RecyclerView.g adapter = blurViewRecyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterCommandList");
        }
        g50 g50VarZ = ((w01) adapter).z(i);
        p80.a aVar = p80.f2403a;
        ActivityCommandList activityCommandList = this.f7284a;
        String strB = g50VarZ.b();
        String str = "# " + g50VarZ.a() + "\n\n" + o72.d(new File(g50VarZ.a()), bb2.f5692a);
        String string = this.f7284a.getString(u61.btn_test_run);
        f92.c(string, "getString(R.string.btn_test_run)");
        q80 q80Var = new q80(string, new q91(this, g50VarZ), false, 4, null);
        String string2 = this.f7284a.getString(u61.btn_back);
        f92.c(string2, "getString(R.string.btn_back)");
        aVar.h(activityCommandList, strB, str, q80Var, new q80(string2, null, false, 6, null));
    }
}
