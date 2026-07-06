package a;

import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.SwitchNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public interface jf0 {
    void a(SwitchNode switchNode, Runnable runnable);

    void b(PickerNode pickerNode, Runnable runnable);

    void c(PageNode pageNode, Runnable runnable);

    void d(ClickableNode clickableNode);

    void e(ActionNode actionNode, Runnable runnable);
}
