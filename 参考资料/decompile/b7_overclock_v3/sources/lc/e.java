package lc;

import cc.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements y<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f39567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f39568c;

    public e(String str, List<String> list, boolean z10) {
        this.f39566a = str;
        this.f39567b = Collections.unmodifiableList(list);
        this.f39568c = z10;
    }
}
