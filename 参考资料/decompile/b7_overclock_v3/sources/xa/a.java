package xa;

import android.content.res.Resources;
import android.graphics.Color;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.util.ArrayList;
import java.util.List;
import v7.a;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f54970a = 1122867;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f54971b = 1122868;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f54972c = {Color.rgb(a.c.f52776l, 248, 246), Color.rgb(com.google.zxing.oned.d.f21430g, 212, 212), Color.rgb(136, 180, mb.e.f41031i2), Color.rgb(118, mb.e.f41073w1, HideBottomViewOnScrollBehavior.f19616g), Color.rgb(42, 109, 130)};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f54973d = {Color.rgb(217, 80, 138), Color.rgb(254, WaspWingInfo.COLD_LEVEL_STANDARD_B7, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f54974e = {Color.rgb(64, 89, 128), Color.rgb(WaspWingInfo.COLD_LEVEL_STANDARD_B7, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f54975f = {Color.rgb(s0.c.f49294u, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f54976g = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f54977h = {e("#2ecc71"), e("#f1c40f"), e("#e74c3c"), e("#3498db")};

    public static int a(int i10, int i11) {
        return (i10 & 16777215) | ((i11 & 255) << 24);
    }

    public static List<Integer> b(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i10)));
        }
        return arrayList;
    }

    public static List<Integer> c(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static int d() {
        return Color.rgb(51, 181, 229);
    }

    public static int e(String str) {
        int i10 = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((i10 >> 16) & 255, (i10 >> 8) & 255, (i10 >> 0) & 255);
    }
}
