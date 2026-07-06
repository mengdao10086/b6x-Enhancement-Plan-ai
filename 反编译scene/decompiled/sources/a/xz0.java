package a;

import android.widget.Filter;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xz0 extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zz0 f7933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3639a;

    public xz0(zz0 zz0Var) {
        f92.d(zz0Var, "adapterGrid");
        this.f7933a = zz0Var;
        this.f3639a = "";
    }

    public final CharSequence a() {
        return this.f3639a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0103 A[SYNTHETIC] */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r17) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.xz0.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        zz0 zz0Var = this.f7933a;
        f92.b(filterResults);
        Object obj = filterResults.values;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.omarea.model.AppInfo> /* = java.util.ArrayList<com.omarea.model.AppInfo> */");
        }
        zz0Var.I((ArrayList) obj);
        this.f7933a.i();
    }
}
