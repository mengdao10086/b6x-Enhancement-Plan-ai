package a;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ec1<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f721a;

    public ec1(List list, int i) {
        this.f721a = list;
        this.f5990a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String str = (String) t;
        String str2 = (String) t2;
        return w52.a(Integer.valueOf(this.f721a.contains(str) ? this.f721a.indexOf(str) : this.f5990a), Integer.valueOf(this.f721a.contains(str2) ? this.f721a.indexOf(str2) : this.f5990a));
    }
}
