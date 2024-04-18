package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Add new Flower",
            description = "This method is used to add a new flower. The name and country are necessary.")
    @PostMapping("/add")
    public ResponseEntity<?> addFlower(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.add(flowerEntity);
        return new ResponseEntity<>(flowerDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a Flower",
            description = "This method checks if the ID exists, if so, updates it. You need the whole body.")
    @PutMapping("/update")
    public ResponseEntity<?> updateFlower(@RequestBody FlowerEntity flowerEntity){
        FlowerDTO flowerDTO = flowerService.update(flowerEntity);
        return new ResponseEntity<>(flowerDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete one flower",
            description = "This method checks if the ID exists, if so, it deletes it.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlower(@PathVariable("id")Integer flowerId){
        flowerService.delete(flowerId);
        return new ResponseEntity<>("Flower eliminated", HttpStatus.OK);
    }

    @Operation(summary = "Show one Flower",
            description = "This method checks if the ID exists, if so, it displays it.")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOneFlower(@PathVariable("id")Integer flowerId){
        FlowerDTO flowerDTO = flowerService.getOneDTO(flowerId);
        return new ResponseEntity<>(flowerDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Show a list of flowers",
            description = "This method shows the complete list of flowers.")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlowers(){
        List<FlowerDTO> flowerDTOList = flowerService.getAll();
        return new ResponseEntity<>(flowerDTOList, HttpStatus.OK);
    }
}
