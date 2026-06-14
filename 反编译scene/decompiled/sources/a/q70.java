package a;

import android.widget.Filter;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q70 extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u70 f7184a;

    public q70(u70 u70Var) {
        f92.d(u70Var, "adapter");
        this.f7184a = u70Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010e A[SYNTHETIC] */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r17) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.q70.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        u70 u70Var = this.f7184a;
        f92.b(filterResults);
        Object obj = filterResults.values;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.omarea.common.model.SelectItem> /* = java.util.ArrayList<com.omarea.common.model.SelectItem> */");
        }
        u70Var.i((ArrayList) obj);
        if (filterResults.count > 0) {
            this.f7184a.notifyDataSetChanged();
        } else {
            this.f7184a.notifyDataSetInvalidated();
        }
    }
}
