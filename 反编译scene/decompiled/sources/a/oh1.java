package a;

import a.p80;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.omarea.vtools.services.CompileService;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oh1 extends hh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g91 f7022a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh1(g91 g91Var) {
        super(g91Var);
        f92.d(g91Var, "context");
        this.f7022a = g91Var;
    }

    public final boolean h() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void i() {
        j();
    }

    public final void j() {
        if (h()) {
            if (CompileService.f8925a.a()) {
                g91 g91Var = this.f7022a;
                Toast.makeText(g91Var, g91Var.getString(u61.dex2oat_compiling), 0).show();
                return;
            }
            View viewInflate = this.f7022a.getLayoutInflater().inflate(2131558490, (ViewGroup) null);
            p80.a aVar = p80.f2403a;
            g91 g91Var2 = this.f7022a;
            f92.c(viewInflate, "view");
            p80.b bVarT = p80.a.t(aVar, g91Var2, viewInflate, false, 4, null);
            viewInflate.findViewById(t61.mode_speed_profile).setOnClickListener(new jh1(this, bVarT));
            viewInflate.findViewById(t61.mode_speed).setOnClickListener(new kh1(this, bVarT));
            viewInflate.findViewById(t61.mode_everything).setOnClickListener(new lh1(this, bVarT));
            viewInflate.findViewById(t61.mode_reset).setOnClickListener(new mh1(this, bVarT));
            View viewFindViewById = viewInflate.findViewById(t61.mode_compact);
            if (Build.VERSION.SDK_INT > 28) {
                viewFindViewById.setOnClickListener(new ih1(viewFindViewById, this, bVarT));
            } else {
                viewFindViewById.setVisibility(8);
            }
            viewInflate.findViewById(t61.faq).setOnClickListener(new nh1(this, bVarT));
        }
    }

    public final void k(String str) {
        g91 g91Var;
        int i;
        if (CompileService.f8925a.a()) {
            g91Var = this.f7022a;
            i = u61.dex2oat_compiling;
        } else {
            try {
                Intent intent = new Intent(this.f7022a, (Class<?>) CompileService.class);
                intent.setAction(str);
                this.f7022a.startService(intent);
                Toast.makeText(this.f7022a, this.f7022a.getString(u61.dex2oat_start_ok), 0).show();
                return;
            } catch (Exception unused) {
                g91Var = this.f7022a;
                i = u61.dex2oat_start_fail;
            }
        }
        Toast.makeText(g91Var, g91Var.getString(i), 0).show();
    }
}
