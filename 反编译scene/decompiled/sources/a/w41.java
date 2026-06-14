package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.FpsWatchSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w41 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v41 f3378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f3379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yj0 f3380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SimpleDateFormat f3382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<FpsWatchSession> f3383a;
    public v41 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final SimpleDateFormat f3384b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<FpsWatchSession> f3385b;
    public boolean c;

    public final class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageButton f7756a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImageView f3386a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f3387a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ImageButton f3388b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ImageView f3389b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f3390b;
        public View c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public TextView f3391c;
        public View d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public TextView f3392d;
        public TextView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w41 w41Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final ImageButton M() {
            return this.f3388b;
        }

        public final ImageButton N() {
            return this.f7756a;
        }

        public final ImageView O() {
            return this.f3389b;
        }

        public final TextView P() {
            return this.f3390b;
        }

        public final View Q() {
            return this.c;
        }

        public final TextView R() {
            return this.f3391c;
        }

        public final ImageView S() {
            return this.f3386a;
        }

        public final View T() {
            return this.d;
        }

        public final TextView U() {
            return this.e;
        }

        public final TextView V() {
            return this.f3392d;
        }

        public final TextView W() {
            return this.f3387a;
        }

        public final View X() {
            return this.b;
        }

        public final void Y(ImageButton imageButton) {
            this.f3388b = imageButton;
        }

        public final void Z(ImageButton imageButton) {
            this.f7756a = imageButton;
        }

        public final void a0(ImageView imageView) {
            this.f3389b = imageView;
        }

        public final void b0(TextView textView) {
            this.f3390b = textView;
        }

        public final void c0(View view) {
            this.c = view;
        }

        public final void d0(TextView textView) {
            this.f3391c = textView;
        }

        public final void e0(ImageView imageView) {
            this.f3386a = imageView;
        }

        public final void f0(View view) {
            this.d = view;
        }

        public final void g0(TextView textView) {
            this.e = textView;
        }

        public final void h0(TextView textView) {
            this.f3392d = textView;
        }

        public final void i0(TextView textView) {
            this.f3387a = textView;
        }

        public final void j0(View view) {
            this.b = view;
        }
    }

    public w41(Context context, ArrayList<FpsWatchSession> arrayList) {
        f92.d(context, "context");
        f92.d(arrayList, "list");
        this.f3381a = context;
        this.f3385b = arrayList;
        this.f7755a = -1;
        this.f3383a = arrayList;
        this.f3382a = new SimpleDateFormat("yyyy-MM-dd");
        this.f3384b = new SimpleDateFormat("HH:mm:ss");
        this.f3380a = new yj0();
        this.f3379a = new vj0();
    }

    public final void A(String str) {
        ArrayList<FpsWatchSession> arrayList;
        f92.d(str, "keywords");
        if ((str.length() == 0) || f92.a(str, "android")) {
            arrayList = this.f3385b;
        } else {
            ArrayList<FpsWatchSession> arrayList2 = this.f3385b;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                FpsWatchSession fpsWatchSession = (FpsWatchSession) obj;
                if (f92.a(fpsWatchSession.packageName, str) || f92.a(fpsWatchSession.appName, str)) {
                    arrayList3.add(obj);
                }
            }
            arrayList = new ArrayList<>(arrayList3);
        }
        this.f3383a = arrayList;
        i();
    }

    public final FpsWatchSession B(int i) {
        FpsWatchSession fpsWatchSession = this.f3383a.get(i);
        f92.c(fpsWatchSession, "filterResult[position]");
        return fpsWatchSession;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "holder");
        ((RecyclerView.d0) aVar).f4387a.setOnClickListener(new x41(this, i, aVar));
        ImageButton imageButtonM = aVar.M();
        if (imageButtonM != null) {
            imageButtonM.setOnClickListener(new y41(this, i));
        }
        ImageButton imageButtonN = aVar.N();
        if (imageButtonN != null) {
            imageButtonN.setOnClickListener(new z41(this, i));
        }
        I(i, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f3381a).inflate(2131558630, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.e0((ImageView) viewInflate.findViewById(2131361811));
        aVar.j0(viewInflate.findViewById(t61.NewTag));
        aVar.i0((TextView) viewInflate.findViewById(2131361824));
        aVar.h0((TextView) viewInflate.findViewById(t61.ItemTime));
        aVar.c0(viewInflate.findViewById(t61.ItemModeDot));
        aVar.g0((TextView) viewInflate.findViewById(t61.ItemSummary));
        aVar.b0((TextView) viewInflate.findViewById(2131361806));
        aVar.d0((TextView) viewInflate.findViewById(t61.ItemDuration));
        aVar.Z((ImageButton) viewInflate.findViewById(t61.delete));
        aVar.a0((ImageView) viewInflate.findViewById(t61.ItemCloud));
        aVar.Y((ImageButton) viewInflate.findViewById(t61.confirm));
        aVar.f0(viewInflate.findViewById(t61.Selected));
        return aVar;
    }

    public final void E(int i) {
        FpsWatchSession fpsWatchSession = this.f3383a.get(i);
        f92.c(fpsWatchSession, "this.filterResult.get(position)");
        FpsWatchSession fpsWatchSession2 = fpsWatchSession;
        this.f3383a.remove(i);
        if (this.f3385b.contains(fpsWatchSession2)) {
            this.f3385b.remove(fpsWatchSession2);
        }
        i();
    }

    public final void F(View view, FpsWatchSession fpsWatchSession) {
        String strSubstring;
        String str = fpsWatchSession.mode;
        if ((str == null || str.length() == 0) || bc2.o(str, "#", false, 2, null) || !ec2.C(str, "#", false, 2, null)) {
            view.setAlpha(0.0f);
            view.setBackground(null);
            return;
        }
        int iN = ec2.N(str, "#", 0, false, 6, null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = str.substring(0, iN);
        f92.c(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i = iN + 1;
        if (ec2.d0(str, new String[]{"#"}, false, 0, 6, null).size() > 2) {
            int iS = ec2.S(str, "#", 0, false, 6, null);
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(i, iS);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(i);
            f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        view.setBackground(wu0.f3480a.h(strSubstring));
        view.setAlpha(f92.a(strSubstring2, "SOURCE_SCENE_ONLINE") ? 1.0f : 0.3f);
    }

    public final void G(v41 v41Var) {
        this.f3378a = v41Var;
    }

    public final void H(v41 v41Var) {
        this.b = v41Var;
    }

    public final void I(int i, a aVar) {
        TextView textViewV;
        SimpleDateFormat simpleDateFormat;
        Date date;
        View viewT;
        float f;
        f92.d(aVar, "viewHolder");
        FpsWatchSession fpsWatchSessionB = B(i);
        TextView textViewW = aVar.W();
        if (textViewW != null) {
            textViewW.setText(fpsWatchSessionB.appName);
        }
        ImageView imageViewS = aVar.S();
        if (imageViewS != null) {
            imageViewS.setImageDrawable(fpsWatchSessionB.appIcon);
        }
        TextView textViewU = aVar.U();
        boolean z = true;
        if (textViewU != null) {
            q92 q92Var = q92.f7191a;
            String str = String.format("%.2f  %.2fW", Arrays.copyOf(new Object[]{Double.valueOf(fpsWatchSessionB.avgFPS), Double.valueOf(fpsWatchSessionB.avgPower)}, 2));
            f92.c(str, "java.lang.String.format(format, *args)");
            textViewU.setText(str);
        }
        TextView textViewR = aVar.R();
        if (textViewR != null) {
            textViewR.setText(this.f3379a.c(((double) fpsWatchSessionB.duration) / 60.0d));
        }
        View viewQ = aVar.Q();
        if (viewQ != null) {
            F(viewQ, fpsWatchSessionB);
        }
        ImageView imageViewO = aVar.O();
        if (imageViewO != null) {
            String str2 = fpsWatchSessionB.cloudId;
            imageViewO.setVisibility(str2 == null || str2.length() == 0 ? 8 : 0);
        }
        String str3 = fpsWatchSessionB.sessionDesc;
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        TextView textViewP = aVar.P();
        if (z) {
            if (textViewP != null) {
                textViewP.setText((CharSequence) null);
                textViewP.setVisibility(8);
            }
        } else if (textViewP != null) {
            textViewP.setText(fpsWatchSessionB.sessionDesc);
            textViewP.setVisibility(0);
        }
        yj0 yj0Var = this.f3380a;
        Long l = fpsWatchSessionB.beginTime;
        f92.c(l, "item.beginTime");
        if (yj0Var.a(l.longValue())) {
            View viewX = aVar.X();
            if (viewX != null) {
                viewX.setVisibility(0);
            }
            textViewV = aVar.V();
            if (textViewV != null) {
                simpleDateFormat = this.f3384b;
                Long l2 = fpsWatchSessionB.beginTime;
                f92.c(l2, "item.beginTime");
                date = new Date(l2.longValue());
                textViewV.setText(simpleDateFormat.format(date));
            }
        } else {
            View viewX2 = aVar.X();
            if (viewX2 != null) {
                viewX2.setVisibility(8);
            }
            textViewV = aVar.V();
            if (textViewV != null) {
                simpleDateFormat = this.f3382a;
                Long l3 = fpsWatchSessionB.beginTime;
                f92.c(l3, "item.beginTime");
                date = new Date(l3.longValue());
                textViewV.setText(simpleDateFormat.format(date));
            }
        }
        if (i == this.f7755a) {
            viewT = aVar.T();
            if (viewT != null) {
                f = 0.7f;
                viewT.setAlpha(f);
            }
        } else {
            viewT = aVar.T();
            if (viewT != null) {
                f = 0.0f;
                viewT.setAlpha(f);
            }
        }
        if (this.c && this.f7755a == i) {
            ImageButton imageButtonN = aVar.N();
            if (imageButtonN != null) {
                imageButtonN.setVisibility(8);
            }
            ImageButton imageButtonM = aVar.M();
            if (imageButtonM != null) {
                imageButtonM.setVisibility(0);
                return;
            }
            return;
        }
        ImageButton imageButtonN2 = aVar.N();
        if (imageButtonN2 != null) {
            imageButtonN2.setVisibility(0);
        }
        ImageButton imageButtonM2 = aVar.M();
        if (imageButtonM2 != null) {
            imageButtonM2.setVisibility(8);
        }
    }

    public final void J(int i, boolean z) {
        int i2 = this.f7755a;
        if (i2 == i && this.c == z) {
            return;
        }
        this.c = z;
        if (i2 != -1) {
            this.f7755a = i;
            j(i2);
        }
        this.f7755a = i;
        j(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f3383a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }
}
