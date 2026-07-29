package q7;

import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public class d {
    public static void a(ActionItemNormal actionItemNormal) {
        if (!a5.f.i().o() || !o5.p.d()) {
            actionItemNormal.setVisibility(8);
            return;
        }
        actionItemNormal.setVisibility(0);
        if (a5.f.i().n()) {
            actionItemNormal.setTitle(actionItemNormal.getContext().getString(R.string.device_setting_quit_alpha_group));
        } else {
            actionItemNormal.setTitle(actionItemNormal.getContext().getString(R.string.device_setting_join_alpha_group));
        }
    }
}
