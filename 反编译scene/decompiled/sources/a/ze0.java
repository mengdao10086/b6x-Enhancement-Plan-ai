package a;

import android.R;
import android.content.Context;
import android.view.ViewGroup;
import com.omarea.krscript.model.GroupNode;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ze0 extends if0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<if0> f8063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3837a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze0(Context context, boolean z, GroupNode groupNode) {
        super(context, z ? nb0.kr_group_list_root : nb0.kr_group_list_item, groupNode);
        f92.d(context, "context");
        f92.d(groupNode, "config");
        this.f3837a = z;
        this.f8063a = new ArrayList<>();
        g(groupNode.getTitle());
    }

    public final ze0 i(if0 if0Var) {
        f92.d(if0Var, "item");
        ((ViewGroup) c().findViewById(R.id.content)).addView(if0Var.d());
        this.f8063a.add(if0Var);
        return this;
    }

    public final boolean j() {
        return this.f3837a;
    }

    public final boolean k(String str) {
        f92.d(str, "key");
        for (if0 if0Var : this.f8063a) {
            if ((if0Var instanceof ye0) && if0Var.b().equals(str)) {
                ((ye0) if0Var).m();
                return true;
            }
            if ((if0Var instanceof ze0) && ((ze0) if0Var).k(str)) {
                return true;
            }
        }
        return false;
    }

    public final void l() {
        for (if0 if0Var : this.f8063a) {
            if (if0Var instanceof ze0) {
                ((ze0) if0Var).l();
            } else {
                if0Var.h();
            }
        }
    }

    public final void m(String[] strArr) {
        f92.d(strArr, "keys");
        for (String str : strArr) {
            if (str.equals(b())) {
                l();
            } else {
                for (if0 if0Var : this.f8063a) {
                    if (if0Var instanceof ze0) {
                        ((ze0) if0Var).m(strArr);
                    } else if (if0Var.b().equals(str)) {
                        if0Var.h();
                    }
                }
            }
        }
    }
}
