package com.omarea.vtools.activities;

import a.bb2;
import a.bc2;
import a.c90;
import a.d52;
import a.e50;
import a.ec2;
import a.f92;
import a.g91;
import a.hk0;
import a.i52;
import a.l90;
import a.n30;
import a.nb2;
import a.o72;
import a.p80;
import a.s61;
import a.t61;
import a.u42;
import a.u61;
import a.y42;
import a.y60;
import a.z42;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityMiuiThermal extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5347a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8750a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5346a = "";
    public boolean b = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hk0 f5345a = new hk0();

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8751a;

        public a(p80.b bVar) {
            this.f8751a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8751a.c();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8752a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ View f5348a;

        public b(View view, p80.b bVar) {
            this.f5348a = view;
            this.f8752a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            View viewFindViewById = this.f5348a.findViewById(t61.save_thermal);
            f92.c(viewFindViewById, "view.findViewById<Compou…utton>(R.id.save_thermal)");
            boolean zIsChecked = ((CompoundButton) viewFindViewById).isChecked();
            this.f8752a.c();
            ActivityMiuiThermal.this.l(zIsChecked);
        }
    }

    public static final class c implements c90 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5350a;

        public c(ArrayList arrayList) {
            this.f5350a = arrayList;
        }

        @Override // a.c90
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            if (!list.isEmpty()) {
                ArrayList arrayList = this.f5350a;
                String strE = ((n30) i52.A(list)).e();
                f92.b(strE);
                CharSequence charSequence = (CharSequence) arrayList.get(Integer.parseInt(strE));
                Intent intent = new Intent(ActivityMiuiThermal.this, (Class<?>) ActivityFileSelector.class);
                intent.putExtra("extension", "conf");
                intent.putExtra("start", charSequence);
                ActivityMiuiThermal activityMiuiThermal = ActivityMiuiThermal.this;
                activityMiuiThermal.startActivityForResult(intent, activityMiuiThermal.f8750a);
            }
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5347a == null) {
            this.f5347a = new HashMap();
        }
        View view = (View) this.f5347a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5347a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(boolean r8) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityMiuiThermal.l(boolean):void");
    }

    public final String m() {
        EditText editText = (EditText) _$_findCachedViewById(t61.thermal_config);
        f92.c(editText, "thermal_config");
        String string = editText.getText().toString();
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return new nb2("\r\t").g(new nb2("\r\n").g(ec2.r0(string).toString(), "\n"), "\t");
    }

    public final byte[] n() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strM = m();
        Charset charset = bb2.f5692a;
        if (strM == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strM.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        if (this.b) {
            bytes = this.f5345a.c(bytes);
        }
        f92.c(bytes, "data");
        return bytes;
    }

    public final void o() {
        Context applicationContext = getApplicationContext();
        f92.c(applicationContext, "applicationContext");
        CharSequence[] textArray = applicationContext.getResources().getTextArray(s61.config_start_dir_options);
        f92.c(textArray, "applicationContext.resou…config_start_dir_options)");
        ArrayList arrayList = new ArrayList(u42.I(textArray));
        if (!f92.a(e50.f677a.y0(), "root")) {
            d52.q(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            String string = null;
            if (i < 0) {
                y42.l();
                throw null;
            }
            CharSequence charSequence = (CharSequence) obj;
            n30 n30Var = new n30();
            if (charSequence != null) {
                string = charSequence.toString();
            }
            n30Var.i(string);
            n30Var.j(String.valueOf(i));
            arrayList2.add(n30Var);
            i = i2;
        }
        l90 l90Var = new l90(this, arrayList2, y42.e(), false);
        String string2 = getString(u61.miu_thermal_dirs);
        f92.c(string2, "getString(R.string.miu_thermal_dirs)");
        l90Var.m(string2);
        l90Var.k(new c(arrayList));
        l90Var.o();
    }

    @Override // a.cl, android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != this.f8750a || intent == null || intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        f92.b(extras);
        String string = extras.getString("file");
        f92.b(string);
        if (bc2.x(string, "thermal", false, 2, null)) {
            Toast.makeText(this, getString(u61.miui_thermal_invalid), 1).show();
            return;
        }
        this.f5346a = string;
        setTitle(string);
        try {
            q();
            this.b = true;
        } catch (Exception unused) {
            ((EditText) _$_findCachedViewById(t61.thermal_config)).setText(bc2.x(this.f5346a, "/data", false, 2, null) ? y60.f7952a.i(this.f5346a) : ec2.r0(new String(o72.b(new File(this.f5346a)), bb2.f5692a)).toString());
            this.b = false;
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558456);
        setBackArrow();
        onViewCreated();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623941, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Toast toastMakeText;
        f92.d(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361923) {
            o();
            return true;
        }
        if (itemId == 2131361930) {
            if (!f92.a(e50.f677a.y0(), "basic")) {
                if (this.f5346a.length() > 0) {
                    r();
                    return true;
                }
            }
        } else {
            if (itemId != 2131361895) {
                if (itemId != 2131361912) {
                    return super.onOptionsItemSelected(menuItem);
                }
                p("https://github.com/helloklf/vtools/blob/scene3/docs/MIUI%E6%B8%A9%E6%8E%A7%E8%AF%B4%E6%98%8E.md");
                return true;
            }
            if (f92.a(e50.f677a.y0(), "basic")) {
                toastMakeText = Toast.makeText(getContext(), getString(u61.miui_thermal_readonly), 0);
                toastMakeText.show();
                return true;
            }
            if (this.f5346a.length() > 0) {
                View viewInflate = getLayoutInflater().inflate(2131558508, (ViewGroup) null);
                p80.a aVar = p80.f2403a;
                f92.c(viewInflate, "view");
                p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
                viewInflate.findViewById(2131362069).setOnClickListener(new a(bVarT));
                viewInflate.findViewById(t61.btn_apply).setOnClickListener(new b(viewInflate, bVarT));
                return true;
            }
        }
        toastMakeText = Toast.makeText(this, getString(u61.miui_thermal_dis_save), 0);
        toastMakeText.show();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu != null ? menu.findItem(2131361930) : null;
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(new File(this.f5346a).canWrite());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_miui_thermal));
    }

    public final void onViewCreated() {
    }

    public final void p(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final void q() {
        byte[] bArrB;
        File file = new File(this.f5346a);
        if (bc2.x(this.f5346a, "/data", false, 2, null)) {
            y60 y60Var = y60.f7952a;
            String absolutePath = file.getAbsolutePath();
            f92.c(absolutePath, "file.absolutePath");
            bArrB = y60Var.j(absolutePath);
        } else {
            bArrB = o72.b(file);
        }
        byte[] bArrA = this.f5345a.a(bArrB);
        EditText editText = (EditText) _$_findCachedViewById(t61.thermal_config);
        f92.c(bArrA, "output");
        editText.setText(new String(bArrA, bb2.f5692a));
        setTitle(file.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0073  */
    @android.annotation.SuppressLint({"RestrictedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r5 = this;
            byte[] r0 = r5.n()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r5.getFilesDir()
            java.lang.String r3 = "filesDir"
            a.f92.c(r2, r3)
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "miui-thermal.tmp"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            a.o72.e(r2, r0)
            a.s60 r0 = a.s60.f7366a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "cp '"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r3 = "' '"
            r2.append(r3)
            java.lang.String r3 = r5.f5346a
            r2.append(r3)
            java.lang.String r3 = "'\nchmod 664 '"
            r2.append(r3)
            java.lang.String r3 = r5.f5346a
            r2.append(r3)
            r3 = 39
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.a(r2)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            r2.delete()
            java.lang.String r1 = "error"
            boolean r0 = a.f92.a(r0, r1)
            r1 = 2131887180(0x7f12044c, float:1.940896E38)
            r2 = 1
            if (r0 == 0) goto L7f
        L73:
            java.lang.String r0 = r5.getString(r1)
        L77:
            android.widget.Toast r0 = android.widget.Toast.makeText(r5, r0, r2)
            r0.show()
            goto La6
        L7f:
            a.y60 r0 = a.y60.f7952a
            java.lang.String r3 = r5.f5346a
            byte[] r0 = r0.j(r3)
            a.hk0 r3 = r5.f5345a
            byte[] r0 = r3.a(r0)
            java.lang.String r3 = "output"
            a.f92.c(r0, r3)
            java.nio.charset.Charset r3 = a.bb2.f5692a
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0, r3)
            java.lang.String r0 = r5.m()
            boolean r0 = a.f92.a(r4, r0)
            if (r0 == 0) goto L73
            java.lang.String r0 = "OK"
            goto L77
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityMiuiThermal.r():void");
    }
}
