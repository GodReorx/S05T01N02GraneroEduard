package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions;

public class FlowerNotGetAll extends RuntimeException{
    public FlowerNotGetAll(){
        super("The database are empty.");
    }
}
