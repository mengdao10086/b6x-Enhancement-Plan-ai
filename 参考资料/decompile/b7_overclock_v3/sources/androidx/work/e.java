package androidx.work;

import androidx.work.d;
import kotlin.Pair;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a@\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u000b\u001a\u00020\n\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0086\b¨\u0006\f"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "Landroidx/work/d;", "b", "([Lkotlin/Pair;)Landroidx/work/d;", i1.a.f31577d5, "key", "", "a", "work-runtime-ktx_release"}, k = 2, mv = {1, 5, 1})
public final class e {
    public static final /* synthetic */ <T> boolean a(d dVar, String key) {
        f0.p(dVar, "<this>");
        f0.p(key, "key");
        f0.y(4, i1.a.f31577d5);
        return dVar.C(key, Object.class);
    }

    @yt.k
    public static final d b(@yt.k Pair<String, ? extends Object>... pairs) throws Throwable {
        f0.p(pairs, "pairs");
        d.a aVar = new d.a();
        int length = pairs.length;
        int i10 = 0;
        while (i10 < length) {
            Pair<String, ? extends Object> pair = pairs[i10];
            i10++;
            aVar.b(pair.f(), pair.h());
        }
        d dVarA = aVar.a();
        f0.o(dVarA, "dataBuilder.build()");
        return dVarA;
    }
}
