package androidx.activity;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(26)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f1358a = new b();

    public final void a(@yt.k Activity activity, @yt.k Rect hint) {
        f0.p(activity, "activity");
        f0.p(hint, "hint");
        activity.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(hint).build());
    }
}
