package a;

import android.widget.Filter;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o11 extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n11 f6970a;

    public o11(n11 n11Var) {
        this.f6970a = n11Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r14) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.o11.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Object arrayList;
        n11 n11Var = this.f6970a;
        if (filterResults == null || (arrayList = filterResults.values) == null) {
            arrayList = new ArrayList();
        }
        if (arrayList == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.omarea.store.ModulesStore.MagiskModuleDetail> /* = java.util.ArrayList<com.omarea.store.ModulesStore.MagiskModuleDetail> */");
        }
        n11Var.f1988a = (ArrayList) arrayList;
        this.f6970a.i();
    }
}
