package j8;

import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.ArrayList;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public class c implements a8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f36202a = {R.string.floatview_property_type_click, R.string.floatview_property_type_moba, R.string.floatview_property_type_slide};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[][] f36203b = {new int[]{100}, new int[]{300, 311}, new int[]{400, 401, 402, 403, a.c.C, a.c.D, 406, a.c.F}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GamepadInfo f36204c;

    public c(GamepadInfo gamepadInfo) {
        this.f36204c = gamepadInfo;
    }

    @Override // a8.a
    public void a(a8.b bVar) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
        for (int i10 : this.f36202a) {
            arrayList.add(Integer.valueOf(i10));
        }
        for (int[] iArr : this.f36203b) {
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            for (int i11 : iArr) {
                arrayList3.add(Integer.valueOf(i11));
            }
            arrayList2.add(arrayList3);
        }
        bVar.e(arrayList, new ArrayList<>(arrayList2.get(0)), arrayList2);
    }
}
