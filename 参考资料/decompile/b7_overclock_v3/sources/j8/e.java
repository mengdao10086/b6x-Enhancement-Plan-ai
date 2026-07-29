package j8;

import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.ArrayList;
import m9.k;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public class e implements a8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f36208a = {R.string.floatview_property_type_click, R.string.floatview_property_type_moba, R.string.floatview_property_type_slide};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[][] f36209b = {new int[]{100}, new int[]{300, 301, 311}, new int[]{400, 401, 402, 403, a.c.C, a.c.D, 406, a.c.F}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GamepadInfo f36210c;

    public e(GamepadInfo gamepadInfo) {
        this.f36210c = gamepadInfo;
    }

    @Override // a8.a
    public void a(a8.b bVar) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
        for (int i10 : this.f36208a) {
            if (i10 != R.string.floatview_property_type_slide || o9.e.a(this.f36210c, k.f40820f)) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        for (int[] iArr : this.f36209b) {
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            for (int i11 : iArr) {
                arrayList3.add(Integer.valueOf(i11));
            }
            arrayList2.add(arrayList3);
        }
        bVar.e(arrayList, new ArrayList<>(arrayList2.get(0)), arrayList2);
    }
}
