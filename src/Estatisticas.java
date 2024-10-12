public class Estatisticas {
    private static int totalUsuarios;
    private static int propostasAceitas;
    private static int propostasNegadas;
    private static int propostasAguardando;

    public static void incrementarTotalUsuarios() {
        totalUsuarios++;
    }

    public static void incrementarPropostasAceitas() {
        propostasAceitas++;
        propostasAguardando--;
    }

    public static void incrementarPropostasNegadas() {
        propostasNegadas++;
        propostasAguardando--;
    }

    public static void incrementarPropostasAguardando() {
        propostasAguardando++;
    }






    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(int totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public int getPropostasAceitas() {
        return propostasAceitas;
    }

    public void setPropostasAceitas(int propostasAceitas) {
        this.propostasAceitas = propostasAceitas;
    }

    public int getPropostasNegadas() {
        return propostasNegadas;
    }

    public void setPropostasNegadas(int propostasNegadas) {
        this.propostasNegadas = propostasNegadas;
    }

    public int getPropostasAguardando() {
        return propostasAguardando;
    }

    public void setPropostasAguardando(int propostasAguardando) {
        this.propostasAguardando = propostasAguardando;
    }
}




