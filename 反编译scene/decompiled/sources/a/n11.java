package a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.MagiskModuleUnofficial;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n11 extends RecyclerView.g<a> implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m11 f6862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final o11 f1985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<cy0> f1988a;
    public m11 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<cy0> f1989b;

    public final class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Button f6863a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f1990a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f1991b;
        public TextView c;
        public TextView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n11 n11Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final Button M() {
            return this.f6863a;
        }

        public final View N() {
            return this.b;
        }

        public final TextView O() {
            return this.f1991b;
        }

        public final TextView P() {
            return this.d;
        }

        public final TextView Q() {
            return this.f1990a;
        }

        public final TextView R() {
            return this.c;
        }

        public final void S(Button button) {
            this.f6863a = button;
        }

        public final void T(View view) {
            this.b = view;
        }

        public final void U(TextView textView) {
            this.f1991b = textView;
        }

        public final void V(TextView textView) {
            this.d = textView;
        }

        public final void W(TextView textView) {
            this.f1990a = textView;
        }

        public final void X(TextView textView) {
            this.c = textView;
        }
    }

    public n11(Context context, ArrayList<cy0> arrayList) {
        f92.d(context, "context");
        f92.d(arrayList, "list");
        this.f1986a = context;
        this.f1989b = arrayList;
        this.f1987a = "";
        this.f1988a = arrayList;
        this.f1985a = new o11(this);
    }

    public final cy0 B(int i) {
        cy0 cy0Var = this.f1988a.get(i);
        f92.c(cy0Var, "result[position]");
        return cy0Var;
    }

    public final SpannableString C(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f1987a.length() == 0) {
            return spannableString;
        }
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String str2 = this.f1987a;
        Locale locale2 = Locale.getDefault();
        f92.c(locale2, "Locale.getDefault()");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase(locale2);
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.f1987a.length() + iN, 33);
        return spannableString;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "holder");
        Button buttonM = aVar.M();
        if (buttonM != null) {
            buttonM.setOnClickListener(new p11(buttonM, this, i));
            buttonM.setOnLongClickListener(new q11(buttonM, this, i));
        }
        G(i, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f1986a).inflate(2131558632, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.T(viewInflate.findViewById(t61.ItemCredible));
        aVar.W((TextView) viewInflate.findViewById(2131361824));
        aVar.U((TextView) viewInflate.findViewById(t61.ItemText));
        aVar.X((TextView) viewInflate.findViewById(t61.ItemVersion));
        aVar.V((TextView) viewInflate.findViewById(t61.ItemSource));
        aVar.S((Button) viewInflate.findViewById(t61.download));
        return aVar;
    }

    public final void F(m11 m11Var) {
        this.f6862a = m11Var;
    }

    public final void G(int i, a aVar) {
        String name;
        Context context;
        int i2;
        f92.d(aVar, "viewHolder");
        cy0 cy0VarB = B(i);
        String name2 = cy0VarB.getName();
        int i3 = 0;
        if (name2 == null || name2.length() == 0) {
            name = cy0VarB.getId();
        } else {
            name = cy0VarB.getName();
            f92.b(name);
        }
        View viewN = aVar.N();
        if (viewN != null) {
            if (!f92.a(cy0VarB.getSource(), "official") && cy0VarB.getPraise() <= 100) {
                i3 = 8;
            }
            viewN.setVisibility(i3);
        }
        TextView textViewQ = aVar.Q();
        if (textViewQ != null) {
            textViewQ.setText(C(name));
        }
        TextView textViewO = aVar.O();
        if (textViewO != null) {
            String description = cy0VarB.getDescription();
            if (description == null) {
                description = "";
            }
            textViewO.setText(C(description));
        }
        TextView textViewR = aVar.R();
        if (textViewR != null) {
            textViewR.setText("Version: " + cy0VarB.getVersionName() + " (" + cy0VarB.getVersionCode() + ')');
        }
        TextView textViewP = aVar.P();
        if (textViewP != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Author: ");
            String author = cy0VarB.getAuthor();
            sb.append((Object) C(author != null ? author : ""));
            textViewP.setText(sb.toString());
        }
        Button buttonM = aVar.M();
        if (buttonM != null) {
            if (f92.a(cy0VarB.getSource(), "share") || (cy0VarB instanceof MagiskModuleUnofficial)) {
                context = buttonM.getContext();
                i2 = u61.detail;
            } else {
                context = buttonM.getContext();
                i2 = u61.download;
            }
            buttonM.setText(context.getString(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f1988a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return this.f1985a;
    }
}
