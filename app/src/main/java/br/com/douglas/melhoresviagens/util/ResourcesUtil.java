package br.com.douglas.melhoresviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.douglas.melhoresviagens.model.Pacote;

public class ResourcesUtil {

    public static Drawable devolveUmDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, "drawable", context.getPackageName());
        Resources.Theme tema = context.getTheme();
        return resources.getDrawable(idDoDrawable, tema);
    }
}
