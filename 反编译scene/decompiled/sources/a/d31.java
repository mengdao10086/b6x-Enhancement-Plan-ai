package a;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d31<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f475a;

    public d31(List list, int i) {
        this.f475a = list;
        this.f5856a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String str = (String) t;
        String str2 = (String) t2;
        return w52.a(Integer.valueOf(this.f475a.contains(str) ? this.f475a.indexOf(str) : this.f5856a), Integer.valueOf(this.f475a.contains(str2) ? this.f475a.indexOf(str2) : this.f5856a));
    }
}
