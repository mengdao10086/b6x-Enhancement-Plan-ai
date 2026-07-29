package moe.shizuku.manager.adb;

import android.content.SharedPreferences;
import android.util.Base64;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nAdbKey.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbKey.kt\nmoe/shizuku/manager/adb/PreferenceAdbKeyStore\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,392:1\n39#2,12:393\n*S KotlinDebug\n*F\n+ 1 AdbKey.kt\nmoe/shizuku/manager/adb/PreferenceAdbKeyStore\n*L\n330#1:393,12\n*E\n"})
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final SharedPreferences f41546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final String f41547b;

    public j(@k SharedPreferences preference) {
        f0.p(preference, "preference");
        this.f41546a = preference;
        this.f41547b = "adbkey";
    }

    @Override // moe.shizuku.manager.adb.e
    public void a(@k byte[] bytes) {
        f0.p(bytes, "bytes");
        SharedPreferences.Editor editor = this.f41546a.edit();
        f0.o(editor, "editor");
        String str = this.f41547b;
        byte[] bArrEncode = Base64.encode(bytes, 2);
        f0.o(bArrEncode, "encode(bytes, Base64.NO_WRAP)");
        editor.putString(str, new String(bArrEncode, kotlin.text.d.f38161b));
        editor.apply();
    }

    @Override // moe.shizuku.manager.adb.e
    @l
    public byte[] get() {
        if (this.f41546a.contains(this.f41547b)) {
            return Base64.decode(this.f41546a.getString(this.f41547b, null), 2);
        }
        return null;
    }
}
