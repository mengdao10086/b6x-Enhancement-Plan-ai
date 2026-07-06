package a;

import a.d70;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c70<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return w52.a(Boolean.valueOf(!((d70.a) t).getSelected()), Boolean.valueOf(!((d70.a) t2).getSelected()));
    }
}
