
public class TestaCartaoDeCredito {
    public static void main(String[] args) {
        CartaoDeCredito cdc1 = new CartaoDeCredito();
        cdc1.Numero = 2251321;
        cdc1.DataDeValidade = "02/04/2029";
        
        CartaoDeCredito cdc2 = new CartaoDeCredito();
        cdc2.Numero = 4392391;
        cdc2.DataDeValidade = "09/06/2028";
        
        System.out.println(cdc1.Numero);
        System.out.println(cdc1.DataDeValidade);
        System.out.println(cdc2.Numero);
        System.out.println(cdc2.DataDeValidade);
    }   
}
