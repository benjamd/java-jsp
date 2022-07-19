

package beans;
 
import java.io.Serializable;

public class Rectangulo implements Serializable{
    
    private int base;
    private int altura;

    public int getBase() {
        return this.base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "base=" + base + ", altura=" + altura + '}';
    }
    
    public int getArea(){
        return this.base * this.altura;
    }
}
