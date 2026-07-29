package v5;

import com.flydigi.base.common.n;
import com.flydigi.sdk.gamepad.extension.config.data.CFGMacroList;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import okio.f0;
import okio.l;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    public class a extends TypeToken<CFGMacroList> {
    }

    public static ArrayList<CFGPropertyMacro> a(final File file, int mDeviceMode) {
        try {
            l lVarE = f0.e(f0.t(file));
            String strY1 = lVarE.y1();
            lVarE.close();
            n.a("flydigitestdata readMacroListFromFile:" + strY1);
            CFGMacroList cFGMacroList = (CFGMacroList) new Gson().fromJson(strY1, new a().getType());
            if (mDeviceMode == 0) {
                return cFGMacroList.getGpWholeList();
            }
            if (mDeviceMode == 1) {
                return cFGMacroList.getKbMosList();
            }
            if (mDeviceMode != 2) {
                return null;
            }
            return cFGMacroList.getGpHalfList();
        } catch (Exception e10) {
            n.a("flydigitestdata Read CFGPropertyMacro From File Error!" + e10.getMessage());
            return null;
        }
    }
}
