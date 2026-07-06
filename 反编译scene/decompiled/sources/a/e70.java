package a;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e70 extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d70 f5974a;

    public e70(d70 d70Var) {
        f92.d(d70Var, "adapter");
        this.f5974a = d70Var;
    }

    public final boolean a(String str, String str2) {
        List listE;
        if (ec2.C(str, str2, false, 2, null)) {
            return true;
        }
        List<String> listH = new nb2(" ").h(str, 0);
        if (listH.isEmpty()) {
            listE = y42.e();
        } else {
            ListIterator<String> listIterator = listH.listIterator(listH.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listE = i52.V(listH, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listE = y42.e();
        }
        Object[] array = listE.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (String str3 : (String[]) array) {
            if (ec2.C(str3, str2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r12) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e70.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        d70 d70Var = this.f5974a;
        f92.b(filterResults);
        Object obj = filterResults.values;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.omarea.common.ui.AdapterAppChooser.AppInfo>");
        }
        d70Var.i((ArrayList) obj);
        if (filterResults.count > 0) {
            this.f5974a.notifyDataSetChanged();
        } else {
            this.f5974a.notifyDataSetInvalidated();
        }
    }
}
