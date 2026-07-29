package com.flydigi.base.ui.image_preview;

import android.content.ContentValues;
import android.net.Uri;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "com.flydigi.base.ui.image_preview.ImagePreviewViewModel$createPhotoUri$2", f = "ImagePreviewViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImagePreviewViewModel$createPhotoUri$2 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super Uri>, Object> {
    public final /* synthetic */ Uri $imageCollection;
    public final /* synthetic */ String $url;
    public int label;
    public final /* synthetic */ ImagePreviewViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewViewModel$createPhotoUri$2(String str, ImagePreviewViewModel imagePreviewViewModel, Uri uri, kotlin.coroutines.c<? super ImagePreviewViewModel$createPhotoUri$2> cVar) {
        super(2, cVar);
        this.$url = str;
        this.this$0 = imagePreviewViewModel;
        this.$imageCollection = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        return new ImagePreviewViewModel$createPhotoUri$2(this.$url, this.this$0, this.$imageCollection, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        String strG = b0.G(this.$url);
        f0.o(strG, "getFileExtension(url)");
        if (d1.g(strG)) {
            strG = "jpg";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", System.currentTimeMillis() + '.' + strG);
        return this.this$0.k().getContentResolver().insert(this.$imageCollection, contentValues);
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l kotlin.coroutines.c<? super Uri> cVar) {
        return ((ImagePreviewViewModel$createPhotoUri$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
