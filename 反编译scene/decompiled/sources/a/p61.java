package a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class p61 extends Binder implements q61 {
    public static q61 f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.omarea.vaddin.IAppConfigAidlInterface");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof q61)) ? new o61(iBinder) : (q61) iInterfaceQueryLocalInterface;
    }

    public static q61 g() {
        return o61.f6988a;
    }
}
