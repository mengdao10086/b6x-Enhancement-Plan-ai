package a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l0 extends ArrayAdapter<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f6658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController.RecycleListView f1700a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(q0 q0Var, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.f6658a = q0Var;
        this.f1700a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f6658a.f2507a;
        if (zArr != null && zArr[i]) {
            this.f1700a.setItemChecked(i, true);
        }
        return view2;
    }
}
