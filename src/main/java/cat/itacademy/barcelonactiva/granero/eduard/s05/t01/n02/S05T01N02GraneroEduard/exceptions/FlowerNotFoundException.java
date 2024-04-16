package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions;

public class FlowerNotFoundException extends RuntimeException {
    public FlowerNotFoundException (Integer id){
        super("Flower not found with ID: " + id );
    }
}
