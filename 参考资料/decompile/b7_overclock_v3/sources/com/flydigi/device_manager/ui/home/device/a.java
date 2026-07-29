package com.flydigi.device_manager.ui.home.device;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nBaseDriverReleaseViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseDriverReleaseViewModel.kt\ncom/flydigi/device_manager/ui/home/device/BaseDriverReleaseViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public abstract class a extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final j0<Boolean> f15170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final LiveData<Boolean> f15171f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@yt.k Application application) {
        super(application);
        kotlin.jvm.internal.f0.p(application, "application");
        j0<Boolean> j0Var = new j0<>(Boolean.FALSE);
        this.f15170e = j0Var;
        this.f15171f = j0Var;
    }

    public final void h(Uri uri, InputStream inputStream) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("alterDocument:");
            sb2.append(uri);
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = j().getContentResolver().openFileDescriptor(uri, "w");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    fileOutputStream.write(kotlin.io.a.p(inputStream));
                    z1 z1Var = z1.f38230a;
                    kotlin.io.b.a(fileOutputStream, null);
                    kotlin.io.b.a(parcelFileDescriptorOpenFileDescriptor, null);
                } finally {
                }
            } finally {
            }
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public final void i(@yt.k f1.a serverDirectory) throws IOException {
        kotlin.jvm.internal.f0.p(serverDirectory, "serverDirectory");
        q(serverDirectory);
        n(serverDirectory);
        o(serverDirectory);
        r(serverDirectory);
    }

    @yt.k
    public final Context j() {
        return g();
    }

    @yt.k
    public final LiveData<Boolean> k() {
        return this.f15171f;
    }

    @yt.k
    public final j0<Boolean> l() {
        return this.f15170e;
    }

    public abstract void m();

    public final void n(f1.a aVar) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("释放FZToolHelperAndroid到");
        sb2.append(aVar.n());
        f1.a aVarG = aVar.g(v5.c.f52713e);
        if (aVarG != null) {
            aVarG.e();
        }
        f1.a aVarG2 = aVar.g(v5.c.f52713e);
        if (aVarG2 == null) {
            aVarG2 = aVar.d("*/*", v5.c.f52713e);
        }
        if (aVarG2 != null) {
            InputStream inputStreamOpen = j().getAssets().open(v5.c.f52713e);
            kotlin.jvm.internal.f0.o(inputStreamOpen, "context.assets.open(DriverManager.DRIVER_JAR_NAME)");
            Uri uriN = aVarG2.n();
            kotlin.jvm.internal.f0.o(uriN, "it.uri");
            h(uriN, inputStreamOpen);
        }
    }

    public final void o(f1.a aVar) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("释放libmotionelf_server.so到");
        sb2.append(aVar.n());
        f1.a aVarG = aVar.g(v5.c.f52712d);
        if (aVarG != null) {
            aVarG.e();
        }
        f1.a aVarG2 = aVar.g(v5.c.f52712d);
        if (aVarG2 == null) {
            aVarG2 = aVar.d("*/*", v5.c.f52712d);
        }
        if (aVarG2 != null) {
            String str = (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_KEY_USE_COMPATIBLE_DRIVER, false) || !v5.c.e()) ? "libmotionelf_server.so_x32" : "libmotionelf_server.so_x64";
            AssetManager assets = j().getAssets();
            kotlin.jvm.internal.f0.o(assets, "context.assets");
            InputStream inputStreamOpen = assets.open(str);
            Uri uriN = aVarG2.n();
            kotlin.jvm.internal.f0.o(uriN, "it.uri");
            kotlin.jvm.internal.f0.o(inputStreamOpen, "`is`");
            h(uriN, inputStreamOpen);
        }
    }

    public final void q(f1.a aVar) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("释放motionelf_server到");
        sb2.append(aVar.n());
        f1.a aVarG = aVar.g(v5.c.f52711c);
        if (aVarG != null) {
            aVarG.e();
        }
        f1.a aVarG2 = aVar.g(v5.c.f52711c);
        if (aVarG2 == null) {
            aVarG2 = aVar.d("*/*", v5.c.f52711c);
        }
        if (aVarG2 != null) {
            String str = v5.c.f() ? "motionelf_server_x86" : (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_KEY_USE_COMPATIBLE_DRIVER, false) || !v5.c.e()) ? "motionelf_server_x32" : "motionelf_server_x64";
            AssetManager assets = j().getAssets();
            kotlin.jvm.internal.f0.o(assets, "context.assets");
            InputStream inputStreamOpen = assets.open(str);
            Uri uriN = aVarG2.n();
            kotlin.jvm.internal.f0.o(uriN, "it.uri");
            kotlin.jvm.internal.f0.o(inputStreamOpen, "`is`");
            h(uriN, inputStreamOpen);
        }
    }

    public final void r(f1.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("释放starter.sh到");
        sb2.append(aVar.n());
        f1.a aVarG = aVar.g(v5.c.f52714f);
        if (aVarG != null) {
            aVarG.e();
        }
        f1.a aVarG2 = aVar.g(v5.c.f52714f);
        if (aVarG2 == null) {
            aVarG2 = aVar.d("*/*", v5.c.f52714f);
        }
        if (aVarG2 != null) {
            InputStream inputStreamOpenRawResource = j().getResources().openRawResource(R.raw.starter);
            kotlin.jvm.internal.f0.o(inputStreamOpenRawResource, "context.resources.openRawResource(R.raw.starter)");
            Uri uriN = aVarG2.n();
            kotlin.jvm.internal.f0.o(uriN, "it.uri");
            h(uriN, inputStreamOpenRawResource);
        }
    }
}
