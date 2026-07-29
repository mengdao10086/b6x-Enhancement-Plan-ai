package b8;

import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class h implements a8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GamepadInfo f9138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CFGPropertyJS f9139b;

    public h(GamepadInfo gamepadInfo, CFGPropertyJS cFGPropertyJS) {
        this.f9138a = gamepadInfo;
        this.f9139b = cFGPropertyJS;
    }

    @Override // a8.a
    public void a(a8.b bVar) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayList3 = new ArrayList<>();
        arrayList.add(1);
        bVar.e(arrayList, arrayList2, arrayList3);
    }
}
