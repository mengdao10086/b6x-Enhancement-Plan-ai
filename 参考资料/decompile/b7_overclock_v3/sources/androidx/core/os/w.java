package androidx.core.os;

import android.os.PersistableBundle;
import g.v0;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nPersistableBundle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,155:1\n13579#2,2:156\n*S KotlinDebug\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n*L\n35#1:156,2\n*E\n"})
public final class w {
    @yt.k
    @v0(21)
    public static final PersistableBundle a() {
        return u.a(0);
    }

    @yt.k
    @v0(21)
    public static final PersistableBundle b(@yt.k Pair<String, ? extends Object>... pairs) {
        f0.p(pairs, "pairs");
        PersistableBundle persistableBundleA = u.a(pairs.length);
        for (Pair<String, ? extends Object> pair : pairs) {
            u.b(persistableBundleA, pair.a(), pair.b());
        }
        return persistableBundleA;
    }

    @yt.k
    @v0(21)
    public static final PersistableBundle c(@yt.k Map<String, ? extends Object> map) {
        f0.p(map, "<this>");
        PersistableBundle persistableBundleA = u.a(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            u.b(persistableBundleA, entry.getKey(), entry.getValue());
        }
        return persistableBundleA;
    }
}
