package androidx.work;

import androidx.work.m;
import g.n0;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0086\b\u001a\u001f\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0086\b¨\u0006\b"}, d2 = {"Landroidx/work/ListenableWorker;", i1.a.T4, "Landroidx/work/m$a;", "a", "Lkotlin/reflect/d;", "Landroidx/work/j;", "inputMerger", "b", "work-runtime-ktx_release"}, k = 2, mv = {1, 5, 1})
public final class n {
    public static final /* synthetic */ <W extends ListenableWorker> m.a a() {
        f0.y(4, i1.a.T4);
        return new m.a(ListenableWorker.class);
    }

    @yt.k
    public static final m.a b(@yt.k m.a aVar, @yt.k @n0 kotlin.reflect.d<? extends j> inputMerger) {
        f0.p(aVar, "<this>");
        f0.p(inputMerger, "inputMerger");
        m.a aVarT = aVar.t(hk.a.e(inputMerger));
        f0.o(aVarT, "setInputMerger(inputMerger.java)");
        return aVarT;
    }
}
