package br.com.douglas.melhoresviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    public static String formataMoedaParaBR(BigDecimal valor) {
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBR
                .format(valor)
                .replace(FORMATO_PADRAO, FORMATO_COM_ESPACO);
    }

}
