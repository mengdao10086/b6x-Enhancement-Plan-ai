package a;

import android.widget.Toast;
import com.omarea.krscript.model.PickerNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ae0 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ be0 f5598a;

    public ae0(be0 be0Var) {
        this.f5598a = be0Var;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        String str = "";
        if (this.f5598a.f5698a.f389a.getMultiple()) {
            ce0 ce0Var = this.f5598a.f5698a;
            fe0 fe0Var = ce0Var.f5784a;
            PickerNode pickerNode = ce0Var.f389a;
            ArrayList arrayList = new ArrayList(z42.m(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add("" + ((n30) it.next()).e());
            }
            fe0Var.O1(pickerNode, i52.H(arrayList, this.f5598a.f5698a.f389a.getSeparator(), null, null, 0, null, null, 62, null), this.f5598a.f5698a.f390a);
            return;
        }
        if (list.size() <= 0) {
            Toast.makeText(this.f5598a.f5698a.f5784a.p(), this.f5598a.f5698a.f5784a.J(ob0.picker_select_none), 0).show();
            return;
        }
        ce0 ce0Var2 = this.f5598a.f5698a;
        fe0 fe0Var2 = ce0Var2.f5784a;
        PickerNode pickerNode2 = ce0Var2.f389a;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (list.size() > 0) {
            str = "" + list.get(0).e();
        }
        sb.append(str);
        fe0Var2.O1(pickerNode2, sb.toString(), this.f5598a.f5698a.f390a);
    }
}
