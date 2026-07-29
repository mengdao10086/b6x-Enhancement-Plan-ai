package com.github.drjacky.imagepicker.provider;

import android.net.Uri;
import com.github.drjacky.imagepicker.R;
import fa.f;
import ik.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@zj.d(c = "com.github.drjacky.imagepicker.provider.CompressionProvider$compress$1", f = "CompressionProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@d0(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CompressionProvider$compress$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ CompressionProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressionProvider$compress$1(CompressionProvider compressionProvider, Uri uri, kotlin.coroutines.c<? super CompressionProvider$compress$1> cVar) {
        super(2, cVar);
        this.this$0 = compressionProvider;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        return new CompressionProvider$compress$1(this.this$0, this.$uri, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        File fileK = this.this$0.k(this.$uri);
        if (fileK != null) {
            f.f28008a.a(this.$uri, fileK);
            this.this$0.a().l4(fileK);
        } else {
            this.this$0.e(R.string.error_failed_to_compress_image);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l kotlin.coroutines.c<? super z1> cVar) {
        return ((CompressionProvider$compress$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
