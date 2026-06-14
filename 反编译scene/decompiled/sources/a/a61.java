package a;

import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a61<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f5573a;

    public a61(HashMap map) {
        this.f5573a = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Long l = (Long) this.f5573a.get((String) t2);
        if (l == null) {
            l = l;
        }
        Long l2 = (Long) this.f5573a.get((String) t);
        return w52.a(l, l2 != null ? l2 : 0L);
    }
}
