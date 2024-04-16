package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions;

public class FlowerNotCreated extends RuntimeException{
    public FlowerNotCreated (){
        super("Can't create a new flower at BBDD, contact with your administrator");
    }
}
