package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Map<String, Integer> f6208a = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean a(@yt.k String name, int i10) {
        kotlin.jvm.internal.f0.p(name, "name");
        Integer num = this.f6208a.get(name);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z10 = (iIntValue & i10) != 0;
        this.f6208a.put(name, Integer.valueOf(i10 | iIntValue));
        return !z10;
    }
}
