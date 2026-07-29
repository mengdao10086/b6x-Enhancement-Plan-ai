package com.github.drjacky.imagepicker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.g;
import androidx.appcompat.app.f;
import com.github.drjacky.imagepicker.constant.ImageProvider;
import com.github.drjacky.imagepicker.provider.CompressionProvider;
import f.b;
import java.io.File;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m9.h;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b@\u0010AJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J-\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000bJ\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00106\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00105R\"\u0010:\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00105R\u0018\u0010=\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<¨\u0006D"}, d2 = {"Lcom/github/drjacky/imagepicker/ImagePickerActivity;", "Landroidx/appcompat/app/f;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/z1;", "onCreate", "outState", "onSaveInstanceState", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onBackPressed", "Landroid/net/Uri;", "uri", "", "isCamera", "o4", "m4", "Ljava/io/File;", m7.a.f40702b, "l4", "q4", "message", "n4", "k4", "j4", "p4", "Lcom/github/drjacky/imagepicker/provider/d;", "K0", "Lcom/github/drjacky/imagepicker/provider/d;", "mGalleryProvider", "Lcom/github/drjacky/imagepicker/provider/b;", h.B, "Lcom/github/drjacky/imagepicker/provider/b;", "mCameraProvider", "Lcom/github/drjacky/imagepicker/provider/c;", "v1", "Lcom/github/drjacky/imagepicker/provider/c;", "mCropProvider", "Lcom/github/drjacky/imagepicker/provider/CompressionProvider;", "C1", "Lcom/github/drjacky/imagepicker/provider/CompressionProvider;", "mCompressionProvider", "Landroidx/activity/result/g;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "K1", "Landroidx/activity/result/g;", "galleryLauncher", "v2", "cameraLauncher", "C2", "cropLauncher", "K2", "Landroid/net/Uri;", "mImageUri", "E7", "mCropUri", "<init>", "()V", "F7", "a", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class ImagePickerActivity extends f {

    @k
    public static final a F7 = new a(null);

    @k
    public static final String G7 = "image_picker";

    @k
    public static final String H7 = "state.image_uri";
    public CompressionProvider C1;

    @k
    public final g<Intent> C2;

    @l
    public Uri E7;

    @l
    public com.github.drjacky.imagepicker.provider.d K0;

    @k
    public final g<Intent> K1;

    @l
    public Uri K2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @l
    public com.github.drjacky.imagepicker.provider.b f16516k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public com.github.drjacky.imagepicker.provider.c f16517v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @k
    public final g<Intent> f16518v2;

    @d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/github/drjacky/imagepicker/ImagePickerActivity$a;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Landroid/content/Intent;", "a", "(Landroid/content/Context;)Landroid/content/Intent;", "", "STATE_IMAGE_URI", "Ljava/lang/String;", "TAG", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final Intent a(@k Context context) {
            f0.p(context, "context");
            Intent intent = new Intent();
            String string = context.getString(R.string.error_task_cancelled);
            f0.o(string, "context.getString(R.string.error_task_cancelled)");
            intent.putExtra(com.github.drjacky.imagepicker.b.f16537l, string);
            return intent;
        }
    }

    @d0(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16519a;

        static {
            int[] iArr = new int[ImageProvider.valuesCustom().length];
            iArr[ImageProvider.GALLERY.ordinal()] = 1;
            iArr[ImageProvider.CAMERA.ordinal()] = 2;
            iArr[ImageProvider.FRONT_CAMERA.ordinal()] = 3;
            f16519a = iArr;
        }
    }

    public ImagePickerActivity() {
        g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.github.drjacky.imagepicker.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ImagePickerActivity.i4(this.f16554a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            mGalleryProvider?.handleResult(it)\n        }");
        this.K1 = gVarP1;
        g<Intent> gVarP12 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.github.drjacky.imagepicker.d
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ImagePickerActivity.g4(this.f16555a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP12, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            mCameraProvider?.handleResult(it)\n        }");
        this.f16518v2 = gVarP12;
        g<Intent> gVarP13 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.github.drjacky.imagepicker.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ImagePickerActivity.h4(this.f16556a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP13, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            mCropProvider.handleResult(it)\n        }");
        this.C2 = gVarP13;
    }

    public static final void g4(ImagePickerActivity this$0, ActivityResult it2) {
        f0.p(this$0, "this$0");
        com.github.drjacky.imagepicker.provider.b bVar = this$0.f16516k1;
        if (bVar == null) {
            return;
        }
        f0.o(it2, "it");
        bVar.l(it2);
    }

    public static final void h4(ImagePickerActivity this$0, ActivityResult it2) {
        f0.p(this$0, "this$0");
        com.github.drjacky.imagepicker.provider.c cVar = this$0.f16517v1;
        if (cVar == null) {
            f0.S("mCropProvider");
            throw null;
        }
        f0.o(it2, "it");
        cVar.m(it2);
    }

    public static final void i4(ImagePickerActivity this$0, ActivityResult it2) {
        f0.p(this$0, "this$0");
        com.github.drjacky.imagepicker.provider.d dVar = this$0.K0;
        if (dVar == null) {
            return;
        }
        f0.o(it2, "it");
        dVar.l(it2);
    }

    public void c4() {
    }

    public final void j4(Bundle bundle) {
        com.github.drjacky.imagepicker.provider.b bVar;
        com.github.drjacky.imagepicker.provider.b bVar2;
        com.github.drjacky.imagepicker.provider.c cVar = new com.github.drjacky.imagepicker.provider.c(this, new ik.l<Intent, z1>() { // from class: com.github.drjacky.imagepicker.ImagePickerActivity$loadBundle$1
            {
                super(1);
            }

            public final void b(@k Intent it2) {
                f0.p(it2, "it");
                this.this$0.C2.b(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Intent intent) {
                b(intent);
                return z1.f38230a;
            }
        });
        this.f16517v1 = cVar;
        cVar.c(bundle);
        this.C1 = new CompressionProvider(this);
        Intent intent = getIntent();
        ImageProvider imageProvider = (ImageProvider) (intent == null ? null : intent.getSerializableExtra(com.github.drjacky.imagepicker.b.f16528c));
        int i10 = imageProvider == null ? -1 : b.f16519a[imageProvider.ordinal()];
        if (i10 == 1) {
            com.github.drjacky.imagepicker.provider.d dVar = new com.github.drjacky.imagepicker.provider.d(this, new ik.l<Intent, z1>() { // from class: com.github.drjacky.imagepicker.ImagePickerActivity$loadBundle$2
                {
                    super(1);
                }

                public final void b(@k Intent it2) {
                    f0.p(it2, "it");
                    this.this$0.K1.b(it2);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Intent intent2) {
                    b(intent2);
                    return z1.f38230a;
                }
            });
            this.K0 = dVar;
            if (bundle == null) {
                dVar.q();
                return;
            }
            return;
        }
        if (i10 == 2) {
            com.github.drjacky.imagepicker.provider.b bVar3 = new com.github.drjacky.imagepicker.provider.b(this, false, new ik.l<Intent, z1>() { // from class: com.github.drjacky.imagepicker.ImagePickerActivity$loadBundle$3
                {
                    super(1);
                }

                public final void b(@k Intent it2) {
                    f0.p(it2, "it");
                    this.this$0.f16518v2.b(it2);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Intent intent2) {
                    b(intent2);
                    return z1.f38230a;
                }
            });
            this.f16516k1 = bVar3;
            bVar3.c(bundle);
            if (bundle != null || (bVar = this.f16516k1) == null) {
                return;
            }
            bVar.q();
            return;
        }
        if (i10 != 3) {
            String string = getString(R.string.error_task_cancelled);
            f0.o(string, "getString(R.string.error_task_cancelled)");
            n4(string);
            return;
        }
        com.github.drjacky.imagepicker.provider.b bVar4 = new com.github.drjacky.imagepicker.provider.b(this, true, new ik.l<Intent, z1>() { // from class: com.github.drjacky.imagepicker.ImagePickerActivity$loadBundle$4
            {
                super(1);
            }

            public final void b(@k Intent it2) {
                f0.p(it2, "it");
                this.this$0.f16518v2.b(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Intent intent2) {
                b(intent2);
                return z1.f38230a;
            }
        });
        this.f16516k1 = bVar4;
        bVar4.c(bundle);
        if (bundle != null || (bVar2 = this.f16516k1) == null) {
            return;
        }
        bVar2.q();
    }

    public final void k4(Bundle bundle) {
        if (bundle != null) {
            this.K2 = (Uri) bundle.getParcelable(H7);
        }
    }

    public final void l4(@k File file) {
        String path;
        f0.p(file, "file");
        if (this.f16516k1 != null) {
            file.delete();
        }
        Uri uri = this.E7;
        if (uri != null && (path = uri.getPath()) != null) {
            new File(path).delete();
        }
        this.E7 = null;
        f0.m(null);
        p4(null);
    }

    public final void m4(@k Uri uri) {
        f0.p(uri, "uri");
        this.E7 = uri;
        if (this.f16516k1 != null) {
            uri.getPath();
            this.K2 = null;
        }
        CompressionProvider compressionProvider = this.C1;
        if (compressionProvider == null) {
            f0.S("mCompressionProvider");
            throw null;
        }
        if (!compressionProvider.m(uri)) {
            p4(uri);
            return;
        }
        CompressionProvider compressionProvider2 = this.C1;
        if (compressionProvider2 != null) {
            compressionProvider2.j(uri);
        } else {
            f0.S("mCompressionProvider");
            throw null;
        }
    }

    public final void n4(@k String message) {
        f0.p(message, "message");
        Intent intent = new Intent();
        intent.putExtra(com.github.drjacky.imagepicker.b.f16537l, message);
        setResult(64, intent);
        finish();
    }

    public final void o4(@k Uri uri, boolean z10) {
        f0.p(uri, "uri");
        this.K2 = uri;
        com.github.drjacky.imagepicker.provider.c cVar = this.f16517v1;
        if (cVar == null) {
            f0.S("mCropProvider");
            throw null;
        }
        if (!cVar.n()) {
            CompressionProvider compressionProvider = this.C1;
            if (compressionProvider == null) {
                f0.S("mCompressionProvider");
                throw null;
            }
            if (!compressionProvider.m(uri)) {
                p4(uri);
                return;
            }
            CompressionProvider compressionProvider2 = this.C1;
            if (compressionProvider2 != null) {
                compressionProvider2.j(uri);
                return;
            } else {
                f0.S("mCompressionProvider");
                throw null;
            }
        }
        com.github.drjacky.imagepicker.provider.c cVar2 = this.f16517v1;
        if (cVar2 == null) {
            f0.S("mCropProvider");
            throw null;
        }
        if (cVar2 == null) {
            f0.S("mCropProvider");
            throw null;
        }
        boolean zP = cVar2.p();
        com.github.drjacky.imagepicker.provider.c cVar3 = this.f16517v1;
        if (cVar3 != null) {
            cVar2.q(uri, zP, cVar3.o(), z10);
        } else {
            f0.S("mCropProvider");
            throw null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        q4();
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        k4(bundle);
        j4(bundle);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @k String[] permissions, @k int[] grantResults) {
        f0.p(permissions, "permissions");
        f0.p(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        com.github.drjacky.imagepicker.provider.b bVar = this.f16516k1;
        if (bVar != null) {
            bVar.n(i10);
        }
        com.github.drjacky.imagepicker.provider.d dVar = this.K0;
        if (dVar == null) {
            return;
        }
        dVar.n(i10);
    }

    @Override // androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(@k Bundle outState) {
        f0.p(outState, "outState");
        outState.putParcelable(H7, this.K2);
        com.github.drjacky.imagepicker.provider.b bVar = this.f16516k1;
        if (bVar != null) {
            bVar.d(outState);
        }
        com.github.drjacky.imagepicker.provider.c cVar = this.f16517v1;
        if (cVar == null) {
            f0.S("mCropProvider");
            throw null;
        }
        cVar.d(outState);
        super.onSaveInstanceState(outState);
    }

    public final void p4(Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        intent.putExtra(com.github.drjacky.imagepicker.b.f16538m, uri.getPath());
        setResult(-1, intent);
        finish();
    }

    public final void q4() {
        setResult(0, F7.a(this));
        finish();
    }
}
