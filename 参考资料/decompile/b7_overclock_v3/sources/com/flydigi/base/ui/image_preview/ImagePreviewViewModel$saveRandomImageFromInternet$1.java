package com.flydigi.base.ui.image_preview;

import android.net.Uri;
import ik.p;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.OutputStream;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m2;
import kotlinx.coroutines.o0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "com.flydigi.base.ui.image_preview.ImagePreviewViewModel$saveRandomImageFromInternet$1", f = "ImagePreviewViewModel.kt", i = {}, l = {70, 72}, m = "invokeSuspend", n = {}, s = {})
public final class ImagePreviewViewModel$saveRandomImageFromInternet$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.a<z1> $callback;
    public final /* synthetic */ String $url;
    public int label;
    public final /* synthetic */ ImagePreviewViewModel this$0;

    /* JADX INFO: renamed from: com.flydigi.base.ui.image_preview.ImagePreviewViewModel$saveRandomImageFromInternet$1$1, reason: invalid class name */
    @t0({"SMAP\nImagePreviewViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImagePreviewViewModel.kt\ncom/flydigi/base/ui/image_preview/ImagePreviewViewModel$saveRandomImageFromInternet$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
    @zj.d(c = "com.flydigi.base.ui.image_preview.ImagePreviewViewModel$saveRandomImageFromInternet$1$1", f = "ImagePreviewViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ ik.a<z1> $callback;
        public final /* synthetic */ Uri $imageUri;
        public final /* synthetic */ String $url;
        public Object L$0;
        public Object L$1;
        public int label;
        public final /* synthetic */ ImagePreviewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, ImagePreviewViewModel imagePreviewViewModel, String str, ik.a<z1> aVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$imageUri = uri;
            this.this$0 = imagePreviewViewModel;
            this.$url = str;
            this.$callback = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$imageUri, this.this$0, this.$url, this.$callback, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r6v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object q0(@k Object obj) throws Throwable {
            ?? fileInputStream;
            Closeable closeable;
            Throwable th2;
            Object objH = yj.b.h();
            ?? r12 = this.label;
            try {
                if (r12 == 0) {
                    u0.n(obj);
                    Uri uri = this.$imageUri;
                    if (uri != null) {
                        ImagePreviewViewModel imagePreviewViewModel = this.this$0;
                        String str = this.$url;
                        ik.a<z1> aVar = this.$callback;
                        fileInputStream = new FileInputStream(com.bumptech.glide.b.E(imagePreviewViewModel.k()).E().t(str).J1(Integer.MIN_VALUE, Integer.MIN_VALUE).get());
                        try {
                            OutputStream outputStreamOpenOutputStream = imagePreviewViewModel.k().getContentResolver().openOutputStream(uri, "w");
                            fileInputStream = fileInputStream;
                            if (outputStreamOpenOutputStream != null) {
                                try {
                                    kotlin.io.a.l(fileInputStream, outputStreamOpenOutputStream, 0, 2, null);
                                    m2 m2VarE = d1.e();
                                    ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1 imagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1 = new ImagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1(aVar, null);
                                    this.L$0 = fileInputStream;
                                    this.L$1 = outputStreamOpenOutputStream;
                                    this.label = 1;
                                    if (h.h(m2VarE, imagePreviewViewModel$saveRandomImageFromInternet$1$1$1$2$1$1, this) == objH) {
                                        return objH;
                                    }
                                    closeable = outputStreamOpenOutputStream;
                                    r12 = fileInputStream;
                                } catch (Throwable th3) {
                                    r12 = fileInputStream;
                                    closeable = outputStreamOpenOutputStream;
                                    th2 = th3;
                                    throw th2;
                                }
                            }
                            z1 z1Var = z1.f38230a;
                            kotlin.io.b.a(fileInputStream, null);
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    return z1.f38230a;
                }
                if (r12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$1;
                r12 = (Closeable) this.L$0;
                try {
                    u0.n(obj);
                    r12 = r12;
                } catch (Throwable th5) {
                    th2 = th5;
                    try {
                        throw th2;
                    } finally {
                    }
                }
                z1 z1Var2 = z1.f38230a;
                kotlin.io.b.a(closeable, null);
                fileInputStream = r12;
                z1 z1Var3 = z1.f38230a;
                kotlin.io.b.a(fileInputStream, null);
                return z1.f38230a;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = r12;
            }
        }

        @Override // ik.p
        @l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@k o0 o0Var, @l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewViewModel$saveRandomImageFromInternet$1(ImagePreviewViewModel imagePreviewViewModel, String str, ik.a<z1> aVar, kotlin.coroutines.c<? super ImagePreviewViewModel$saveRandomImageFromInternet$1> cVar) {
        super(2, cVar);
        this.this$0 = imagePreviewViewModel;
        this.$url = str;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        return new ImagePreviewViewModel$saveRandomImageFromInternet$1(this.this$0, this.$url, this.$callback, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            ImagePreviewViewModel imagePreviewViewModel = this.this$0;
            String str = this.$url;
            this.label = 1;
            obj = imagePreviewViewModel.i(str, this);
            if (obj == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u0.n(obj);
                return z1.f38230a;
            }
            u0.n(obj);
        }
        Uri uri = (Uri) obj;
        CoroutineDispatcher coroutineDispatcherC = d1.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(uri, this.this$0, this.$url, this.$callback, null);
        this.label = 2;
        if (h.h(coroutineDispatcherC, anonymousClass1, this) == objH) {
            return objH;
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l kotlin.coroutines.c<? super z1> cVar) {
        return ((ImagePreviewViewModel$saveRandomImageFromInternet$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
