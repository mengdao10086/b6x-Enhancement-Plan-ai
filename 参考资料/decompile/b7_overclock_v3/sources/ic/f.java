package ic;

import g.p0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f32066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f32068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f32069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final d f32070e;

    public f(@p0 String str, long j10, List<a> list) {
        this(str, j10, list, Collections.emptyList(), null);
    }

    public int a(int i10) {
        int size = this.f32068c.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f32068c.get(i11).f32027b == i10) {
                return i11;
            }
        }
        return -1;
    }

    public f(@p0 String str, long j10, List<a> list, List<e> list2) {
        this(str, j10, list, list2, null);
    }

    public f(@p0 String str, long j10, List<a> list, List<e> list2, @p0 d dVar) {
        this.f32066a = str;
        this.f32067b = j10;
        this.f32068c = Collections.unmodifiableList(list);
        this.f32069d = Collections.unmodifiableList(list2);
        this.f32070e = dVar;
    }
}
