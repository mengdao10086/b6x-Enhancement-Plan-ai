package kotlinx.coroutines.flow.internal;

import ik.q;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements q<kotlinx.coroutines.flow.f<? super Object>, Object, kotlin.coroutines.c<? super z1>, Object>, zj.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f38704c = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, kotlinx.coroutines.flow.f.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k kotlinx.coroutines.flow.f<Object> fVar, @yt.l Object obj, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return fVar.f(obj, cVar);
    }
}
