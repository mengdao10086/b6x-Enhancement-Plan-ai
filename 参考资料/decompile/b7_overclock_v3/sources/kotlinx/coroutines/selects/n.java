package kotlinx.coroutines.selects;

import ik.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
@s0
public class n<R> extends SelectImplementation<R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final List<SelectImplementation<R>.a> f39036g;

    public n(@yt.k CoroutineContext coroutineContext) {
        super(coroutineContext);
        this.f39036g = new ArrayList();
    }

    @s0
    public static /* synthetic */ <R> Object l0(n<R> nVar, kotlin.coroutines.c<? super R> cVar) {
        nVar.n0();
        return super.R(cVar);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    @yt.l
    @s0
    public Object R(@yt.k kotlin.coroutines.c<? super R> cVar) {
        return l0(this, cVar);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.b
    public <P, Q> void j(@yt.k g<? super P, ? extends Q> gVar, P p10, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        this.f39036g.add(new SelectImplementation.a(gVar.b(), gVar.a(), gVar.d(), p10, pVar, gVar.c()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.b
    public void k(@yt.k c cVar, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        this.f39036g.add(new SelectImplementation.a(cVar.b(), cVar.a(), cVar.d(), SelectKt.l(), lVar, cVar.c()));
    }

    public final void n0() {
        try {
            Collections.shuffle(this.f39036g);
            Iterator<T> it2 = this.f39036g.iterator();
            while (it2.hasNext()) {
                SelectImplementation.f0(this, (SelectImplementation.a) it2.next(), false, 1, null);
            }
        } finally {
            this.f39036g.clear();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.b
    public <Q> void p(@yt.k e<? extends Q> eVar, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        this.f39036g.add(new SelectImplementation.a(eVar.b(), eVar.a(), eVar.d(), null, pVar, eVar.c()));
    }
}
