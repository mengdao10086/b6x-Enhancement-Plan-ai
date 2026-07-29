package p9;

import hk.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f46512a = new a();

    @m
    @k
    public static final <T> List<List<T>> a(@k List<? extends T> list, int i10) {
        f0.p(list, "list");
        int size = list.size();
        int i11 = i10 - 1;
        int i12 = (size + i11) / i10;
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            ArrayList arrayList2 = new ArrayList(size);
            int i14 = 0;
            while (i14 < size) {
                int i15 = i14 + 1;
                if ((i15 + i11) / i10 == i13 + 1) {
                    arrayList2.add(list.get(i14));
                }
                if (i15 == i15 * i10) {
                    break;
                }
                i14 = i15;
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
