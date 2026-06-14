package a;

import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ge0 {
    public ge0() {
    }

    public /* synthetic */ ge0(b92 b92Var) {
        this();
    }

    public final int a(ActionParamInfo actionParamInfo, ArrayList<n30> arrayList) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(arrayList, "options");
        ArrayList arrayList2 = new ArrayList();
        if (actionParamInfo.getValueFromShell() != null) {
            String valueFromShell = actionParamInfo.getValueFromShell();
            f92.b(valueFromShell);
            arrayList2.add(valueFromShell);
        }
        if (actionParamInfo.getValue() != null) {
            String value = actionParamInfo.getValue();
            f92.b(value);
            arrayList2.add(value);
        }
        if (arrayList2.size() <= 0) {
            return -1;
        }
        int size = arrayList2.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            Iterator<n30> it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (f92.a(it.next().e(), (String) arrayList2.get(i2))) {
                    i = i3;
                    break;
                }
                i3++;
            }
            if (i > -1) {
                break;
            }
        }
        return i;
    }

    public final boolean[] b(ActionParamInfo actionParamInfo, ArrayList<n30> arrayList) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(arrayList, "options");
        boolean[] zArr = new boolean[arrayList.size()];
        List<String> listC = c(actionParamInfo);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            n30 n30Var = arrayList.get(i);
            f92.c(n30Var, "options[index]");
            zArr[i] = listC != null && i52.v(listC, n30Var.e());
        }
        return zArr;
    }

    public final List<String> c(ActionParamInfo actionParamInfo) {
        List listD0;
        f92.d(actionParamInfo, "actionParamInfo");
        String valueFromShell = actionParamInfo.getValueFromShell() != null ? actionParamInfo.getValueFromShell() : actionParamInfo.getValue();
        int i = 0;
        List<String> listA0 = (valueFromShell == null || (listD0 = ec2.d0(valueFromShell, new String[]{actionParamInfo.getSeparator()}, false, 0, 6, null)) == null) ? null : i52.a0(listD0);
        if (listA0 != null && f92.a(actionParamInfo.getSeparator(), "\n")) {
            for (Object obj : listA0) {
                int i2 = i + 1;
                if (i < 0) {
                    y42.l();
                    throw null;
                }
                listA0.set(i, bc2.t((String) obj, "\r", "", false, 4, null));
                i = i2;
            }
        }
        return listA0;
    }

    public final ArrayList<n30> d(ActionParamInfo actionParamInfo, ArrayList<n30> arrayList) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(arrayList, "options");
        List<String> listC = c(actionParamInfo);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            n30 n30Var = arrayList.get(i);
            f92.c(n30Var, "options[index]");
            arrayList.get(i).h(listC != null && i52.v(listC, n30Var.e()));
        }
        return arrayList;
    }
}
