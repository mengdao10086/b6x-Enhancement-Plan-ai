package ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.Settings;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f427c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f428d = new e(new int[]{2}, 8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f429e = new e(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f430f = "external_surround_sound_enabled";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f432b;

    public e(@p0 int[] iArr, int i10) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f431a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f431a = new int[0];
        }
        this.f432b = i10;
    }

    public static boolean a() {
        if (u0.f31154a >= 17) {
            String str = u0.f31156c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static e b(Context context) {
        return c(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    public static e c(Context context, @p0 Intent intent) {
        return (a() && Settings.Global.getInt(context.getContentResolver(), f430f, 0) == 1) ? f429e : (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f428d : new e(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    @p0
    public static Uri d() {
        if (a()) {
            return Settings.Global.getUriFor(f430f);
        }
        return null;
    }

    public int e() {
        return this.f432b;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Arrays.equals(this.f431a, eVar.f431a) && this.f432b == eVar.f432b;
    }

    public boolean f(int i10) {
        return Arrays.binarySearch(this.f431a, i10) >= 0;
    }

    public int hashCode() {
        return this.f432b + (Arrays.hashCode(this.f431a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f432b + ", supportedEncodings=" + Arrays.toString(this.f431a) + "]";
    }
}
