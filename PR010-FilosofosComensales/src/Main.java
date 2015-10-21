/**
 * Created by Usuario on 21/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        int cont = 0, n = 5, i = 0;
        Filosofo[] filosofos = new Filosofo[n];
        Palillo[] palillos = new Palillo[n];

        for(i=0;i<n;i++){
            palillos[i] = new Palillo(i);
        }

        for(i=0;i<n;i++){
            if(i == 0){
                filosofos[i] = new Filosofo(i,palillos[n-1],palillos[i]);
            }else{
                filosofos[i] = new Filosofo(i,palillos[i-1],palillos[i]);
            }

        }

        for(i=0;i<n;i++)
            filosofos[i].start();


    }
}
