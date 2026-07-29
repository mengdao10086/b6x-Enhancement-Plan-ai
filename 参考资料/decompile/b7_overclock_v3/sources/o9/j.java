package o9;

import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import hk.m;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final j f43001a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f43002b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f43003c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f43004d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f43005e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f43006f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f43007g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f43008h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f43009i = 8;

    @m
    public static final int a(@k CFGSubPropertyMacro cfgSubPropertyMacro) {
        f0.p(cfgSubPropertyMacro, "cfgSubPropertyMacro");
        int type = cfgSubPropertyMacro.getType();
        if (type == 2) {
            return 2;
        }
        if (type == 12) {
            return cfgSubPropertyMacro.reverse() ? 8 : 7;
        }
        if (type == 5) {
            return cfgSubPropertyMacro.reverse() ? 5 : 3;
        }
        if (type != 6) {
            return 1;
        }
        return cfgSubPropertyMacro.reverse() ? 6 : 4;
    }
}
