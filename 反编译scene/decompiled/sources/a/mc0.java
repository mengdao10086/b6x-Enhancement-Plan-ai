package a;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.util.Log;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ActionParamInfo;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.SwitchNode;
import com.omarea.krscript.model.TextNode;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j60 f6792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f1916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NodeInfoBase f1917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InputStream f1918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ActionParamInfo> f1920a;
    public String b;
    public String c;

    public mc0(Context context, InputStream inputStream) {
        f92.d(context, "context");
        f92.d(inputStream, "pageConfigStream");
        this.f1919a = "";
        this.b = "";
        this.c = "";
        this.f1915a = context;
        this.f1918a = inputStream;
        this.f6792a = new j60(context);
    }

    public mc0(Context context, String str, String str2) {
        f92.d(context, "context");
        f92.d(str, "pageConfig");
        this.f1919a = "";
        this.b = "";
        this.c = "";
        this.f1915a = context;
        this.f1919a = str;
        this.c = str2 == null ? "" : str2;
        this.f6792a = new j60(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0163, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.krscript.model.ClickableNode b(com.omarea.krscript.model.ClickableNode r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.b(com.omarea.krscript.model.ClickableNode, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.ClickableNode");
    }

    public final void c(NodeInfoBase nodeInfoBase, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (f92.a(attributeName, "su") || f92.a(attributeName, "sh") || f92.a(attributeName, "desc-sh")) {
                f92.c(attributeValue, "attrValue");
                nodeInfoBase.setDescSh(attributeValue);
                nodeInfoBase.setDesc(d(this.f1915a, nodeInfoBase.getDescSh()));
            }
        }
        if (nodeInfoBase.getDesc().length() == 0) {
            String strNextText = xmlPullParser.nextText();
            f92.c(strNextText, "parser.nextText()");
            nodeInfoBase.setDesc(strNextText);
        }
    }

    public final String d(Context context, String str) {
        if (this.f1917a == null) {
            this.f1917a = new NodeInfoBase(this.b);
        }
        String strC = yc0.c(context, str, this.f1917a);
        f92.c(strC, "ScriptEnvironmen.execute…criptIn, virtualRootNode)");
        return strC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a5, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.krscript.model.GroupNode e(org.xmlpull.v1.XmlPullParser r8) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.e(org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.GroupNode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f5, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.krscript.model.NodeInfoBase f(com.omarea.krscript.model.NodeInfoBase r8, org.xmlpull.v1.XmlPullParser r9) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.f(com.omarea.krscript.model.NodeInfoBase, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.NodeInfoBase");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.krscript.model.PageNode g(com.omarea.krscript.model.PageNode r7, org.xmlpull.v1.XmlPullParser r8) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.g(com.omarea.krscript.model.PageNode, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.PageNode");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void h(PickerNode pickerNode, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (attributeName != null) {
                switch (attributeName.hashCode()) {
                    case 653829648:
                        if (attributeName.equals("multiple")) {
                            pickerNode.setMultiple(f92.a(attributeValue, "multiple") || f92.a(attributeValue, "true") || f92.a(attributeValue, "1"));
                            continue;
                        }
                        break;
                    case 1374438372:
                        if (!attributeName.equals("options-sh")) {
                            break;
                        }
                        break;
                    case 1374438385:
                        if (!attributeName.equals("options-su")) {
                            break;
                        }
                        break;
                    case 1732829925:
                        if (attributeName.equals("separator")) {
                            f92.c(attributeValue, "attrValue");
                            pickerNode.setSeparator(attributeValue);
                        } else {
                            continue;
                        }
                        break;
                    case 1845386925:
                        if (!attributeName.equals("option-sh")) {
                            break;
                        }
                        break;
                }
                if (pickerNode.getOptions() == null) {
                    pickerNode.setOptions(new ArrayList<>());
                }
                f92.c(attributeValue, "attrValue");
                pickerNode.setOptionsSh(attributeValue);
            }
        }
    }

    public final ArrayList<NodeInfoBase> i() throws XmlPullParserException, IOException {
        InputStream inputStream = this.f1918a;
        if (inputStream != null) {
            f92.b(inputStream);
            return j(inputStream);
        }
        try {
            qc0 qc0Var = new qc0(this.f1915a, this.c);
            InputStream inputStreamE = qc0Var.e(this.f1919a);
            if (inputStreamE == null) {
                return new ArrayList<>();
            }
            this.b = qc0Var.c();
            return j(inputStreamE);
        } catch (Exception e) {
            new Handler(Looper.getMainLooper()).post(new kc0(this, e));
            Log.e("KrConfig Fail！", "" + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<com.omarea.krscript.model.NodeInfoBase> j(java.io.InputStream r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 651
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.j(java.io.InputStream):java.util.ArrayList");
    }

    public final void k(XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (f92.a(attributeName, "file")) {
                f92.c(attributeValue, "attrValue");
                if (attributeValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                new wc0(this.f1915a).d(ec2.r0(attributeValue).toString());
            } else if (f92.a(attributeName, "dir")) {
                f92.c(attributeValue, "attrValue");
                if (attributeValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                new wc0(this.f1915a).f(ec2.r0(attributeValue).toString());
            } else {
                continue;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void l(TextNode textNode, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Layout.Alignment alignment;
        TextNode.TextRow textRow = new TextNode.TextRow();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            f92.c(attributeName, "parser.getAttributeName(i)");
            if (attributeName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = attributeName.toLowerCase();
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
            String attributeValue = xmlPullParser.getAttributeValue(i);
            try {
                boolean z = true;
                switch (lowerCase.hashCode()) {
                    case -1655966961:
                        if (lowerCase.equals("activity")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setActivity$krscript_release_mini(attributeValue);
                        }
                        break;
                    case -1332194002:
                        if (lowerCase.equals("background")) {
                            textRow.setBgColor$krscript_release_mini(Color.parseColor(attributeValue));
                        }
                        break;
                    case -1183762788:
                        if (lowerCase.equals("intent")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setActivity$krscript_release_mini(attributeValue);
                        }
                        break;
                    case -1178781136:
                        if (lowerCase.equals("italic")) {
                            if (!f92.a(attributeValue, "1") && !f92.a(attributeValue, "true") && !f92.a(attributeValue, "italic")) {
                                z = false;
                            }
                            textRow.setItalic$krscript_release_mini(z);
                        }
                        break;
                    case -1026963764:
                        if (lowerCase.equals("underline")) {
                            if (!f92.a(attributeValue, "1") && !f92.a(attributeValue, "true") && !f92.a(attributeValue, "underline")) {
                                z = false;
                            }
                            textRow.setUnderline$krscript_release_mini(z);
                        }
                        break;
                    case -907685685:
                        if (lowerCase.equals("script")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setOnClickScript$krscript_release_mini(attributeValue);
                        }
                        break;
                    case -175307202:
                        if (lowerCase.equals("bgcolor")) {
                            textRow.setBgColor$krscript_release_mini(Color.parseColor(attributeValue));
                        }
                        break;
                    case 97:
                        if (lowerCase.equals("a")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setActivity$krscript_release_mini(attributeValue);
                        }
                        break;
                    case 98:
                        if (lowerCase.equals("b")) {
                            if (!f92.a(attributeValue, "1") && !f92.a(attributeValue, "true") && !f92.a(attributeValue, "bold")) {
                                z = false;
                            }
                            textRow.setBold$krscript_release_mini(z);
                        }
                        break;
                    case 105:
                        if (lowerCase.equals("i")) {
                            if (!f92.a(attributeValue, "1")) {
                                z = false;
                            }
                            textRow.setItalic$krscript_release_mini(z);
                        }
                        break;
                    case 117:
                        if (lowerCase.equals("u")) {
                            if (!f92.a(attributeValue, "1")) {
                                z = false;
                            }
                            textRow.setUnderline$krscript_release_mini(z);
                        }
                        break;
                    case 3141:
                        if (lowerCase.equals("bg")) {
                            textRow.setBgColor$krscript_release_mini(Color.parseColor(attributeValue));
                        }
                        break;
                    case 3669:
                        if (lowerCase.equals("sh")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setDynamicTextSh$krscript_release_mini(attributeValue);
                        }
                        break;
                    case 113291:
                        if (lowerCase.equals("run")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setOnClickScript$krscript_release_mini(attributeValue);
                        }
                        break;
                    case 3029637:
                        if (lowerCase.equals("bold")) {
                            if (!f92.a(attributeValue, "1")) {
                                z = false;
                            }
                            textRow.setBold$krscript_release_mini(z);
                        }
                        break;
                    case 3211051:
                        if (lowerCase.equals("href")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setLink$krscript_release_mini(attributeValue);
                        }
                        break;
                    case 3321850:
                        if (lowerCase.equals("link")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setLink$krscript_release_mini(attributeValue);
                        }
                        break;
                    case 3530753:
                        if (lowerCase.equals("size")) {
                            f92.c(attributeValue, "attrValue");
                            textRow.setSize$krscript_release_mini(Integer.parseInt(attributeValue));
                        }
                        break;
                    case 92903173:
                        if (lowerCase.equals("align") && attributeValue != null) {
                            switch (attributeValue.hashCode()) {
                                case -1364013995:
                                    if (attributeValue.equals("center")) {
                                        alignment = Layout.Alignment.ALIGN_CENTER;
                                    }
                                    break;
                                case -1039745817:
                                    if (attributeValue.equals("normal")) {
                                        alignment = Layout.Alignment.ALIGN_NORMAL;
                                    }
                                    break;
                                case 3317767:
                                    if (attributeValue.equals("left") && Build.VERSION.SDK_INT >= 28) {
                                        alignment = Layout.Alignment.ALIGN_LEFT;
                                    }
                                    break;
                                case 108511772:
                                    if (attributeValue.equals("right") && Build.VERSION.SDK_INT >= 28) {
                                        alignment = Layout.Alignment.ALIGN_RIGHT;
                                    }
                                    break;
                                default:
                                    continue;
                            }
                            textRow.setAlign$krscript_release_mini(alignment);
                        }
                        break;
                    case 94001407:
                        if (lowerCase.equals("break")) {
                            if (!f92.a(attributeValue, "1") && !f92.a(attributeValue, "true") && !f92.a(attributeValue, "break")) {
                                z = false;
                            }
                            textRow.setBreakRow$krscript_release_mini(z);
                        }
                        break;
                    case 94842723:
                        if (lowerCase.equals("color")) {
                            textRow.setColor$krscript_release_mini(Color.parseColor(attributeValue));
                        }
                        break;
                    case 1984457027:
                        if (lowerCase.equals("foreground")) {
                            textRow.setColor$krscript_release_mini(Color.parseColor(attributeValue));
                        }
                        break;
                }
            } catch (Exception unused) {
            }
        }
        textRow.setText$krscript_release_mini("" + xmlPullParser.nextText());
        textNode.getRows().add(textRow);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        if (r6.equals("background-task") != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x012f, code lost:
    
        if (r6.equals("bg-task") != false) goto L85;
     */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:117)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.krscript.model.RunnableNode m(com.omarea.krscript.model.RunnableNode r20, org.xmlpull.v1.XmlPullParser r21) {
        /*
            Method dump skipped, instruction units count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.m(com.omarea.krscript.model.RunnableNode, org.xmlpull.v1.XmlPullParser):com.omarea.krscript.model.RunnableNode");
    }

    public final void n(NodeInfoBase nodeInfoBase, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (f92.a(attributeName, "su") || f92.a(attributeName, "sh") || f92.a(attributeName, "summary-sh")) {
                f92.c(attributeValue, "attrValue");
                nodeInfoBase.setSummarySh(attributeValue);
                nodeInfoBase.setSummary(d(this.f1915a, nodeInfoBase.getSummarySh()));
            }
        }
        if (nodeInfoBase.getSummary().length() == 0) {
            String strNextText = xmlPullParser.nextText();
            f92.c(strNextText, "parser.nextText()");
            nodeInfoBase.setSummary(strNextText);
        }
    }

    public final void o(ActionNode actionNode, XmlPullParser xmlPullParser) {
        if (actionNode != null) {
            if (actionNode.getSetState() == null) {
                actionNode.setSetState("");
            }
            actionNode.setParams(this.f1920a);
            this.f1920a = null;
        }
    }

    public final void p(PageNode pageNode, XmlPullParser xmlPullParser) {
    }

    public final void q(PickerNode pickerNode, XmlPullParser xmlPullParser) {
        if (pickerNode != null) {
            if (pickerNode.getGetState() == null) {
                pickerNode.setGetState("");
            } else {
                pickerNode.setValue(d(this.f1915a, "" + pickerNode.getGetState()));
            }
            if (pickerNode.getSetState() == null) {
                pickerNode.setSetState("");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(com.omarea.krscript.model.SwitchNode r3, org.xmlpull.v1.XmlPullParser r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L49
            android.content.Context r4 = r2.f1915a
            java.lang.String r0 = r3.getGetState()
            java.lang.String r4 = r2.d(r4, r0)
            java.lang.String r0 = "error"
            boolean r0 = a.f92.a(r4, r0)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L3a
            java.lang.String r0 = "1"
            boolean r0 = a.f92.a(r4, r0)
            if (r0 != 0) goto L3b
            if (r4 == 0) goto L32
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            a.f92.c(r4, r0)
            java.lang.String r0 = "true"
            boolean r4 = a.f92.a(r4, r0)
            if (r4 == 0) goto L3a
            goto L3b
        L32:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        L3a:
            r1 = 0
        L3b:
            r3.setChecked(r1)
            java.lang.String r4 = r3.getSetState()
            if (r4 != 0) goto L49
            java.lang.String r4 = ""
            r3.setSetState(r4)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.r(com.omarea.krscript.model.SwitchNode, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void s(TextNode textNode, XmlPullParser xmlPullParser) {
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:117)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public final void t(ActionNode actionNode, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str;
        String str2;
        String str3 = "title";
        if (f92.a("title", xmlPullParser.getName())) {
            String strNextText = xmlPullParser.nextText();
            f92.c(strNextText, "parser.nextText()");
            actionNode.setTitle(strNextText);
            return;
        }
        String str4 = "desc";
        if (f92.a("desc", xmlPullParser.getName())) {
            c(actionNode, xmlPullParser);
            return;
        }
        if (f92.a("summary", xmlPullParser.getName())) {
            n(actionNode, xmlPullParser);
            return;
        }
        if (f92.a("script", xmlPullParser.getName()) || f92.a("set", xmlPullParser.getName()) || f92.a("setstate", xmlPullParser.getName())) {
            String strNextText2 = xmlPullParser.nextText();
            f92.c(strNextText2, "parser.nextText()");
            if (strNextText2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            actionNode.setSetState(ec2.r0(strNextText2).toString());
            return;
        }
        if (f92.a("lock", xmlPullParser.getName()) || f92.a("lock-state", xmlPullParser.getName())) {
            String strNextText3 = xmlPullParser.nextText();
            f92.c(strNextText3, "parser.nextText()");
            actionNode.setLockShell(strNextText3);
            return;
        }
        if (!f92.a("param", xmlPullParser.getName())) {
            if (this.f1916a == null || !f92.a("option", xmlPullParser.getName())) {
                if (f92.a("resource", xmlPullParser.getName())) {
                    k(xmlPullParser);
                    return;
                }
                return;
            }
            ActionParamInfo actionParamInfo = this.f1916a;
            f92.b(actionParamInfo);
            if (actionParamInfo.getOptions() == null) {
                actionParamInfo.setOptions(new ArrayList<>());
            }
            n30 n30Var = new n30();
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                String attributeValue = xmlPullParser.getAttributeValue(i);
                if (f92.a(attributeName, "val") || f92.a(attributeName, "value")) {
                    n30Var.j(attributeValue);
                }
            }
            n30Var.i(xmlPullParser.nextText());
            if (n30Var.e() == null) {
                CharSequence charSequenceD = n30Var.d();
                f92.b(charSequenceD);
                n30Var.j(charSequenceD.toString());
            }
            ArrayList<n30> options = actionParamInfo.getOptions();
            f92.b(options);
            options.add(n30Var);
            return;
        }
        if (this.f1920a == null) {
            this.f1920a = new ArrayList<>();
        }
        ActionParamInfo actionParamInfo2 = new ActionParamInfo();
        this.f1916a = actionParamInfo2;
        f92.b(actionParamInfo2);
        int attributeCount2 = xmlPullParser.getAttributeCount();
        int i2 = 0;
        while (true) {
            if (i2 >= attributeCount2) {
                if (!actionParamInfo2.getSupported() || actionParamInfo2.getName() == null) {
                    return;
                }
                String name = actionParamInfo2.getName();
                f92.b(name);
                if (name.length() > 0) {
                    ArrayList<ActionParamInfo> arrayList = this.f1920a;
                    f92.b(arrayList);
                    arrayList.add(actionParamInfo2);
                    return;
                }
                return;
            }
            String attributeName2 = xmlPullParser.getAttributeName(i2);
            String attributeValue2 = xmlPullParser.getAttributeValue(i2);
            if (f92.a(attributeName2, "name")) {
                actionParamInfo2.setName(attributeValue2);
            } else if (f92.a(attributeName2, "label")) {
                actionParamInfo2.setLabel(attributeValue2);
            } else if (f92.a(attributeName2, "placeholder")) {
                f92.c(attributeValue2, "attrValue");
                actionParamInfo2.setPlaceholder(attributeValue2);
            } else if (f92.a(attributeName2, str3)) {
                actionParamInfo2.setTitle(attributeValue2);
            } else if (f92.a(attributeName2, str4)) {
                actionParamInfo2.setDesc(attributeValue2);
            } else if (f92.a(attributeName2, "value")) {
                actionParamInfo2.setValue(attributeValue2);
            } else if (f92.a(attributeName2, "type")) {
                f92.c(attributeValue2, "attrValue");
                if (attributeValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = attributeValue2.toLowerCase();
                f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                int length = lowerCase.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length) {
                    boolean z2 = f92.e(lowerCase.charAt(!z ? i3 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                actionParamInfo2.setType(lowerCase.subSequence(i3, length + 1).toString());
            } else if (f92.a(attributeName2, "suffix")) {
                f92.c(attributeValue2, "attrValue");
                if (attributeValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = attributeValue2.toLowerCase();
                f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
                int length2 = lowerCase2.length() - 1;
                int i4 = 0;
                boolean z3 = false;
                while (i4 <= length2) {
                    boolean z4 = f92.e(lowerCase2.charAt(!z3 ? i4 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z4) {
                        i4++;
                    } else {
                        z3 = true;
                    }
                }
                String string = lowerCase2.subSequence(i4, length2 + 1).toString();
                if (actionParamInfo2.getMime().length() == 0) {
                    actionParamInfo2.setMime(new rc0().a(string));
                }
                actionParamInfo2.setSuffix(string);
            } else if (f92.a(attributeName2, "mime")) {
                f92.c(attributeValue2, "attrValue");
                if (attributeValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase3 = attributeValue2.toLowerCase();
                f92.c(lowerCase3, "(this as java.lang.String).toLowerCase()");
                actionParamInfo2.setMime(lowerCase3);
            } else {
                str = str3;
                if (f92.a(attributeName2, "readonly")) {
                    f92.c(attributeValue2, "attrValue");
                    if (attributeValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase4 = attributeValue2.toLowerCase();
                    f92.c(lowerCase4, "(this as java.lang.String).toLowerCase()");
                    int length3 = lowerCase4.length() - 1;
                    boolean z5 = false;
                    int i5 = 0;
                    while (true) {
                        if (i5 > length3) {
                            str2 = str4;
                            break;
                        }
                        str2 = str4;
                        boolean z6 = f92.e(lowerCase4.charAt(!z5 ? i5 : length3), 32) <= 0;
                        if (z5) {
                            if (!z6) {
                                break;
                            } else {
                                length3--;
                            }
                        } else if (z6) {
                            i5++;
                        } else {
                            z5 = true;
                        }
                        str4 = str2;
                    }
                    String string2 = lowerCase4.subSequence(i5, length3 + 1).toString();
                    actionParamInfo2.setReadonly(f92.a(string2, "readonly") || f92.a(string2, "true") || f92.a(string2, "1"));
                } else {
                    str2 = str4;
                    if (f92.a(attributeName2, "maxlength")) {
                        actionParamInfo2.setMaxLength(Integer.parseInt(attributeValue2));
                    } else if (f92.a(attributeName2, "min")) {
                        actionParamInfo2.setMin(Integer.parseInt(attributeValue2));
                    } else if (f92.a(attributeName2, "max")) {
                        actionParamInfo2.setMax(Integer.parseInt(attributeValue2));
                    } else if (f92.a(attributeName2, "min-sh")) {
                        Context context = this.f1915a;
                        f92.c(attributeValue2, "attrValue");
                        try {
                            actionParamInfo2.setMin(Integer.parseInt(d(context, attributeValue2)));
                        } catch (Exception unused) {
                        }
                    } else if (f92.a(attributeName2, "max-sh")) {
                        Context context2 = this.f1915a;
                        f92.c(attributeValue2, "attrValue");
                        actionParamInfo2.setMax(Integer.parseInt(d(context2, attributeValue2)));
                    } else if (f92.a(attributeName2, "required")) {
                        actionParamInfo2.setRequired(f92.a(attributeValue2, "true") || f92.a(attributeValue2, "1") || f92.a(attributeValue2, "required"));
                    } else {
                        if (f92.a(attributeName2, "value-sh") || f92.a(attributeName2, "value-su")) {
                            actionParamInfo2.setValueShell(attributeValue2);
                        } else if (f92.a(attributeName2, "options-sh") || f92.a(attributeName2, "option-sh") || f92.a(attributeName2, "options-su")) {
                            if (actionParamInfo2.getOptions() == null) {
                                actionParamInfo2.setOptions(new ArrayList<>());
                            }
                            f92.c(attributeValue2, "script");
                            actionParamInfo2.setOptionsSh(attributeValue2);
                        } else if (f92.a(attributeName2, "exist")) {
                            y60 y60Var = y60.f7952a;
                            f92.c(attributeValue2, "attrValue");
                            actionParamInfo2.setSupported(y60Var.g(attributeValue2));
                        } else if (f92.a(attributeName2, "support") || f92.a(attributeName2, "visible") || f92.a(attributeName2, "visible-sh")) {
                            Context context3 = this.f1915a;
                            f92.c(attributeValue2, "attrValue");
                            if (!f92.a(d(context3, attributeValue2), "1")) {
                                actionParamInfo2.setSupported(false);
                            }
                        } else if (f92.a(attributeName2, "multiple")) {
                            actionParamInfo2.setMultiple(f92.a(attributeValue2, "multiple") || f92.a(attributeValue2, "true") || f92.a(attributeValue2, "1"));
                        } else if (f92.a(attributeName2, "editable")) {
                            actionParamInfo2.setEditable(f92.a(attributeValue2, "editable") || f92.a(attributeValue2, "true") || f92.a(attributeValue2, "1"));
                        } else if (f92.a(attributeName2, "separator")) {
                            f92.c(attributeValue2, "attrValue");
                            actionParamInfo2.setSeparator(attributeValue2);
                        }
                        i2++;
                        str4 = str2;
                        str3 = str;
                    }
                }
                i2++;
                str4 = str2;
                str3 = str;
            }
            str = str3;
            str2 = str4;
            i2++;
            str4 = str2;
            str3 = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x01d5, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(com.omarea.krscript.model.PageNode r14, org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mc0.u(com.omarea.krscript.model.PageNode, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void v(PickerNode pickerNode, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (f92.a("title", xmlPullParser.getName())) {
            String strNextText = xmlPullParser.nextText();
            f92.c(strNextText, "parser.nextText()");
            pickerNode.setTitle(strNextText);
            return;
        }
        if (f92.a("desc", xmlPullParser.getName())) {
            c(pickerNode, xmlPullParser);
            return;
        }
        if (f92.a("summary", xmlPullParser.getName())) {
            n(pickerNode, xmlPullParser);
            return;
        }
        if (!f92.a("option", xmlPullParser.getName())) {
            if (f92.a("getstate", xmlPullParser.getName()) || f92.a("get", xmlPullParser.getName())) {
                pickerNode.setGetState(xmlPullParser.nextText());
                return;
            }
            if (f92.a("setstate", xmlPullParser.getName()) || f92.a("set", xmlPullParser.getName())) {
                pickerNode.setSetState(xmlPullParser.nextText());
                return;
            }
            if (f92.a("resource", xmlPullParser.getName())) {
                k(xmlPullParser);
                return;
            } else {
                if (f92.a("lock", xmlPullParser.getName()) || f92.a("lock-state", xmlPullParser.getName())) {
                    String strNextText2 = xmlPullParser.nextText();
                    f92.c(strNextText2, "parser.nextText()");
                    pickerNode.setLockShell(strNextText2);
                    return;
                }
                return;
            }
        }
        if (pickerNode.getOptions() == null) {
            pickerNode.setOptions(new ArrayList<>());
        }
        n30 n30Var = new n30();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (f92.a(attributeName, "val") || f92.a(attributeName, "value")) {
                n30Var.j(attributeValue);
            }
        }
        n30Var.i(xmlPullParser.nextText());
        if (n30Var.e() == null) {
            CharSequence charSequenceD = n30Var.d();
            f92.b(charSequenceD);
            n30Var.j(charSequenceD.toString());
        }
        ArrayList<n30> options = pickerNode.getOptions();
        f92.b(options);
        options.add(n30Var);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void w(SwitchNode switchNode, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name == null) {
            return;
        }
        switch (name.hashCode()) {
            case -1857640538:
                if (name.equals("summary")) {
                    n(switchNode, xmlPullParser);
                }
                break;
            case -341064690:
                if (name.equals("resource")) {
                    k(xmlPullParser);
                }
                break;
            case -196357777:
                if (!name.equals("lock-state")) {
                }
                String strNextText = xmlPullParser.nextText();
                f92.c(strNextText, "parser.nextText()");
                switchNode.setLockShell(strNextText);
                break;
            case 102230:
                if (!name.equals("get")) {
                }
                String strNextText2 = xmlPullParser.nextText();
                f92.c(strNextText2, "parser.nextText()");
                switchNode.setGetState(strNextText2);
                break;
            case 113762:
                if (!name.equals("set")) {
                }
                switchNode.setSetState(xmlPullParser.nextText());
                break;
            case 3079825:
                if (name.equals("desc")) {
                    c(switchNode, xmlPullParser);
                }
                break;
            case 3327275:
                if (!name.equals("lock")) {
                }
                String strNextText3 = xmlPullParser.nextText();
                f92.c(strNextText3, "parser.nextText()");
                switchNode.setLockShell(strNextText3);
                break;
            case 110371416:
                if (name.equals("title")) {
                    String strNextText4 = xmlPullParser.nextText();
                    f92.c(strNextText4, "parser.nextText()");
                    switchNode.setTitle(strNextText4);
                }
                break;
            case 1434023279:
                if (!name.equals("setstate")) {
                }
                switchNode.setSetState(xmlPullParser.nextText());
                break;
            case 1995135739:
                if (!name.equals("getstate")) {
                }
                String strNextText22 = xmlPullParser.nextText();
                f92.c(strNextText22, "parser.nextText()");
                switchNode.setGetState(strNextText22);
                break;
        }
    }

    public final void x(TextNode textNode, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (f92.a("title", xmlPullParser.getName())) {
            String strNextText = xmlPullParser.nextText();
            f92.c(strNextText, "parser.nextText()");
            textNode.setTitle(strNextText);
        } else {
            if (f92.a("desc", xmlPullParser.getName())) {
                c(textNode, xmlPullParser);
                return;
            }
            if (f92.a("summary", xmlPullParser.getName())) {
                n(textNode, xmlPullParser);
            } else if (f92.a("slice", xmlPullParser.getName())) {
                l(textNode, xmlPullParser);
            } else if (f92.a("resource", xmlPullParser.getName())) {
                k(xmlPullParser);
            }
        }
    }
}
