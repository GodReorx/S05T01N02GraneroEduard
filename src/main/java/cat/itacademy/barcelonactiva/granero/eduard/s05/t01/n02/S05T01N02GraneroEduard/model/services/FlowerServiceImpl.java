package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.services;

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
        return convertToDTO(flowerRepository.save(flowerEntity));
    }

    @Override
    public FlowerDTO update(FlowerEntity flowerEntity) {
        Optional<FlowerEntity> flowerDB = flowerRepository.findById(flowerEntity.getPk_FlowerID());
        if (flowerDB.isPresent()){
            FlowerEntity flowerUpdate = flowerDB.get();
            flowerUpdate.setPk_FlowerID(flowerEntity.getPk_FlowerID());
            flowerUpdate.setFlowerName(flowerEntity.getFlowerName());
            flowerUpdate.setFlowerCountry(flowerEntity.getFlowerCountry());
            return convertToDTO(flowerRepository.save(flowerUpdate));
        } else {
            throw new RuntimeException("Record not found with ID: " + flowerEntity.getPk_FlowerID());
        }
    }

    @Override
    public boolean delete(Integer flowerID) {
        Optional<FlowerEntity> flowerEntity = flowerRepository.findById(flowerID);
        if (flowerEntity.isPresent()){
            flowerRepository.deleteById(flowerID);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public FlowerEntity getOne(Integer flowerID) {
        Optional<FlowerEntity> flowerEntity = flowerRepository.findById(flowerID);
        if (flowerEntity.isPresent()){
            return flowerEntity.get();
        } else {
            throw new RuntimeException("Record not found with ID: " + flowerID);
        }
    }

    @Override
    public FlowerDTO getOneDTO(Integer flowerID) {
        Optional<FlowerEntity> flowerEntity = flowerRepository.findById(flowerID);
        if (flowerEntity.isPresent()){
            return convertToDTO(flowerEntity.get());
        } else {
            throw new RuntimeException("Record not found with ID: " + flowerID);
        }
    }

    @Override
    public List<FlowerDTO> getAll() {
        List<FlowerEntity> flowerEntityList = flowerRepository.findAll();
        return flowerEntityList.stream().map(flowerEntity -> convertToDTO(flowerEntity)).collect(Collectors.toList());
    }

    private FlowerDTO convertToDTO (FlowerEntity flowerEntity){
        return new FlowerDTO(flowerEntity.getPk_FlowerID(), flowerEntity.getFlowerName(),flowerEntity.getFlowerCountry());
    }
}
