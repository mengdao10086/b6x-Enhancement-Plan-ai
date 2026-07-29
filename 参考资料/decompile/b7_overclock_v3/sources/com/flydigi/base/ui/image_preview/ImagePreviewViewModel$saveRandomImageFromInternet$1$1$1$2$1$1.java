package com.flydigi.base.ui.image_preview;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "com.flydigi.base.ui.image_preview.ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1", f = "ImagePreviewViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.a<z1> $callback;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1(ik.a<z1> aVar, kotlin.coroutines.c<? super ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1> cVar) {
        super(2, cVar);
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        return new ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1(this.$callback, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        this.$callback.o();
        return z1.f38230a;
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l kotlin.coroutines.c<? super z1> cVar) {
        return ((ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
