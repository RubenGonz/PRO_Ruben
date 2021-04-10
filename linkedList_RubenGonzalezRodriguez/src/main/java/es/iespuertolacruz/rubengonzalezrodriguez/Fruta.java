package es.iespuertolacruz.rubengonzalezrodriguez;

public class Fruta {

   String color;
   int peso;

   /**
    * Constructor por defecto
    */
   public Fruta() {
   }
   
   /**
    * Constructor con parametros
    *
    * @param color
    * @param peso
    */
   public Fruta(String color, int peso) {
      this.color = color;
      this.peso = peso;
   }

   public String getColor() {
      return this.color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public int getPeso() {
      return this.peso;
   }

   public void setPeso(int peso) {
      this.peso = peso;
   }

}
