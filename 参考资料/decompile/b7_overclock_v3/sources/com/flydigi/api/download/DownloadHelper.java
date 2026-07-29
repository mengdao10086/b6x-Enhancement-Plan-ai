package com.flydigi.api.download;

import com.blankj.utilcode.util.j1;
import dj.o;
import ik.l;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f0;
import lu.g;
import okhttp3.a0;
import okhttp3.e0;
import retrofit2.r;
import retrofit2.s;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final s f13302a;

    public DownloadHelper(@k String url, @k d listener) {
        f0.p(url, "url");
        f0.p(listener, "listener");
        s sVarF = new s.b().c(url).j(new a0.a().d(new c(listener)).l0(true).k(15L, TimeUnit.SECONDS).f()).a(g.d()).f();
        f0.o(sVarF, "Builder()\n            .b…e())\n            .build()");
        this.f13302a = sVarF;
    }

    public static /* synthetic */ z d(DownloadHelper downloadHelper, String str, String str2, File file, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            file = null;
        }
        return downloadHelper.c(str, str2, file);
    }

    public static final InputStream e(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (InputStream) tmp0.i(obj);
    }

    public static final File f(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    @k
    public final z<File> c(@k final String prefix, @k String url, @yt.l final File file) {
        f0.p(prefix, "prefix");
        f0.p(url, "url");
        z<r<e0>> zVarN7 = ((h5.d) this.f13302a.g(h5.d.class)).z(url).J5(lj.b.d()).n7(lj.b.d());
        final DownloadHelper$downloadFile$1 downloadHelper$downloadFile$1 = new l<r<e0>, InputStream>() { // from class: com.flydigi.api.download.DownloadHelper$downloadFile$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InputStream i(@k r<e0> t10) {
                f0.p(t10, "t");
                e0 e0VarA = t10.a();
                if (e0VarA != null) {
                    return e0VarA.byteStream();
                }
                return null;
            }
        };
        z zVarB4 = zVarN7.A3(new o() { // from class: com.flydigi.api.download.a
            @Override // dj.o
            public final Object apply(Object obj) {
                return DownloadHelper.e(downloadHelper$downloadFile$1, obj);
            }
        }).b4(lj.b.a());
        final l<InputStream, File> lVar = new l<InputStream, File>() { // from class: com.flydigi.api.download.DownloadHelper$downloadFile$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final File i(@k InputStream is2) {
                f0.p(is2, "is");
                String str = prefix + '_' + System.nanoTime() + ".tmp";
                File file2 = file;
                if (file2 == null) {
                    file2 = new File(j1.a().getExternalCacheDir(), str);
                }
                com.blankj.utilcode.util.a0.L(file2, is2);
                return file2;
            }
        };
        z<File> zVarA3 = zVarB4.A3(new o() { // from class: com.flydigi.api.download.b
            @Override // dj.o
            public final Object apply(Object obj) {
                return DownloadHelper.f(lVar, obj);
            }
        });
        f0.o(zVarA3, "prefix: String, url: Str…ap realFile\n            }");
        return zVarA3;
    }
}
