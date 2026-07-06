package a;

import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class re1<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return w52.a(Integer.valueOf(((Number) t).intValue()), Integer.valueOf(((Number) t2).intValue()));
    }
}
