package a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class el1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fl1 f6019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String[] f770a;

    public el1(fl1 fl1Var, ArrayList arrayList, String[] strArr) {
        this.f6019a = fl1Var;
        this.f769a = arrayList;
        this.f770a = strArr;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        if (!list.isEmpty()) {
            int iIndexOf = this.f769a.indexOf(i52.A(list));
            fl1 fl1Var = this.f6019a;
            String str = this.f770a[iIndexOf];
            f92.c(str, "values.get(this)");
            fl1Var.u(str);
        }
    }
}
