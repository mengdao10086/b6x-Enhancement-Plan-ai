package h0;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {
    @SuppressLint({"ApplySharedPref"})
    public static final void a(@yt.k SharedPreferences sharedPreferences, boolean z10, @yt.k ik.l<? super SharedPreferences.Editor, z1> action) {
        kotlin.jvm.internal.f0.p(sharedPreferences, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        kotlin.jvm.internal.f0.o(editor, "editor");
        action.i(editor);
        if (z10) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void b(SharedPreferences sharedPreferences, boolean z10, ik.l action, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        kotlin.jvm.internal.f0.p(sharedPreferences, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        kotlin.jvm.internal.f0.o(editor, "editor");
        action.i(editor);
        if (z10) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
