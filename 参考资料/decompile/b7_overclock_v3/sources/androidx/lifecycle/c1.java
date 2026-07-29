package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Map<String, x0> f6175a = new LinkedHashMap();

    public final void a() {
        Iterator<x0> it2 = this.f6175a.values().iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
        this.f6175a.clear();
    }

    @yt.l
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final x0 b(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return this.f6175a.get(key);
    }

    @yt.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> c() {
        return new HashSet(this.f6175a.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void d(@yt.k String key, @yt.k x0 viewModel) {
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(viewModel, "viewModel");
        x0 x0VarPut = this.f6175a.put(key, viewModel);
        if (x0VarPut != null) {
            x0VarPut.e();
        }
    }
}
