package com.omarea.vtools.activities;

import a.c60;
import a.f92;
import a.g91;
import a.m42;
import a.nb2;
import a.o72;
import a.p80;
import a.se0;
import a.t61;
import a.u61;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.omarea.krscript.model.RunnableNode;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityCustomCommand extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8637a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8638a = new a();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8639a = new b();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCustomCommand.this.l();
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCustomCommand activityCustomCommand;
            int i;
            EditText editText = (EditText) ActivityCustomCommand.this._$_findCachedViewById(t61.command_title);
            f92.c(editText, "command_title");
            Editable text = editText.getText();
            String string = text != null ? text.toString() : null;
            EditText editText2 = (EditText) ActivityCustomCommand.this._$_findCachedViewById(t61.command_script);
            f92.c(editText2, "command_script");
            Editable text2 = editText2.getText();
            String string2 = text2 != null ? text2.toString() : null;
            boolean z = true;
            if (string == null || string.length() == 0) {
                activityCustomCommand = ActivityCustomCommand.this;
                i = u61.task_command_name_empty;
            } else {
                if (string2 != null && string2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    ActivityCustomCommand.n(ActivityCustomCommand.this, string, string2, false, 4, null);
                    return;
                } else {
                    activityCustomCommand = ActivityCustomCommand.this;
                    i = u61.task_command_content_empty;
                }
            }
            Toast.makeText(activityCustomCommand, activityCustomCommand.getString(i), 0).show();
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5241a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.f5241a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityCustomCommand.this.m(this.f5241a, this.b, true);
        }
    }

    public static /* synthetic */ void n(ActivityCustomCommand activityCustomCommand, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        activityCustomCommand.m(str, str2, z);
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8637a == null) {
            this.f8637a = new HashMap();
        }
        View view = (View) this.f8637a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8637a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void l() {
        EditText editText = (EditText) _$_findCachedViewById(t61.command_title);
        f92.c(editText, "command_title");
        Editable text = editText.getText();
        String string = text != null ? text.toString() : null;
        EditText editText2 = (EditText) _$_findCachedViewById(t61.command_script);
        f92.c(editText2, "command_script");
        Editable text2 = editText2.getText();
        String string2 = text2 != null ? text2.toString() : null;
        RunnableNode runnableNode = new RunnableNode("");
        runnableNode.setTitle("TEST-EXECUTOR");
        runnableNode.setDesc("COMMAND >> " + string);
        se0 se0VarA = se0.f7388a.a(runnableNode, a.f8638a, b.f8639a, String.valueOf(string2), null, false);
        se0VarA.B1(getSupportFragmentManager(), "");
        se0VarA.z1(false);
    }

    public final void m(String str, String str2, boolean z) {
        int i;
        String strG = new nb2("\r\t").g(new nb2("\r\n").g(str2, "\n"), "\t");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
        if (strG == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strG.getBytes(charsetDefaultCharset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        String str3 = "custom-command/" + URLEncoder.encode(str) + ".sh";
        String strD = c60.f5764a.d(getContext(), str3);
        if (!new File(strD).exists() || z) {
            if (c60.f5764a.l(bytes, str3, this)) {
                Intent intent = new Intent();
                intent.putExtra("path", strD);
                m42 m42Var = m42.f6769a;
                setResult(-1, intent);
                finish();
                i = u61.task_command_save_ok;
            } else {
                i = u61.task_command_save_fail;
            }
            Toast.makeText(this, getString(i), 0).show();
            return;
        }
        File file = new File(strD);
        Charset charsetDefaultCharset2 = Charset.defaultCharset();
        f92.c(charsetDefaultCharset2, "Charset.defaultCharset()");
        String strD2 = o72.d(file, charsetDefaultCharset2);
        p80.a aVar = p80.f2403a;
        String string = getString(u61.task_command_name_replace);
        f92.c(string, "getString(R.string.task_command_name_replace)");
        aVar.o(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : getString(u61.task_command_name_exist) + "\n" + strD2, (16 & 8) != 0 ? null : new e(str, str2), (16 & 16) != 0 ? null : null);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558446);
        setBackArrow();
        ((Button) _$_findCachedViewById(t61.btn_run)).setOnClickListener(new c());
        ((Button) _$_findCachedViewById(t61.btn_confirm)).setOnClickListener(new d());
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_custom_command));
    }
}
