package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")

public class FlowerController {
    @Autowired
    FlowerService flowerService;

    @PostMapping("/add")
    public ResponseEntity<?> addFlower(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.add(flowerEntity);
        return new ResponseEntity<>(flowerDTO, HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<?> updateFlower(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.update(flowerEntity);
        return new ResponseEntity<>(flowerDTO, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlower(@PathVariable("id")Integer flowerId){
        boolean doIt = flowerService.delete(flowerId);
        if(doIt){
            return new ResponseEntity<>("Flower eliminated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: Flower not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOneFlower(@PathVariable("id")Integer flowerId){
        FlowerDTO flowerDTO = flowerService.getOneDTO(flowerId);
        return new ResponseEntity<>(flowerDTO, HttpStatus.FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlowers(){
        List<FlowerDTO> flowerDTOList = flowerService.getAll();
        return new ResponseEntity<>(flowerDTOList, HttpStatus.OK);
    }
}
