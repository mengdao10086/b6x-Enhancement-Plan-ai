package com.omarea.sysmbol;

import a.a42;
import a.b62;
import a.d70;
import a.d72;
import a.d80;
import a.ec2;
import a.f92;
import a.g92;
import a.h42;
import a.i52;
import a.k82;
import a.kh0;
import a.la2;
import a.m42;
import a.mz0;
import a.nz0;
import a.pz0;
import a.q21;
import a.qc2;
import a.qe2;
import a.qi0;
import a.qz0;
import a.r62;
import a.rh0;
import a.rx0;
import a.t61;
import a.v0;
import a.v72;
import a.wd2;
import a.x60;
import a.x62;
import a.xd2;
import a.y42;
import a.y60;
import a.z32;
import a.z42;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class PerfOptionsRender extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rx0 f8361a;

    public interface a {
        String a(String str);

        String b(String str);
    }

    @x62(c = "com.omarea.sysmbol.PerfOptionsRender$appsItemRender$1", f = "PerfOptionsRender.kt", l = {}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8362a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f4809a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Runnable runnable, b62 b62Var) {
            super(2, b62Var);
            this.f4809a = runnable;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = new b(this.f4809a, b62Var);
            bVar.f8362a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            this.f4809a.run();
            return m42.f6769a;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ la2 f8363a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ rh0 f4810a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ z32 f4811a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f4813a;

        public c(rh0 rh0Var, z32 z32Var, la2 la2Var, Runnable runnable) {
            this.f4810a = rh0Var;
            this.f4811a = z32Var;
            this.f8363a = la2Var;
            this.f4813a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List list = (List) this.f4810a.getValue();
            ArrayList arrayList = new ArrayList();
            for (AppInfo appInfo : (ArrayList) this.f4811a.getValue()) {
                d70.a aVar = new d70.a();
                aVar.setAppName(appInfo.getAppName());
                aVar.setPackageName(appInfo.getPackageName());
                aVar.setSelected(list.contains(appInfo.getPackageName()));
                arrayList.add(aVar);
            }
            d80 d80Var = new d80(false, arrayList, true, new mz0(this));
            Context context = PerfOptionsRender.this.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
            d80Var.B1(((v0) context).getSupportFragmentManager(), "perf-apps");
        }
    }

    public static final class d extends g92 implements v72<ArrayList<AppInfo>> {
        public d() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ArrayList<AppInfo> i() {
            Context context = PerfOptionsRender.this.getContext();
            f92.c(context, "context");
            return new kh0(context, false).h(null, true);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ la2 f8365a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ rh0 f4814a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ z32 f4815a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TextView f4816a;

        public e(rh0 rh0Var, z32 z32Var, la2 la2Var, TextView textView) {
            this.f4814a = rh0Var;
            this.f4815a = z32Var;
            this.f8365a = la2Var;
            this.f4816a = textView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object next;
            String appName;
            Iterable<String> iterable = (Iterable) this.f4814a.getValue();
            ArrayList arrayList = new ArrayList(z42.m(iterable, 10));
            for (String str : iterable) {
                Iterator it = ((Iterable) this.f4815a.getValue()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (f92.a(((AppInfo) next).getPackageName(), str)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                AppInfo appInfo = (AppInfo) next;
                if (appInfo != null && (appName = appInfo.getAppName()) != null) {
                    str = appName;
                }
                arrayList.add(str);
            }
            this.f4816a.post(new nz0(this, i52.H(arrayList, "，", null, null, 0, null, null, 62, null)));
        }
    }

    public static final class f implements rh0<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8366a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f4817a;

        public f(a aVar, pz0 pz0Var) {
            this.f4817a = aVar;
            this.f8366a = pz0Var;
        }

        @Override // a.rh0
        public /* bridge */ /* synthetic */ void a(Integer num) {
            c(num.intValue());
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getValue() {
            String strA = this.f4817a.a(PerfOptionsRender.this.g(this.f8366a));
            f92.b(strA);
            return Integer.valueOf(Integer.parseInt(strA));
        }

        public void c(int i) {
            PerfOptionsRender perfOptionsRender = PerfOptionsRender.this;
            String str = this.f8366a.f2488c;
            f92.c(str, "item.path");
            String strB = this.f4817a.b(String.valueOf(i));
            f92.b(strB);
            perfOptionsRender.o(str, strB);
        }
    }

    public static final class g implements rh0<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8367a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f4819a;

        public g(a aVar, pz0 pz0Var) {
            this.f4819a = aVar;
            this.f8367a = pz0Var;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double getValue() {
            String strA = this.f4819a.a(PerfOptionsRender.this.g(this.f8367a));
            f92.b(strA);
            return Double.valueOf(Double.parseDouble(strA));
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Double d) {
            PerfOptionsRender perfOptionsRender = PerfOptionsRender.this;
            String str = this.f8367a.f2488c;
            f92.c(str, "item.path");
            String strB = this.f4819a.b("" + d);
            f92.b(strB);
            perfOptionsRender.o(str, strB);
        }
    }

    public static final class h implements rh0<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8368a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f4821a;

        public h(pz0 pz0Var, a aVar) {
            this.f8368a = pz0Var;
            this.f4821a = aVar;
        }

        @Override // a.rh0
        public /* bridge */ /* synthetic */ void a(Boolean bool) {
            c(bool.booleanValue());
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean getValue() {
            return Boolean.valueOf(f92.a(this.f4821a.a(PerfOptionsRender.this.g(this.f8368a)), this.f8368a.g));
        }

        public void c(boolean z) {
            PerfOptionsRender perfOptionsRender = PerfOptionsRender.this;
            String str = this.f8368a.f2488c;
            f92.c(str, "item.path");
            String strB = this.f4821a.b(z ? this.f8368a.g : this.f8368a.h);
            f92.b(strB);
            perfOptionsRender.o(str, strB);
        }
    }

    public static final class i implements rh0<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8369a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f4823a;

        public i(pz0 pz0Var, a aVar) {
            this.f8369a = pz0Var;
            this.f4823a = aVar;
        }

        @Override // a.rh0
        public /* bridge */ /* synthetic */ void a(Integer num) {
            c(num.intValue());
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getValue() {
            String strG = PerfOptionsRender.this.g(this.f8369a);
            int i = 0;
            for (qz0 qz0Var : this.f8369a.f2486a) {
                if (f92.a(qz0Var.b, strG)) {
                    return Integer.valueOf(i);
                }
                i++;
            }
            return -1;
        }

        public void c(int i) {
            if (i > -1) {
                pz0 pz0Var = this.f8369a;
                String str = pz0Var.f2486a[i].b;
                PerfOptionsRender perfOptionsRender = PerfOptionsRender.this;
                String str2 = pz0Var.f2488c;
                f92.c(str2, "item.path");
                String strB = this.f4823a.b(str);
                f92.b(strB);
                perfOptionsRender.o(str2, strB);
            }
        }
    }

    public static final class j implements rh0<List<? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8370a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f4825a;

        public j(a aVar, pz0 pz0Var) {
            this.f4825a = aVar;
            this.f8370a = pz0Var;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<String> getValue() {
            List listD0;
            List<String> listY;
            String strA = this.f4825a.a(PerfOptionsRender.this.g(this.f8370a));
            return (strA == null || (listD0 = ec2.d0(strA, new String[]{","}, false, 0, 6, null)) == null || (listY = i52.Y(listD0)) == null) ? y42.e() : listY;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(List<String> list) {
            f92.d(list, "value");
            PerfOptionsRender perfOptionsRender = PerfOptionsRender.this;
            String str = this.f8370a.f2488c;
            f92.c(str, "item.path");
            String strB = this.f4825a.b(i52.H(list, ",", null, null, 0, null, null, 62, null));
            f92.b(strB);
            perfOptionsRender.o(str, strB);
        }
    }

    public static final class k implements rh0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8371a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f4827a;

        public k(a aVar, pz0 pz0Var) {
            this.f4827a = aVar;
            this.f8371a = pz0Var;
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getValue() {
            return this.f4827a.a(PerfOptionsRender.this.g(this.f8371a));
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            PerfOptionsRender perfOptionsRender = PerfOptionsRender.this;
            String str2 = this.f8371a.f2488c;
            f92.c(str2, "item.path");
            String strB = this.f4827a.b(str);
            f92.b(strB);
            perfOptionsRender.o(str2, strB);
        }
    }

    public static final class l implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pz0 f8372a;

        public l(pz0 pz0Var) {
            this.f8372a = pz0Var;
        }

        @Override // com.omarea.sysmbol.PerfOptionsRender.a
        public String a(String str) {
            HashMap<String, String> map = this.f8372a.f2485a;
            return (map == null || !map.containsKey(str)) ? str : this.f8372a.f2485a.get(str);
        }

        @Override // com.omarea.sysmbol.PerfOptionsRender.a
        public String b(String str) {
            HashMap<String, String> map = this.f8372a.f2485a;
            if (map == null || !map.containsValue(str)) {
                return str;
            }
            for (Map.Entry<String, String> entry : this.f8372a.f2485a.entrySet()) {
                if (f92.a(entry.getValue(), str)) {
                    return entry.getKey();
                }
            }
            return str;
        }
    }

    public PerfOptionsRender(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m(context, attributeSet);
    }

    public final View c(pz0 pz0Var) {
        View viewI = i(2131558606);
        TextView textView = (TextView) viewI.findViewById(2131361824);
        TextView textView2 = (TextView) viewI.findViewById(t61.ItemApps);
        TextView textView3 = (TextView) viewI.findViewById(2131361806);
        f92.c(textView, "itemTitle");
        textView.setText(pz0Var.f2484a);
        rh0<?> rh0VarF = f(pz0Var);
        if (rh0VarF == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.basic.FormValueHandler.InputHandler<kotlin.collections.List<kotlin.String>>");
        }
        f92.c(textView3, "itemDesc");
        p(textView3, pz0Var.f2487b);
        z32 z32VarA = a42.a(new d());
        e eVar = new e(rh0VarF, z32VarA, null, textView2);
        qc2.d(xd2.a(qe2.a()), null, null, new b(eVar, null), 3, null);
        textView2.setOnClickListener(new c(rh0VarF, z32VarA, null, eVar));
        return viewI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View d(pz0 pz0Var) {
        View viewI = i(2131558607);
        TextView textView = (TextView) viewI.findViewById(2131361824);
        CompoundButton compoundButton = (CompoundButton) viewI.findViewById(t61.ItemSwitch);
        TextView textView2 = (TextView) viewI.findViewById(2131361806);
        textView.setText(pz0Var.f2484a);
        qi0 qi0Var = new qi0(null, 1, null);
        f92.c(compoundButton, "itemSwitch");
        rh0<?> rh0VarF = f(pz0Var);
        if (rh0VarF == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.basic.FormValueHandler.InputHandler<kotlin.Boolean>");
        }
        qi0Var.e(compoundButton, rh0VarF);
        f92.c(textView2, "itemDesc");
        p(textView2, pz0Var.f2487b);
        return viewI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View e(pz0 pz0Var) {
        View viewI = i(2131558608);
        TextView textView = (TextView) viewI.findViewById(2131361824);
        EditText editText = (EditText) viewI.findViewById(t61.ItemEditText);
        TextView textView2 = (TextView) viewI.findViewById(2131361806);
        textView.setText(pz0Var.f2484a);
        qi0 qi0Var = new qi0(null, 1, null);
        f92.c(editText, "itemEditText");
        rh0<?> rh0VarF = f(pz0Var);
        if (rh0VarF == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.basic.FormValueHandler.InputHandler<kotlin.Double>");
        }
        qi0Var.i(editText, rh0VarF);
        f92.c(textView2, "itemDesc");
        p(textView2, pz0Var.f2487b);
        editText.setHint(pz0Var.e);
        return viewI;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final rh0<?> f(pz0 pz0Var) {
        a aVarH = h(pz0Var);
        String str = pz0Var.f;
        if (str != null) {
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        return new f(aVarH, pz0Var);
                    }
                    break;
                case -906021636:
                    if (str.equals("select")) {
                        return new i(pz0Var, aVarH);
                    }
                    break;
                case 3000946:
                    if (str.equals("apps")) {
                        return new j(aVarH, pz0Var);
                    }
                    break;
                case 64711720:
                    if (str.equals("boolean")) {
                        return new h(pz0Var, aVarH);
                    }
                    break;
                case 1542263633:
                    if (str.equals("decimal")) {
                        return new g(aVarH, pz0Var);
                    }
                    break;
            }
        }
        return new k(aVarH, pz0Var);
    }

    public final String g(pz0 pz0Var) {
        rx0 rx0Var = this.f8361a;
        if (rx0Var != null) {
            f92.b(rx0Var);
            return rx0Var.d(pz0Var.f2488c, pz0Var.d);
        }
        x60 x60Var = x60.f7856a;
        String str = pz0Var.f2488c;
        f92.c(str, "item.path");
        String strD = x60Var.d(str);
        if (strD.length() == 0) {
            y60 y60Var = y60.f7952a;
            String str2 = pz0Var.f2488c;
            f92.c(str2, "item.path");
            if (!y60Var.d(str2)) {
                return pz0Var.d;
            }
        }
        return strD;
    }

    public final a h(pz0 pz0Var) {
        return new l(pz0Var);
    }

    public final View i(int i2) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null, false);
        f92.c(viewInflate, "LayoutInflater.from(this…te(layoutId, null, false)");
        return viewInflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View j(pz0 pz0Var) {
        double d2;
        View viewI = i(2131558611);
        TextView textView = (TextView) viewI.findViewById(2131361824);
        SeekBar seekBar = (SeekBar) viewI.findViewById(t61.ItemSeekBar);
        TextView textView2 = (TextView) viewI.findViewById(2131361806);
        TextView textView3 = (TextView) viewI.findViewById(t61.ItemValue);
        textView.setText(pz0Var.f2484a);
        double d3 = pz0Var.c;
        if (d3 == 0.0d) {
            seekBar.setMax((int) pz0Var.b);
            if (Build.VERSION.SDK_INT >= 26) {
                d2 = pz0Var.f7161a;
                seekBar.setMin((int) d2);
            }
        } else {
            seekBar.setMax((int) (pz0Var.b / d3));
            if (Build.VERSION.SDK_INT >= 26) {
                d2 = pz0Var.f7161a / pz0Var.c;
                seekBar.setMin((int) d2);
            }
        }
        qi0 qi0Var = new qi0(null, 1, null);
        f92.c(seekBar, "itemSeekBar");
        rh0<?> rh0VarF = f(pz0Var);
        if (rh0VarF == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.basic.FormValueHandler.InputHandler<kotlin.Int>");
        }
        qi0Var.g(seekBar, rh0VarF, textView3, pz0Var);
        f92.c(textView2, "itemDesc");
        p(textView2, pz0Var.f2487b);
        return viewI;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final View k(pz0 pz0Var) {
        String str = pz0Var.f;
        if (str != null) {
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        return j(pz0Var);
                    }
                    break;
                case -906021636:
                    if (str.equals("select")) {
                        return l(pz0Var);
                    }
                    break;
                case 3000946:
                    if (str.equals("apps")) {
                        return c(pz0Var);
                    }
                    break;
                case 64711720:
                    if (str.equals("boolean")) {
                        return d(pz0Var);
                    }
                    break;
                case 1542263633:
                    if (str.equals("decimal")) {
                        return e(pz0Var);
                    }
                    break;
            }
        }
        return q(pz0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View l(pz0 pz0Var) {
        View viewI = i(2131558612);
        TextView textView = (TextView) viewI.findViewById(2131361824);
        Spinner spinner = (Spinner) viewI.findViewById(t61.ItemSpinner);
        TextView textView2 = (TextView) viewI.findViewById(2131361806);
        f92.c(textView, "itemTitle");
        textView.setText(pz0Var.f2484a);
        qi0 qi0Var = new qi0(null, 1, null);
        f92.c(spinner, "itemSpinner");
        rh0<?> rh0VarF = f(pz0Var);
        if (rh0VarF == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.basic.FormValueHandler.InputHandler<kotlin.Int>");
        }
        qi0Var.h(spinner, rh0VarF);
        f92.c(textView2, "itemDesc");
        p(textView2, pz0Var.f2487b);
        qz0[] qz0VarArr = pz0Var.f2486a;
        String[] strArr = new String[qz0VarArr.length];
        f92.c(qz0VarArr, "item.options");
        int length = qz0VarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = qz0VarArr[i2].f7253a;
        }
        spinner.setAdapter((SpinnerAdapter) new q21(spinner.getContext(), strArr));
        return viewI;
    }

    public final void m(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(2131558610, (ViewGroup) this, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.util.ArrayList<a.oz0> r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.sysmbol.PerfOptionsRender.n(java.util.ArrayList, java.lang.String):void");
    }

    public final void o(String str, String str2) {
        if (str.length() == 0) {
            return;
        }
        rx0 rx0Var = this.f8361a;
        if (rx0Var == null) {
            y60.f7952a.l(str, str2);
        } else {
            f92.b(rx0Var);
            rx0Var.k(str, str2);
        }
    }

    public final void p(TextView textView, String str) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View q(pz0 pz0Var) {
        View viewI = i(2131558613);
        TextView textView = (TextView) viewI.findViewById(2131361824);
        EditText editText = (EditText) viewI.findViewById(t61.ItemEditText);
        TextView textView2 = (TextView) viewI.findViewById(2131361806);
        textView.setText(pz0Var.f2484a);
        qi0 qi0Var = new qi0(null, 1, null);
        f92.c(editText, "itemEditText");
        rh0<?> rh0VarF = f(pz0Var);
        if (rh0VarF == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.basic.FormValueHandler.InputHandler<kotlin.String>");
        }
        qi0Var.f(editText, rh0VarF);
        f92.c(textView2, "itemDesc");
        p(textView2, pz0Var.f2487b);
        editText.setHint(pz0Var.e);
        return viewI;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        setAlpha(z ? 1.0f : 0.5f);
    }
}
