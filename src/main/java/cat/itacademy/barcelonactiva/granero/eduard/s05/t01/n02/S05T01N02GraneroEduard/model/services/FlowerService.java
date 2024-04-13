package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.services;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerService {
    FlowerDTO add (FlowerEntity flowerEntity);
    FlowerDTO update (FlowerEntity flowerEntity);
    boolean delete (Integer flowerID);
    FlowerEntity getOne (Integer flowerID);
    FlowerDTO getOneDTO (Integer flowerID);
    List<FlowerDTO> getAll ();
}
