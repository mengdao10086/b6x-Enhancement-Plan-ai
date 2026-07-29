package fa;

import android.net.Uri;
import java.io.File;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"Lfa/f;", "", "Landroid/net/Uri;", "filePathOri", "Ljava/io/File;", "filePathDest", "Lkotlin/z1;", "a", "Li1/a;", "oldExif", "newExif", "", "property", "b", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final f f28008a = new f();

    public final void a(@yt.k Uri filePathOri, @yt.k File filePathDest) throws Throwable {
        f0.p(filePathOri, "filePathOri");
        f0.p(filePathDest, "filePathDest");
        try {
            String path = filePathOri.getPath();
            f0.m(path);
            i1.a aVar = new i1.a(path);
            i1.a aVar2 = new i1.a(filePathDest);
            Iterator it2 = CollectionsKt__CollectionsKt.L(i1.a.f31716v0, i1.a.f31708u0, i1.a.f31743y0, i1.a.D1, i1.a.C1, i1.a.R0, i1.a.f31550a2, i1.a.f31589f1, i1.a.Y1, i1.a.E1, i1.a.U, i1.a.P0, i1.a.f31753z1, i1.a.f31744y1, i1.a.B1, i1.a.A1, i1.a.W, i1.a.X, i1.a.C).iterator();
            while (it2.hasNext()) {
                try {
                    b(aVar, aVar2, (String) it2.next());
                } catch (Exception e10) {
                    e = e10;
                    f0.C("Error preserving Exif data on selected image: ", e);
                    return;
                }
            }
            aVar2.q0();
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void b(i1.a aVar, i1.a aVar2, String str) {
        if (aVar.i(str) != null) {
            aVar2.v0(str, aVar.i(str));
        }
    }
}
