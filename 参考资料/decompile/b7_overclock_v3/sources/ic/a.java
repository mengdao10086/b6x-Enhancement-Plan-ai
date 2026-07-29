package ic;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f32025g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i> f32028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f32029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f32030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<d> f32031f;

    public a(int i10, int i11, List<i> list, List<d> list2, List<d> list3, List<d> list4) {
        this.f32026a = i10;
        this.f32027b = i11;
        this.f32028c = Collections.unmodifiableList(list);
        this.f32029d = Collections.unmodifiableList(list2);
        this.f32030e = Collections.unmodifiableList(list3);
        this.f32031f = Collections.unmodifiableList(list4);
    }
}
