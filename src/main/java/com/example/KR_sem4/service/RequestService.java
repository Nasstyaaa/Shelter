package com.example.KR_sem4.service;

import com.example.KR_sem4.entity.Animal;
import com.example.KR_sem4.entity.Request;
import com.example.KR_sem4.entity.User;
import com.example.KR_sem4.repository.AnimalRepository;
import com.example.KR_sem4.repository.RequestRepository;
import com.example.KR_sem4.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;


    public Request createRequest(String nameAnimal, Long user_id){
        User user = userRepository.findUserById(user_id);
        Animal animal = animalRepository.findAnimalByName(nameAnimal);
        if (animal == null) {
            throw new IllegalArgumentException("Animal not found");
        }
        Request request = Request.builder()
                .user(user)
                .animal(animal)
                .status("NEW")
                .build();
        return requestRepository.save(request);
    }

    public List<Request> getRequests(){
        return requestRepository.findAll();
    }

    @Transactional
    public void approveRequest(Long request_id){
        Request request =  requestRepository.findRequestById(request_id);
        Long animal_id = request.getAnimal().getId();
        request.getAnimal().setIsAvailable(false);
        request.setStatus("APPROVED");
        for(Request req : requestRepository.findAll()){
            if(Objects.equals(req.getStatus(), "NEW") && Objects.equals(req.getAnimal().getId(), animal_id)){
                req.setStatus("REJECTED");
            }
        }
    }

    @Transactional
    public void rejectRequest(Long request_id){
        Request request = requestRepository.findRequestById(request_id);
        request.setStatus("REJECTED");
    }
    public List<Request> findByUserId(Long id){
        return requestRepository.findByUserId(id);
    }

    public List<Request> findRequestByStatus(String status){
        return requestRepository.findAllByStatus(status);
    }

    public Request findRequestById(Long id){
        return requestRepository.findRequestById(id);
    }

}
