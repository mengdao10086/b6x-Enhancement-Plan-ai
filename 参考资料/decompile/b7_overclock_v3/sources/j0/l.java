package j0;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import g.e1;
import g.u;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(26)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final l f36006a = new l();

    @u
    @hk.m
    @yt.k
    public static final Typeface a(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "typedArray");
        Typeface font = typedArray.getFont(i10);
        f0.m(font);
        return font;
    }
}
