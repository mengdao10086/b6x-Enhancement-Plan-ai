package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nInlineList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
@hk.f
public final class o<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Object f38822a;

    public /* synthetic */ o(Object obj) {
        this.f38822a = obj;
    }

    public static final /* synthetic */ o a(Object obj) {
        return new o(obj);
    }

    @yt.k
    public static <E> Object b(@yt.l Object obj) {
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, int i10, kotlin.jvm.internal.u uVar) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return b(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof o) && kotlin.jvm.internal.f0.g(obj, ((o) obj2).j());
    }

    public static final boolean e(Object obj, Object obj2) {
        return kotlin.jvm.internal.f0.g(obj, obj2);
    }

    public static final void f(Object obj, @yt.k ik.l<? super E, z1> lVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            lVar.i(obj);
            return;
        }
        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                lVar.i((Object) arrayList.get(size));
            }
        }
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @yt.k
    public static final Object h(Object obj, E e10) {
        if (obj == null) {
            return b(e10);
        }
        if (obj instanceof ArrayList) {
            kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e10);
            return b(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e10);
        return b(arrayList);
    }

    public static String i(Object obj) {
        return "InlineList(holder=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f38822a, obj);
    }

    public int hashCode() {
        return g(this.f38822a);
    }

    public final /* synthetic */ Object j() {
        return this.f38822a;
    }

    public String toString() {
        return i(this.f38822a);
    }
}
