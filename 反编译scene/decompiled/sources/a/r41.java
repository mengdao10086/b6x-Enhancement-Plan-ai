package a;

import android.content.pm.ComponentInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r41<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u41 f7270a;

    public r41(u41 u41Var) {
        this.f7270a = u41Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        ComponentInfo componentInfo = (ComponentInfo) t;
        int i = 0;
        Integer numValueOf = Integer.valueOf(f92.a(this.f7270a.c, componentInfo.name) ? -1 : (componentInfo.exported && componentInfo.enabled) ? 0 : 1);
        ComponentInfo componentInfo2 = (ComponentInfo) t2;
        if (f92.a(this.f7270a.c, componentInfo2.name)) {
            i = -1;
        } else if (!componentInfo2.exported || !componentInfo2.enabled) {
            i = 1;
        }
        return w52.a(numValueOf, Integer.valueOf(i));
    }
}
