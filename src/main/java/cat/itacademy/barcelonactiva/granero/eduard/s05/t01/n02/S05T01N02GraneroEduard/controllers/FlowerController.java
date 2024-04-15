package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.PostUpdate;
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

    @Operation(summary = "This method for add new flower, you need to put name and country")
    @PostMapping("/add")
    public ResponseEntity<?> addFlower(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.add(flowerEntity);
        return new ResponseEntity<>(flowerDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "This method check if exist de ID, if exist update it, need a completed body for flower")
    @PutMapping("/update")
    public ResponseEntity<?> updateFlower(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.update(flowerEntity);
        return new ResponseEntity<>(flowerDTO, HttpStatus.OK);
    }

    @Operation(summary = "Pass the id and then it deleted, if not found, send a HttpStatus NOT FOUND")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlower(@PathVariable("id")Integer flowerId){
        boolean doIt = flowerService.delete(flowerId);
        if(doIt){
            return new ResponseEntity<>("Flower eliminated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: Flower not found", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Pass the id and return the FlowerDTO with this ID")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOneFlower(@PathVariable("id")Integer flowerId){
        FlowerDTO flowerDTO = flowerService.getOneDTO(flowerId);
        return new ResponseEntity<>(flowerDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Show all elements of flowers")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlowers(){
        List<FlowerDTO> flowerDTOList = flowerService.getAll();
        return new ResponseEntity<>(flowerDTOList, HttpStatus.OK);
    }
}
