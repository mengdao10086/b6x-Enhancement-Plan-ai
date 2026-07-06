package a;

import a.p80;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g91 f6118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EditText f911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f912a;
    public EditText b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f913b;
    public EditText c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f914c;
    public EditText d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final String f915d;
    public EditText e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final String f916e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    public fl1(g91 g91Var) {
        f92.d(g91Var, "context");
        this.f6118a = g91Var;
        this.f912a = "persist.vtools.device.backuped";
        this.f913b = "persist.vtools.brand";
        this.f914c = "persist.vtools.model";
        this.f915d = "persist.vtools.product";
        this.f916e = "persist.vtools.device";
        this.f = "persist.vtools.manufacturer";
        this.g = "ro.product.brand";
        this.h = "ro.product.name";
        this.i = "ro.product.model";
        this.j = "ro.product.manufacturer";
        this.k = "ro.product.device";
    }

    public static final /* synthetic */ EditText d(fl1 fl1Var) {
        EditText editText = fl1Var.b;
        if (editText != null) {
            return editText;
        }
        f92.m("editBrand");
        throw null;
    }

    public static final /* synthetic */ EditText e(fl1 fl1Var) {
        EditText editText = fl1Var.d;
        if (editText != null) {
            return editText;
        }
        f92.m("editDevice");
        throw null;
    }

    public static final /* synthetic */ EditText f(fl1 fl1Var) {
        EditText editText = fl1Var.e;
        if (editText != null) {
            return editText;
        }
        f92.m("editManufacturer");
        throw null;
    }

    public static final /* synthetic */ EditText g(fl1 fl1Var) {
        EditText editText = fl1Var.f911a;
        if (editText != null) {
            return editText;
        }
        f92.m("editModel");
        throw null;
    }

    public static final /* synthetic */ EditText h(fl1 fl1Var) {
        EditText editText = fl1Var.c;
        if (editText != null) {
            return editText;
        }
        f92.m("editProductName");
        throw null;
    }

    @SuppressLint({"ApplySharedPref"})
    public final void o() {
        if (!f92.a(p(this.f912a, "false"), "true")) {
            um0 um0Var = um0.f7612a;
            String str = this.f913b;
            String str2 = Build.BRAND;
            f92.c(str2, "Build.BRAND");
            um0Var.b(str, str2);
            um0 um0Var2 = um0.f7612a;
            String str3 = this.f914c;
            String str4 = Build.MODEL;
            f92.c(str4, "Build.MODEL");
            um0Var2.b(str3, str4);
            um0 um0Var3 = um0.f7612a;
            String str5 = this.f915d;
            String str6 = Build.PRODUCT;
            f92.c(str6, "Build.PRODUCT");
            um0Var3.b(str5, str6);
            um0 um0Var4 = um0.f7612a;
            String str7 = this.f916e;
            String str8 = Build.DEVICE;
            f92.c(str8, "Build.DEVICE");
            um0Var4.b(str7, str8);
            um0 um0Var5 = um0.f7612a;
            String str9 = this.f;
            String str10 = Build.MANUFACTURER;
            f92.c(str10, "Build.MANUFACTURER");
            um0Var5.b(str9, str10);
            um0.f7612a.b(this.f912a, "true");
        }
    }

    public final String p(String str, String str2) {
        String strA = um0.f7612a.a(str);
        return (f92.a(strA, "null") || f92.a(strA, "")) ? str2 : strA;
    }

    public final g91 q() {
        return this.f6118a;
    }

    public final void r() {
        if (!f92.a(p(this.f912a, "false"), "true")) {
            return;
        }
        EditText editText = this.b;
        if (editText == null) {
            f92.m("editBrand");
            throw null;
        }
        editText.setText(Build.BRAND);
        EditText editText2 = this.f911a;
        if (editText2 == null) {
            f92.m("editModel");
            throw null;
        }
        editText2.setText(Build.MODEL);
        EditText editText3 = this.c;
        if (editText3 == null) {
            f92.m("editProductName");
            throw null;
        }
        editText3.setText(Build.PRODUCT);
        EditText editText4 = this.d;
        if (editText4 == null) {
            f92.m("editDevice");
            throw null;
        }
        editText4.setText(Build.DEVICE);
        EditText editText5 = this.e;
        if (editText5 != null) {
            editText5.setText(Build.MANUFACTURER);
        } else {
            f92.m("editManufacturer");
            throw null;
        }
    }

    public final void s() {
        View viewInflate = LayoutInflater.from(this.f6118a).inflate(2131558491, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(t61.dialog_addin_model);
        f92.b(viewFindViewById);
        this.f911a = (EditText) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(t61.dialog_addin_brand);
        f92.b(viewFindViewById2);
        this.b = (EditText) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(t61.dialog_addin_name);
        f92.b(viewFindViewById3);
        this.c = (EditText) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(t61.dialog_addin_device);
        f92.b(viewFindViewById4);
        this.d = (EditText) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(t61.dialog_addin_manufacturer);
        f92.b(viewFindViewById5);
        this.e = (EditText) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(t61.dialog_addin_default);
        f92.b(viewFindViewById6);
        ((Button) viewFindViewById6).setOnClickListener(new zk1(this));
        View viewFindViewById7 = viewInflate.findViewById(t61.dialog_chooser);
        f92.b(viewFindViewById7);
        ((Button) viewFindViewById7).setOnClickListener(new al1(this));
        ((Button) viewInflate.findViewById(t61.dialog_help)).setOnClickListener(new bl1(this));
        p80.a aVar = p80.f2403a;
        g91 g91Var = this.f6118a;
        String string = g91Var.getString(u61.btn_save);
        f92.c(string, "context.getString(R.string.btn_save)");
        aVar.f(g91Var, (32 & 2) != 0 ? "" : "", (32 & 4) == 0 ? "" : "", (32 & 8) != 0 ? null : viewInflate, (32 & 16) != 0 ? null : new q80(string, new cl1(this), false, 4, null), (32 & 32) == 0 ? null : null);
        r();
        try {
            Object systemService = this.f6118a.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
            ClipData.Item itemAt = primaryClip != null ? primaryClip.getItemAt(0) : null;
            CharSequence text = itemAt != null ? itemAt.getText() : null;
            if (text == null || text.length() == 0) {
                return;
            }
            String string2 = text.toString();
            if (string2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            byte[] bArrDecode = Base64.decode(ec2.r0(string2).toString(), 0);
            f92.c(bArrDecode, "Base64.decode(content.to…).trim(), Base64.DEFAULT)");
            String str = new String(bArrDecode, bb2.f5692a);
            if (new nb2("^.*@.*@.*@.*@.*$").f(str)) {
                p80.a aVar2 = p80.f2403a;
                g91 g91Var2 = this.f6118a;
                String string3 = this.f6118a.getString(u61.dialog_addin_device_template);
                f92.c(string3, "context.getString(R.stri…og_addin_device_template)");
                String string4 = this.f6118a.getString(u61.dialog_addin_device_detection);
                f92.c(string4, "context.getString(R.stri…g_addin_device_detection)");
                aVar2.i(g91Var2, (16 & 2) != 0 ? "" : string3, (16 & 4) != 0 ? "" : string4, (16 & 8) != 0 ? null : new dl1(this, str), (16 & 16) != 0 ? null : null);
            }
        } catch (Exception unused) {
        }
    }

    public final void t() {
        EditText editText;
        String strP;
        if (!f92.a(p(this.f912a, "false"), "true")) {
            EditText editText2 = this.b;
            if (editText2 == null) {
                f92.m("editBrand");
                throw null;
            }
            editText2.setText(Build.BRAND);
            EditText editText3 = this.f911a;
            if (editText3 == null) {
                f92.m("editModel");
                throw null;
            }
            editText3.setText(Build.MODEL);
            EditText editText4 = this.c;
            if (editText4 == null) {
                f92.m("editProductName");
                throw null;
            }
            editText4.setText(Build.PRODUCT);
            EditText editText5 = this.d;
            if (editText5 == null) {
                f92.m("editDevice");
                throw null;
            }
            editText5.setText(Build.DEVICE);
            editText = this.e;
            if (editText == null) {
                f92.m("editManufacturer");
                throw null;
            }
            strP = Build.MANUFACTURER;
        } else {
            EditText editText6 = this.b;
            if (editText6 == null) {
                f92.m("editBrand");
                throw null;
            }
            String str = this.f913b;
            String str2 = Build.BRAND;
            f92.c(str2, "Build.BRAND");
            editText6.setText(p(str, str2));
            EditText editText7 = this.f911a;
            if (editText7 == null) {
                f92.m("editModel");
                throw null;
            }
            String str3 = this.f914c;
            String str4 = Build.MODEL;
            f92.c(str4, "Build.MODEL");
            editText7.setText(p(str3, str4));
            EditText editText8 = this.c;
            if (editText8 == null) {
                f92.m("editProductName");
                throw null;
            }
            String str5 = this.f915d;
            String str6 = Build.PRODUCT;
            f92.c(str6, "Build.PRODUCT");
            editText8.setText(p(str5, str6));
            EditText editText9 = this.d;
            if (editText9 == null) {
                f92.m("editDevice");
                throw null;
            }
            String str7 = this.f916e;
            String str8 = Build.DEVICE;
            f92.c(str8, "Build.DEVICE");
            editText9.setText(p(str7, str8));
            editText = this.e;
            if (editText == null) {
                f92.m("editManufacturer");
                throw null;
            }
            String str9 = this.f;
            String str10 = Build.MANUFACTURER;
            f92.c(str10, "Build.MANUFACTURER");
            strP = p(str9, str10);
        }
        editText.setText(strP);
    }

    public final void u(String str) {
        if (new nb2("^.*@.*@.*@.*@.*$").f(str)) {
            List listD0 = ec2.d0(str, new String[]{"@"}, false, 0, 6, null);
            EditText editText = this.f911a;
            if (editText == null) {
                f92.m("editModel");
                throw null;
            }
            editText.setText((CharSequence) listD0.get(0));
            EditText editText2 = this.b;
            if (editText2 == null) {
                f92.m("editBrand");
                throw null;
            }
            editText2.setText((CharSequence) listD0.get(1));
            EditText editText3 = this.e;
            if (editText3 == null) {
                f92.m("editManufacturer");
                throw null;
            }
            editText3.setText((CharSequence) listD0.get(2));
            EditText editText4 = this.c;
            if (editText4 == null) {
                f92.m("editProductName");
                throw null;
            }
            editText4.setText((CharSequence) listD0.get(3));
            EditText editText5 = this.d;
            if (editText5 != null) {
                editText5.setText((CharSequence) listD0.get(4));
            } else {
                f92.m("editDevice");
                throw null;
            }
        }
    }

    public final void v() {
        String[] stringArray = this.f6118a.getResources().getStringArray(s61.config_device_templates);
        f92.c(stringArray, "context.resources.getStr….config_device_templates)");
        ArrayList arrayList = new ArrayList(stringArray.length);
        for (String str : stringArray) {
            n30 n30Var = new n30();
            n30Var.i(str);
            arrayList.add(n30Var);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        String[] stringArray2 = this.f6118a.getResources().getStringArray(s61.config_device_templates_data);
        f92.c(stringArray2, "context.resources.getStr…ig_device_templates_data)");
        new b90(this.f6118a.getThemeMode().a(), arrayList2, false, new el1(this, arrayList2, stringArray2), 0, 16, null).B1(this.f6118a.getSupportFragmentManager(), "device-template-chooser");
    }
}
