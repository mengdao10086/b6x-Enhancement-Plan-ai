package com.flydigi.sdk.bluetooth;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
@zj.d(c = "com.flydigi.sdk.bluetooth.AbstractDataInteractionController", f = "AbstractDataInteractionController.kt", i = {0}, l = {55}, m = "runFetchLoop", n = {"this"}, s = {"L$0"})
public final class AbstractDataInteractionController$runFetchLoop$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AbstractDataInteractionController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractDataInteractionController$runFetchLoop$1(AbstractDataInteractionController abstractDataInteractionController, kotlin.coroutines.c<? super AbstractDataInteractionController$runFetchLoop$1> cVar) {
        super(cVar);
        this.this$0 = abstractDataInteractionController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c1(this);
    }
}
