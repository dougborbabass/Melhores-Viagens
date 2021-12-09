package br.com.douglas.melhoresviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Datautil {

    public static final String DIA_E_MES = "dd/MM";

    public static String periodoDaViagemEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat sdf = new SimpleDateFormat(DIA_E_MES);
        String dataIdaFormatada = sdf.format(dataIda.getTime());
        String dataVoltaFormatada = sdf.format(dataVolta.getTime());
        return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
    }
}
