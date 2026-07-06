package a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.GroupNode;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.SwitchNode;
import com.omarea.krscript.model.TextNode;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class of0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf0 f7016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nf0 f2236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final we0 f2237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ze0 f2238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<NodeInfoBase> f2240a;

    public of0(Context context, ArrayList<NodeInfoBase> arrayList, jf0 jf0Var, ze0 ze0Var) {
        f92.d(context, "mContext");
        f92.d(arrayList, "itemConfigList");
        f92.d(jf0Var, "clickListener");
        f92.d(ze0Var, "rootGroup");
        this.f2239a = context;
        this.f2240a = arrayList;
        this.f7016a = jf0Var;
        this.f2238a = ze0Var;
        this.f2237a = new mf0(this);
        this.f2236a = new nf0(this);
        o(this.f2238a, this.f2240a);
    }

    public final if0 f(ActionNode actionNode) {
        return new te0(this.f2239a, actionNode);
    }

    public final ze0 g(GroupNode groupNode) {
        return new ze0(this.f2239a, false, groupNode);
    }

    public final if0 h(PickerNode pickerNode) {
        return new bf0(this.f2239a, pickerNode);
    }

    public final if0 i(PageNode pageNode) {
        return new af0(this.f2239a, pageNode);
    }

    public final if0 j(SwitchNode switchNode) {
        return new cf0(this.f2239a, switchNode);
    }

    public final if0 k(TextNode textNode) {
        return new hf0(this.f2239a, nb0.kr_text_list_item, textNode);
    }

    public final if0 l(TextNode textNode) {
        return new hf0(this.f2239a, nb0.kr_text_list_item_white, textNode);
    }

    public final NodeInfoBase m(String str, ArrayList<NodeInfoBase> arrayList) {
        NodeInfoBase nodeInfoBaseM;
        for (NodeInfoBase nodeInfoBase : arrayList) {
            if (f92.a(nodeInfoBase.getIndex(), str)) {
                return nodeInfoBase;
            }
            if (nodeInfoBase instanceof GroupNode) {
                GroupNode groupNode = (GroupNode) nodeInfoBase;
                if (groupNode.getChildren().size() > 0 && (nodeInfoBaseM = m(str, groupNode.getChildren())) != null) {
                    return nodeInfoBaseM;
                }
            }
        }
        return null;
    }

    public final Runnable n(NodeInfoBase nodeInfoBase, ye0 ye0Var) {
        return new lf0(this, new Handler(Looper.getMainLooper()), ye0Var, nodeInfoBase);
    }

    public final void o(ze0 ze0Var, ArrayList<NodeInfoBase> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            NodeInfoBase nodeInfoBase = arrayList.get(i);
            f92.c(nodeInfoBase, "actionInfos[index]");
            NodeInfoBase nodeInfoBase2 = nodeInfoBase;
            if0 if0VarK = null;
            try {
                if (nodeInfoBase2 instanceof PageNode) {
                    if0VarK = i((PageNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof SwitchNode) {
                    if0VarK = j((SwitchNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof ActionNode) {
                    if0VarK = f((ActionNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof PickerNode) {
                    if0VarK = h((PickerNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof TextNode) {
                    if0VarK = ze0Var.j() ? k((TextNode) nodeInfoBase2) : l((TextNode) nodeInfoBase2);
                } else if (nodeInfoBase2 instanceof GroupNode) {
                    ze0 ze0VarG = g((GroupNode) nodeInfoBase2);
                    if (((GroupNode) nodeInfoBase2).getChildren().size() > 0) {
                        ze0Var.i(ze0VarG);
                        o(ze0VarG, ((GroupNode) nodeInfoBase2).getChildren());
                    }
                }
                if (if0VarK != null) {
                    if (if0VarK instanceof ye0) {
                        ((ye0) if0VarK).k(this.f2237a);
                        ((ye0) if0VarK).l(this.f2236a);
                    }
                    ze0Var.i(if0VarK);
                }
            } catch (Exception e) {
                Toast.makeText(this.f2239a, nodeInfoBase2.getTitle() + "界面渲染异常" + e.getMessage(), 0).show();
            }
        }
    }

    public final void p(NodeInfoBase nodeInfoBase, ye0 ye0Var) {
        if (nodeInfoBase instanceof PageNode) {
            this.f7016a.c((PageNode) nodeInfoBase, n(nodeInfoBase, ye0Var));
            return;
        }
        if (nodeInfoBase instanceof ActionNode) {
            this.f7016a.e((ActionNode) nodeInfoBase, n(nodeInfoBase, ye0Var));
        } else if (nodeInfoBase instanceof PickerNode) {
            this.f7016a.b((PickerNode) nodeInfoBase, n(nodeInfoBase, ye0Var));
        } else if (nodeInfoBase instanceof SwitchNode) {
            this.f7016a.a((SwitchNode) nodeInfoBase, n(nodeInfoBase, ye0Var));
        }
    }
}
