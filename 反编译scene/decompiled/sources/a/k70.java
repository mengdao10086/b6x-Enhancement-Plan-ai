package a;

import android.widget.Filter;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class k70 extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v70 f6580a;

    public k70(v70 v70Var) {
        f92.d(v70Var, "adapter");
        this.f6580a = v70Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0123 A[SYNTHETIC] */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r17) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k70.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        v70 v70Var = this.f6580a;
        f92.b(filterResults);
        Object obj = filterResults.values;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.omarea.common.model.SelectItem> /* = java.util.ArrayList<com.omarea.common.model.SelectItem> */");
        }
        v70Var.k((ArrayList) obj);
        if (filterResults.count > 0) {
            this.f6580a.notifyDataSetChanged();
        } else {
            this.f6580a.notifyDataSetInvalidated();
        }
    }
}
