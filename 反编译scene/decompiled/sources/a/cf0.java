package a;

import android.content.Context;
import android.widget.Switch;
import com.omarea.krscript.model.SwitchNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cf0 extends ye0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Switch f5787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SwitchNode f391a;
    public final Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf0(Context context, SwitchNode switchNode) {
        super(context, nb0.kr_switch_list_item, switchNode);
        f92.d(context, "context");
        f92.d(switchNode, "config");
        this.b = context;
        this.f391a = switchNode;
        this.f5787a = (Switch) c().findViewById(mb0.kr_switch);
        n(this.f391a.getChecked());
    }

    @Override // a.if0
    public void h() {
        super.h();
        boolean z = true;
        if (this.f391a.getGetState().length() > 0) {
            String strC = yc0.c(this.b, this.f391a.getGetState(), this.f391a);
            SwitchNode switchNode = this.f391a;
            if (!f92.a(strC, "1")) {
                f92.c(strC, "shellResult");
                if (strC == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = strC.toLowerCase();
                f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (!f92.a(lowerCase, "true")) {
                    z = false;
                }
            }
            switchNode.setChecked(z);
        }
        n(this.f391a.getChecked());
    }

    public final void n(boolean z) {
        Switch r0 = this.f5787a;
        if (r0 != null) {
            r0.setChecked(z);
        }
    }
}
