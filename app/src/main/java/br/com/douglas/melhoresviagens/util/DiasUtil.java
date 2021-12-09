package br.com.douglas.melhoresviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmdias(int qtdDias) {
        return qtdDias > 1 ? qtdDias + PLURAL : qtdDias + SINGULAR;
    }
}
