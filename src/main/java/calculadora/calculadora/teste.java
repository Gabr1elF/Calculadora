package calculadora.calculadora;

public class teste {
    public static void main(String[] args) {
        String oi = "2+2";
        String[] parte = oi.split("\\+");
        int soma = 0;

        for(String i : parte){
            int num = Integer.parseInt(i);
            soma += num;
        }

        System.out.println(soma);
    }
}
