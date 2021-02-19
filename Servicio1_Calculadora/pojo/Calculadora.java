public class Calculadora implements InterfazCalculadora{

    public int sumar (int s1, int s2){
        int resultado = s1+s2;
        return resultado;
    }
	public int restar (int min, int sus){
        int resultado = min-sus;
        return resultado;
    }
	public int multiplicar (int m1, int m2){
        int resultado = m1*m2;
        return resultado;
    }
	public float dividir (int num, int den){
        float resultado = (float) num/den;
        return resultado;
    }
    
}