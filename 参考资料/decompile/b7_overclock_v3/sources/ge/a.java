package ge;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.RestrictTo;
import g.i1;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f29243a = 1.0f;

    @i1
    public static void b(float f10) {
        f29243a = f10;
    }

    public float a(@n0 ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
