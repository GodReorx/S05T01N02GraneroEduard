package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.services;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions.FlowerIsNull;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions.FlowerNotCreated;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions.FlowerNotGetAll;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements FlowerService{
    @Autowired
    FlowerRepository flowerRepository;

    @Override
    public FlowerDTO add(FlowerEntity flowerEntity) {
        if(flowerEntity.allNull()){throw new FlowerNotCreated();}
        try{
            return convertToDTO(flowerRepository.save(flowerEntity));
        } catch (Exception ex){
            throw new FlowerNotCreated();
        }
    }

    @Override
    public FlowerDTO update(FlowerEntity flowerEntity) {
       try {
           Optional<FlowerEntity> flowerDB = flowerRepository.findById(flowerEntity.getPk_FlowerID());
           FlowerEntity flowerUpdate = flowerDB.get();
           flowerUpdate.setPk_FlowerID(flowerEntity.getPk_FlowerID());
           flowerUpdate.setFlowerName(flowerEntity.getFlowerName());
           flowerUpdate.setFlowerCountry(flowerEntity.getFlowerCountry());
           return convertToDTO(flowerRepository.save(flowerUpdate));
       } catch (Exception e) {
           throw new FlowerNotFoundException(flowerEntity.getPk_FlowerID());
       }
    }

    @Override
    public void delete(Integer flowerID) {
        Optional<FlowerEntity> flowerEntity = flowerRepository.findById(flowerID);
        if (flowerEntity.isEmpty()){throw new FlowerNotFoundException(flowerID);}
        flowerRepository.deleteById(flowerID);
    }

    @Override
    public FlowerEntity getOne(Integer flowerID) {
        try {
            Optional<FlowerEntity> flowerEntity = flowerRepository.findById(flowerID);
            return flowerEntity.get();
        } catch (Exception e){
            throw new FlowerNotFoundException(flowerID);
        }
    }

    @Override
    public FlowerDTO getOneDTO(Integer flowerID) {
        try {
            Optional<FlowerEntity> flowerEntity = flowerRepository.findById(flowerID);
            return convertToDTO(flowerEntity.get());
        }catch (Exception e){
            throw new FlowerNotFoundException(flowerID);
        }
    }

    @Override
    public List<FlowerDTO> getAll() {
        List<FlowerEntity> flowerEntityList = flowerRepository.findAll();
        if(flowerEntityList.isEmpty()){throw new FlowerNotGetAll();}
        flowerEntityList.forEach(flower -> {
            if (flower.allNull())
                throw new FlowerIsNull();
        });
        return flowerEntityList.stream().map(flower -> convertToDTO(flower)).collect(Collectors.toList());
    }

    private FlowerDTO convertToDTO (FlowerEntity flowerEntity){
        return new FlowerDTO(flowerEntity.getPk_FlowerID(), flowerEntity.getFlowerName(),flowerEntity.getFlowerCountry());
    }
}
