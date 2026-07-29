package d8;

import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.ArrayList;
import m9.k;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public class e implements a8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f26104a = {R.string.floatview_property_type_click, R.string.floatview_property_type_fps, R.string.floatview_property_type_moba, R.string.floatview_property_type_slide, R.string.floatview_property_type_macro};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[][] f26105b = {new int[]{100, 101, 102, 104}, new int[]{a.c.f52772h, a.c.f52773i}, new int[]{300, 306, 307, 308, 303}, new int[]{400, 401, 402, 403, a.c.C, a.c.D, 406, a.c.F}, new int[]{601, 602, 603}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GamepadInfo f26106c;

    public e(GamepadInfo gamepadInfo) {
        this.f26106c = gamepadInfo;
    }

    @Override // a8.a
    public void a(a8.b bVar) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
        for (int i10 : this.f26104a) {
            arrayList.add(Integer.valueOf(i10));
        }
        for (int[] iArr : this.f26105b) {
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            for (int i11 : iArr) {
                if ((this.f26106c.isSupportMotion() || i11 != 308) && ((i11 != 104 || o9.e.a(this.f26106c, k.f40823i)) && ((i11 != 306 && i11 != 307) || !this.f26106c.isFlashplayMode() || !u9.b.e(true)))) {
                    arrayList3.add(Integer.valueOf(i11));
                }
            }
            arrayList2.add(arrayList3);
        }
        bVar.e(arrayList, new ArrayList<>(arrayList2.get(0)), arrayList2);
    }
}
