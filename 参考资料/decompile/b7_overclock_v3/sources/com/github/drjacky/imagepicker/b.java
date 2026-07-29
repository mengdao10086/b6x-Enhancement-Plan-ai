package com.github.drjacky.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.flydigi.sdk.bluetooth.l;
import com.github.drjacky.imagepicker.constant.ImageProvider;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import hk.m;
import java.io.File;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import xf.j;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/github/drjacky/imagepicker/b;", "", "<init>", "()V", "a", "b", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final C0174b f16526a = new C0174b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16527b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final String f16528c = "extra.image_provider";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final String f16529d = "extra.crop";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final String f16530e = "extra.crop_x";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final String f16531f = "extra.crop_y";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final String f16532g = "extra.crop_oval";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final String f16533h = "extra.crop_free_style";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final String f16534i = "extra.max_width";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final String f16535j = "extra.max_height";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final String f16536k = "extra.keep_ratio";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @k
    public static final String f16537l = "extra.error";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @k
    public static final String f16538m = "extra.file_path";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @k
    public static final String f16539n = "extra.mime_types";

    @d0(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b6\u00107J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0000J\u0006\u0010\u0006\u001a\u00020\u0000J\u001b\u0010\n\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J \u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017J\u001a\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u001a\u0010!\u001a\u00020\u001b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001b0\u001aJ\b\u0010#\u001a\u00020\"H\u0002R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010,R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010/R\u0016\u00101\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010/R\u0016\u00102\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010/R\u0016\u00104\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00103R\u0016\u00105\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00103R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010/¨\u00068"}, d2 = {"Lcom/github/drjacky/imagepicker/b$a;", "", "Lcom/github/drjacky/imagepicker/constant/ImageProvider;", "imageProvider", "q", "d", m0.k.f40564b, "", "", "mimeTypes", l.f16298a, "([Ljava/lang/String;)Lcom/github/drjacky/imagepicker/b$a;", "", "x", "y", "h", "g", j.f55230b, "i", "k", "", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "", "keepRatio", "o", "Lkotlin/Function1;", "Lkotlin/z1;", "interceptor", SsManifestParser.e.J, "Landroid/content/Intent;", "e", "onResult", "f", "Landroid/os/Bundle;", "n", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", androidx.appcompat.widget.c.f2369r, "b", "Lcom/github/drjacky/imagepicker/constant/ImageProvider;", "c", "[Ljava/lang/String;", "F", "cropX", "cropY", "Z", "crop", "cropOval", "cropFreeStyle", "I", "maxWidth", "maxHeight", "<init>", "(Landroid/app/Activity;)V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final Activity f16540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public ImageProvider f16541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @k
        public String[] f16542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f16543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f16544e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16545f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f16546g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f16547h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16548i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f16549j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f16550k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @yt.l
        public ik.l<? super ImageProvider, z1> f16551l;

        /* JADX INFO: renamed from: com.github.drjacky.imagepicker.b$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/github/drjacky/imagepicker/b$a$a", "Lea/b;", "Lcom/github/drjacky/imagepicker/constant/ImageProvider;", "t", "Lkotlin/z1;", "a", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
        public static final class C0173a implements ea.b<ImageProvider> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ik.l<Intent, z1> f16553b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0173a(ik.l<? super Intent, z1> lVar) {
                this.f16553b = lVar;
            }

            @Override // ea.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(@yt.l ImageProvider imageProvider) {
                if (imageProvider == null) {
                    return;
                }
                a aVar = a.this;
                ik.l<Intent, z1> lVar = this.f16553b;
                aVar.f16541b = imageProvider;
                ik.l lVar2 = aVar.f16551l;
                if (lVar2 != null) {
                    lVar2.i(aVar.f16541b);
                }
                lVar.i(aVar.e());
            }
        }

        public a(@k Activity activity) {
            f0.p(activity, "activity");
            this.f16540a = activity;
            this.f16541b = ImageProvider.BOTH;
            this.f16542c = new String[0];
        }

        public static /* synthetic */ a p(a aVar, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return aVar.o(i10, i11, z10);
        }

        @k
        public final a d() {
            this.f16541b = ImageProvider.CAMERA;
            return this;
        }

        @k
        public final Intent e() {
            Intent intent = new Intent(this.f16540a, (Class<?>) ImagePickerActivity.class);
            intent.putExtras(n());
            return intent;
        }

        public final void f(@k ik.l<? super Intent, z1> onResult) {
            f0.p(onResult, "onResult");
            if (this.f16541b == ImageProvider.BOTH) {
                fa.e.f28007a.e(this.f16540a, new C0173a(onResult));
            }
        }

        @k
        public final a g() {
            this.f16545f = true;
            return this;
        }

        @k
        public final a h(float f10, float f11) {
            this.f16543d = f10;
            this.f16544e = f11;
            return g();
        }

        @k
        public final a i() {
            this.f16547h = true;
            return this;
        }

        @k
        public final a j() {
            this.f16546g = true;
            return this;
        }

        @k
        public final a k() {
            return h(1.0f, 1.0f);
        }

        @k
        public final a l(@k String[] mimeTypes) {
            f0.p(mimeTypes, "mimeTypes");
            this.f16542c = mimeTypes;
            return this;
        }

        @k
        public final a m() {
            this.f16541b = ImageProvider.GALLERY;
            return this;
        }

        public final Bundle n() {
            Bundle bundle = new Bundle();
            bundle.putSerializable(b.f16528c, this.f16541b);
            bundle.putStringArray(b.f16539n, this.f16542c);
            bundle.putBoolean(b.f16532g, this.f16546g);
            bundle.putBoolean(b.f16533h, this.f16547h);
            bundle.putBoolean(b.f16529d, this.f16545f);
            bundle.putFloat(b.f16530e, this.f16543d);
            bundle.putFloat(b.f16531f, this.f16544e);
            bundle.putInt(b.f16534i, this.f16548i);
            bundle.putInt(b.f16535j, this.f16549j);
            bundle.putBoolean(b.f16536k, this.f16550k);
            return bundle;
        }

        @k
        public final a o(int i10, int i11, boolean z10) {
            this.f16548i = i10;
            this.f16549j = i11;
            this.f16550k = z10;
            return this;
        }

        @k
        public final a q(@k ImageProvider imageProvider) {
            f0.p(imageProvider, "imageProvider");
            this.f16541b = imageProvider;
            return this;
        }

        @k
        public final a r(@k ik.l<? super ImageProvider, z1> interceptor) {
            f0.p(interceptor, "interceptor");
            this.f16551l = interceptor;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.github.drjacky.imagepicker.b$b, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007R\u0014\u0010\r\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/github/drjacky/imagepicker/b$b;", "", "Landroid/app/Activity;", androidx.appcompat.widget.c.f2369r, "Lcom/github/drjacky/imagepicker/b$a;", "d", "Landroid/content/Intent;", "data", "", "a", "c", "Ljava/io/File;", "b", "EXTRA_CROP", "Ljava/lang/String;", "EXTRA_CROP_FREE_STYLE", "EXTRA_CROP_OVAL", "EXTRA_CROP_X", "EXTRA_CROP_Y", "EXTRA_ERROR", "EXTRA_FILE_PATH", "EXTRA_IMAGE_PROVIDER", "EXTRA_KEEP_RATIO", "EXTRA_MAX_HEIGHT", "EXTRA_MAX_WIDTH", "EXTRA_MIME_TYPES", "", "RESULT_ERROR", "I", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class C0174b {
        public C0174b() {
        }

        public /* synthetic */ C0174b(u uVar) {
            this();
        }

        @m
        @k
        public final String a(@yt.l Intent intent) {
            String stringExtra = intent == null ? null : intent.getStringExtra(b.f16537l);
            return stringExtra != null ? stringExtra : "Unknown Error!";
        }

        @m
        @yt.l
        public final File b(@yt.l Intent intent) {
            String strC = c(intent);
            if (strC != null) {
                return new File(strC);
            }
            return null;
        }

        @m
        @yt.l
        public final String c(@yt.l Intent intent) {
            if (intent == null) {
                return null;
            }
            return intent.getStringExtra(b.f16538m);
        }

        @m
        @k
        public final a d(@k Activity activity) {
            f0.p(activity, "activity");
            return new a(activity);
        }
    }

    @m
    @k
    public static final String a(@yt.l Intent intent) {
        return f16526a.a(intent);
    }

    @m
    @yt.l
    public static final File b(@yt.l Intent intent) {
        return f16526a.b(intent);
    }

    @m
    @yt.l
    public static final String c(@yt.l Intent intent) {
        return f16526a.c(intent);
    }

    @m
    @k
    public static final a d(@k Activity activity) {
        return f16526a.d(activity);
    }
}
