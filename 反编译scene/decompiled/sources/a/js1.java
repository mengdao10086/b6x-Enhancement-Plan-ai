package a;

import a.p80;
import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class js1 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f6542a;

    public js1(zs1 zs1Var) {
        this.f6542a = zs1Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        HashMap<String, String> mapR = this.f6542a.f3875a.r(i);
        if (mapR != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : mapR.entrySet()) {
                sb.append("\n");
                String key = entry.getKey();
                f92.c(key, "param.key");
                String str = key;
                String key2 = entry.getKey();
                f92.c(key2, "param.key");
                int iS = ec2.S(key2, "/", 0, false, 6, null) + 1;
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = str.substring(iS);
                f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                sb.append("：");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            p80.a aVar = p80.f2403a;
            cl clVarJ = this.f6542a.j();
            f92.b(clVarJ);
            f92.c(clVarJ, "activity!!");
            String string = sb.toString();
            f92.c(string, "msg.toString()");
            p80.a.B(aVar, clVarJ, "Governor Params", string, null, 8, null);
        }
    }
}
